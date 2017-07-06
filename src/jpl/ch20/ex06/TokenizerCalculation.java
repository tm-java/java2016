package jpl.ch20.ex06;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class TokenizerCalculation {
	private final Map<String, Double> table = new HashMap<String, Double>();

	enum Operation {
		EQUAL{

			@Override
			public double execute(double d1, double d2) {
				return d2;
			}
			
		}, PLUS{

			@Override
			public double execute(double d1, double d2) {
				return (d1 + d2);
			}
			
		}, MINUS {

			@Override
			public double execute(double d1, double d2) {
				return (d1 - d2);
			}
			
		};
		
		public abstract double execute(double d1, double d2);
	}

	public TokenizerCalculation() {
		table.put("data1", 0.0);
		table.put("data2", 0.0);
		table.put("data3", 0.0);
	}

	public void calculation(Reader source) throws IOException {
		StreamTokenizer in = new StreamTokenizer(source);
		String selectedKey = null;
		Operation op = null;
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			if (in.ttype == StreamTokenizer.TT_WORD) {
				if (!table.containsKey(in.sval)) {
					throw new IOException();
				}
				selectedKey = in.sval;
			} else if (in.ttype == StreamTokenizer.TT_NUMBER) {
				if (selectedKey == null || op == null) {
					throw new IOException();
				}
				table.put(selectedKey, op.execute(table.get(selectedKey), in.nval));
				selectedKey = null;
				op = null;
			} else if (in.ttype == '=') {
				if (op != null) {
					throw new IOException();
				}
				op = Operation.EQUAL;
			} else if (in.ttype == '+') {
				if (op != null) {
					throw new IOException();
				}
				op = Operation.PLUS;
			} else if (in.ttype == '-') {
				if (op != null) {
					throw new IOException();
				}
				op = Operation.MINUS;
			} else {
				throw new IOException();
			}
		}
		
		for (Map.Entry<String, Double> e : table.entrySet()) {
			System.out.println(e.getKey() + " = " + e.getValue());
		}
	}
}
