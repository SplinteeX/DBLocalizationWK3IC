import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class DBLocalizationApplication extends Application {

    private ComboBox<String> languageComboBox;
    private Label firstNameLabel, lastNameLabel, emailLabel;
    private TextField firstNameField, lastNameField, emailField;
    private Button saveButton;
    private ResourceBundle bundle;
    private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Initialize bundle with default locale
        bundle = ResourceBundle.getBundle("MessageBundle", Locale.ENGLISH);
        primaryStage.setTitle(getString("app.title"));

        // Language selection ComboBox
        languageComboBox = new ComboBox<>();
        languageComboBox.getItems().addAll("English", "Farsi", "Japanese");
        languageComboBox.setValue("English");
        languageComboBox.setOnAction(e -> updateLanguage());

        // Labels and TextFields
        firstNameLabel = new Label();
        lastNameLabel = new Label();
        emailLabel = new Label();

        firstNameField = new TextField();
        lastNameField = new TextField();
        emailField = new TextField();

        saveButton = new Button();
        saveButton.setOnAction(e -> saveData());

        // GridPane Layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(new Label(getString("select.language")), 0, 0);
        gridPane.add(languageComboBox, 1, 0);

        gridPane.add(firstNameLabel, 0, 1);
        gridPane.add(firstNameField, 1, 1);

        gridPane.add(lastNameLabel, 0, 2);
        gridPane.add(lastNameField, 1, 2);

        gridPane.add(emailLabel, 0, 3);
        gridPane.add(emailField, 1, 3);

        gridPane.add(saveButton, 1, 4);

        updateLanguage();  // Initialize labels with default language

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateLanguage() {
        String selectedLanguage = languageComboBox.getValue();
        Locale locale;

        switch (selectedLanguage) {
            case "Farsi":
                locale = new Locale("fa");
                break;
            case "Japanese":
                locale = new Locale("ja");
                break;
            default:
                locale = new Locale("en");
        }

        bundle = ResourceBundle.getBundle("MessageBundle", locale);
        primaryStage.setTitle(getString("app.title"));

        firstNameLabel.setText(getString("label.firstName"));
        lastNameLabel.setText(getString("label.lastName"));
        emailLabel.setText(getString("label.email"));
        saveButton.setText(getString("button.save"));
    }

    private String getString(String key) {
        return bundle.getString(key);
    }

    private String getTableName() {
        // Return table name based on selected language
        switch (languageComboBox.getValue()) {
            case "Farsi":
                return "employee_fa";
            case "Japanese":
                return "employee_ja";
            default:
                return "employee_en";
        }
    }

    private void saveData() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String tableName = getTableName(); // Get the appropriate table name

        // Create an instance of EmployeeDataHandler to save data
        EmployeeDataHandler dataHandler = new EmployeeDataHandler();
        dataHandler.saveData(firstName, lastName, email, tableName);

        // Clear fields after attempting to save
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
