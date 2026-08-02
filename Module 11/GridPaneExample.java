/**
 * GridPaneExample.java
 *
 * Demonstrates the JavaFX GridPane layout pane.
 *
 * GridPane arranges its child nodes into a flexible grid made up of rows
 * and columns. Each child is assigned to a cell using column/row index
 * values, and a child can span multiple rows or columns if needed. This
 * makes GridPane a natural choice for form-style layouts, such as the
 * simple login form built below, where labels need to line up neatly
 * next to their corresponding input fields.
 *
 * To compile and run 
 * (JavaFX SDK required, adjust the path below):
 *   javac --module-path "path/to/javafx-sdk/lib" --add-modules javafx.controls GridPaneExample.java
 *   java  --module-path "path/to/javafx-sdk/lib" --add-modules javafx.controls GridPaneExample
 *
 * Author: Zachary White
 * Instructor: Darrell Payne
 * Class: CSD 402
 * Date: Aug 1, 2026
 */

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneExample extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create the GridPane container that will hold all the form controls.
        GridPane grid = new GridPane();

        // Padding adds space between the grid's outer edge and the window.
        grid.setPadding(new Insets(20, 20, 20, 20));

        // Hgap/Vgap control the horizontal and vertical spacing between cells.
        grid.setHgap(10);
        grid.setVgap(10);

        // Optional: uncomment the line below during development to visualize
        // the grid lines while positioning controls.
        // grid.setGridLinesVisible(true);

        // ColumnConstraints let us control how much space each column takes.
        // Here, column 0 (labels) stays narrow while column 1 (fields) grows.
        ColumnConstraints labelColumn = new ColumnConstraints(100);
        ColumnConstraints fieldColumn = new ColumnConstraints(200);
        grid.getColumnConstraints().addAll(labelColumn, fieldColumn);

        // A title label spanning both columns (column 0, row 0, span 2 columns, 1 row).
        Label title = new Label("Please Sign In");
        grid.add(title, 0, 0, 2, 1);

        // Username row: label in column 0, text field in column 1, row 1.
        Label userLabel = new Label("Username:");
        GridPane.setHalignment(userLabel, HPos.RIGHT);
        grid.add(userLabel, 0, 1);

        TextField userField = new TextField();
        grid.add(userField, 1, 1);

        // Password row: label in column 0, password field in column 1, row 2.
        Label passLabel = new Label("Password:");
        GridPane.setHalignment(passLabel, HPos.RIGHT);
        grid.add(passLabel, 0, 2);

        PasswordField passField = new PasswordField();
        grid.add(passField, 1, 2);

        // Login button placed in column 1, row 3, right-aligned within its cell.
        Button loginButton = new Button("Login");
        GridPane.setHalignment(loginButton, HPos.RIGHT);
        grid.add(loginButton, 1, 3);

        // A simple event handler to show the grid layout in action.
        loginButton.setOnAction(e ->
                title.setText("Welcome, " + userField.getText() + "!"));

        Scene scene = new Scene(grid, 340, 220);
        primaryStage.setTitle("JavaFX GridPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
