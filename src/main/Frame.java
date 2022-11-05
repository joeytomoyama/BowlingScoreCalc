package main;

import main.FrameManager.State;

public class Frame {
	
	protected int frameIndex;
	protected int[] scores = new int[]{0, 0};
	protected int frameScore;
	protected int transferedScore;
	protected int scoreCount;
	protected boolean completed;

	public Frame(int frameIndex) {
		this.frameIndex = frameIndex;
		this.frameScore = 0;
		this.transferedScore = 0;
		this.scoreCount = 0;
		this.completed = false;
//		System.out.println("New Frame #" + this.frameIndex);
	}
	
	public void scorePoint(int score) {
		// register score
		this.scores[this.scoreCount] = score;
		System.out.println("scored: " + score + " | " + FrameManager.getCurrentState());
		this.scoreCount++;
		// check strike
		if (score == 10) {
			FrameManager.setCurrentState(State.STRIKE);
			this.completed = true;
		}
		// check if frame completed
		boolean twoRoundsCompleted = this.scoreCount > this.scores.length - 1;
		if (twoRoundsCompleted) {
			this.completed = true;
			// transfer score to previous frame(strike)
			if (FrameManager.isStrike()) {
				FrameManager.getPrevFrame(frameIndex).transferScore(this.calcFrameScore());
				FrameManager.setNormal();
			}
			// check spare
			// if (this.calcFrameScore() >= 10) FrameManager.setCurrentState(State.SPARE);
		}
	}
	
	public int calcFrameScore() {
		return this.scores[0] + this.scores[1] + this.transferedScore;
	}
	
	public void transferScore(int points) {
		this.transferedScore = points;
		// this.setScore(this.getScore() + points);
	}
	
	
	public int getScore() {
		return this.frameScore;
	}
	
	public void setScore(int score) {
		this.frameScore = score;
	}

	public boolean isCompleted() {
		return this.completed;
	}
	
	public String toString() {
		return String.format("Frame #%d: %d - %d(%d) | %d", this.frameIndex, this.scores[0], this.scores[1], this.calcFrameScore(), FrameManager.getTotalScore());
	}
}
