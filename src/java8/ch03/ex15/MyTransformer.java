package java8.ch03.ex15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class MyTransformer {
	public static Image transform(Image in, ColorTransformer f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}

	public static Color[][] parallelTransform(Color[][] in, UnaryOperator<Color> f) {
		int n = Runtime.getRuntime().availableProcessors();
		int height = in.length;
		int width = in[0].length;
		Color[][] out = new Color[height][width];
		try {
			ExecutorService pool = Executors.newCachedThreadPool();
			for (int i = 0; i < n; i++) {
				int fromY = i * height / n;
				int toY = (i + 1) *  height / n;
				pool.submit(() -> {
					for (int x = 0; x < width; x++) {
						for (int y = fromY; y < toY; y++) {
							out[y][x] = f.apply(in[y][x]);
						}
					}
				});
			}
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		return out;
	}

	public static ColorTransformer compose(ColorTransformer op1, ColorTransformer op2) {
		return (x, y, c) -> op2.apply(x, y, op1.apply(x, y, c));
	}

	public static ColorTransformer xyIgnore(UnaryOperator<Color> op) {
		return (x, y, c) -> op.apply(c);
	}

}
