package com.example.worddictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Group root;
    @Override
    public void start(Stage stage) throws IOException {
        root=new Group();
        DictionaryPage page=new DictionaryPage();
        root.getChildren().add(page.root);
        Scene scene = new Scene(root, 600, 497);
        stage.setTitle("WordDictionary");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}