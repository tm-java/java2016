package jpl.ch16.ex02;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

//メモ：インナークラスを完全名で示す時 enclosing$inner
//例）java.util.AbstractMap$SimpleEntry

public class TypeDesc {
	public static void main(String[] args) {
		TypeDesc desc = new TypeDesc();
		for (String name : args) {
			try {
				Class<?> startClass = Class.forName(name);
				desc.printType(startClass, 0, basic);
			} catch (ClassNotFoundException e) {
				System.err.println(e);
			}
		}
	}

	// デフォルトで標準出力に表示する
	private java.io.PrintStream out = System.out;

	// 型名にラベルつけするprintType()で使用される
	private static String[] basic = { "class", "interface", "enum", "anntation", "enclosing" },
			supercl = { "extends", "implematnts" }, iFace = { null, "extends" }, enclsng = { "enclosing", "enclosing" };

	private void printType(Type type, int depth, String[] labels) {
		if (type == null) {
			return;
		}
		// TypeをClassオブジェクトに変換する
		Class<?> cls = null;
		if (type instanceof Class<?>) {
			cls = (Class<?>) type;
		} else if (type instanceof ParameterizedType) {
			cls = (Class<?>) ((ParameterizedType) type).getRawType();
		} else {
			throw new Error("Unexpected non-class type");
		}

		// ClassオブジェクトがObjectクラスの場合、何もしない
		if (cls == Object.class) {
			return;
		}

		// この型を表示
		for (int i = 0; i < depth; i++) {
			out.print(" ");
		}
		int kind = cls.isAnnotation() ? 3 : cls.isEnum() ? 2 : cls.isInterface() ? 1 : 0;
		out.print(labels[kind] + " ");
		out.print(cls.getCanonicalName());

		// あれば、ジェネリック型パラメータを表示
		TypeVariable<?>[] params = cls.getTypeParameters();
		if (params.length > 0) {
			out.print('<');
			for (TypeVariable<?> param : params) {
				out.print(param.getName());
				out.print(", ");
			}
			out.println("\b\b>");
		} else {
			out.println();
		}

		// ネストした型の場合、エンクロージングクラスを表示
		if (cls.isMemberClass()) {
			Type enclosing = cls.getEnclosingClass();
			printType(enclosing, depth + 1, enclsng);
		}

		// このクラスが実装しているすべてのインターフェースを表示
		Type[] interfaces = cls.getGenericInterfaces();
		for (Type iface : interfaces) {
			printType(iface, depth + 1, cls.isInterface() ? iFace : supercl);
		}
		// スーパークラスに対して再帰
		printType(cls.getGenericSuperclass(), depth + 1, supercl);
	}
}
