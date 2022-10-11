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
    this.chain = newParts.get(0);
    this.tyre_size = newParts.get(1);
  }

  public static void main(String[] args){
    Part chain = new Part("11-speed", "enough gears for the flat");
    Part tyre_size = new Part("slick tyres", "go faster with less friction");
    BicycleComp myBike = new BicycleComp("large", new RoadBikeParts(chain, tyre_size));
    ArrayList<Part> myParts = (ArrayList<Part>) myBike.getParts();
    for (Part part : myParts){
      System.out.println(part.getName());
    }
    

  }
}