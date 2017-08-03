package java8.ch03.ex15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {
	private Color[][] in;
	private List<ColorTransformer> pendingOperations;
	
	private LatentImage(Color[][] in) {
		this.in = in;
		this.pendingOperations = new ArrayList<>();
	}
	
	public static LatentImage from(Color[][] in) {
		return new LatentImage(in);
	}
		
	public LatentImage transform(ColorTransformer f) {
		this.pendingOperations.add(f);
		return this;
	}

	public LatentImage transform(UnaryOperator<Color> f) {
		this.pendingOperations.add(MyTransformer.xyIgnore(f));
		return this;
	}

	public Color[][] toImage() {
		
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
							for (ColorTransformer f : this.pendingOperations) {
								out[y][x] = f.apply(x, y, in[y][x]);
							}
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

}
