package java8.ch04.ex05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Gauge extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button smaller = new Button("smaller");
		Button larger = new Button("larger");
		
		Rectangle gauge = new Rectangle(0, 5, 30, 15);
		Rectangle rect = new Rectangle(0, 5, 100, 15);
		rect.setFill(null);
		rect.setStroke(Color.DARKGRAY);
		
		smaller.setOnAction(event -> gauge.setWidth(gauge.getWidth() - 5));
		smaller.disableProperty().bind(MyObservableValue.observe(t -> t.doubleValue() <= 0.0, gauge.widthProperty()));
		larger.setOnAction(event -> gauge.setWidth(gauge.getWidth() + 5));
		larger.disableProperty().bind(MyObservableValue.observe(t -> t.doubleValue() >= 100.0, gauge.widthProperty()));
		
		Pane pane = new Pane(gauge, rect);
		HBox hbox = new HBox();
		hbox.getChildren().addAll(smaller, pane, larger);
		Scene scene = new Scene(hbox);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
