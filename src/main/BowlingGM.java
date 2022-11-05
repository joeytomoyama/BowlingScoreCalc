package main;

import java.util.ArrayList;
import java.util.List;

public class BowlingGM {
	
	enum State {
			NORMAL,
			SPARE,
			STRIKE
	}
	protected State currentState;
	protected static List<Frame> frames;
	protected int currentFrameIndex;
	protected FrameManager fm;
	
	protected int totalPoints;
	
	private int framesAmount = 10;
	
	public BowlingGM() {
		this.currentState = State.NORMAL;
		frames = new ArrayList<>();
		this.currentFrameIndex = 0;
		this.totalPoints = 0;
		this.fm = new FrameManager(frames);
	}
	
	public void startGame() {
		for (int i = 0; i < framesAmount; i++) {
			frames.add(new Frame(i));
		}
	}
	
	public void throwBall(int pinsHit) {
		if (this.currentFrameIndex >= 10) {
			System.out.println("game has ended");
			return;
		}
		boolean scored = frames.get(this.currentFrameIndex).scorePoint(pinsHit);
		if (scored == false) {
			this.currentFrameIndex++;
			this.throwBall();
		}
	}
	
	//throwBall with random score
	public void throwBall() {
		this.throwBall((int)(Math.random() * 11));
	}
	
	
	//getters and setters
	public int getCurrentFrame() {
		return this.currentFrameIndex;
	}
	
	public void setCurrentFrame(int currentFrame) {
		this.currentFrameIndex = currentFrame;
	}

}
