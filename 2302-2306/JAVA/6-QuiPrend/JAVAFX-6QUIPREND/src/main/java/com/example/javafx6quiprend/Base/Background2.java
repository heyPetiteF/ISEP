package com.example.javafx6quiprend.Base;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Background2 extends Application {

    private ImageView backgroundImageView;
    private Button exitButton;
    private Button continueButton;
    private Text textLabel;
    private int counter = 0;
    private String[] lines = {"In 【6 nimmt】 ",
            "there are 104 cards numbered from 1 to 104.",
            "Every card has at least 1 small bull head on it",
            "which will score against you."};
    private String currentText = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("6 QUI PREND");

        // 创建根容器
        StackPane root = new StackPane();
        root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        // 添加背景图像
        Image backgroundImage = new Image("IMG/background.jpg");
        backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1300);
        backgroundImageView.setFitHeight(800);
        root.getChildren().add(backgroundImageView);

        // 创建文本标签
        textLabel = new Text();
        textLabel.setFont(Font.font("Algerian", 40));
        textLabel.setFill(Color.BLACK);
        textLabel.setWrappingWidth(800);
        textLabel.setTextOrigin(javafx.geometry.VPos.TOP);
        textLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        root.getChildren().add(textLabel);

        // 设置 EXIT 按钮
        exitButton = new Button("EXIT");
        exitButton.setFont(Font.font("Algerian", 26));
        exitButton.setTextFill(Color.web("#583b94"));
        exitButton.setOnAction(e -> System.exit(0));
        StackPane.setAlignment(exitButton, Pos.TOP_RIGHT);
        StackPane.setMargin(exitButton, new javafx.geometry.Insets(10));
        root.getChildren().add(exitButton);

        // 设置 CONTINUE 按钮
        continueButton = new Button("CONTINUE>>>");
        continueButton.setFont(Font.font("Algerian", 30));
        continueButton.setTextFill(Color.web("#583b94"));
        continueButton.setOnAction(e -> {
            new Background3().start(new Stage());
            primaryStage.close();
        });
        StackPane.setAlignment(continueButton, Pos.BOTTOM_CENTER);
        StackPane.setMargin(continueButton, new javafx.geometry.Insets(0, 0, 50, 0));
        root.getChildren().add(continueButton);

        // 创建场景
        Scene scene = new Scene(root, 1300, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

        // 启动定时器
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(20), e -> {
            if (counter >= lines.length) {
                timeline.stop();
                return;
            }
            String line = lines[counter];
            if (currentText.length() < line.length()) {
                currentText = line.substring(0, currentText.length() + 1);
                textLabel.setText(currentText);
            } else {
                counter++;
                currentText = "";
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
