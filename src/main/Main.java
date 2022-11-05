package main;

public class Main {
	
	public static void main(String[] args) {
		BowlingGM gm = new BowlingGM();
		gm.startGame();
//		for (int i = 0; i < 10	; i++) {
//			fm.throwBall();
//		}
		gm.throwBall(10);
		gm.throwBall(5);
		gm.throwBall(4);
		gm.throwBall(3);
		gm.throwBall(1);
		gm.throwBall(3);
		System.out.println();
		System.out.println(gm);
	}
}
