package jpl.ch16.ex11;

public class BinarySearchTreePlayer implements Player {

	@Override
	public void play(Game game) {
		int max = Game.MAX_NUMBER;
		int min = Game.MIN_NUMBER;
		int mid = (min + max) / 2;
		
		Game.Result result;
		while ((result = game.checkNumber(mid)) != Game.Result.HIT) {
			if (result == Game.Result.HIGH) {
				min = mid + 1;
			} else {
				max = mid - 1; 
			}
			mid = (min + max) / 2;
		}
	}
}