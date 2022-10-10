public class RoadBicycle extends Bicycle{

  public RoadBicycle(String size, String chain, int tyre_size){
    super(size, chain, tyre_size);
  }

  public static void main(String[] args){
    RoadBicycle rb = new RoadBicycle("small", "21-speed", 28);
    System.out.println(rb.getSize());
  }

}