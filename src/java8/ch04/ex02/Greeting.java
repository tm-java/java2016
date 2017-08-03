package java8.ch04.ex02;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Greeting {
	private StringProperty textP = null;
	private String text;
	
	public final StringProperty textProperty() {
		if (textP == null) {
			textP = new SimpleStringProperty();
			if (text != null) {
				textP.set(text);
			}
		}
		return textP;
	}
	
	public final void setText(String newValue) {
		text = newValue;
		if (textP != null) {
			textP.set(newValue);
		}
	}
	
	public final String getText() {
		return text;
	}

}
