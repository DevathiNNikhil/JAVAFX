package Bill;

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

public class Bill {
    @FXML
    private Label status;
    @FXML
    private TextField item;
    @FXML
    private TextField qty;
    @FXML
    private Label item1;
    @FXML
    private Label qty1;
    @FXML
    private Label price2;
    @FXML
    private Label value;
    List<String> l = new ArrayList();
    List<Integer> q = new ArrayList();
    List<Integer> price1 = new ArrayList();
    List<Integer> value1=new ArrayList();
    String[] items;
    String[] qs;
    String[] prices;
    String s4 = "";
    String s5 = "";
    String s6="";
    void data() {
        try {
            String s1 = new String(Files.readAllBytes(Paths.get("item.txt")));
            String s2 = new String(Files.readAllBytes(Paths.get("qty.txt")));
            String s3 = new String(Files.readAllBytes(Paths.get("price.txt")));
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
        }
        catch(IOException e){
            System.out.println("Invalid input");
        }
    }
    public void btn2(ActionEvent e1) {
        data();
    }
    public void btn(ActionEvent e){
        String itemg;
        int qtyg, i;
        itemg = item.getText();
        qtyg = Integer.parseInt(qty.getText());
        for (i = 0; i < l.size(); i++) {
            if (itemg.equals(l.get(i))) {
                if (qtyg <= q.get(i)) {
                    int t = q.get(i) - qtyg;
                    q.set(i, t);
                    s4 += itemg + "\n";
                    s5 += qtyg + "\n";
                    s6=s6+String.valueOf(qtyg* price1.get(i))+"\n";
                    value1.add(qtyg* price1.get(i));
                    price2.setText(s6);
                    item1.setText(s4);
                    qty1.setText(s5);
                    status.setText("");
                    break;
                }
            }
        }
        if (i == l.size())
            status.setText("Item not found");
    }

    public void btn1(ActionEvent e){
        int sum=0,i;
        for(i=0;i<value1.size();i++){
            sum+=value1.get(i);
        }
        value.setText(String.valueOf(sum));
    }
    public void update(ActionEvent e) throws IOException {
        ArrayList<String> qty4 = new ArrayList();
        String s7 = "";
        String s9 = "";
        String[] s20 = s4.split("\n");
        String[] s21 = s5.split("\n");
        try {
            String s22 = new String(Files.readAllBytes(Paths.get("item1.txt")));
            String s23 = new String(Files.readAllBytes(Paths.get("qty1.txt")));
            String[] s24 = s22.split("\r\n");
            String[] s25 = s23.split("\r\n");
            for (String i : s25) {
                qty4.add(i);
            }
            for (int i = 0; i < s20.length; i++) {
                for (int j = 0; j < s24.length; j++)
                    if (s24[j].equals(s20[i])) {
                        int k = Integer.parseInt(s25[j]) + Integer.parseInt(s21[i]);
                        qty4.set(j, String.valueOf(k));
                    }

            }
            for (String i : qty4)
                s7 += i + "\r\n";
            for (int i : q)
                s9 += String.valueOf(i) + "\r\n";
            Path fileName = Path.of("qty1.txt");
            Files.writeString(fileName, s7);
            Path fileName1 = Path.of("qty.txt");
            Files.writeString(fileName1, s9);
        }
        catch (IOException e1){
            System.out.println("Invalid input");
        }
    }
}
