package Home;

import Background.Background1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    private JLabel backgroundLabel;
    private JButton exitButton;
    private JButton startButton;

    public Home() {
        // 设置窗口标题
        setTitle("HARRY POTTER");

        // 设置窗口大小
        setSize(1300, 800);

        // 设置窗口背景
        ImageIcon backgroundImg = new ImageIcon("HP_IMG\\face.png");
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
        exitButton.setBounds(getWidth() - 100, 0, 100, 30);
        backgroundLabel.add(exitButton);

        // 创建 START GAME 按钮
        startButton = new JButton("START GAME");
        startButton.addActionListener(this);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFont(new Font("Algerian", Font.BOLD, 40));
        startButton.setForeground(Color.WHITE);
        startButton.setBounds(getWidth() / 2 - 150, getHeight() / 2 - 50, 800, 100);
        backgroundLabel.add(startButton);

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

                // 设置 START GAME 按钮的位置
                startButton.setBounds(width / 2 - 150, height / 2 + 150, 300, 100);
            }
        };

        // 将 ComponentListener 监听器添加到窗口中
        addComponentListener(componentListener);

        // 设置窗口可见
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 处理按钮点击事件
        if (e.getSource() == exitButton) {
            // 点击了 EXIT 按钮
            System.exit(0);
        } else if (e.getSource() == startButton) {
            // 点击了 START GAME 按钮
            new Background1();
            dispose();
        }
    }

}
