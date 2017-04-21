package ua.blackjack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("view/UserView.fxml"));
		primaryStage.setTitle("BlackJack");
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("file:resources/images/ico.png"));
		primaryStage.setScene(new Scene(root, 700, 540));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
