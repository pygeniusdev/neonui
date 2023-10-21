import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AndroidStyleApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Android 4.4 Style App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.setBackground(Color.WHITE);

        // Create text input field
        JTextField textField = new JTextField("Enter text");
        textField.setBackground(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(new Color(51, 181, 229))); // Set the border color
        textField.setMargin(new Insets(10, 10, 10, 10));

        // Create radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout());
        radioPanel.setBackground(Color.WHITE);
        JRadioButton radioButton1 = new JRadioButton("Option 1");
        JRadioButton radioButton2 = new JRadioButton("Option 2");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);

        // Create toggle switches (tumblers)
        JPanel tumblerPanel = new JPanel();
        tumblerPanel.setLayout(new FlowLayout());
        tumblerPanel.setBackground(Color.WHITE);
        JToggleButton tumbler1 = new JToggleButton("On");
        JToggleButton tumbler2 = new JToggleButton("Off");
        tumblerPanel.add(tumbler1);
        tumblerPanel.add(tumbler2);

        // Create a button with Android-style appearance
        JButton button = new JButton("Click Me");
        button.setBackground(new Color(51, 181, 229)); // Use RGB values for #33B5E5
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);

        // Add an ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textField.getText();
                String selectedOption = radioButton1.isSelected() ? radioButton1.getText() : radioButton2.getText();
                String tumblerStatus = tumbler1.isSelected() ? "On" : "Off";
                JOptionPane.showMessageDialog(frame, "Button Clicked!\nText: " + inputText + "\nSelected Option: " + selectedOption + "\nTumbler Status: " + tumblerStatus);
            }
        });

        // Add components to the panel
        panel.add(textField);
        panel.add(radioPanel);
        panel.add(tumblerPanel);
        panel.add(button);

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Create a panel for navigation buttons
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout());

        // Create buttons for navigation
        JButton backButton = new JButton("Back");
        JButton leaveButton = new JButton("Leave");
        JButton viewAppsButton = new JButton("View Apps");

        // Add navigation buttons to the navigation panel
        navPanel.add(backButton);
        navPanel.add(leaveButton);
        navPanel.add(viewAppsButton);

        // Add the navigation panel to the bottom of the frame
        frame.add(navPanel, BorderLayout.SOUTH);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}
