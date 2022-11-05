package main;

public class Main {
	
	public static void main(String[] args) {
		BowlingGM fm = new BowlingGM();
		fm.startGame();
		for (int i = 0; i < 20	; i++) {
			fm.throwBall();
		}
	}
}
