package main;

public class Frame {
	
	protected int frameIndex;
	protected int[] scores = new int[]{0, 0};
	protected int transferedScore;
	protected int scoreCount;
	protected boolean completed;

	public Frame(int frameIndex) {
		this.frameIndex = frameIndex;
		this.transferedScore = 0;
		this.scoreCount = 0;
		this.completed = false;
	}
	
	public void scorePoint(int score) {
		// register score
		this.scores[this.scoreCount] = score;
		System.out.println("scored: " + score + " | " + FrameManager.getCurrentState());
		this.scoreCount++;
		//transfer score to previous frame(spare)
		if (FrameManager.isSpare()) FrameManager.setPrevFrame(frameIndex, score);
		// check strike
		if (score == 10) {
			FrameManager.setStrike();
			this.completed = true;
		}
		// check if frame completed
		boolean twoRoundsCompleted = this.scoreCount > this.scores.length - 1;
		if (twoRoundsCompleted) {
			this.completed = true;
			// transfer score to previous frame(strike)
			boolean previousIsStrike = FrameManager.isStrike();
			if (previousIsStrike) {
				FrameManager.setPrevFrame(frameIndex, this.calcFrameScore());
			}
			// check spare
			if (this.calcFrameScore() >= 10) FrameManager.setSpare();;	// maybe setup new variable instead of using calcFrameScore
		}
	}
	
	public int calcFrameScore() {
		return this.scores[0] + this.scores[1] + this.transferedScore;
	}
	
	public void transferScore(int points) {
		this.transferedScore = points;
	}
	
	

	// public void setScore(int score) {
	// 	this.frameScore = score;
	// }

	public boolean isCompleted() {
		return this.completed;
	}
	
	public String toString() {
		return String.format("Frame #%2d: %2d - %2d(%2d) | %3d",
		this.frameIndex, this.scores[0], this.scores[1], this.calcFrameScore(), BowlingGM.getTotalScore(frameIndex + 1));
	}
}
