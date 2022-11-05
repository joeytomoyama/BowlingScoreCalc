package backup;

public class BowlingPanel {
	
	protected int totalPoints = 0;
	protected FrameManager fm ;
	
	public BowlingPanel() {
		this.totalPoints = 0;
		this.fm = new FrameManager();
		fm.throwBall(0);
		fm.throwBall(0);
		fm.throwBall(0);
		fm.throwBall(0);
		fm.throwBall(0);
		fm.throwBall(0);
		fm.throwBall(0);
		fm.throwBall(0);
	}
	
	public void startGame() {
		
	}
	
	public void throwBall(int points) {
		
	}
}
