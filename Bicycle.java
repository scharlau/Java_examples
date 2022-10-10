#using inheritance
public class Bicycle {
  private String size;
  private String chain;
  private int tyre_size;

  public Bicycle(String size, String chain, int tyre_size){
    this.size = size;
    this.chain = chain;
    this.tyre_size = tyre_size;
  }
  
  public void setSize(String newSize){
    size = newSize;
  }

  public String getSize(){
    return this.size;
  }

  public static void main(String[] args){
    Bicycle myBike = new Bicycle("large", "ten speed", 28);
    System.out.println(myBike.getSize());
  }
}
