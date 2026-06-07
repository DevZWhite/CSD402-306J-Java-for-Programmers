/*
   Program Name: WaterHeatCalculatorController.java
   Author: Zachary White
   Date: June 7, 2026
   Course: CSD402 - Module 1

 * Description:
   MVC Controller for WaterHeatCalculator. Handles all user interaction
   and business logic. UI fields are injected by FXMLLoader via @FXML
   annotations — no manual layout code needed here.

 * Formula Reference:
   Q = waterMass * (finalTemperature - initialTemperature) * 4184
   Q       = Energy in Joules
   4184    = Specific heat capacity of water (J/kg·°C)
   Temperatures must be entered in Celsius
*/

package White_mod1_csd402;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class WaterHeatCalculatorController {

    // FXML-injected UI fields (matched by fx:id in the .fxml)
    @FXML private TextField tfMass;
    @FXML private TextField tfInitialTemp;
    @FXML private TextField tfFinalTemp;
    @FXML private Label     lblResult;

    // calculate() – reads inputs, applies formula, displays result
    @FXML
    private void calculate() {
        try {
            // Parse user inputs
            double waterMass          = Double.parseDouble(tfMass.getText().trim());
            double initialTemperature = Double.parseDouble(tfInitialTemp.getText().trim());
            double finalTemperature   = Double.parseDouble(tfFinalTemp.getText().trim());

            // Validate: mass must be a positive real number
            if (waterMass <= 0) {
                showError("Water mass must be a positive number.");
                return;
            }

            // Validate: final temp must be greater than initial temp
            if (finalTemperature <= initialTemperature) {
                showError("Final temperature must be greater than initial temperature.");
                return;
            }

            // Apply formula: Q = waterMass * (finalTemperature - initialTemperature) * 4184
            double Q = waterMass * (finalTemperature - initialTemperature) * 4184;

            // Display formatted result
            lblResult.setTextFill(Color.web("#1a8a1a"));
            lblResult.setText(String.format(
                "Energy Required (Q):%n%.2f kg \u00d7 (%.2f\u00b0C \u2212 %.2f\u00b0C) \u00d7 4184%n= %,.2f Joules",
                waterMass, finalTemperature, initialTemperature, Q
            ));

        } catch (NumberFormatException ex) {
            showError("Please enter valid numeric values for all fields.");
        }
    }

    // clearFields() – resets all inputs and the result label
    @FXML
    private void clearFields() {
        tfMass.clear();
        tfInitialTemp.clear();
        tfFinalTemp.clear();
        lblResult.setTextFill(Color.web("#1a8a1a"));
        lblResult.setText("Enter values above and click Calculate.");
    }

    // showError() – displays a validation error in red
    private void showError(String message) {
        lblResult.setTextFill(Color.CRIMSON);
        lblResult.setText("\u26a0  " + message);
    }
}
