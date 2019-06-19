import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Bus
{
  public class PassengerComparator implements Comparator<Passenger>
  {
    @Override
    public int compare(Passenger a, Passenger b)
    {
      return b.getPriority() - a.getPriority();
    }
  }

  private static final int TERMINAL = -1;

  // Attributes
  private static final String[] ROUTES = new String[] { "MNL to STC", "STC to MNL" };
  private static final String[][] STOPS = new String[][]
  {
    new String[]
    {
      "Mampalasan Toll Exit",
      "Phase 6, San Jose Village",
      "Milagros del Rosario Building (East Canopy)",
      "Paseo CALTEX Gasoline Station (for trips AE 108 & AE 109)"
    },
    new String[]
    {
      "PETRON Gasoline Station along Gil Puyat Avenue",
      "Gate 4 - Gokongwei Gate",
      "Gate 2 - North Gate (HSSH)",
      "Gate 1 - South Gate (LS Building Entrance)"
    }
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
    this.route = route;
    this.stop = TERMINAL;
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

  public void unload()
  {
    Iterator i = passengers.iterator();
    Passenger person = null;
    while(i.hasNext())
    {
      person = (Passenger) i.next();
      if (person.getStop() == stop)
      {
        i.remove();
        System.out.println(person.getName() + "has dropped off.")
      }
    }
  }

  public void move()
  {

  }

  public int getRoute()
  {
    return route;
  }

  public int getStop()
  {
    return stop;
  }
}
