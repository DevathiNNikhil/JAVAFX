package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Controller {
    @FXML
    private Label status;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    private Stage stage;
    public void login(ActionEvent event) throws Exception{
        if (username.getText().equals("user1") && password.getText().equals("24022002")){
            status.setText("Login success");
            Parent root = FXMLLoader.load(getClass().getResource("after.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(root, 600, 400);
            scene.getStylesheets().add(getClass().getResource("application1.css").toExternalForm());
            stage.setTitle("choose");
            stage.setScene(scene);
            stage.show();
        }
        else{
            status.setText("Login denied");
        }
    }
}
