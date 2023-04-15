import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application{

  private TextField inputField;
    private Label outputLabel;

    public void start(Stage primaryStage) throws Exception{
      // Set up the UI
      Label titleLabel = new Label("Metric Converter");
      titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

      Label inputLabel = new Label("Enter conversion (e.g. 1 km = m):");
      inputField = new TextField();
      inputField.setPromptText("Enter conversion here");

      outputLabel = new Label();
      outputLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

      Button convertButton = new Button("Convert");
      convertButton.setOnAction(e -> convert());

      Button exitButton = new Button("Exit");
      exitButton.setOnAction(e -> primaryStage.close());

      HBox buttonBox = new HBox(10, convertButton, exitButton);
      buttonBox.setAlignment(Pos.CENTER_RIGHT);

      VBox root = new VBox(20, titleLabel, inputLabel, inputField, outputLabel, buttonBox);
      root.setPadding(new Insets(20));
      root.setAlignment(Pos.CENTER);

      // Create the scene and show the stage
      Scene scene = new Scene(root, 400, 300);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Metric Converter");
      primaryStage.show();
    }

    private void convert() {
      String input = inputField.getText();
      if (input.equals("exit") || input.equals("-1")) {
          System.exit(0);
      }

      String[] parts = input.split("\\s+");
      if (parts.length != 4) {
          outputLabel.setText("Invalid input. Please enter a valid conversion, e.g. 1 km = mi");
          return;
      }

      double value = Double.parseDouble(parts[0]);
      String fromUnit = parts[1];
      String toUnit = parts[3];

      if (fromUnit.equals("kg") && toUnit.equals("lb")) {
          value = value * 2.20462;
          outputLabel.setText(value + " lb");
      } else if (fromUnit.equals("lb") && toUnit.equals("kg")) {
          value = value / 2.20462;
          outputLabel.setText(value + " kg");
      } else if (fromUnit.equals("g") && toUnit.equals("oz")) {
          value = value * 0.035274;
          outputLabel.setText(value + " oz");
      } else if (fromUnit.equals("oz") && toUnit.equals("g")) {
          value = value / 0.035274;
          outputLabel.setText(value + " g");
      } else if (fromUnit.equals("km") && toUnit.equals("mi")) {
          value = value * 0.621371;
          outputLabel.setText(value + " mi");
      } else if (fromUnit.equals("mi") && toUnit.equals("km")) {
          value = value / 0.621371;
          outputLabel.setText(value + " km");
      } else if (fromUnit.equals("mm") && toUnit.equals("in")) {
          value = value * 0.0393701;
          outputLabel.setText(value + " in");
      } else if (fromUnit.equals("in") && toUnit.equals("mm")) {
          value = value / 0.0393701;
          outputLabel.setText(value + " mm");
      } else {
          outputLabel.setText("Invalid input. Please enter a valid conversion, e.g. 1 km = m");

      }
      System.out.println("Exiting the program...");
    }
  }
  