package Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public class Level6 extends JFrame implements ActionListener {
    private JLabel backgroundLabel;
    private JButton exitButton;
    private JButton continueButton;
    private JLabel textLabel;
    private Timer timer;
    private int counter = 0;
    private String[] lines = {"<br>You have arrived 【Tour d’astronomie】!"
            +"<br>Here you will use and be subject to attacks of ATN."
            +"<br>You must defeat Mangemorts or join them."
            +"<br>Watch out for dodging your opponent's attacks!"
            +"<br>Are you ready to fight?!Click to <CONTINUE>!"
            +"<br>"
            +"<br>!!! Mangemorts are coming !!!"
    };
    private String currentText = "";

    public Level6() {
        // 设置窗口标题
        setTitle("HARRY POTTER");

        // 设置窗口大小
        setSize(1300, 800);

        // 设置窗口背景
        ImageIcon backgroundImg = new ImageIcon("HP_IMG/Tour d’astronomie.jpg");
        Image scaledImage = backgroundImg.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        backgroundImg = new ImageIcon(scaledImage);
        backgroundLabel = new JLabel(backgroundImg);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        // 创建 EXIT 按钮
        exitButton = new JButton("EXIT");
        exitButton.addActionListener(this);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFont(new Font("Algerian", Font.BOLD, 26));
        exitButton.setForeground(Color.WHITE);
        backgroundLabel.add(exitButton);

        // 创建文本标签
        textLabel = new JLabel();
        textLabel.setFont(new Font("Algerian", Font.BOLD, 40));
        textLabel.setForeground(Color.WHITE);
        textLabel.setBackground(new Color(0, 0, 0, 0));
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setVerticalAlignment(SwingConstants.TOP);
        getContentPane().add(textLabel, BorderLayout.CENTER);

        // 创建定时器
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter >= lines.length) {
                    timer.stop();
                    return;
                }
                String line = lines[counter];
                if (currentText.length() < line.length()) {
                    currentText = line.substring(0, currentText.length() + 1);
                    textLabel.setText("<html><div style='text-align: center;'>" + formatText(currentText) + "</div></html>");
                } else {
                    currentText += "<br>";
                    counter++;
                }
            }
        });
        // 启动定时器
        timer.start();

        // 创建 CONTINUE 按钮
        continueButton = new JButton("CONTINUE>>>");
        continueButton.addActionListener((ActionListener) this);
        continueButton.setBorderPainted(false);
        continueButton.setFocusPainted(false);
        continueButton.setContentAreaFilled(false);
        continueButton.setFont(new Font("Algerian", Font.BOLD, 30));
        continueButton.setForeground(Color.WHITE);
        backgroundLabel.add(continueButton);

        // 创建 ComponentListener 监听器
        ComponentListener componentListener = new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                // 获取窗口大小
                int width = getContentPane().getWidth();
                int height = getContentPane().getHeight();

                // 设置背景图的大小和位置
                backgroundLabel.setBounds(0, 0, width, height);

                // 设置 EXIT 按钮的位置
                exitButton.setBounds(width - 100, 0, 100, 70);

                //设置文本始终在顶层
                textLabel.getParent().setComponentZOrder(textLabel, 0);

                // 设置 CONTINUE 按钮的位置
                continueButton.setBounds(width - 250, height - 100, 300, 100);
            }
        };

        // 将 ComponentListener 监听器添加到窗口中
        addComponentListener(componentListener);

        // 设置窗口可见
        setVisible(true);
    }

    private String formatText(String text) {
        String[] lines = text.split("<br>");
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append("<p style='margin: 0; padding: 0;'>").append(line).append("</p>");
        }
        return sb.toString();
    }


    public void actionPerformed(ActionEvent e) {
        // 处理按钮点击事件
        if (e.getSource() == exitButton) {
            // 点击了 EXIT 按钮
            System.exit(0);
        } else if (e.getSource() == continueButton) {
            // 点击了 START GAME 按钮
            new Level66();
            dispose();
        }
    }

}
