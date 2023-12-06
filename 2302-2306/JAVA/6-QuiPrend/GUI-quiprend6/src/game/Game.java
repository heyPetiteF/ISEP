package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Game extends JFrame implements ActionListener {
    private JLabel backgroundLabel;
    private JButton exitButton;
    private JButton continueButton;
    private JComboBox<Integer> playerCountComboBox;
    private JLabel[] playerIDLabels;
    private JTextField[] playerIDFields;
    private JButton connectButton;
    private JPanel playerIDPanel;

    public Game() {
        // Set window title
        setTitle("6 QUI PREND");

        // Set window size
        setSize(1300, 800);

        // Set window background
        ImageIcon backgroundImg = new ImageIcon("IMG\\background.jpg");
        backgroundLabel = new JLabel(backgroundImg);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        // Create EXIT button
        exitButton = createButton("EXIT", 26);
        exitButton.setBounds(getWidth() - 100, 0, 100, 70);
        exitButton.addActionListener(this);
        backgroundLabel.add(exitButton);

        // Create CONTINUE button
        continueButton = createButton("CONTINUE>>>", 30);
        continueButton.setBounds(getWidth() - 250, getHeight() - 100, 300, 100);
        continueButton.addActionListener(this);
        backgroundLabel.add(continueButton);

        // Create player count combo box and confirm button
        playerCountComboBox = createComboBox(new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10}, 26);
        playerCountComboBox.setBounds(300, 100, 200, 50);
        backgroundLabel.add(playerCountComboBox);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);
        confirmButton.setBorderPainted(false);
        confirmButton.setFocusPainted(false);
        confirmButton.setContentAreaFilled(false);
        confirmButton.setFont(new Font("Algerian", Font.BOLD, 26));
        confirmButton.setForeground(Color.decode("#583b94"));
        confirmButton.setBounds(220, 100, 400, 50);
        backgroundLabel.add(confirmButton);


        // Create connect button
        connectButton = createButton("Login", 26);
        connectButton.setBounds(400, 200, 200, 50);
        connectButton.addActionListener(this);
        connectButton.setEnabled(false);
        backgroundLabel.add(connectButton);

        // Create player ID input panel
        playerIDPanel = new JPanel();
        playerIDPanel.setOpaque(false);
        playerIDPanel.setLayout(new BoxLayout(playerIDPanel, BoxLayout.Y_AXIS));
        playerIDPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        backgroundLabel.add(playerIDPanel);

        // Add component listener for resizing
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustComponentPositions();
            }
        });

        // Make the window visible
        setVisible(true);
    }

    private JButton createButton(String text, int fontSize) {
        JButton button = new JButton(text);
        button.addActionListener(this);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font("Algerian", Font.BOLD, fontSize));
        button.setForeground(Color.decode("#583b94"));
        return button;
    }

    private JComboBox<Integer> createComboBox(Integer[] items, int fontSize) {
        JComboBox<Integer> comboBox = new JComboBox<>(items);
        comboBox.setFont(new Font("Algerian", Font.BOLD, fontSize));
        comboBox.setForeground(Color.decode("#583b94"));
        return comboBox;
    }

    private void adjustComponentPositions() {
        int width = getContentPane().getWidth();
        int height = getContentPane().getHeight();

        backgroundLabel.setBounds(0, 0, width, height);
        exitButton.setBounds(width - 100, 0, 100, 70);
        continueButton.setBounds(width - 250, height - 100, 300, 100);
        playerCountComboBox.setBounds(500, 100, 100, 50);
        connectButton.setBounds(400, 100, 600, 50);

        if (playerIDFields != null && playerIDFields.length > 0) {
            int startY = 200;
            int labelHeight = 30;
            int fieldHeight = 25;
            int spacing = 0;
            for (int i = 0; i < playerIDFields.length; i++) {
                playerIDLabels[i].setBounds( 400, startY + (labelHeight + fieldHeight + spacing) * i, 200, labelHeight);
                playerIDFields[i].setBounds(550, startY + (labelHeight + fieldHeight + spacing) * i, 200, fieldHeight);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == continueButton) {
            new game1();
            dispose();
        } else if (e.getActionCommand().equals("Confirm")) {
            int playerCount = (Integer) playerCountComboBox.getSelectedItem();
            createPlayerIDFields(playerCount);
            connectButton.setEnabled(true);
        } else if (e.getSource() == connectButton) {
            connectToDatabase();
        }
    }

    private void createPlayerIDFields(int playerCount) {
        playerIDLabels = new JLabel[playerCount];
        playerIDFields = new JTextField[playerCount];
        int startY = 200;
        int labelHeight = 30;
        int fieldHeight = 25;
        int spacing = 10;
        for (int i = 0; i < playerCount; i++) {
            playerIDLabels[i] = new JLabel("PLAYER ID " + (i + 1));
            playerIDLabels[i].setFont(new Font("Algerian", Font.BOLD, 20));
            playerIDLabels[i].setForeground(Color.BLACK);
            playerIDLabels[i].setBackground(new Color(0, 0, 0, 0));
            playerIDLabels[i].setHorizontalAlignment(SwingConstants.LEFT);
            playerIDLabels[i].setVerticalAlignment(SwingConstants.CENTER);
            backgroundLabel.add(playerIDLabels[i]);

            playerIDFields[i] = new JTextField();
            playerIDFields[i].setFont(new Font("Algerian", Font.BOLD, 20));
            playerIDFields[i].setForeground(Color.BLACK);
            backgroundLabel.add(playerIDFields[i]);
        }

        adjustComponentPositions();
    }

    private void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/gui-quiprend6";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            for (int i = 0; i < playerIDFields.length; i++) {
                String playerID = playerIDFields[i].getText();
                if (isValidInteger(playerID)) {
                    String query = "INSERT INTO players (id) VALUES (?)";
                    PreparedStatement statement = connection.prepareStatement(query);
                    int id = Integer.parseInt(playerID);
                    statement.setInt(1, id);
                    statement.executeUpdate();
                    statement.close();
                } else {
                    System.out.println("Invalid player ID: " + playerID);
                }
            }

            connection.close();

            JOptionPane.showMessageDialog(this, "MYSQL connection successful!", "Connection Successful!", JOptionPane.INFORMATION_MESSAGE);

            createPlayerIDFields(playerIDFields.length);

            getContentPane().validate();
            getContentPane().repaint();
            playerIDPanel.revalidate();
            playerIDPanel.repaint();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, "MYSQL connection failed! Please check the database connection information.", "Connection Failed", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private boolean isValidInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
