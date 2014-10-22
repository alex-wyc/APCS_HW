import java.util.*;

public class Nomar extends Basechar{
    private String name;
    private int sight, HP, level; 
    private double intimidation;

    public Nomar(){
		super();
		name = "The Great Nomar";
		level = super.getLv() + 5;
		intimidation = 0.5;
		HP = super.getHP() + 10;
    }
    
    public Nomar(String name){
    	super(name);
    	intimidation = 0.1;
    }
    
    public double getIntimidation(){
    	return intimidation;
    }
    
    public void setIntimidation(double NewIntimidation){
    	intimidation = NewIntimidation;
    }
    
    public static void wait(int ms){
    	try {
    		Thread.sleep(ms);
    	} catch (Exception e) {}
    }

	public void attack(Basechar other) {
		Random r = new Random();
		int i = r.nextInt(4);

		switch (i) {
			case 0:
				basicAttack(other);
				break;
			
			case 1:
				lecture(other);
				break;

			case 2:
				instaKill(other);
				break;

			case 3:
				confiscation(other);
				break;
		}
	}

	public void basicAttack(Basechar other) {
		if (this.toHit(1)) {
			int damage = this.getAtk(false) - (other.getDef() / 2);
			other.setHP(other.getHP() - damage);
			System.out.println("The " + this.getName() + " landed a hit!");
			System.out.println("It inflicted " + damage + " damage!!");
		}

		else {
			System.out.println("It missed!!");
		}
	}
	
    public void lecture(Basechar other){

		Random chanceToHit = new Random();
		Random IntFactor = new Random();
		double intd = this.getIntimidation();
		
		if (chanceToHit.nextDouble() < this.getAccuracy()){
	    	System.out.println(this + " gives you a lengthy lecture");
            wait(5000);
	    	other.setHP(other.getHP() - (this.getAtk(false) - (other.getDef() / 2)));
	    	this.setIntimidation(intimidation + ((Math.abs(IntFactor.nextDouble() - intimidation)) * 0.5));
	    }

		else{
 	    	System.out.println(this + " tries to lecture you but you can't hear him over your blasting headphones");
		}
    }
    
    public void instaKill(Basechar other){
        Random chanceToHit = new Random();
        if (chanceToHit.nextDouble() < (this.getAccuracy() * 0.3)){
        	System.out.println(getName() + " calls your parents");
        	wait(1000);
        	other.setHP(0);
        }
        else{
        	System.out.println(getName() + " calls your parents but no one answers");
        	wait(1000);
        }
    
    }
    
    public void confiscation(Basechar other){
    	Random chanceToHit = new Random();
    	if (chanceToHit.nextDouble() < (this.getAccuracy())) {
    		if (other.getWielded().equals("Bare Hands")) {
    			System.out.println(this.getName() + " uses confiscate");
    			wait(1000);
    			System.out.println("...but you had nothing on you");
    		}
    		else{
    		        System.out.println(this.getName() + " confiscates your " + other.getWielded());
    		        other.setWielded("Bare Hands");	
    		}
    		
    	}
    }
}

  

	
