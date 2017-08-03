package java8.ch03.ex15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
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
		Image img = new Image(new File("src/java8/ch03/ex12/queen-mary.png").toURI().toString());
		ImageView imgView = new ImageView(img);
		root.getChildren().add(imgView);

		// 画像を変換して表示。ファイルの場合はnew File( "ファイル名" ).toURI().toString()でパスを指定する
		Image img2 = new Image(new File("src/java8/ch03/ex12/queen-mary.png").toURI().toString());
		Color[][] wImg = LatentImage.from(toArray(img2))
				.transform(Color::brighter)
				.transform((x, y, c) -> {
					if (x < 10 || y < 10 || x >= ((int) img.getWidth() - 10) || y >= ((int) img.getHeight() - 10)) {
						return Color.GRAY;
					}
					return c;})
				.toImage();
		ImageView imgView2 = new ImageView(toImage(wImg));
		root.getChildren().add(imgView2);

		// シーンの作成
		Scene scene = new Scene(root);

		// ウィンドウ表示
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public Color[][] toArray(Image in) {
		int height = (int) in.getHeight();
		int width = (int) in.getWidth();
		Color[][] out = new Color[height][width];
		
		for (int y = 0; y < height; y++) { 
			for (int x = 0; x < width; x++) {
				out[y][x] = in.getPixelReader().getColor(x, y);
			}
		}
		return out;
	}
	
	public Image toImage(Color[][] in) {
		int height = in.length;
		int width = in[0].length;
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, in[y][x]);
			}
		}
		return out;
	}

}
