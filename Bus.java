
/**
 * The {@code Buss} class represents a bus that loads/unloads passengers
 * and moves to different locations.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Bus
{
  /**
    * Sorts the passengers by stop and priority level.
    * Returns an integer of the difference of the two Passengers compared.
    */
  public class PassengerComparator implements Comparator<Passenger>
  {
    @Override
    public int compare(Passenger a, Passenger b)
    {
      int stop = b.getStop() - a.getStop();
      if (stop == 0)
        return b.getPriority() - a.getPriority();
      else
        return stop;
    }
  }

  private static final int TERMINAL = -1;

  // Attributes
  public static final String[] ROUTES = new String[] { "MNL to STC", "STC to MNL" };
  public static final String[][] STOPS = new String[][]
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
  /**
   * Constructs the {@code Bus} class.
   *
   * @param plateNumber the unique identfication String of a Bus
   * @param capacity the maximum number of passengers it can hold
   * @param route the route of the bus
   */
  public Bus(String plateNumber, int capacity, int route)
  {
    this.plateNumber = plateNumber;
    this.passengers = new ArrayList<>();
    this.capacity = capacity;
    this.route = route;
    this.stop = TERMINAL;
  }
  /**
    * Loads a person in the bus. Adds person to passengers ArrayList if
    * the bus is not full. Sorts the passengers by stop and priority everytime
    *  a person is loaded to the bus.
    * @param person one Passenger that will be loaded to the bus
    */
  public void load(Passenger person)
  {
    if (!isFull())
    {
      passengers.add(person);
      sortByStatus();
    }
    else
      System.out.println("Bus " + plateNumber + " is already full.");
  }
  /**
    * Unloads a person in the bus. Removes persons in passengers ArrayList if
    * the bus stop is the same with their stop.
    */
  public void unload()
  {
    int headcount, pLvl = 1;
    Iterator i = passengers.iterator();
    Passenger person = null;
    while (i.hasNext())
    {
      person = (Passenger) i.next();
      if (person.getStop() == stop)
        headcount++;
    }

    while(headcount >= 0)
    {
      for(Passenger p : passengers)
      {
        if(p.getPriority() == pLvl)
        {
          passengers.remove(p);
          System.out.println(p.getName() + "has dropped off.");
          headcount--;
        }
      }
      pLvl++;
    }
  }
  /**
    * Sorting passengers using Collections.sort(passengers,comparator)
    */
  private void sortByStatus()
  {
    Collections.sort(passengers, new PassengerComparator());
  }
  /**
    * Moves the current stop location to the next location. If next stop
    * location is not in the array of stops, then it will be set to TERMINAL (-1).
    */
  public void move()
  {
    stop++;
    if (stop >= STOPS[route].length)
    {
      stop = TERMINAL; // -1 means we are at the terminal
      route = (route + 1) % ROUTES.length;
    }
  }
  /**
   * Returns true if the bus is full, and false if not.
   *
   * @return a boolean value when called
   */
  public boolean isFull()
  {
    return passengers.size() == capacity;
  }

}
