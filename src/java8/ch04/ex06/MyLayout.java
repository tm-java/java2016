package java8.ch04.ex06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MyLayout extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane pane = new BorderPane();
		Scene scene = new Scene(pane);
		
		BorderPane topPane = new BorderPane();
		topPane.setCenter(new Button("Top"));
		pane.setTop(topPane);
		pane.setLeft(new Button("Left"));
		pane.setCenter(new Button("Center"));
		pane.setRight(new Button("Right"));
		BorderPane bottomPane = new BorderPane();
		bottomPane.setCenter(new Button("Bottom"));
		pane.setBottom(bottomPane);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

}
