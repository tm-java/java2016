package jpl.ch24.ex01;

import java.util.ListResourceBundle;

public class GlobalRes_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return contents;
	}
	
	private static final Object[][] contents = {
			{GlobalRes.HELLO, "Hello" },
			{GlobalRes.GOODBYE, "GoodBye"},
	};

}
