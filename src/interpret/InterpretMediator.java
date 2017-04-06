package interpret;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Vector;

public interface InterpretMediator {
	/**
	 * 作成済みのオブジェクトのリストを得る
	 * @return 作成済みのオブジェクトのリスト
	 */
	Object[] objests();
	
	public Object[] arrays();
 
	/**
	 * 新しくオブジェクトを生成して、リストobjectに追加する。
	 * @param c 生成したいオブジェクトのコンストラクタ
	 * @param args コンストラクタに必要な引数。Constructor.newInstanceの仕様どおりにしてください。
	 * @return 成功した場合にtrueを返す。
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	Object newObject(Constructor c, Object... args)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
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
			throws IllegalArgumentException, NegativeArraySizeException;
	
	/**
	 * 引数のタイプに該当する作成済みオブジェクトのリストを返す
	 * TODO できれば、代入可能なオブジェクトも返してあげたい
	 */
	public Vector matchObjects(Type type);
	
	public Object parsePrimitive(Class<?> cls, String in);
	

}
