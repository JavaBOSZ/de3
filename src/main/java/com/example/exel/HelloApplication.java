package com.example.exel;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("class:"+i);
        }

        VBox clas = new VBox();

        {
            StackPane stackPane = new StackPane();
            stackPane.setPrefSize(100,50);
            stackPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;");
            stackPane.getChildren().add(new Label("class"));
            clas.getChildren().add(stackPane);
        }

        strings.forEach(e->{
            StackPane stackPane = new StackPane();
            stackPane.setPrefSize(100,50);
            stackPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;");
            stackPane.getChildren().add(new Label(e));
            clas.getChildren().add(stackPane);
        });





        HBox hbox = new HBox();

        hbox.getChildren().add(clas);


        ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList("CheckBox", "TextField"));
        choiceBox.getSelectionModel().selectFirst();

        TextField nameCol = new TextField();

        Button add = new Button("add");
        add.setOnAction(e->{

            VBox tmp = new VBox();

            if (Objects.equals(choiceBox.getValue(), "CheckBox")){
                {
                    StackPane stackPane = new StackPane();
                    stackPane.setPrefSize(100,50);
                    stackPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;");
                    stackPane.getChildren().add(new Label(nameCol.getText()));
                    tmp.getChildren().add(stackPane);
                }
                for (int i = 0; i < 10; i++) {
                    StackPane stackPane = new StackPane();
                    stackPane.setPrefSize(100,50);
                    stackPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;");
                    stackPane.getChildren().add(new CheckBox());
                    tmp.getChildren().add(stackPane);
                }

            } else if (Objects.equals(choiceBox.getValue(), "TextField")) {
                {
                    StackPane stackPane = new StackPane();
                    stackPane.setPrefSize(200,50);
                    stackPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;");
                    stackPane.getChildren().add(new Label(nameCol.getText()));
                    tmp.getChildren().add(stackPane);
                }
                for (int i = 0; i < 10; i++) {
                    StackPane stackPane = new StackPane();
                    stackPane.setPrefSize(200,50);
                    stackPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;");
                    stackPane.getChildren().add(new TextField());
                    tmp.getChildren().add(stackPane);
                }
            }

            hbox.getChildren().add(tmp);

        });
        HBox h = new HBox(choiceBox,nameCol, add);


        VBox vBox = new VBox(h,hbox);
        Scene scene = new Scene(vBox,1000,600);
        stage.setTitle("exel");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}