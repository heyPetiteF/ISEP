package Background;

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
import game.*;

public class Background1 extends JFrame implements ActionListener {
    private JLabel backgroundLabel;
    private JButton exitButton;
    private JButton playButton;
    private JButton rulesButton;
    private JLabel textLabel;
    private Timer timer;
    private int counter = 0;
    private String[] lines = {"<br>Welcome to the 【6quiprend】"
            +"<br>This game allows 2-10 players to play"
            +"<br>a single play session lasts approximately 18 minutes"
            +"<br>"
            +"<br>To find out the rules of the game: "
            +"<br>click on [Rules] "
            +"<br>To go straight to the game:"
            +"<br>click on [Play the game] "};
    private String currentText = "";
    private JLabel imageLabel;
    private float alpha = 0.0f;

    public Background1() {
        // 设置窗口标题
        setTitle("6 QUI PREND");

        // 设置窗口大小
        setSize(1300, 800);

        // 设置窗口背景
        ImageIcon backgroundImg = new ImageIcon("IMG\\background.jpg");
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
        exitButton.setForeground(Color.decode("#583b94"));
        backgroundLabel.add(exitButton);

        // 创建文本标签
        textLabel = new JLabel();
        textLabel.setFont(new Font("Algerian", Font.BOLD, 40));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBackground(new Color(0, 0, 0, 0));
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setVerticalAlignment(SwingConstants.TOP);
        getContentPane().add(textLabel, BorderLayout.CENTER);

        // 创建定时器
        timer = new Timer(10, new ActionListener() {
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
        ImageIcon imageIcon = new ImageIcon("IMG\\logo 6QuiPrend.png");

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
            alpha += 0.005f;
            if (alpha > 1.0f) {
                alpha = 1.0f;
            }
            imageLabel.setIcon(getAlphaImageIcon(finalImageIcon, alpha));
        });
        // 启动定时器
        timer.start();

        // 创建 rule 按钮
        rulesButton = new JButton("<<<RULES");
        rulesButton.addActionListener((ActionListener) this);
        rulesButton.setBorderPainted(false);
        rulesButton.setFocusPainted(false);
        rulesButton.setContentAreaFilled(false);
        rulesButton.setFont(new Font("Algerian", Font.BOLD, 30));
        rulesButton.setForeground(Color.decode("#583b94"));
        backgroundLabel.add(rulesButton);

      // 创建 play game 按钮
        playButton = new JButton("PLAY THE GAME>>>");
        playButton.addActionListener((ActionListener) this);
        playButton.setBorderPainted(false);
        playButton.setFocusPainted(false);
        playButton.setContentAreaFilled(false);
        playButton.setFont(new Font("Algerian", Font.BOLD, 30));
        playButton.setForeground(Color.decode("#583b94"));
        backgroundLabel.add(playButton);

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

                imageLabel.setBounds(50, 100, 300, 600);

                rulesButton.setBounds(10, height - 100, 200, 100);
                // 设置 PLAY 按钮的位置
                playButton.setBounds(width - 400, height - 100, 500, 100);
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
            BufferedImage image = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB_PRE);
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
        } else if (e.getSource() == playButton) {
            // 点击了 START GAME 按钮
            new Game();
            dispose();
        }else if (e.getSource() == rulesButton) {
            // 点击了 START GAME 按钮
            new Background2();
            dispose();
        }
    }

}
