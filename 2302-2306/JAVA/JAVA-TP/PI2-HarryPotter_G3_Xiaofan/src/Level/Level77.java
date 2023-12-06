package Level;

import Base.Base;
import END.WIN;
import END.loss;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Scanner;

import static Base.Base.addPotion;

public class Level77 extends JFrame implements ActionListener {

    private JLabel backgroundLabel;
    private JButton exitButton;
    private JLabel textLabel;
    private  JButton Button1;
    private JLabel imageLabel;
    private Timer timer;
    private int counter = 0;
    private float alpha = 0.0f;
    private String[] lines = {"<br>In this level"
            +"<br>You can attack your enemies with the skills you know!"
            +"<br>This is the most powerful enemy of all"
            +"<br>Try with all your might!"};
    private String currentText = "";
    static int HP1 = 100;
    private static int Judgement;
    private Random random;


    public Level77() {
        random = new Random();
        // 设置窗口标题
        setTitle("HARRY POTTER");

        // 设置窗口大小
        setSize(1300, 800);

        // 设置窗口背景
        ImageIcon backgroundImg = new ImageIcon("HP_IMG/Castle.jpg");
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

        // 创建图片标签
        imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("HP_IMG\\NPC3.png");

        // 获取原图像的大小
        int originalWidth = imageIcon.getIconWidth();
        int originalHeight = imageIcon.getIconHeight();

        // 设置缩放后的大小
        int maxWidth = 500; // 设置最大宽度
        int maxHeight = 500; // 设置最大高度
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

        // 创建四个选择按钮
        Button1 = new JButton("Click to Attack !!!");
        Button1.setFont(new Font("Algerian", Font.BOLD, 40));
        Button1.setForeground(Color.WHITE);
        Button1.addActionListener((ActionListener) this);
        Button1.setBorderPainted(false);
        Button1.setFocusPainted(false);
        Button1.setContentAreaFilled(false);
        Button1.setBackground(new Color(255, 255, 255, 128));
        Button1.setPreferredSize(new Dimension(500, 50));
        Button1.setOpaque(true);


        // 添加选择面板到主面板中
        backgroundLabel.add(Button1);




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

                imageLabel.setBounds(10, 200, 300, 600);

                Button1.setBounds(300, 500, 900, 100);


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

    private void playGame() {
        Base base = new Base();
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int choice = input.nextInt();
        int probability = random.nextInt(10);

            if (probability >= 1) {
                switch (choice) {
                    case 1:
                        HP1 -= 30;
                        base.HP -= 5;
                        break;
                    case 2:
                        HP1 -= 60;
                        base.HP -= 5;
                        break;
                }
                HP1();
            } else {
                Dodge();
            }
    }


    public static void HP1(){

        while (Base.HP <= 0) {
            Judgement = 0;
            System.out.println("Oops ...... You have been defeated by the enemy......");
            break;
        }
        while (Base.HP > 0) {
            if(HP1 > 0) {
                System.out.println("Enemy is alive, it now has HP of " + HP1 + ".\nKeep fighting!");
            }
            if(HP1 <= 0) {
                Judgement = 1;
                System.out.println("Congratulations !!!The enemy has been defeated by you!!! \n");
                System.out.println("You are moving on to the next level......");
            }
            break;
        }
    }

    public static void Dodge(){
        System.out.println("The enemy dodged your attack!");
        System.out.println("Please attack again!");
        Base.HP -= 5;
    }

    public void actionPerformed(ActionEvent e) {

        // 处理按钮点击事件
        if (e.getSource() == exitButton) {
            // 点击了 EXIT 按钮
            System.exit(0);
        }
        if (e.getSource() == Button1){
            //playGame();
            // 50% chance of executing new WIN()
            if (random.nextDouble() < 0.5) {
                new WIN();
            } else {
                new loss();
            }
        }
    }

}
