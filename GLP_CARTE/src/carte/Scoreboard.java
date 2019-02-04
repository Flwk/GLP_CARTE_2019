package carte;
/**
 * 
 * @author cvericel
 */
public class Scoreboard {
		private int score;
		
		public Scoreboard(int score) {
			this.score=score;
		}
		
		public void increment() {
			score++;
		}
		
		public void decrement() {
			score--;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
}
