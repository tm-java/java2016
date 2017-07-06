package java8.ch02.ex07;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 良い考えではない。
 * 要素の個数などを考えずに処理を簡略化できることがメリットだと思うので、
 * 無限か否かを判断してから何か処理をしたいのであれば、それは何か別の方法を検討すべき
 * @author matsuitomomi
 *
 */
public class Finite {
	/**
	 * 与えられたStreamが、有限か否かを返す
	 * 有限か否かは、メモリエラーが発生するかで判断する
	 * @param stream
	 * @return
	 */
	public static <T> boolean isFinite(Stream<T> stream) {
		//データ用
		List<T> list = new ArrayList<T>();
		Optional<T> result = stream.filter(t -> {
			try {
				list.add(t);//データを加えていく
			}catch (OutOfMemoryError e) {
				list.clear();
				System.gc();
				return true;
			}
			return false;
		}).findAny();
		
		//メモリエラーが発生した場合、その時の値がresutlに入っているはず
		if (result.isPresent()) {
			return false;//無限
		}
		return true;//有限
	}

}
