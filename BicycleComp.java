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
    myParts = rbp.getParts();
    return myParts;
  }

  public void setParts(ArrayList<Part> newParts){
    this.parts.setParts(newParts);
  }

  public static void main(String[] args){
    Part chain = new Part("11-speed", "enough gears for the flat");
    Part tyre_size = new Part("slick tyres", "go faster with less friction");
    BicycleComp myBike = new BicycleComp("large", new RoadBikeParts(chain, tyre_size));
    ArrayList<Part> myParts = (ArrayList<Part>) myBike.getParts();
    for (Part part : myParts){
      System.out.println(part.getName());
    }
    Part newChain = new Part("21-speed", "more gears for those hill");
    Part newTyre_size = new Part("slick armadillo tyres", "go faster with less friction and fewer punctures");
    ArrayList<Part> newParts = new ArrayList<Part>();
    newParts.add(newChain);
    newParts.add(newTyre_size);
    myBike.setParts(newParts);
    ArrayList<Part> myNewParts = (ArrayList<Part>) myBike.getParts();
    for (Part part : myNewParts){
      System.out.println(part.getName());
    }

  }
}

