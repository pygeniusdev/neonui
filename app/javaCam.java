import javax.swing.*;
import java.awt.*;

public class CameraUISimulation {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Camera UI Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel cameraPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Simulate camera view (placeholder image)
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.GRAY);
                g.drawRect(50, 50, getWidth() - 100, getHeight() - 100);

                // Simulate capture button
                g.setColor(Color.RED);
                g.fillRoundRect(350, 500, 100, 50, 10, 10);
                g.setColor(Color.WHITE);
                g.drawString("Capture", 375, 530);
            }
        };

        frame.add(cameraPanel);
        frame.setVisible(true);
    }
}
