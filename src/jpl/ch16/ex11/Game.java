package jpl.ch16.ex11;
/*
 * 2017.4.7 メモ
 * 
 * java Game BinarySearchTreePlayer
 * とすると、BinarySearchTreePlayerのクラスを通常のクラスローダーが見つけられなくて、自分で実装したloadClassが呼ばれる
 * 
 * ただし
 * java Game jpl.ch16.ex12.BinarySearchTreePlayer
 * としても、実は実行される！！
 * これは、クラスローダーの２番目の親クラスローダーから見つけるから、実行できる。
 * この時の、自分で作ったloadClassは実行されていない
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;
import java.util.Random;

/**
 * 数当てゲームを提供するクラス
 * 
 * 実行方法
 * ・Playerをimplementsしたクラスの、クラスファイルをこのパッケージに保存する。
 * 　（クラスファイルは、プロジェクトフォルダの中のbinフォルダ内）
 * ・実行時の引数に、クラス名を入れて実行
 * 　（例. WeakPlayer）
 * @author mt
 */
public class Game {
	private int score;
	private int hit;
	public static final int MAX_NUMBER = 20;
	public static final int MIN_NUMBER = 1;
	private static final Queue<String> players = new ArrayDeque<String>();

	public enum Result {
		HIGH, LOW, HIT
	};

	public static void main(String[] args) {
		setPlayers(args);
		String name;// クラス名
		while ((name = getNextPlayer()) != null) {
			try {
				PlayerLoader loader = new PlayerLoader();
				Class<? extends Player> classOf = loader.loadClass(name).asSubclass(Player.class);
				Player player = classOf.newInstance();
				Game game = new Game();
				player.play(game);
				game.reportScore(name);
			} catch (Exception e) {
				try {
					reportException(name, e);
				} catch (FileNotFoundException fe) {
					fe.printStackTrace();
				}
			}
		}
	}

	/**
	 * ランダムで、MINNUMBER~MAX_NUMBERの答えを決定
	 */
	private Game() {
		Random random = new Random();
		hit = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
	}

	/**
	 * hitが引数の値より大きければHIGH,小さければLOW,一致していればHIT
	 * 
	 * @param num
	 * @return HIGH,LOW,HIT
	 */
	public Result checkNumber(int num) {
		score++;
		return (num < hit) ? Result.HIGH : (num == hit) ? Result.HIT : Result.LOW;
	}

	/**
	 * 0に近いほど、いい結果
	 * 
	 * @return
	 */
	public void reportScore(String name) {
		System.out.println("answer = " + hit + " , " + name + "'s score : " + score);
	}

	private static void reportException(String name, Exception e) throws FileNotFoundException {
		System.out.println(name);
		e.printStackTrace();
	}

	private static String getNextPlayer() {
		return players.poll();
	}

	private static void setPlayers(String[] in) {
		for (String s : in) {
			players.add(s);
		}
	}

}
