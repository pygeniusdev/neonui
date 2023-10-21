from kivy.app import App
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.textinput import TextInput
from kivy.uix.button import Button
from kivy.uix.popup import Popup
from kivy.uix.label import Label
from kivy.uix.slider import Slider

class NotepadApp(App):
    def build(self):
        self.title = 'Kivy Notepad'
        layout = BoxLayout(orientation='vertical', spacing=10, padding=10)

        self.text_input = TextInput(text='', multiline=True)
        self.text_input.bind(on_text_validate=self.auto_create_note)
        self.text_input.bind(focus=self.auto_save_note)

        save_button = Button(text='Save')
        load_button = Button(text='Load')
        settings_button = Button(text='Settings')

        save_button.bind(on_press=self.save_file)
        load_button.bind(on_press=self.load_file)
        settings_button.bind(on_press=self.show_settings)

        layout.add_widget(self.text_input)
        button_layout = BoxLayout(orientation='horizontal', spacing=10)
        button_layout.add_widget(save_button)
        button_layout.add_widget(load_button)
        button_layout.add_widget(settings_button)
        layout.add_widget(button_layout)

        font_size_slider = Slider(min=10, max=30, step=1, value=self.text_input.font_size)
        font_size_slider.bind(value=self.set_font_size)
        layout.add_widget(font_size_slider)

        return layout

    def auto_create_note(self, instance):
        if not instance.text.strip():
            instance.text = "New Note:\n\n"

    def auto_save_note(self, instance, value):
        if not value:
            self.save_file(None)

    def save_file(self, instance):
        content = self.text_input.text
        with open('notepad.txt', 'w') as file:
            file.write(content)
        self.show_popup('File Saved', 'notepad.txt has been saved.')

    def load_file(self, instance):
        try:
            with open('notepad.txt', 'r') as file:
                content = file.read()
                self.text_input.text = content
            self.show_popup('File Loaded', 'notepad.txt has been loaded.')
        except FileNotFoundError:
            self.show_popup('File Not Found', 'notepad.txt does not exist.')

    def show_popup(self, title, content):
        popup = Popup(title=title, content=Label(text=content), size_hint=(None, None), size=(400, 200))
        popup.open()

    def show_settings(self, instance):
        settings_popup = Popup(title='Settings', size_hint=(None, None), size=(300, 200))
        layout = BoxLayout(orientation='vertical', spacing=10, padding=10)

        font_size_label = Label(text='Font Size:')
        font_size_slider = Slider(min=10, max=30, step=1, value=self.text_input.font_size)
        save_settings_button = Button(text='Save Settings')

        font_size_slider.bind(value=self.set_font_size)
        save_settings_button.bind(on_press=settings_popup.dismiss)

        layout.add_widget(font_size_label)
        layout.add_widget(font_size_slider)
        layout.add_widget(save_settings_button)
        settings_popup.content = layout

        settings_popup.open()

    def set_font_size(self, instance, value):
        self.text_input.font_size = value

if __name__ == '__main__':
    NotepadApp().run()
