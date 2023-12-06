package com.example.javafx6quiprend.Base;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Background4 extends Application {
    private Label textLabel;
    private int counter = 0;
    private String[] lines = {"If the card you played is the sixth in its row,",
            "you must pick up all cards in that row",
            "and will lose points for each bull head on these cards.",
            "",
            "THEN, Click the button to start the game!"};
    private String currentText = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 设置窗口标题
        primaryStage.setTitle("6 QUI PREND");

        // 创建根布局
        BorderPane root = new BorderPane();

        // 设置背景图像
        Image backgroundImage = new Image("file:IMG/background.jpg");
        BackgroundImage background = new BackgroundImage(backgroundImage, null, null, null, null);
        root.setBackground(new Background(background));

        // 创建顶部布局
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.CENTER_RIGHT);
        root.setTop(topBox);

        // 创建 EXIT 按钮
        Button exitButton = new Button("EXIT");
        exitButton.setFont(Font.font("Algerian", 26));
        exitButton.setTextFill(Color.web("#583b94"));
        exitButton.setOnAction(e -> System.exit(0));
        topBox.getChildren().add(exitButton);

        // 创建中央布局
        BorderPane centerPane = new BorderPane();
        centerPane.setPrefSize(1300, 800);
        root.setCenter(centerPane);

        // 创建文本标签
        textLabel = new Label();
        textLabel.setFont(Font.font("Algerian", 40));
        textLabel.setTextFill(Color.BLACK);
        textLabel.setAlignment(Pos.TOP_CENTER);
        centerPane.setCenter(textLabel);

        // 创建底部布局
        HBox bottomBox = new HBox();
        bottomBox.setAlignment(Pos.CENTER_RIGHT);
        root.setBottom(bottomBox);

        // 创建 CONTINUE 按钮
        Button continueButton = new Button("PLAY THE GAME >>>");
        continueButton.setFont(Font.font("Algerian", 30));
        continueButton.setTextFill(Color.web("#583b94"));
        continueButton.setOnAction(e -> {
            // new Game().start(primaryStage);
            // 修改为启动游戏界面的代码
            primaryStage.close();
        });
        bottomBox.getChildren().add(continueButton);

        // 创建场景
        Scene scene = new Scene(root);

        // 设置窗口大小
        primaryStage.setWidth(1300);
        primaryStage.setHeight(800);

        // 设置窗口场景
        primaryStage.setScene(scene);

        // 显示窗口
        primaryStage.show();

        // 创建时间轴
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.03), event -> {
            if (counter >= lines.length) {
                timeline.stop();
                return;
            }
            String line = lines[counter];
            if (currentText.length() < line.length()) {
                currentText = line.substring(0, currentText.length() + 1);
                textLabel.setText(currentText);
            } else {
                currentText += "\n";
                counter++;
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
