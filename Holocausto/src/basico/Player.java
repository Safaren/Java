
package pigElCerdo;

public class Player {

	private int points;
	private int[] die = new int[20]; 
	private String name;

	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public int[] getDie() {
		return die;
	}

	public void setDie(int indi , int die) {
		this.die[indi] = die;
	}


	public void setPoints(int points) {
		this.points = points;
	}

	public Player(int points, String name) {
		super();
		this.points = points;
		this.name = name;
	}
	
	@Override
	public String toString() {
	
		return name;
	}
	
}
