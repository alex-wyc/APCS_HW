public class Driver {
    /*
	public static void main(String[] args){
	Basechar c = new Basechar();
	Warrior w = new Warrior();
	Mage m = new Mage();

	System.out.println(c.getHealth());
	System.out.println(w.getHealth());
	System.out.println(m.getHealth());

	System.out.println(m.getManna());

    }
	*/

	public static void main(String[] args) {
	
	Basechar c1 = new Basechar();
	//Basechar c2 = new Basechar("Tom");

	Basechar b1,b2;
	Warrior w1,w2;
	Mage m1,m2;

	b1 = new Basechar();
	w1 = new Warrior();
	m1 = new Mage("Tom");

	m2 = m1;
	//m2 = b1;
	//m2 = c1;
	//m2 = w1;

	b2 = m1;
	b2 = m2;
	//b2 = new Warrior();

	m2.getHealth();
	m2.getManna();

	//b2.getManna();
	//b2.getHealth();

	System.out.println(m1.getName());
	System.out.println(m1.getName());
	}
}
