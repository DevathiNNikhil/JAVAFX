package total;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Total {
    @FXML
    private Label item;
    @FXML
    private Label qty;
    @FXML
    private Label price;
    @FXML
    private Label value;
    public void btn(ActionEvent e) throws IOException {
        List<String> l = new ArrayList();
        List<Integer> q = new ArrayList();
        List<Integer> price1 = new ArrayList();
        List<Integer> value1=new ArrayList();
        String[] items;
        String[] qs;
        String[] prices;
        String s1 = new String(Files.readAllBytes(Paths.get("item1.txt")));
        String s2 = new String(Files.readAllBytes(Paths.get("qty1.txt")));
        String s3 = new String(Files.readAllBytes(Paths.get("price1.txt")));
        items = s1.split("\r\n");
        qs = s2.split("\r\n");
        prices = s3.split("\r\n");
        for (String s : items)
            l.add(s);
        for (String s : qs) {
            q.add(Integer.parseInt(s));
        }
        for (String s : prices)
            price1.add(Integer.parseInt(s));
        int sum=0;
        String s4="";
        String s5="";
        String s6="";
        item.setText("");
        qty.setText("");
        price.setText("");
        for(int i=0;i<l.size();i++){
            if(q.get(i)!=0){
                s4+=l.get(i)+"\n";
                s5+=String.valueOf(q.get(i))+"\n";
                s6+=String.valueOf(q.get(i)*price1.get(i))+"\n";
                value1.add(q.get(i)*price1.get(i));
            }
        }
        for(int i:value1)
            sum+=i;
        value.setText(String.valueOf(sum));
        item.setText(s4);
        qty.setText(s5);
        price.setText(s6);
    }
}
