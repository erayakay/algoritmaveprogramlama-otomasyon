
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegistrationFormApplication extends Application {

    private Object scan;
    private String sifre;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("KAYIT OL");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        addUIControls(gridPane);
        Scene scene = new Scene(gridPane, 800, 500);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private GridPane createRegistrationFormPane() {
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);

        gridPane.setPadding(new Insets(40, 40, 40, 40));

        gridPane.setHgap(10);

        gridPane.setVgap(10);

        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    public void addUIControls(GridPane gridPane) throws UnsupportedEncodingException {
       
        // form başlık
        Label headerLabel = new Label("KAYIT FORMU");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        //  ad Label
        Label nameLabel = new Label("ADINIZ : ");
        gridPane.add(nameLabel, 0, 1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1, 1);

        //  Email Label
        Label emailLabel = new Label("Email : ");
        gridPane.add(emailLabel, 0, 2);

        // email field
        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        gridPane.add(emailField, 1, 2);

        // şifre Label
        
        Label passwordLabel = new Label("ŞİFRE : ");
       
      
        gridPane.add(passwordLabel, 0, 3);

        //  şifre Field
        PasswordField passwordField = new PasswordField();
         sifre = passwordField.getText();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 3);

      
        Button submitButton = new Button("KAYDET");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                File yaz = new File("C:\\Users\\bilgisayaradıı\\Desktop/yaz.txt");
               
                try (FileWriter dosyayayaz = new FileWriter(yaz)) {
                    dosyayayaz.write(""+sifre);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "HATA!", "Adınız boş olamaz !");
                    return;
                }
                if (emailField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "HATA!", "Email boş olamaz !");
                    return;
                }
                if (passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "HATA!", "Şifre boş olamaz !");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "KAYIT BAŞARILI!", "Hoş geldiniz " + nameField.getText());
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) throws IOException {
 String sifre = null;
     

        launch(args);
    }

    public static class sifre {

        public sifre() {
        }
    }

   
    
}
