import java.util.ArrayList;

public class Bus
{
  // Attributes
  private static final String[] ROUTES = new String[] { "MNL to STC", "STC to MNL" };
  private static final String[][] STOPS = new String[][]
  {
    new String[] {  },
    new String[] {  }
  };

  private final String plateNumber;
  private final int capacity;
  private ArrayList<Passenger> passengers;
  private int route;
  private int stop;

  public Bus(String plateNumber, int capacity, int route)
  {
    this.plateNumber = plateNumber;
    this.capacity = capacity;
    this.route = route
  }

  public void load(Passenger person)
  {
    if (passengers.size() < capacity)
      passengers.add(person);
    else
      System.out.println("Bus " + plateNumber + " is already full.");
  }


}
