/*
   Program Name: WaterHeatCalculator.java
   Author: Zachary White
   Date: June 7, 2026
   Course: CSD402 - Module 1 Darrell Payne

   Requirements:
   JDK Version: 26.0.1
   JavaFX Version: 26.0.1

 * Description:
   Application entry point. Loads the FXML layout and launches the JavaFX stage.
   All UI logic is handled by WaterHeatCalculatorController.java.
   All UI layout is defined in water_heat_calculator.fxml.
*/

package White_mod1_csd402;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WaterHeatCalculator extends Application {

    // start() – loads FXML, sets scene, shows stage
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("water_heat_calculator.fxml")
        );

        Scene scene = new Scene(loader.load(), 580, 430);

        primaryStage.setTitle("Water Heat Energy Calculator \u2013 CSD402 Mod 1");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // main() – application entry point
    public static void main(String[] args) {
        launch(args);
    }
}
