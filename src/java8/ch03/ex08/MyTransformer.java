package java8.ch03.ex08;

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
	
	public static ColorTransformer addEdge(Image in, int length, Color color) {
		if (length < 0) {
			throw new IllegalArgumentException();
		}
		
		return (x, y, c) -> {
			if (x < length || y < length || x >= ((int)in.getWidth() - length) || y >= ((int)in.getHeight() - length)) {
				return color;
			}
			return c;
		};
		
	}

}
