public class MyNamedObject extends MyObject {
  
  private String name;

  public MyNamedObject (double value, String name) {
     super(value);
     this.name= name;  
  }
  public  String getName () {
    return name;
  }
}