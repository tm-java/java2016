/*練習1.2:HelloWorldのコードを一部変更して、どのようなエラーが発生するか調べてください*/

package jpl.ch01.ex02;
/*[種類]コンパイルエラー
*[原因]packageのコメントアウト
*[メッセージ]The declared package "" does not match the expected package"jpl.ch01.ex02"
*/

import java.io.PrintStream;


public class HelloWorld {
	/*[種類]コンパイルエラー
	*[原因]class名を変更する
	*[メッセージ]the The public type Hello must be defined in its own file. 
	*/

	public static void main(String[] s) {
	/*[種類]実行エラー
	*[原因]publicの変更
	*[メッセージ]エラー: メイン・メソッドがクラスjpl.ch01.ex02.HelloWorldで見つかりません。次のようにメイン・メソッドを定義してください。
	*public static void main(String[] args)
	*またはJavaFXアプリケーション・クラスはjavafx.application.Applicationを拡張する必要があります
	*/
	/*[種類]実行エラー
	*[原因]staticの削除
	*[メッセージ]メイン・メソッドがクラスjpl.ch01.ex02.HelloWorldのstaticではありません。次のようにメイン・メソッドを定義してください。
	*public static void main(String[] args)
	*/
		
		// TODO Auto-generated method stub
		PrintStream ps = System.out;
		String[] str = {"Hello",",","world"}; 
		ps.println(str);
		//[種類]期待とは違う実行結果
		//[原因]printlnの引数をString型の配列に変更
		//[実行結果][Ljava.lang.String;@677327b6
	}

}
