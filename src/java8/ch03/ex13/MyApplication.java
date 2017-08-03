package java8.ch03.ex13;

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
		Image img = new Image(new File("src/java8/ch03/ex13/queen-mary.png").toURI().toString());
		ImageView imgView = new ImageView(img);
		root.getChildren().add(imgView);

		// 画像を変換して表示。ファイルの場合はnew File( "ファイル名" ).toURI().toString()でパスを指定する
		Image img2 = new Image(new File("src/java8/ch03/ex13/queen-mary.png").toURI().toString());
		Image wImg = LatentImage.from(img2)
				.transform(Color::brighter)
				.transform((x, y, c) -> {
					int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
					int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
					double red = 0;
					double blue = 0;
					double green = 0;
					int count = 0;
					for (int i = 0; i < 9; i++) {
						int diffx = x + dx[i];
						int diffy = y + dy[i];
						if (diffx < 0 || diffx >= img2.getWidth() || diffy < 0 || diffy >= img.getHeight()) {
							continue;
						}
						red += img2.getPixelReader().getColor(diffx, diffy).getRed();
						blue += img2.getPixelReader().getColor(diffx, diffy).getBlue();
						green += img2.getPixelReader().getColor(diffx, diffy).getGreen();
						count++;
					}
					return new Color(red/count, green/count, blue/count, c.getOpacity());
				})
				.toImage();
		ImageView imgView2 = new ImageView(wImg);
		root.getChildren().add(imgView2);

		// シーンの作成
		Scene scene = new Scene(root);

		// ウィンドウ表示
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
