package java8.ch04.ex01;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloJavaFX extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		String hello = "Hello JavaFX!";
		//Label
		Label message = new Label(hello);
		message.setFont(new Font(100));
		
		//textField
		TextField text = new TextField(hello);
		text.textProperty().addListener(p -> {
			message.setText(text.getText());
		});
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(text, message);
		primaryStage.setScene(new Scene(vbox));
		primaryStage.setTitle("hello");
		primaryStage.show();
	}
}
