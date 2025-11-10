//Lab Session:12 (Student enrollment system with GUI front end)
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;

public class Lab12 {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Record System");

        // Labels and Inputs
        Label nameLabel = new Label("Student Name:");
        TextField nameField = new TextField();
        
        Label idLabel = new Label("Student ID:");
        TextField idField = new TextField();
        
        Label courseLabel = new Label("Course:");
        TextField courseField = new TextField();
        
        Button addButton = new Button("Add Record");
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(150);

        // Event Handling for Button
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String id = idField.getText();
            String course = courseField.getText();

            if (name.isEmpty() || id.isEmpty() || course.isEmpty()) {
                outputArea.appendText("Please fill all fields!\n");
            } else {
                outputArea.appendText("Record Added: " + name + " | ID: " + id + " | Course: " + course + "\n");
                nameField.clear();
                idField.clear();
                courseField.clear();
            }
        });

        // Layout
        GridPane form = new GridPane();
        form.setPadding(new Insets(15));
        form.setVgap(10);
        form.setHgap(10);

        form.add(nameLabel, 0, 0);
        form.add(nameField, 1, 0);
        form.add(idLabel, 0, 1);
        form.add(idField, 1, 1);
        form.add(courseLabel, 0, 2);
        form.add(courseField, 1, 2);
        form.add(addButton, 1, 3);

        VBox layout = new VBox(15, form, outputArea);
        layout.setPadding(new Insets(15));

        Scene scene = new Scene(layout, 400, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
