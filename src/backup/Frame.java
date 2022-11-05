package backup;

public class Frame {
	
	protected int frameID;
	protected int[] scores = new int[]{0, 0};
	protected int pinCount = 10;
	protected int scoreCount;

	public Frame(int frameID) {
		this.frameID = frameID;
		this.scoreCount = 0;
		System.out.println("New Frame #" + this.frameID);
	}
	
	public boolean scorePoint(int score) {
		if (this.scoreCount >= 2) {
			System.out.println(this.toString());
			return false;
		}
		this.scores[this.scoreCount] = score;
		this.scoreCount++;
//		System.out.println(this.toString());
		return true;
	}
	
	public boolean scorePoint() {
		return this.scorePoint((int)(Math.random() * 11));
	}
	
	public String toString() {
		return String.format("Frame #%d: %d - %d", this.frameID, this.scores[0], this.scores[1]);
	}
}
