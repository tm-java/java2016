package java8.ch04.ex04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CenterCircle extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Circle c = new Circle(100);
		c.setFill(Color.CORAL);
		Pane pane = new Pane(c);
		Scene scene = new Scene(pane);
		
		c.centerXProperty().bind(Bindings.divide(scene.widthProperty(), 2));
		c.centerYProperty().bind(Bindings.divide(scene.heightProperty(), 2));
		c.radiusProperty().bind(Bindings.divide(scene.heightProperty(), 2));
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("center circle");
		primaryStage.show();
		
	}
}
