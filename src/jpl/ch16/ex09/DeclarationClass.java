package jpl.ch16.ex09;

import java.lang.reflect.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class DeclarationClass {
	public static void main(String[] args) {
		DeclarationClass dc = new DeclarationClass();
		try {
			Class<?> c = Class.forName(args[0]);
			dc.printClass(c);
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class:" + args[0]);
		}
	}

	private final Map<Integer, String> mod = new LinkedHashMap<Integer, String>();
	// 型名にラベルつけするprintType()で使用される
	private static String[] basic = { "class", "interface", "enum", "anntation" },
			supercl = { "extends", "implematnts" }, iFace = { null, "extends" };

	public DeclarationClass() {
		mod.put(Modifier.PUBLIC, "public");
		mod.put(Modifier.PROTECTED, "protected");
		mod.put(Modifier.PRIVATE, "private");
		mod.put(Modifier.ABSTRACT, "abstract");
		mod.put(Modifier.STATIC, "static");
		mod.put(Modifier.FINAL, "final");
		mod.put(Modifier.TRANSIENT, "transient");
		mod.put(Modifier.VOLATILE, "volatile");
		mod.put(Modifier.SYNCHRONIZED, "synchronized");
		mod.put(Modifier.NATIVE, "native");
		mod.put(Modifier.STRICT, "strictfp");
		mod.put(Modifier.INTERFACE, "interface");
	}

	private void printClass(Type type) {
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

		// 修飾子
		printModifier(cls);
		// 指定されたクラス
		printType(type, basic);
		System.out.print(" ");
		// スーパークラス
		printType(cls.getGenericSuperclass(), supercl);
		System.out.print(" ");
		// このクラスが実装しているすべてのインターフェースを表示
		Type[] interfaces = cls.getGenericInterfaces();
		int count = 0;
		for (Type iface : interfaces) {
			if (count == 0) {
				printType(iface, cls.isInterface() ? iFace : supercl);
			} else {
				System.out.print(", ");
				printType(iface);
			}
			count++;
		}
	}

	private void printModifier(Class<?> cls) {
		// 修飾子
		int modifier = cls.getModifiers();
		for (Map.Entry<Integer, String> e : mod.entrySet()) {
			if ((modifier & e.getKey()) != 0) {
				System.out.print(e.getValue() + " ");
			}
		}
	}

	private void printType(Type type, String[] labels) {
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

		// この型を表示
		if(labels != null) {
			int kind = cls.isAnnotation() ? 3 : cls.isEnum() ? 2 : cls.isInterface() ? 1 : 0;
			System.out.print(labels[kind] + " ");
		}
		System.out.print(cls.getSimpleName());
		
		// あれば、ジェネリック型パラメータを表示
		TypeVariable<?>[] params = cls.getTypeParameters();
		if (params.length > 0) {
			System.out.print('<');
			for (TypeVariable<?> param : params) {
				System.out.print(param.getName());
				System.out.print(", ");
			}
			System.out.print("\b\b>");
		}
	}
	
	private void printType(Type type) {
		printType(type, null);
	}
}
