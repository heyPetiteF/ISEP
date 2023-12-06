package com.example.javafx6quiprend.Base;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Home extends Application {

    private Button exitButton;
    private Button startButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 设置窗口标题
        primaryStage.setTitle("6QUIPREND");

        // 创建根容器
        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);

        // 设置背景图
        Image backgroundImage = new Image(getClass().getResourceAsStream("IMG\\background-1.png"));
        ImageView backgroundImageView = new ImageView(backgroundImage);
        root.getChildren().add(backgroundImageView);

        // 创建退出按钮
        exitButton = new Button("EXIT");
        exitButton.setOnAction(e -> System.exit(0));
        exitButton.setFont(Font.font("Algerian", FontWeight.BOLD, 28));
        exitButton.setTextFill(Color.web("#583b94"));
        exitButton.setStyle("-fx-background-color: transparent;");
        StackPane.setAlignment(exitButton, Pos.TOP_RIGHT);

        // 创建开始游戏按钮
        startButton = new Button("START GAME");
        startButton.setOnAction(e -> {
            Background1 background1 = new Background1();
            background1.start(primaryStage);
        });
        startButton.setFont(Font.font("Algerian", FontWeight.BOLD, 43));
        startButton.setTextFill(Color.web("#583b94"));
        startButton.setStyle("-fx-background-color: transparent;");
        StackPane.setAlignment(startButton, Pos.CENTER);

        // 创建垂直布局容器，并将按钮添加到其中
        VBox buttonsContainer = new VBox(30);
        buttonsContainer.setAlignment(Pos.CENTER);
        buttonsContainer.getChildren().addAll(exitButton, startButton);

        // 创建场景，并将根容器添加到其中
        Scene scene = new Scene(root, 1300, 800);
        root.getChildren().add(buttonsContainer);

        // 监听场景大小变化
        scene.widthProperty().addListener((observable, oldValue, newValue) -> {
            adjustComponentPositions(scene.getWidth(), scene.getHeight());
        });
        scene.heightProperty().addListener((observable, oldValue, newValue) -> {
            adjustComponentPositions(scene.getWidth(), scene.getHeight());
        });

        // 设置场景
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void adjustComponentPositions(double width, double height) {
        // 设置按钮位置
        StackPane.setAlignment(exitButton, Pos.TOP_RIGHT);
        StackPane.setAlignment(startButton, Pos.CENTER);
    }
}
