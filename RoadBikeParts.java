public class RoadBikeParts implements Parts {

    private String chain = "11-speed";
  
  public String getParts(){
    return this.chain;
  }

  public void setParts(String newParts){
    this.chain = newParts;
  }

  public static void main(String[] args){
    BicycleComp myBike = new BicycleComp("large", new RoadBikeParts());
    System.out.println(myBike.getParts());
  }
}