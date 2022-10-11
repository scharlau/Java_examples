//using composition
public class BicycleComp {
  private String size;
  private RoadBikeParts parts;

  public BicycleComp(String size, RoadBikeParts parts){
    this.size = size;
    this.parts = parts;
  }
  
  public void setParts(RoadBikeParts newParts){
    parts = newParts;
  }

  public RoadBikeParts getParts(){
    return this.parts;
  }

}

