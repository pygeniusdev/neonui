import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesktopApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Desktop Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(320, 240); // Set the size to 320x240 pixels

            // Create a JPanel with a blue background color
            JPanel backgroundPanel = new JPanel();
            backgroundPanel.setBackground(Color.BLUE);
            frame.setContentPane(backgroundPanel);

            // Create a menu bar with a "File" menu
            JMenuBar menuBar = new JMenuBar();
            JMenu fileMenu = new JMenu("File");
            JMenuItem openMenuItem = new JMenuItem("Open");
            JMenuItem exitMenuItem = new JMenuItem("Exit");
            fileMenu.add(openMenuItem);
            fileMenu.add(exitMenuItem);
            menuBar.add(fileMenu);
            frame.setJMenuBar(menuBar);

            // Add a button on top of the blue background
            JButton button = new JButton("Click Me");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Button clicked!");
                }
            });
            backgroundPanel.add(button);

            frame.setVisible(true);
        });
    }
}
