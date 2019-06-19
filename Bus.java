import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Bus
{
  public class PassengerComparator implements Comparator<Passenger>
  {
    @Override
    public int compare(Passenger a, Passenger b)
    {
      return Math.signum(b.getPriority() - a.getPriority());
    }
  }

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
    {
      passengers.add(person);
      Collections.sort(passengers, new PassengerComparator());
    }
    else
      System.out.println("Bus " + plateNumber + " is already full.");
  }


}
