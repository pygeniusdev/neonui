from kivy.app import App
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.label import Label
from kivy.uix.textinput import TextInput
from kivy.uix.button import Button
from kivy.uix.dropdown import DropDown
from googletrans import Translator

class TranslatorApp(App):
    def build(self):
        self.title = 'Translator App'
        layout = BoxLayout(orientation='vertical', padding=10)

        self.input_label = Label(text='Enter text to translate:')
        self.input_text = TextInput()
        self.output_label = Label(text='Translation:')
        self.output_text = TextInput()

        self.translate_button = Button(text='Translate')
        self.translate_button.bind(on_release=self.show_language_menu)

        self.language_menu = DropDown()
        languages = [
            'Spanish', 'French', 'German', 'Chinese', 'Japanese', 'Arabic',
            'Russian', 'Italian', 'Dutch', 'Korean', 'Portuguese', 'Swedish',
            'Norwegian', 'Finnish', 'Danish', 'Turkish', 'Greek', 'Hindi',
            'Hebrew', 'Thai', 'Polish', 'Romanian', 'Czech', 'Hungarian',
            'Indonesian', 'Malay', 'Bulgarian', 'Croatian', 'Slovak', 'Slovenian',
            'Ukrainian', 'Lithuanian', 'Latvian', 'Estonian'
        ]
        
        for lang in languages:
            btn = Button(text=lang, size_hint_y=None, height=30)
            btn.bind(on_release=lambda btn, lang=lang: self.on_language_select(lang))
            self.language_menu.add_widget(btn)

        layout.add_widget(self.input_label)
        layout.add_widget(self.input_text)
        layout.add_widget(self.output_label)
        layout.add_widget(self.output_text)
        layout.add_widget(self.translate_button)

        return layout

    def show_language_menu(self, instance):
        self.language_menu.open(instance)

    def on_language_select(self, language):
        self.translate_text(language)
        self.language_menu.dismiss()

    def translate_text(self, language):
        text_to_translate = self.input_text.text
        lang_codes = {
            'Spanish': 'es', 'French': 'fr', 'German': 'de', 'Chinese': 'zh-cn',
            'Japanese': 'ja', 'Arabic': 'ar', 'Russian': 'ru', 'Italian': 'it',
            'Dutch': 'nl', 'Korean': 'ko', 'Portuguese': 'pt', 'Swedish': 'sv',
            'Norwegian': 'no', 'Finnish': 'fi', 'Danish': 'da', 'Turkish': 'tr',
            'Greek': 'el', 'Hindi': 'hi', 'Hebrew': 'he', 'Thai': 'th',
            'Polish': 'pl', 'Romanian': 'ro', 'Czech': 'cs', 'Hungarian': 'hu',
            'Indonesian': 'id', 'Malay': 'ms', 'Bulgarian': 'bg', 'Croatian': 'hr',
            'Slovak': 'sk', 'Slovenian': 'sl', 'Ukrainian': 'uk', 'Lithuanian': 'lt',
            'Latvian': 'lv', 'Estonian': 'et'
        }

        dest_lang = lang_codes.get(language, 'es')  # Default destination language is Spanish
        translator = Translator()
        translation = translator.translate(text_to_translate, dest=dest_lang)
        self.output_text.text = translation.text

if __name__ == '__main__':
    TranslatorApp().run()
