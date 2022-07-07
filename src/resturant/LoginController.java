package resturant;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
public class LoginController implements Initializable {
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML Button btn ; 
    public void login(Event e) throws IOException {
        if (username.getText().equalsIgnoreCase("m") && password.getText().equals("1")) {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) btn.getScene().getWindow();//casting for getWindow to stage   
            stage.setScene(scene);
            stage.setTitle("الرئيسية");
        } else {
            JOptionPane.showMessageDialog(null, "اسم المستخدم أو كلمة السر غير صحيحة ");
        }
    }
    public void exit() {
        Platform.exit();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
