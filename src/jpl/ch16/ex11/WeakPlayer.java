package jpl.ch16.ex11;

public class WeakPlayer implements Player {

	/**
	 * Game.MIN_NUMBERから一つずつ加算して合っているか確認するだけ
	 */
	@Override
	public void play(Game game) {
		int num = Game.MIN_NUMBER;
		while(game.checkNumber(num) != Game.Result.HIT) {
			num++;
		}
	}
}
