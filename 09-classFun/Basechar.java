/* superclass for warrior (base class) and Mage */
public class Basechar {
    
	private int health = 20;
	private String name;
	
	public Basechar(String PlayerName) {
		name = PlayerName;
	}

	public Basechar() {
		name = "Isaak";
	}
	
	
    public int getHealth() {
		return health;
    }

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}
}
