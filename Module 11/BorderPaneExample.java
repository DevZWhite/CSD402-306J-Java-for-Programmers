/**
 * BorderPaneExample.java
 *
 * Demonstrates the JavaFX BorderPane layout pane.
 *
 * BorderPane divides its available space into five distinct regions:
 * top, bottom, left, right, and center. The top and bottom regions
 * stretch to the full width of the pane, the left and right regions
 * fill the remaining height between them, and the center region
 * expands to fill whatever space is left over. Any region that is not
 * used is simply not allocated space. This makes BorderPane a natural
 * fit for the classic "application shell" layout: a toolbar on top,
 * a status bar on the bottom, a navigation panel on the side, and a
 * main working area in the middle.
 *
 * To compile and run: 
 * (JavaFX SDK required, adjust the path below):
 *   javac --module-path "path/to/javafx-sdk/lib" --add-modules javafx.controls BorderPaneExample.java
 *   java  --module-path "path/to/javafx-sdk/lib" --add-modules javafx.controls BorderPaneExample
 *
 * Author: Zachary White
 * Instructor: Darrell Payne
 * Class: CSD 402
 * Date: Aug 1, 2026
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BorderPaneExample extends Application {

    @Override
    public void start(Stage primaryStage) {

        // The BorderPane is the single root container for this example.
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // --- TOP region: acts as a simple toolbar ---
        HBox toolbar = new HBox(10);
        toolbar.setAlignment(Pos.CENTER_LEFT);
        Button newButton = new Button("New");
        Button openButton = new Button("Open");
        Button saveButton = new Button("Save");
        toolbar.getChildren().addAll(newButton, openButton, saveButton);
        root.setTop(toolbar);

        // --- LEFT region: acts as a navigation panel ---
        ListView<String> navList = new ListView<>();
        navList.getItems().addAll("Home", "Reports", "Settings", "About");
        navList.setPrefWidth(140);
        root.setLeft(navList);

        // --- CENTER region: the main working area; it automatically ---
        // expands to fill whatever space is left after the other four
        // regions have taken what they need.
        Label centerContent = new Label(
                "Main content area.\nSelect an item from the left panel.");
        centerContent.setWrapText(true);
        BorderPane.setAlignment(centerContent, Pos.CENTER);
        root.setCenter(centerContent);

        // --- RIGHT region: extra contextual information panel ---
        Label infoPanel = new Label("Info\nPanel");
        infoPanel.setPadding(new Insets(5));
        root.setRight(infoPanel);

        // --- BOTTOM region: acts as a status bar ---
        Label statusBar = new Label("Ready.");
        statusBar.setPadding(new Insets(5, 0, 0, 0));
        root.setBottom(statusBar);

        // Wire up a simple interaction to show the layout responding to events.
        navList.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> {
                    if (newVal != null) {
                        centerContent.setText("Showing: " + newVal);
                        statusBar.setText("Navigated to " + newVal);
                    }
                });

        Scene scene = new Scene(root, 480, 320);
        primaryStage.setTitle("JavaFX BorderPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
