/**
 * The {@code Passenger} class represents a passenger in public transport, such
 * as a bus.
 */
public class Passenger
{
  // Attributes
  private final String name;
  private final int priorityLvl;
  private final int route;
  private final int stop;

  /**
   * Constructs the {@code Passenger} class.
   *
   * @param name the name of the passenger
   * @param priorityLvl the priority level of the passenger
   * @param route the route
   * @param stop the stop
   */
  public Passenger (String name, int priorityLvl, int route, int stop)
  {
    this.name = name;
    this.priorityLvl = priorityLvl;
    this.route = route;
    this.stop = stop;
  }

  /**
   * Returns the route the passenger will be taking.
   *
   * @return the route, an index into the {@code Bus.ROUTES} array
   */
  public int getRoute()
  {
    return route;
  }

  /**
   * Gets the destination that the passenger will disembark.
   *
   * @return an index into the array of stops in the {@code Route} class
   */
  public int getStop()
  {
    return stop;
  }

  /**
   * Returns the priority level of the passenger.
   *
   * @return the priority level
   */
  public int getPriority()
  {
    return priorityLvl;
  }

  /**
   * Returns the name of the passenger.
   *
   * @return the full name of the passenger
   */
  public String getName()
  {
    return name;
  }
}
