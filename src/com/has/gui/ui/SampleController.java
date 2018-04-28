package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SampleController {
	
	@FXML BorderPane root;
	Pane liveFeed;
	Pane realTimeData;
	Pane remoteControl;
	Pane intrusionHistory;
	
	public SampleController() {
		try {
			liveFeed = FXMLLoader.load(getClass().getResource("LiveFeed.fxml"));
			realTimeData = FXMLLoader.load(getClass().getResource("RealTimeData.fxml"));
			remoteControl = FXMLLoader.load(getClass().getResource("RemoteControl.fxml"));
			intrusionHistory = FXMLLoader.load(getClass().getResource("IntrusionHistory.fxml"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void openLiveFeed(ActionEvent e) {
		root.setCenter(liveFeed);
	}
	
	@FXML
    void openRealTimeData(ActionEvent e) {
		root.setCenter(realTimeData);
	}
	
	@FXML
    void openRemoteControl(ActionEvent e) {
		root.setCenter(remoteControl);
	}
	
	@FXML
    void openIntrusionHistory(ActionEvent e) {
		root.setCenter(intrusionHistory);
	}
}
