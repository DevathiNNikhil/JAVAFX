package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class After {
    private Stage stage;
    public void total(ActionEvent event2) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../total/total.fxml"));
        Scene scene=new Scene(root, 600, 600);
        Stage primaryStage=new Stage();
        primaryStage.setTitle("Total sales");
        scene.getStylesheets().add(getClass().getResource("../total/goods.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void bill(ActionEvent event1) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("../Bill/bill.fxml"));
            Scene scene=new Scene(root, 600, 600);
            Stage primaryStage=new Stage();
            primaryStage.setTitle("Bill");
            scene.getStylesheets().add(getClass().getResource("../Bill/bill.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        }

    public void goods(ActionEvent event2) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("../goods/select.fxml"));
            stage=(Stage)((Node)event2.getSource()).getScene().getWindow();
            Scene scene=new Scene(root, 600, 400);
            stage.setTitle("Goods left");
            stage.setScene(scene);
            stage.show();
        }
    public void choose(ActionEvent event2) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("after.fxml"));
        stage=(Stage)((Node)event2.getSource()).getScene().getWindow();
        Scene scene=new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("application1.css").toExternalForm());
        stage.setTitle("choose");
        stage.setScene(scene);
        stage.show();
    }
    public void add(ActionEvent e) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../goods/add.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene=new Scene(root, 400, 400);
        stage.setTitle("ADD Goods");
        stage.setScene(scene);
        stage.show();
    }
    public void goods1(ActionEvent event2) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../goods./goods1.fxml"));
        Scene scene=new Scene(root, 600, 600);
        Stage primaryStage=new Stage();
        primaryStage.setTitle("Total Goods");
        scene.getStylesheets().add(getClass().getResource("../goods/goods.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void delete(ActionEvent event2) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../goods/delete.fxml"));
        stage=(Stage)((Node)event2.getSource()).getScene().getWindow();
        Scene scene=new Scene(root, 300, 250);
        stage.setTitle("Goods left");
        scene.getStylesheets().add(getClass().getResource("../goods/goods.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
