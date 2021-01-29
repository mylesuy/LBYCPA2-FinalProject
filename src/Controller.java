import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

public class Controller {

    String qty;
    public Button Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9, checkoutCart;
    public Pane pane;

    @FXML
    private void initialize(){
        changeImage(Button1, Button1.getText());
        changeImage(Button2, Button2.getText());
        changeImage(Button3, Button3.getText());
        changeImage(Button4, Button4.getText());
        changeImage(Button5, Button5.getText());
        changeImage(Button6, Button6.getText());
        changeImage(Button7, Button7.getText());
        changeImage(Button8, Button8.getText());
        changeImage(Button9, Button9.getText());
    }

    private void changeImage(Button button, String name) {
        Image image = new Image(getClass().getResourceAsStream("/assets/"+name+".jpg"));
        ImageView imageView = new ImageView(image);
        imageView.fitHeightProperty().bind(button.heightProperty());
        imageView.fitWidthProperty().bind(button.widthProperty());
        button.setGraphic(imageView);
    }

    private void changeCart(Button button, String name){
        Image image = new Image(getClass().getResource("/assets/"+name+".jpg").toString());
        ImageView imageView = new ImageView(image);
        imageView.fitHeightProperty().bind(button.heightProperty());
        imageView.fitWidthProperty().bind(button.widthProperty());
        imageView.setPreserveRatio(true);
        button.setGraphic(imageView);
    }


    public void buttonPressed(ActionEvent event) {
        Button button = (Button) event.getSource();
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle(button.getText()+" chosen");
        dialog.setContentText("Please input the quantity of your order");
        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("assets/"+button.getText()+".jpg"));
        dialog.setGraphic(new ImageView(this.getClass().getResource("assets/"+button.getText()+".jpg").toString()));
        if(button.getText().equals("Beef Burger")){
            dialog.setHeaderText("A burger made with excellent beef, flame-grilled to perfection.");
        }
        if(button.getText().equals("Cheese Burger")){
            dialog.setHeaderText("12-ounces pure beef patties paired with 2 specially-made cheese.");
        }
        if(button.getText().equals("Chicken Burger")){
            dialog.setHeaderText("Crispy chicken fillet inside a burger. Best of both worlds!");
        }
        if(button.getText().equals("Super Burger")){
            dialog.setHeaderText("Our special burger, BUT DOUBLED!");
        }
        if(button.getText().equals("Veggie Burger")){
            dialog.setHeaderText("Our best burger made for those who care about environment.");
        }
        if (button.getText().equals("Fries")){
            dialog.setHeaderText("The best side for the best main dish.");
        }
        if(button.getText().equals("Coke")){
            dialog.setHeaderText("The original drink for the champions.");
        }
        if(button.getText().equals("Coke Zero")){
            dialog.setHeaderText("Your favorite drink but with less body consequences.");
        }
        if(button.getText().equals("Sprite")){
            dialog.setHeaderText("Your good ol' thirst quencher.");
        }

        //for taking the user input
        Optional<String> qty = dialog.showAndWait();
        if(qty.isPresent()) {
            //input cart method here

        }
    }

    public void checkoutPressed(ActionEvent event){

        
    }


}
