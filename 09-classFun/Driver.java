public class Driver {
    public static void main(String[] args){
	Basechar c = new Basechar();
	Warrior w = new Warrior();
	Mage m = new Mage();

	System.out.println(c.getHealth());
	System.out.println(w.getHealth());
	System.out.println(m.getHealth());

	System.out.println(m.getManna());

    }

}
