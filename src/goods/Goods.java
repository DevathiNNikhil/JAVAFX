package goods;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Goods {
    @FXML
    private Label item;
    @FXML
    private Label qty;
    @FXML
    private Label price;
    @FXML
    private Label status1;
    @FXML
    private Label status2;
    @FXML
    private TextField item1;
    @FXML
    private TextField item2;
    @FXML
    private TextField qty1;
    @FXML
    private TextField price1;
    String s1,s2,s3;
    private Stage stage;
    public void data(){
        try {
            s1 = new String(Files.readAllBytes(Paths.get("item.txt")));
            s2 = new String(Files.readAllBytes(Paths.get("qty.txt")));
            s3 = new String(Files.readAllBytes(Paths.get("price.txt")));
        }
        catch(IOException e)
        {
            System.out.println("Invalid data");
        }
    }
    public void itemb(ActionEvent e)  {
        data();
        item.setText(s1);
        qty.setText(s2);
        price.setText(s3);
    }
    public void adds(ActionEvent e) throws IOException {
        data();
        String s5=item1.getText();
        String s6=qty1.getText();
        String s7=price1.getText();
        String s8 = new String(Files.readAllBytes(Paths.get("item1.txt")));
        String s9 = new String(Files.readAllBytes(Paths.get("qty1.txt")));
        String s10 = new String(Files.readAllBytes(Paths.get("price1.txt")));
        s1=s1+s5+"\r\n";
        s2=s2+s6+"\r\n";
        s3=s3+s7+"\r\n";
        s8=s8+s5+"\r\n";
        s9=s9+"0"+"\r\n";
        s10=s10+s7+"\r\n";
        Path fileName = Path.of("item.txt");
        Files.writeString(fileName, s1);
        Path fileName1 = Path.of("qty.txt");
        Files.writeString(fileName1, s2);
        Path fileName2 = Path.of("price.txt");
        Files.writeString(fileName2, s3);
        Path fileName4= Path.of("item1.txt");
        Files.writeString(fileName4, s8);
        Path fileName5 = Path.of("price1.txt");
        Files.writeString(fileName5, s10);
        Path fileName3 = Path.of("qty1.txt");
        Files.writeString(fileName3, s9);
        status2.setText("Item successfully added");
    }
    public void delete(ActionEvent e) throws IOException {
        data();
        String[] item=s1.split("\r\n");//apple banana item=["apple","banana"]
        String[] qty=s2.split("\r\n");
        String[] price=s3.split("\r\n");
        String s8="";
        String s9="";
        String s10="";
        int t;
        ArrayList<String> s5=new ArrayList();
        ArrayList<String> s6=new ArrayList();
        ArrayList<String> s7=new ArrayList();
        for(String i:item)
            s5.add(i);
        for(String i:qty)
            s6.add(i);
        for(String i:price)
            s7.add(i);
        t=s5.size();
        for(int i=0;i< s5.size();i++)
        {
            if(s5.get(i).equals(item2.getText())){
                s5.remove(i);
                s6.remove(i);
                s7.remove(i);
                status1.setText("item successfully deleted");
            }

        }
        if(s5.size()==t)
            status1.setText("item not found");
        for(String i:s5)
            s8+=i+"\r\n";
        for(String i:s6)
            s9+=i+"\r\n";
        for(String i:s7)
            s10+=i+"\r\n";
        Path fileName = Path.of("item.txt");
        Files.writeString(fileName, s8);
        Path fileName1 = Path.of("qty.txt");
        Files.writeString(fileName1, s9);
        Path fileName2 = Path.of("price.txt");
        Files.writeString(fileName2, s10);
    }
    public void home(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("select.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene=new Scene(root, 600, 400);
        stage.setTitle("choose");
        stage.setScene(scene);
        stage.show();
    }
}
