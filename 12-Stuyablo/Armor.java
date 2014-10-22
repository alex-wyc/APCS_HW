public class Armor {
  
  private int extraDef, extraMDef;
  private String ID;
  
  public Armor() {
    extraDef = 0;
    extraMDef = 0;
    ID = "Body";
  }
  
  public Armor(String ArmorID) {
    
    ID = ArmorID;
    
    if (ArmorID.equals("Mail")) {
      extraDef = 5;
      extraMDef = 1;
    }
    
    else if (ArmorID.equals("Cloak")) {
      extraDef = 1;
      extraMDef = 5;
    }
    
    else if (ArmorID.equals("Dragon Scales")) {
      extraDef = 5;
      extraMDef = 5;
    }
  
    else if (ArmorID.equals("Body")) {
      extraDef = 0;
      extraMDef = 0;
      //ID = "Bare Hands"
    }
  }
  
  public String getID() {
    return ID;
  }
  
  public int getExtraDef() {
    return extraDef;
  }
  
  public int getExtraMDef() {
    return extraMDef;
  }
}
