import java.util.Random;

public class Dice {
	
	Random numGenerator = new Random();
	private int m_numSides;
	
	public Dice() {
		m_numSides = 6;
	}
	
	public Dice(int numSides) {
		m_numSides = numSides;
	}
	
	public int getNumSides() {
		return(m_numSides);
	}
	
	public int roll() {
		return(numGenerator.nextInt(m_numSides) + 1);
	}

}
