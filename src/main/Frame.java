package main;

import main.BowlingGM.State;

public class Frame {
	
	protected int frameID;
	protected int[] scores = new int[]{0, 0};
	protected int frameScore;
	protected int scoreCount;

//	private int pinCount = 10;

	public Frame(int frameID) {
		this.frameID = frameID;
		this.frameScore = 0;
		this.scoreCount = 0;
//		System.out.println("New Frame #" + this.frameID);
	}
	
	public boolean scorePoint(int score) {
		if (this.scoreCount > this.scores.length - 1) {
			System.out.println(this.toString());
			return false;
		}
		this.scores[this.scoreCount] = score;
		if (score == 10) {
			BowlingGM.currentState = State.STRIKE;
			this.scoreCount = this.scores.length;
		}
		this.scoreCount++;
		return true;
	}
	
	public int calcFrameScore() {
		return this.scores[0] + this.scores[1];
	}
	
	public void addScore(int points) {
		this.setScore(this.getScore() + points);
	}
	
	
	public int getScore() {
		return this.scoreCount;
	}
	
	public void setScore(int score) {
		this.scoreCount = score;
	}
	
	public String toString() {
		return String.format("Frame #%d: %d - %d(%d)", this.frameID, this.scores[0], this.scores[1], this.calcFrameScore());
	}
}
