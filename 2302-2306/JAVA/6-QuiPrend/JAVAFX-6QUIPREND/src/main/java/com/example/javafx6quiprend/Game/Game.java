package com.example.javafx6quiprend.Game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Game extends Application {
    private ComboBox<Integer> playerCountComboBox;

    @Override
    public void start(Stage primaryStage) {
        // Set window title
        primaryStage.setTitle("6 QUI PREND");

        // Create root layout
        BorderPane root = new BorderPane();

        // Set window background
        Image backgroundImage = new Image("file:IMG/background.jpg");
        BackgroundImage background = new BackgroundImage(backgroundImage, null, null, null, null);
        root.setBackground(new Background(background));

        // Create top layout
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.CENTER_RIGHT);
        root.setTop(topBox);

        // Create EXIT button
        Button exitButton = createButton("EXIT", 26);
        exitButton.setOnAction(e -> System.exit(0));
        topBox.getChildren().add(exitButton);

        // Create center layout
        BorderPane centerPane = new BorderPane();
        centerPane.setPrefSize(1300, 800);
        root.setCenter(centerPane);

        // Create player count combo box and confirm button
        playerCountComboBox = createComboBox(new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10}, 26);
        playerCountComboBox.setPrefSize(200, 50);
        centerPane.setCenter(playerCountComboBox);

        Button confirmButton = createButton("Confirm", 26);
        confirmButton.setOnAction(e -> {
            int playerCount = playerCountComboBox.getValue();
            createPlayerIDFields(playerCount);
        });
        centerPane.setRight(confirmButton);

        // Create bottom layout
        HBox bottomBox = new HBox();
        bottomBox.setAlignment(Pos.CENTER_RIGHT);
        root.setBottom(bottomBox);

        // Create CONTINUE button
        Button continueButton = createButton("CONTINUE >>>", 30);
        continueButton.setOnAction(e -> {
            new Game().start(primaryStage);
            // Dispose current window if needed
            // primaryStage.close();
        });
        bottomBox.getChildren().add(continueButton);

        // Create scene
        Scene scene = new Scene(root);

        // Set window size
        primaryStage.setWidth(1300);
        primaryStage.setHeight(800);

        // Set window scene
        primaryStage.setScene(scene);

        // Show the window
        primaryStage.show();
    }

    private Button createButton(String text, int fontSize) {
        Button button = new Button(text);
        button.setFont(Font.font("Algerian", fontSize));
        button.setTextFill(Color.web("#583b94"));
        button.setFocusTraversable(false);
        return button;
    }

    private ComboBox<Integer> createComboBox(Integer[] items, int fontSize) {
        ComboBox<Integer> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(items);
        comboBox.setValue(items[0]);
        comboBox.setStyle("-fx-font-family: Algerian; -fx-font-size: " + fontSize + "px; -fx-text-fill: #583b94;");
        return comboBox;
    }

    private void createPlayerIDFields(int playerCount) {
        // TODO: Implement player ID fields creation logic
        // You can use JavaFX controls like Label and TextField to create the necessary fields
    }

    public static void main(String[] args) {
        launch(args);
    }
}
