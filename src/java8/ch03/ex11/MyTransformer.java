package java8.ch03.ex11;

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

	public static ColorTransformer compose(ColorTransformer op1, ColorTransformer op2) {
		return (x, y, c) -> op2.apply(x, y, op1.apply(x, y, c));
	}

	public static ColorTransformer xyIgnore(UnaryOperator<Color> op) {
		return (x, y, c) -> op.apply(c);
	}

}
