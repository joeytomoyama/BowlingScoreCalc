package main;

public class Main {
	
	public static void main(String[] args) {
		BowlingGM gm = new BowlingGM();
		gm.startGame();
		gm.throwBall(1);
		gm.throwBall(4);
		//
		gm.throwBall(4);
		gm.throwBall(5);
		//
		gm.throwBall(6);
		gm.throwBall(4);
		//
		gm.throwBall(5);
		gm.throwBall(5);
		//
		gm.throwBall(10);
		//
		gm.throwBall(0);
		gm.throwBall(1);
		//
		gm.throwBall(7);
		gm.throwBall(3);
		//
		gm.throwBall(6);
		gm.throwBall(4);
		//
		gm.throwBall(10);
		//
		gm.throwBall(2);
		gm.throwBall(6);
		//
		System.out.println(gm);
		System.out.println(BowlingGM.getTotalScore(10));
	}
}
