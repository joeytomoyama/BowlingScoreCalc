package main;

// import java.util.List;

public class FrameManager {

	enum State {
		NORMAL,
		SPARE,
		STRIKE
	}
	
	protected static State currentState = State.NORMAL;
	protected static int totalScore = 0;

	public FrameManager() {
	}

	public static void setPrevFrame(int index, int score) {
		BowlingGM.frames.get(index - 1).transferScore(score);;
		currentState = State.NORMAL;
	}

	public static boolean isStrike() {
		return (currentState == State.STRIKE) ? true : false;
	}
	public static void setStrike() {
		currentState = State.STRIKE;
	}

	public static boolean isSpare() {
		return (currentState == State.SPARE) ? true : false;
	}
	public static void setSpare() {
		currentState = State.SPARE;
	}

	public static void setNormal() {
		currentState = State.NORMAL;
	}

	public static int getTotalScore() {
		return totalScore;
	}
	public static void addTotalScore(int score) {
		totalScore += score;
	}


	// getters and setters
	public static State getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(State state) {
		currentState = state;
	}
}
