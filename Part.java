public class Part {
  private String name;
  private String description;

  public Part (String name, String description){
  this.name = name;
  this.description = description;
  }

  public String getName(){
    return this.name;
  }
  public void setName(String newName){
    this.name = newName;
  }
}