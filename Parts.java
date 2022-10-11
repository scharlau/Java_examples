import java.util.ArrayList;

abstract public class Parts {
  private Part chain;
  private Part tyre_size;

  abstract public Part getChain();
  abstract public Part getTyreSize();

  abstract public ArrayList<Part> getParts();
  abstract public void setParts(ArrayList<Part> newParts);

}