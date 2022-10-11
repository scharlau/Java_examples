import java.util.ArrayList;

public class RoadBikeParts extends Parts {
  private Part chain;
  private Part tyre_size;

  public RoadBikeParts(Part chain, Part tyre_size){
    this.chain = chain;
    this.tyre_size = tyre_size;
  }

  public Part getChain(){
    return this.chain;
  }

  public Part getTyreSize(){
    return this.tyre_size;
  }
  
  public ArrayList<Part> getParts(){
    ArrayList<Part> myParts = new ArrayList<Part>();
    myParts.add(this.getChain());
    myParts.add(this.getTyreSize());
    return myParts;
  }

  public void setParts(ArrayList<Part> newParts){
    RoadBikeParts rbp = new RoadBikeParts(newParts.get(0), newParts.get(1));
    this.chain = rbp.getChain();
    this.tyre_size = rbp.getTyreSize();
  }

  
}