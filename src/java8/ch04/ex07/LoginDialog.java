package java8.ch04.ex07;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginDialog extends Application{
	final double rem = new Text("").getLayoutBounds().getHeight();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//child
		Label userNameLabel = new Label("user name:");
		TextField userName = new TextField();
		Label passwordLabel = new Label("password");
		TextField password = new TextField();
		HBox buttons = new HBox();
		buttons.getChildren().addAll(new Button("ok"), new Button("cancel"));
		
		//pane
		GridPane pane = new GridPane();
		pane.add(userNameLabel, 0, 0);
		GridPane.setHalignment(userNameLabel, HPos.RIGHT);
		pane.add(userName, 1, 0);
		pane.add(passwordLabel, 0, 1);
		GridPane.setHalignment(passwordLabel, HPos.RIGHT);
		pane.add(password, 1, 1);
		pane.add(buttons, 0, 2, 2, 2);
		buttons.setAlignment(Pos.CENTER);
		
		//padding
		pane.setHgap(0.8 * rem);
		pane.setVgap(0.8 * rem);
		pane.setPadding(new Insets(0.8 * rem));
		
		//grid
		pane.setGridLinesVisible(true);
		pane.setBorder(new Border(new BorderStroke(Color.CADETBLUE, BorderStrokeStyle.SOLID, new CornerRadii(0.5), BorderWidths.DEFAULT)));
		
		//show
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	

}
