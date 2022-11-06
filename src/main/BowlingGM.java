package main;

import java.util.ArrayList;
import java.util.List;

public class BowlingGM {
	
	protected static List<Frame> frames;
	protected int currentFrameIndex;
	
	protected static int totalPoints;
	
	private int framesAmount = 10;
	
	public BowlingGM() {
		frames = new ArrayList<>();
		this.currentFrameIndex = 0;
		totalPoints = 0;
	}
	
	public void startGame() {
		for (int i = 0; i < framesAmount; i++) {
			frames.add(new Frame(i));
		}
		System.out.println("Frames created");
	}
	
	public void throwBall(int pinsHit) {
		if (frames.get(frames.size() - 1).isCompleted()) {
			System.out.println("game has ended");
			return;
		}
		Frame currentFrame = frames.get(this.currentFrameIndex);
		if (currentFrame.isCompleted() == true) {
			this.currentFrameIndex++;
			currentFrame = frames.get(this.currentFrameIndex);
		}
		currentFrame.scorePoint(pinsHit);
	}
	
	//throwBall with random score
	public void throwBall() {
		this.throwBall((int)(Math.random() * 6));
	}

	public static int getTotalScore(int frameLimit) {
		int sum = 0;
		for (int i = 0; i < frameLimit; i++) {
			Frame fr = frames.get(i);
			sum += fr.calcFrameScore();
		}
		return sum;
	}
	
	
	//getters and setters
	public int getCurrentFrame() {
		return this.currentFrameIndex;
	}
	
	public void setCurrentFrame(int currentFrame) {
		this.currentFrameIndex = currentFrame;
	}
	
	public String toString() {
		String result = "\n";
		for (Frame frame : frames) {
			result += frame + "\n";
		}
		return result;
	}

}
