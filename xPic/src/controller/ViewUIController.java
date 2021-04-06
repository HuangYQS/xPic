package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewUIController implements Initializable {

    @FXML
    private Button back;

    @FXML
    private Button previous;

    @FXML
    private Button next;

    @FXML
    private Button zoomBig;

    @FXML
    private Button zoomSmall;

    @FXML
    private ImageView image;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //这个是自建的变量,便于加载图片
        String path = "Pic/1.jpg";
        image.setImage(new Image(path));
        //imageView = new ImageView(new Image(path));
        //imageView.setImage(new Image(path));

    }


}
