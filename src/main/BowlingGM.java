package main;

import java.util.ArrayList;
import java.util.List;

public class BowlingGM {
	
	protected static List<Frame> frames;
	protected int currentFrameIndex;
	
	protected int totalPoints;
	
	private int framesAmount = 10;
	
	public BowlingGM() {
		frames = new ArrayList<>();
		this.currentFrameIndex = 0;
		this.totalPoints = 0;
	}
	
	public void startGame() {
		for (int i = 0; i < framesAmount; i++) {
			frames.add(new Frame(i));
		}
		System.out.println("Frames created");
	}
	
	public void throwBall(int pinsHit) {
		if (this.currentFrameIndex >= 10) {
			System.out.println("game has ended");
			return;
		}
		Frame currentFrame = frames.get(this.currentFrameIndex);
		if (currentFrame.isCompleted() == true) {
			this.currentFrameIndex++;
			currentFrame = frames.get(this.currentFrameIndex);
		}
		frames.get(this.currentFrameIndex).scorePoint(pinsHit);
	}
	
	//throwBall with random score
	public void throwBall() {
		this.throwBall((int)(Math.random() * 6));
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
