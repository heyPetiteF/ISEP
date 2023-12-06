package Base;

import Background.Background4;
import Level.Level2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class usePotion1 extends JFrame implements ActionListener {
    private JLabel backgroundLabel;
    private JButton exitButton;
    private JButton continueButton;
    private JLabel textLabel;
    private Timer timer;
    private int counter = 0;
    private String[] lines = {"<br>Now you have " + Base.getNumPotions() + "Potion(s)" + "<br>Do you want to use one?"};
    private String currentText = "";
    private JLabel imageLabel;
    private float alpha = 0.0f;
    private  JButton Button1;
    private  JButton Button2;

    public usePotion1() {
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

        // 创建图片标签
        imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("HP_IMG\\NPC5.png");

        // 获取原图像的大小
        int originalWidth = imageIcon.getIconWidth();
        int originalHeight = imageIcon.getIconHeight();

        // 设置缩放后的大小
        int maxWidth = 400; // 设置最大宽度
        int maxHeight = 400; // 设置最大高度
        int scaledWidth, scaledHeight;
        double scaleFactor = 1.0;
        if (originalWidth > maxWidth) {
            scaleFactor = (double)maxWidth / (double)originalWidth;
        } else if (originalHeight > maxHeight) {
            scaleFactor = (double)maxHeight / (double)originalHeight;
        }
        scaledWidth = (int)(originalWidth * scaleFactor);
        scaledHeight = (int)(originalHeight * scaleFactor);

        // 对图像进行缩放
        Image image = imageIcon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);

        imageLabel.setIcon(imageIcon);
        imageLabel.setBackground(new Color(0, 0, 0, 0));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);
        backgroundLabel.add(imageLabel);

        // 创建定时器
        ImageIcon finalImageIcon = imageIcon;
        timer = new Timer(10, e -> {
            if (alpha >= 1.0f) {
                timer.stop();
                return;
            }
            alpha += 0.05f;
            if (alpha > 1.0f) {
                alpha = 1.0f;
            }
            imageLabel.setIcon(getAlphaImageIcon(finalImageIcon, alpha));
        });
        // 启动定时器
        timer.start();

        // 创建四个选择按钮
        Button1 = new JButton("YES");
        Button1.setFont(new Font("Algerian", Font.BOLD, 40));
        Button1.setForeground(Color.GREEN);
        Button1.addActionListener((ActionListener) this);
        Button1.setBorderPainted(false);
        Button1.setFocusPainted(false);
        Button1.setContentAreaFilled(false);
        Button1.setBackground(new Color(255, 255, 255, 128));
        Button1.setPreferredSize(new Dimension(100, 50));
        Button1.setOpaque(true);

        Button2 = new JButton("NO");
        Button2.setFont(new Font("Algerian", Font.BOLD, 40));
        Button2.setForeground(Color.RED);
        Button2.addActionListener((ActionListener) this);
        Button2.setBorderPainted(false);
        Button2.setFocusPainted(false);
        Button2.setContentAreaFilled(false);
        Button2.setBackground(new Color(255, 255, 255, 128));
        Button2.setPreferredSize(new Dimension(100, 50));
        Button2.setOpaque(true);

        backgroundLabel.add(Button1);
        backgroundLabel.add(Button2);


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

                imageLabel.setBounds(50, 200, 300, 600);

                Button1.setBounds(300, 350, 300, 100);
                Button2.setBounds(700, 350, 300, 100);

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

    // 获取指定透明度的ImageIcon
    private ImageIcon getAlphaImageIcon(ImageIcon imageIcon, float alpha) {
        BufferedImage image = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g.drawImage(imageIcon.getImage(), 0, 0, null);
        g.dispose();
        return new ImageIcon(image);
    }

    public void actionPerformed(ActionEvent e) {
        // 处理按钮点击事件
        if (e.getSource() == exitButton) {
            // 点击了 EXIT 按钮
            System.exit(0);
        }
        if (e.getSource() == Button1) {
            Base.usePotion();
            new Level2();
            dispose();
        } else if (e.getSource() == Button2) {
            new Level2();
            dispose();
        }
    }

}
