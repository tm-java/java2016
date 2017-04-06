package interpret;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Objects {
	final List objects = new LinkedList();
	final List arrays = new LinkedList();

	/**
	 * テスト用
	 * 
	 * @param objs
	 */
	Objects(Object[] objs) {
		for (Object o : objs) {
			objects.add(o);
		}
	}

	public Objects() {

	}

	public Object[] objects() {
		return objects.toArray(new Object[] {});
	}

	public Object[] arrays() {
		return arrays.toArray(new Object[] {});
	}

	/**
	 * 新しくオブジェクトを生成して、リストobjectに追加する。
	 * 
	 * @param c
	 *            生成したいオブジェクトのコンストラクタ
	 * @param args
	 *            コンストラクタに必要な引数。Constructor.newInstanceの仕様どおりにしてください。
	 * @return 成功した場合に生成したObjectを返す
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public Object newObject(Constructor c, Object... args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object newObj = c.newInstance(args);
		objects.add(newObj);
		return newObj;
	}

	/**
	 * 新しく配列を生成して、リストarraysに追加する。
	 * 
	 * @param componentType
	 * @param length
	 * @return
	 * @throws IllegalArgumentException
	 * @throws NegativeArraySizeException
	 */
	public Object newArray(Class<?> componentType, int length)
			throws IllegalArgumentException, NegativeArraySizeException {
		Object newAry = Array.newInstance(componentType, length);
		arrays.add(newAry);
		return newAry;
	}

	/**
	 * 引数のタイプに該当する作成済みオブジェクトのリストを返す TODO できれば、代入可能なオブジェクトも返してあげたい
	 */
	public Vector matchObjects(Type type) {
		Vector rtn = new Vector();
		for (Object o : objects) {
			if (o.getClass() == type) {
				rtn.add(o);
			}
		}

		for (Object ary : arrays) {
			if (ary.getClass().getComponentType() == type) {
				for (int i = 0; i < Array.getLength(ary); i++) {
					Object obj = Array.get(ary,i);
					if(rtn.contains(obj)) {
						continue;
					}
					rtn.add(obj);
				}
			}
		}
		return rtn;
	}

	/**
	 * 引数のクラスが持つクラス型の定数を返す TODO 実装
	 */
	public static List matchStaticObjects(Type type) {
		List rtn = new LinkedList();
		return rtn;
	}

	/**
	 * プリミティブ型のtypeを受け取り、その型にStringを変換する
	 * 
	 * @param type
	 *            プリミティブ型のType
	 * @param in
	 *            文字列
	 * @return プリミティブ型の変換したObject
	 * @throws IllegalArgmentException
	 *             引数clsがプリミティブ型でない時。変換に失敗した時。
	 */
	public Object parsePrimitive(Class<?> cls, String in) {
		if (!cls.isPrimitive()) {
			throw new IllegalArgumentException();
		}

		if (in == null) {
			in = "0";
		}

		if (cls == byte.class || cls == Byte.class) {
			return new Byte(Byte.parseByte(in));
		}
		if (cls == short.class || cls == Short.class) {
			return new Short(Short.parseShort(in));
		}
		if (cls == int.class || cls == Integer.class) {
			return new Integer(Integer.parseInt(in));
		}
		if (cls == long.class || cls == Long.class) {
			return new Long(Long.parseLong(in));
		}
		if (cls == float.class || cls == Float.class) {
			return new Float(Float.parseFloat(in));
		}
		if (cls == double.class || cls == Double.class) {
			return new Double(Double.parseDouble(in));
		}
		if (cls == char.class || cls == Character.class) {
			return new Character(in.charAt(0));
		}
		if (cls == boolean.class || cls == Boolean.class) {
			if (in.equals("0")) {
				return false;
			}
			return new Boolean(Boolean.parseBoolean(in));
		}
		throw new IllegalArgumentException();
	}

}
