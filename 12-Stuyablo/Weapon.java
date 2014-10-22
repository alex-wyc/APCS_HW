public class Weapon {
  
  private int extraAtk, extraMAtk, extraRange;
  private String ID;
  
  public Weapon() {
    extraAtk = 0;
    extraMAtk = 0;
    extraRange = 0;
    ID = "Bare Hands";
  }
  
  public Weapon(String weapID) {
    
    ID = weapID;
    
    if (weapID.equals("Longsword W")) {
      extraAtk = 5;
      extraRange = 1;
    }
    
    else if (weapID.equals("Bow and Arrow R")) {
      extraAtk = 2;
      extraRange = 7;
    }
    
    else if (weapID.equals("Bow and Arrow W")) {
      extraAtk = 0;
      extraRange = 1;
    }
  
    else if (weapID.equals("Bare Hands")) {
      extraAtk = 0;
      extraRange = 0;
      //ID = "Bare Hands"
    }
    else if (weapID.equals("Regents Physics Textbook")) {
      extraAtk = 5;
      extraRange = 0;
    }
    
    else if (weapID.equals("Wand W")) {
      extraAtk = 1;
      extraRange = 0;
    }
    
    else if (weapID.equals("Wand R")) {
      extraMAtk = 3;
      extraRange = 1;
    }
  }
  
  public String getID() {
    return ID;
  }
  
  public int getExtraAtk() {
    return extraAtk;
  }
  
  public int getExtraMAtk() {
    return extraMAtk;
  }

  
  public int getExtraRange() {
    return extraRange;
  }
}
