import java.util.ArrayList;

//using composition
public class BicycleComp {
  private String size;
  private RoadBikeParts parts;

  public BicycleComp(String size, RoadBikeParts parts){
    this.size = size;
    this.parts = parts;
  }
  
  public ArrayList<Part> getParts(){
    ArrayList<Part> myParts = new ArrayList<Part>();
    RoadBikeParts rbp = this.parts;
    myParts.add(rbp.getChain());
    myParts.add(rbp.getTyreSize());
    return myParts;
  }

  public void setParts(ArrayList<Part> newParts){
    RoadBikeParts rbp = new RoadBikeParts(newParts.get(0), newParts.get(1));
    this.parts = rbp;
  }

}

