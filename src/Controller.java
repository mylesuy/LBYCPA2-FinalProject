import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;


public class Controller {

    String qty;
    public Button Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9, checkoutCart;
    public Pane pane;


    //added
    public TextField textfieldCustomerName;
    public Graph customersOrder = new Graph();
    ArrayList<Graph> customersOrderArrayList = new ArrayList<>();
    public ListView listOfOrders;
    ObservableList<String> orderList;
    public ListView listOfPrices;
    ObservableList<Integer> priceList;
    public Label totalPrice;
    InsertionSort insertionSort = new InsertionSort();

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
    @FXML
    public void clickSortByPrice(){
        sortByPrice();
    }
    @FXML
    public void clickSortByOrderName(){
        sortByOrderName();
    }

    public void sortByPrice() { //should work pag may price na
        double[] layoutXOfButtons = {Button1.getLayoutX(), Button2.getLayoutX(), Button3.getLayoutX(), Button4.getLayoutX(), Button5.getLayoutX()
                , Button6.getLayoutX(), Button7.getLayoutX(), Button8.getLayoutX(), Button9.getLayoutX()};
        double[] layoutYOfButtons = {Button1.getLayoutY(), Button2.getLayoutY(), Button3.getLayoutY(), Button4.getLayoutY(), Button5.getLayoutY()
                , Button6.getLayoutY(), Button7.getLayoutY(), Button8.getLayoutY(), Button9.getLayoutY()};
        Button[] arrayOfButtons = {Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9};
        int[] arrayOfPrices = {50, 60, 65, 70, 55, 40, 20, 35, 69};
        insertionSort.sortPrice(arrayOfPrices, arrayOfButtons);
        for (int i = 0; i < 9; i++) {
            arrayOfButtons[i].setLayoutX(layoutXOfButtons[i]);
            arrayOfButtons[i].setLayoutY(layoutYOfButtons[i]);
            switch (i) {
                case 0:
                    Button1 = arrayOfButtons[i];
                    break;
                case 1:
                    Button2 = arrayOfButtons[i];
                    break;
                case 2:
                    Button3 = arrayOfButtons[i];
                    break;
                case 3:
                    Button4 = arrayOfButtons[i];
                    break;
                case 4:
                    Button5 = arrayOfButtons[i];
                    break;
                case 5:
                    Button6 = arrayOfButtons[i];
                    break;
                case 6:
                    Button7 = arrayOfButtons[i];
                    break;
                case 7:
                    Button8 = arrayOfButtons[i];
                    break;
                case 8:
                    Button9 = arrayOfButtons[i];
                    break;
            }
        }
    }
    public void sortByOrderName(){
        double[] layoutXOfButtons = {Button1.getLayoutX(),Button2.getLayoutX(),Button3.getLayoutX(),Button4.getLayoutX(),Button5.getLayoutX()
                ,Button6.getLayoutX(),Button7.getLayoutX(),Button8.getLayoutX(),Button9.getLayoutX()};
        double[] layoutYOfButtons = {Button1.getLayoutY(),Button2.getLayoutY(),Button3.getLayoutY(),Button4.getLayoutY(),Button5.getLayoutY()
                ,Button6.getLayoutY(),Button7.getLayoutY(),Button8.getLayoutY(),Button9.getLayoutY()};
        Button[] arrayOfButtons = {Button1,Button2,Button3,Button4,Button5,Button6,Button7,Button8,Button9};
        String[] arrayOfOrderNames = {Button1.getText().toLowerCase(),Button2.getText().toLowerCase(),Button3.getText().toLowerCase(),
                Button4.getText().toLowerCase(),Button5.getText().toLowerCase(),
                Button6.getText().toLowerCase(),Button7.getText().toLowerCase(),Button8.getText().toLowerCase(),Button9.getText().toLowerCase()};

        insertionSort.sortName(arrayOfOrderNames,arrayOfButtons);
        for(int i =0;i<9;i++){
            arrayOfButtons[i].setLayoutX(layoutXOfButtons[i]);
            arrayOfButtons[i].setLayoutY(layoutYOfButtons[i]);
            switch (i) {
                case 0:
                    Button1 = arrayOfButtons[i];
                    break;
                case 1:
                    Button2 = arrayOfButtons[i];
                    break;
                case 2:
                    Button3 = arrayOfButtons[i];
                    break;
                case 3:
                    Button4 = arrayOfButtons[i];
                    break;
                case 4:
                    Button5 = arrayOfButtons[i];
                    break;
                case 5:
                    Button6 = arrayOfButtons[i];
                    break;
                case 6:
                    Button7 = arrayOfButtons[i];
                    break;
                case 7:
                    Button8 = arrayOfButtons[i];
                    break;
                case 8:
                    Button9 = arrayOfButtons[i];
                    break;
            }
        }
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
            int index = checkCustomerInList(textfieldCustomerName);
            for(int i=0;i<Integer.parseInt(qty.get());i++){
                addOrder(index,customersOrderArrayList,button,50);
            }
            orderList = FXCollections.observableArrayList(customersOrder.getAllOrders(customersOrderArrayList.get(index).getCustomerName()));
            listOfOrders.setItems(orderList);
            priceList = FXCollections.observableArrayList(customersOrder.getAllPrices(customersOrderArrayList.get(index).getCustomerName()));
            listOfPrices.setItems(priceList);
            totalPrice.setText(String.valueOf(getTotalPrice(priceList)));
        }
    }

    @FXML
    public void clickEnterCustomerName(){
        listOfOrders.setItems(null);
        listOfPrices.setItems(null);
        if(!checkCustomerDuplicate(textfieldCustomerName)){
            Graph customersOrder1 = new Graph();
            customersOrder1.setCustomerName(textfieldCustomerName.getText());
            customersOrderArrayList.add(customersOrder1);
        }
        if(customersOrderArrayList.size()>0){
            int index = checkCustomerInList(textfieldCustomerName);
            customersOrder = customersOrderArrayList.get(index);
            if (customersOrder.getAllOrders(customersOrderArrayList.get(index).getCustomerName()) != null) {
                orderList = FXCollections.observableArrayList(customersOrder.getAllOrders(customersOrderArrayList.get(index).getCustomerName()));
                listOfOrders.setItems(orderList);
                priceList = FXCollections.observableArrayList(customersOrder.getAllPrices(customersOrderArrayList.get(index).getCustomerName()));
                listOfPrices.setItems(priceList);
            }
        }
    }
    private boolean checkCustomerDuplicate(TextField customerName) {        //checks to see if theres a duplicate customer name
        for (Graph customerOrder : customersOrderArrayList) {
            if (customerOrder.getCustomerName().contains(customerName.getText())) return true;
        }
        return false;
    }
    private int checkCustomerInList(TextField customerName) {               //checks to see if the customers name is there
        for(int i=0; i<customersOrderArrayList.size();i++)
        {
            if(customersOrderArrayList.get(i).getCustomerName().equals(customerName.getText())) return i;
        }
        return -1;
    }
    public void addOrder(int index, ArrayList<Graph> customersOrderArrayList, Button button, int price){        //adds order
        customersOrder.setOrder(button.getText());
        customersOrder.setPrice(price);
        customersOrder.addEdgeForOrder(customersOrderArrayList.get(index).getCustomerName(),customersOrderArrayList.get(index).getOrder());
        customersOrder.addEdgeForPrice(customersOrderArrayList.get(index).getCustomerName(),customersOrderArrayList.get(index).getPrice());
    }
    public void removeOrder(int index, ArrayList<Graph> customersOrderArrayList, Button button, int price){     //removes order
        customersOrder.setOrder(button.getText());
        customersOrder.setPrice(price);
        customersOrder.removeEdgeForPrice(customersOrderArrayList.get(index).getCustomerName(),customersOrderArrayList.get(index).getPrice());
        customersOrder.removeEdgeForOrder(customersOrderArrayList.get(index).getCustomerName(),customersOrderArrayList.get(index).getOrder());
    }
    //clears the cart
    @FXML
    public void clickReset(){           //clears all orders and prices
        int index = checkCustomerInList(textfieldCustomerName);
        customersOrderArrayList.get(index).removeAll();
        listOfOrders.setItems(null);
        listOfPrices.setItems(null);
        totalPrice.setText(String.valueOf(getTotalPrice(priceList)));
    }
    public int getTotalPrice(ObservableList<Integer> priceList){            //gets the total price
        int total=0;
        for (Integer element : priceList) {
            total = element+ total;
        }
        return total;
    }
    public void checkoutPressed(ActionEvent event){


    }


}
