package backup;

import java.util.ArrayList;
import java.util.List;

public class FrameManager {
	
	enum State {
			NORMAL,
			SPARE,
			STRIKE
	}
	protected State currentState;
	protected List<Frame> frames;
	protected int currentFrameIndex;
	
	private int framesAmount = 10;
	
	public FrameManager() {
		this.currentState = State.NORMAL;
		this.frames = new ArrayList<>();
		for (int i = 0; i < framesAmount; i++) {
			this.frames.add(new Frame(i));
		}
		this.currentFrameIndex = 0;
	}
	
	public void throwBall(int points) {
		if (this.currentFrameIndex > 10) System.out.println("game has ended");
		boolean scored = this.frames.get(this.currentFrameIndex).scorePoint();
		if (scored == false) {
			this.currentFrameIndex++;
			this.throwBall(0);
		}
	}
	
	
	//getters and setters
	public int getCurrentFrame() {
		return this.currentFrameIndex;
	}
	
	public void setCurrentFrame(int currentFrame) {
		this.currentFrameIndex = currentFrame;
	}

}
