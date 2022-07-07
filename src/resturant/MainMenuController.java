package resturant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class MainMenuController implements Initializable {

    int count = 0;
    ArrayList<Meals> listM = new ArrayList<>();
    ArrayList<Dranks> listD = new ArrayList<>();
    @FXML
    TextField numMeals;
    @FXML
    TextField numDranks;
    @FXML
    Pane Meals;
    @FXML
    Pane Dranks;
    @FXML
    ComboBox typeM;
    @FXML
    ComboBox typeD;
    @FXML
    TextField numM;
    @FXML
    TextField nameM;
    @FXML
    TextField costM;
    @FXML
    Label doneM;
    @FXML
    TextField numD;
    @FXML
    TextField nameD;
    @FXML
    TextField costD;
    @FXML
    Label doneD;
    @FXML
    TableView<Meals> tableM;
    @FXML
    TableColumn<Meals, Integer> numCM;
    @FXML
    TableColumn<Meals, String> nameCM;
    @FXML
    TableColumn<Meals, String> typeCM;
    @FXML
    TableColumn<Meals, Double> costCM;
    @FXML
    TableView<Dranks> tableD;
    @FXML
    TableColumn<Dranks, Integer> numCD;
    @FXML
    TableColumn<Dranks, String> nameCD;
    @FXML
    TableColumn<Dranks, String> typeCD;
    @FXML
    TableColumn<Dranks, Double> costCD;
    int count2 = 0; //for meals
    int count3 = 0; // for drinks
    int indexM = -1; // index row table meals
    int indexD = -1; //index row table for drinks
    @FXML
    Button meal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableM.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableD.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        typeM.getItems().addAll("مشاوي ", "سمك", " ساندويشات", "بيتزا");
        typeD.getItems().addAll("ساخنة", " باردة");
    }

    public void Drank() {
        Dranks.setVisible(true);
        Meals.setVisible(false);
    }

    public void meal()  {
        Dranks.setVisible(false);
        Meals.setVisible(true);

    }

    public void insertmeals() {
        boolean flag = false;
        int num = Integer.parseInt(numM.getText());
        String name = nameM.getText();
        String type = typeM.getSelectionModel().getSelectedItem().toString();
        double cost = Double.parseDouble(costM.getText());
        for (Meals m : listM) {
            if (m.getNumM() == num || m.getNameM().equals(name)) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        if (flag == true) {
            doneM.setText("تم إضافتها مسبقا");
            doneM.setFont(new Font("Bold", 18));
            doneM.setTextFill(Color.RED);
            doneM.setVisible(true);
            JOptionPane.showMessageDialog(null, "اسم الوجبة أو رقم الوجبة تم إضافته مسبقا");
        } else {
            doneM.setText("تم إضافتها بنجاح");
            doneM.setTextFill(Color.GREEN);
            doneM.setFont(new Font("Bold", 18));
            doneM.setVisible(true);
            listM.add(new Meals(num, name, type, cost));

            Meals m;
            numCM.setCellValueFactory(new PropertyValueFactory<>("numM"));
            nameCM.setCellValueFactory(new PropertyValueFactory<>("nameM"));
            typeCM.setCellValueFactory(new PropertyValueFactory<>("typeM"));
            costCM.setCellValueFactory(new PropertyValueFactory<>("costM"));

            m = listM.get(count2);
            tableM.getItems().add(m);
            count2++;
        }
        numMeals.setText(listM.size() + "");
    }

    public void insertdrinks() {
        boolean flag = false;
        int num = Integer.parseInt(numD.getText());
        String name = nameD.getText();
        String type = typeD.getSelectionModel().getSelectedItem().toString();
        double cost = Double.parseDouble(costD.getText());
        for (Dranks D : listD) {
            if (D.getNumD() == num || D.getNameD().equals(name)) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        if (flag == true) {
            doneD.setText("تم إضافتها مسبقا");
            doneD.setFont(new Font("Bold", 18));
            doneD.setTextFill(Color.RED);
            doneD.setVisible(true);
            JOptionPane.showMessageDialog(null, "اسم المشروب أو رقم المشروب تم إضافته مسبقا");

        } else {
            doneD.setText("تم إضافتها بنجاح");
            doneD.setTextFill(Color.GREEN);
            doneD.setFont(new Font("Bold", 18));
            doneD.setVisible(true);
            listD.add(new Dranks(num, name, type, cost));

            Dranks D;

            numCD.setCellValueFactory(new PropertyValueFactory<>("numD"));
            nameCD.setCellValueFactory(new PropertyValueFactory<>("nameD"));
            typeCD.setCellValueFactory(new PropertyValueFactory<>("typeD"));
            costCD.setCellValueFactory(new PropertyValueFactory<>("costD"));

            D = listD.get(count3);
            tableD.getItems().add(D);
            count3++;
        }
        numDranks.setText(listD.size() + "");
    }

    public void getselectedMeals() {
        indexM = tableM.getSelectionModel().getSelectedIndex();
        if (indexM == -1) {
            return;
        }
        String num = String.valueOf(numCM.getCellData(indexM));
        numM.setText(num);
        String name = nameCM.getCellData(indexM);
        nameM.setText(name);
        String cost = String.valueOf(costCM.getCellData(indexM));
        costM.setText(cost);
        typeM.getSelectionModel().select(typeCM.getCellData(indexM));
    }

    public void getselecteddrinks() {
        indexD = tableD.getSelectionModel().getSelectedIndex();
        if (indexD == -1) {
            return;
        }
        String num = String.valueOf(numCD.getCellData(indexD));
        numD.setText(num);
        String name = nameCD.getCellData(indexD);
        nameD.setText(name);
        String cost = String.valueOf(costCD.getCellData(indexD));
        costD.setText(cost);
        typeD.getSelectionModel().select(typeCD.getCellData(indexD));
    }

    public void updateMeals() {
        boolean flag = false;
        int i = 0;
        int num = Integer.parseInt(numM.getText());
        String name = nameM.getText();
        String type = typeM.getSelectionModel().getSelectedItem().toString();
        double cost = Double.parseDouble(costM.getText());
        for (i = 0; i < listM.size(); i++) {
            if (num == listM.get(i).getNumM()) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        if (flag == true) {
            listM.set(i, new Meals(num, name, type, cost));
            Meals m;
            numCM.setCellValueFactory(new PropertyValueFactory<>("numM"));
            nameCM.setCellValueFactory(new PropertyValueFactory<>("nameM"));
            typeCM.setCellValueFactory(new PropertyValueFactory<>("typeM"));
            costCM.setCellValueFactory(new PropertyValueFactory<>("costM"));
            m = listM.get(i);
            tableM.getItems().set(indexM, m);
            doneM.setText("تم التعديل بنجاح ");
            doneM.setFont(new Font("Bold", 18));
            doneM.setTextFill(Color.GREEN);
            doneM.setVisible(true);
        }
    }

    public void removerows() {
        boolean flag1 = false;
        int i;
        int num = Integer.parseInt(numM.getText());
        for (i = 0; i < listM.size(); i++) {
            if (num == listM.get(i).getNumM()) {
                flag1 = true;
                break;
            } else {
                flag1 = false;
            }
        }
        if (flag1 == true) {
            listM.remove(i);
            count2--;
            numMeals.setText(listM.size() + "");
            tableM.getItems().remove(tableM.getSelectionModel().getSelectedItem());

            doneM.setText("تم حذفه بنجاح");
            doneM.setFont(new Font("Bold", 18));
            doneM.setTextFill(Color.RED);
            doneM.setVisible(true);

        }

    }

    public void updatedrinks() {
        boolean flag = false;
        int i = 0;
        int num = Integer.parseInt(numD.getText());
        String name = nameD.getText();
        String type = typeD.getSelectionModel().getSelectedItem().toString();
        double cost = Double.parseDouble(costD.getText());
        for (i = 0; i < listD.size(); i++) {
            if (num == listD.get(i).getNumD()) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }
        if (flag == true) {
            listD.set(i, new Dranks(num, name, type, cost));
            Dranks D;
            numCD.setCellValueFactory(new PropertyValueFactory<>("numD"));
            nameCD.setCellValueFactory(new PropertyValueFactory<>("nameD"));
            typeCD.setCellValueFactory(new PropertyValueFactory<>("typeD"));
            costCD.setCellValueFactory(new PropertyValueFactory<>("costD"));
            D = listD.get(i);
            tableD.getItems().set(indexD, D);

            doneD.setText("تم التعديل بنجاح");
            doneD.setTextFill(Color.GREEN);
            doneD.setFont(new Font("Bold", 18));
            doneD.setVisible(true);

        }
    }

    public void removerowsDranks() {
        boolean flag1 = false;
        int i;
        int num = Integer.parseInt(numD.getText());
        for (i = 0; i < listD.size(); i++) {
            if (num == listD.get(i).getNumD()) {
                flag1 = true;
                break;
            } else {
                flag1 = false;
            }
        }
        if (flag1 == true) {
            listD.remove(i);
            count3--;
            numDranks.setText(listD.size() + "");
            tableD.getItems().remove(tableD.getSelectionModel().getSelectedItem());
            doneD.setText("تم حذفه بنجاح");
            doneD.setFont(new Font("Bold", 18));
            doneD.setTextFill(Color.RED);
            doneD.setVisible(true);
        }
    }

    public void logout(Event e) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("تسجيل الدخول");
    }
}
