import java.util.ArrayList;

public class Bus
{
  private static final String[] ROUTES = new String[] { "MNL to STC", "STC to MNL" };
  private static final String[] STOPS = new String[]
  {
    new String[] {  },
    new String[] {  }
  };

  private final String plateNumber;
  private final int capacity;
  private ArrayList<Passenger> passengers;
  private int route;
  private int stop;

}
