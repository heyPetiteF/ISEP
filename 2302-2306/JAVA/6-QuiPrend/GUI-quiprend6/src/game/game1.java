package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class game1 extends JFrame implements ActionListener {
    private JLabel backgroundLabel;
    private JButton exitButton;
    private JButton continueButton;
    private JComboBox<Integer> playerCountComboBox;
    private JTextField[] playerIDFields;

    public game1() {
        // Set window title
        setTitle("6 QUI PREND");

        // Set window size
        setSize(1300, 800);

        // Set window background
        ImageIcon backgroundImg = new ImageIcon("IMG\\background1.png");
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


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == continueButton) {
            new END.WIN();
            dispose();
        }
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


            getContentPane().validate();
            getContentPane().repaint();

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
