package controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import action.OpenpicAction;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import service.ChangeService;
public class SlideUIController implements Initializable{
	private Timeline timeline;//时锟斤拷锟竭讹拷锟斤拷
	private int count = 0;

    @FXML
    private Button start;
    
    @FXML
    private Button stop;
    
    @FXML
    private ImageView imageview;
    @FXML
	private void Press(MouseEvent e) {
		if (start.isVisible()) {//锟斤拷锟斤拷锟脚ッ伙拷锟斤拷锟斤拷兀锟斤拷锟斤拷一锟铰撅拷锟斤拷锟截帮拷钮
			start.setVisible(false);
			stop.setVisible(false);
		} else {
			start.setVisible(true);
			stop.setVisible(true);
		}
	}
    @FXML
    void Back(ActionEvent event) {
    	new OpenpicAction();
    }

    @FXML
    void Begin(ActionEvent event) {
    	timeline.play();
    }

    @FXML
    void Stop(ActionEvent event) {
    	timeline.pause();
    }

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {


		String path = "Pic/1.jpg";
		ChangeService.change = new ImageView(path);
		imageview.setImage(ChangeService.change.getImage());
		imageview.setEffect(ChangeService.change.getEffect());
		imageview.setViewport(ChangeService.change.getViewport());
		imageview.setNodeOrientation(ChangeService.change.getNodeOrientation());
		imageview.setRotate(ChangeService.change.getRotate());
	    timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);//锟斤拷止锟斤拷锟斤拷
		imageview.setScaleX(1.0);
		imageview.setScaleY(1.0);
		KeyValue kv1 = new KeyValue(imageview.opacityProperty(), 1);//KeyValue(WritableValue<T> target, T endValue)
		KeyValue kv2 = new KeyValue(imageview.opacityProperty(), 0.2);
		EventHandler<ActionEvent> onFinished = (ActionEvent t) -> {//锟矫碉拷片锟斤拷锟斤拷锟角凤拷锟街癸拷锟斤拷卸锟�
			if (count < ChangeService.files.size()) {
				try {
					imageview.setImage(new Image(ChangeService.files.get(count).toURI().toURL().toString()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			} else if (count == ChangeService.files.size()) {

				count = 0;
				imageview.setOpacity(1.0);
				timeline.stop();
			}
			count++;
		};
		KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), onFinished, kv1, kv2);
		timeline.getKeyFrames().add(keyFrame);
	}
}
