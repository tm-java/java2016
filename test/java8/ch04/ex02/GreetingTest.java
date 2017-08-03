package java8.ch04.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.beans.property.StringProperty;

public class GreetingTest {

	@Test
	public void test() {
		Greeting g = new Greeting();
		g.setText("hello");
		assertEquals("hello", g.getText());
		StringProperty sp = g.textProperty();
		assertEquals("hello", sp.getValue());
		g.setText("こんにちは");
		assertEquals("こんにちは", sp.getValue());
	}

}
