package Background;

import Base.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Background3 extends JFrame implements ActionListener {

    private JLabel backgroundLabel;
    private JButton exitButton;
    private JLabel textLabel;
    private  JButton Button1;
    private  JButton Button2;
    private  JButton Button3;
    private  JButton Button4;

    private Timer timer;
    private int counter = 0;
    private String[] lines = {"<br>There are four academies in the area."+"<br>Which one would you like to join?"+"<br>Please note that you cannot change your choice once you have made it."};
    private String currentText = "";


    public Background3() {
        // 设置窗口标题
        setTitle("HARRY POTTER");

        // 设置窗口大小
        setSize(1300, 800);

        // 设置窗口背景
        ImageIcon backgroundImg = new ImageIcon("HP_IMG\\face-bol.png");
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
                    return;
                }
                String line = lines[counter];
                currentText = line;
                textLabel.setText("<html><div style='text-align: center;'>" + formatText(currentText) + "</div></html>");
                counter++;
            }
        });
        // 启动定时器
        timer.start();

        // 创建四个选择按钮
        Button1 = new JButton("Gryffindor");
        Button1.setFont(new Font("Algerian", Font.BOLD, 40));
        Button1.setForeground(Color.RED);
        Button1.addActionListener((ActionListener) this);
        Button1.setBorderPainted(false);
        Button1.setFocusPainted(false);
        Button1.setContentAreaFilled(false);
        Button1.setBackground(new Color(255, 255, 255, 128));
        Button1.setPreferredSize(new Dimension(100, 50));
        Button1.setOpaque(true);

        Button2 = new JButton("Ravenclaw");
        Button2.setFont(new Font("Algerian", Font.BOLD, 40));
        Button2.setForeground(Color.BLUE);
        Button2.addActionListener((ActionListener) this);
        Button2.setBorderPainted(false);
        Button2.setFocusPainted(false);
        Button2.setContentAreaFilled(false);
        Button2.setBackground(new Color(255, 255, 255, 128));
        Button2.setPreferredSize(new Dimension(100, 50));
        Button2.setOpaque(true);

        Button3 = new JButton("Hufflepuff");
        Button3.setFont(new Font("Algerian", Font.BOLD, 40));
        Button3.setForeground(Color.YELLOW);
        Button3.setBackground(new Color(255, 255, 255, 128));
        Button3.addActionListener((ActionListener) this);
        Button3.setBorderPainted(false);
        Button3.setFocusPainted(false);
        Button3.setContentAreaFilled(false);
        Button3.setPreferredSize(new Dimension(100, 50));
        Button3.setOpaque(true); // 设置按钮不透明

        Button4 = new JButton("Slytherin");
        Button4.setFont(new Font("Algerian", Font.BOLD, 40));
        Button4.setForeground(Color.GREEN);
        Button4.addActionListener((ActionListener) this);
        Button4.setBorderPainted(false);
        Button4.setFocusPainted(false);
        Button4.setContentAreaFilled(false);
        Button4.setBackground(new Color(255, 255, 255, 128));
        Button4.setPreferredSize(new Dimension(100, 50));
        Button4.setOpaque(true);

        // 添加选择面板到主面板中
        backgroundLabel.add(Button1);
        backgroundLabel.add(Button2);
        backgroundLabel.add(Button3);
        backgroundLabel.add(Button4);


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

                Button1.setBounds(300, 350, 300, 100);
                Button2.setBounds(700, 350, 300, 100);
                Button3.setBounds(300, 550, 300, 100);
                Button4.setBounds(700, 550, 300, 100);

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
        Base base = new Base();
        // 处理按钮点击事件
        if (e.getSource() == exitButton) {
            // 点击了 EXIT 按钮
            System.exit(0);
        }
        if (e.getSource() == Button1){
            base.setHP(140);
            base.setSA(0.7);
            base.setNumPotions(1);
            new Background4();
            dispose();
        } else if (e.getSource() == Button2){
            base.setHP(100);
            base.setSA(0.9);
            base.setNumPotions(1);
            new Background4();
            dispose();
        } else if(e.getSource() == Button3){
            base.setHP(100);
            base.setSA(0.7);
            base.setNumPotions(1);
            new Background4();
            dispose();
        } else if(e.getSource() == Button4){
            base.setHP(100);
            base.setSA(0.7);
            base.setNumPotions(1);
            new Background4();
            dispose();
        }
    }

}
