package com.example.javafx6quiprend.Base;

import com.example.javafx6quiprend.Game.Game;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Background1 extends Application {

    private Button exitButton;
    private Button playButton;
    private Button rulesButton;

    private String[] lines = {"Welcome to the 【6quiprend】",
            "This game allows 2-10 players to play",
            "A single play session lasts approximately 18 minutes",
            "",
            "To find out the rules of the game:",
            "click on [Rules]",
            "To go straight to the game:",
            "click on [Play the game]"};
    private int counter = 0;
    private Text textLabel;
    private ImageView imageLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 设置窗口标题
        primaryStage.setTitle("6 QUI PREND");

        // 创建根容器
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: transparent;");

        // 设置背景图
        Image backgroundImage = new Image("IMG/background.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        root.setCenter(backgroundImageView);

        // 创建退出按钮
        exitButton = new Button("EXIT");
        exitButton.setOnAction(e -> System.exit(0));
        exitButton.setFont(Font.font("Algerian", 26));
        exitButton.setTextFill(Color.web("#583b94"));
        exitButton.setStyle("-fx-background-color: transparent;");
        BorderPane.setAlignment(exitButton, Pos.TOP_RIGHT);
        root.setTop(exitButton);

        // 创建文本标签
        textLabel = new Text();
        textLabel.setFont(Font.font("Algerian", 40));
        textLabel.setFill(Color.BLACK);
        textLabel.setStyle("-fx-background-color: transparent;");
        textLabel.setWrappingWidth(800);
        textLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        root.setCenter(textLabel);

        // 创建图片标签
        imageLabel = new ImageView();
        Image image = new Image("IMG/logo 6QuiPrend.png");
        imageLabel.setImage(image);
        imageLabel.setFitWidth(300);
        imageLabel.setFitHeight(300);
        root.setLeft(imageLabel);

        // 创建 rule 按钮
        rulesButton = new Button("<<<RULES");
        rulesButton.setOnAction(e -> {
            Background2 background2 = new Background2();
            background2.start(primaryStage);
        });
        rulesButton.setFont(Font.font("Algerian", 30));
        rulesButton.setTextFill(Color.web("#583b94"));
        rulesButton.setStyle("-fx-background-color: transparent;");
        BorderPane.setAlignment(rulesButton, Pos.BOTTOM_LEFT);
        root.setBottom(rulesButton);

        // 创建 play game 按钮
        playButton = new Button("PLAY THE GAME>>>");
        playButton.setOnAction(e -> {
            Game game = new Game();
            game.start(primaryStage);
        });
        playButton.setFont(Font.font("Algerian", 30));
        playButton.setTextFill(Color.web("#583b94"));
        playButton.setStyle("-fx-background-color: transparent;");
        BorderPane.setAlignment(playButton, Pos.BOTTOM_RIGHT);
        root.setBottom(playButton);

        // 创建淡入淡出效果
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(5000), textLabel);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.setOnFinished(event -> {
            if (counter < lines.length) {
                textLabel.setText(textLabel.getText() + "\n" + lines[counter]);
                counter++;
                fadeTransition.playFromStart();
            }
        });
        fadeTransition.play();

        // 创建场景
        Scene scene = new Scene(root, 1300, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
