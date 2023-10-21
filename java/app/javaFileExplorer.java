import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class UnixFileBrowser extends JFrame {
    private JList<String> fileList;
    private DefaultListModel<String> listModel;
    private File currentDirectory;

    public UnixFileBrowser() {
        setTitle("File Browser");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        fileList = new JList<>(listModel);
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(fileList);

        JButton openButton = new JButton("Open");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSelectedFile();
            }
        });

        fileList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedIndex = fileList.getSelectedIndex();
                    if (selectedIndex >= 0) {
                        String selectedFileName = listModel.get(selectedIndex);
                        File selectedFile = new File(currentDirectory, selectedFileName);
                        if (selectedFile.isDirectory()) {
                            loadFiles(selectedFile);
                        }
                    }
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(openButton);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        loadFiles(new File(System.getProperty("user.home"))); // Start with the user's home directory
    }

    private void loadFiles(File directory) {
        listModel.clear();
        currentDirectory = directory;
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                listModel.addElement(file.getName());
            }
        }
    }

    private void openSelectedFile() {
        String selectedFileName = fileList.getSelectedValue();
        if (selectedFileName != null) {
            File selectedFile = new File(currentDirectory, selectedFileName);
            if (selectedFile.isFile()) {
                // Implement file opening logic here.
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UnixFileBrowser().setVisible(true);
            }
        });
    }
}
