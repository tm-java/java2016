package java8.ch03.ex06;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MyApplication extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// シーングラフの作成
		HBox root = new HBox();

		// 単純に画像を読み込んで表示。ファイルの場合はnew File( "ファイル名" ).toURI().toString()でパスを指定する
		Image img = new Image(new File("src/java8/ch03/ex06/queen-mary.png").toURI().toString());
		ImageView imgView = new ImageView(img);
		root.getChildren().add(imgView);

		// 画像を変換して表示。ファイルの場合はnew File( "ファイル名" ).toURI().toString()でパスを指定する
		Image img2 = new Image(new File("src/java8/ch03/ex06/queen-mary.png").toURI().toString());
		Image wImg = MyTransformer.transform(img2, (c, factor) -> c.deriveColor(0, 1, factor, 1), 1.2);
		ImageView imgView2 = new ImageView(wImg);
		root.getChildren().add(imgView2);

		// シーンの作成
		Scene scene = new Scene(root);

		// ウィンドウ表示
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
