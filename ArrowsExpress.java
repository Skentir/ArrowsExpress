import java.util.*;

public class ArrowsExpress
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    /* Headcount for specific ROUTES.
      Put people in MNL-STC (Route 0) to passengerListA
      Put people in STC-MNL (Route 1) to passengerListB
    */
    List<Passenger> passengerListA = new ArrayList<Passenger>();
    List<Passenger> passengerListB = new ArrayList<Passenger>();

    String name; int route, stop, pLvl; boolean run = true;
    char reply;
    do
    {
      System.out.print("Enter Name of Passenger: ");
      name = sc.nextLine();
      System.out.print("Enter status: ");
      pLvl = sc.nextInt();
      System.out.print("Enter route: ");
      route = sc.nextInt();
      System.out.print("Enter stop: ");
      stop = sc.nextInt();
      sc.nextLine();
      if (route == 0)
        passengerListA.add(new Passenger(name, pLvl, route, stop));
      else
        passengerListB.add(new Passenger(name, pLvl, route, stop));

      System.out.print("Add new entry? (Y/N): ");
      reply = sc.nextLine().charAt(0);
      if (reply == 'Y' || reply == 'y')
        run = true;
      else
        run = false;
    } while(run);

    /*
      Create BusA. Load passengerListA to BusA.
      Create BusB. Load passengerListB to BusB.
    */
    Bus BusA = new Bus(randomPlateNumber(), 50, 0); //Have a random plateNumber
    Bus BusB = new Bus(randomPlateNumber(), 50, 1); //Have a random plateNumber
    System.out.printf("\nBuses arriving in terminal. . .\n");
    /* Insert Load codes here*/

    System.out.printf("\nLoading passengers to Bus A. . .\n");
    while (!BusA.isFull() && passengerListA.size() > 0)
    {
      BusA.load((Passenger) passengerListA.get(0));
      passengerListA.remove(0);
    }

    if (passengerListA.size() == 0)
      System.out.printf("\nSuccess! All passengers are loaded to bus A.\n");
    else
      System.out.printf("\nDang! Not all passengers were loaded to bus A.\n");

    System.out.printf("\nLoading passengers to Bus B. . .\n");
    while (!BusB.isFull() && passengerListB.size() > 0)
    {
      BusB.load((Passenger) passengerListB.get(0));
      passengerListB.remove(0);
    }

    if (passengerListB.size() == 0)
      System.out.printf("\nSuccess! All passengers are loaded to bus B.\n");
    else
      System.out.printf("\nDang! Not all passengers were loaded to bus B.\n");

      /* do the moving code */
    /*
      Bus A and Bus B moves to stop 1.
      Unload passengers. Priority goes first.
      Repeat until it goes beyond last stop.
    */
    System.out.printf("\nMoving to %s. . .\n", stop);
    //System.out.printf("\n%s has been dropped to %s.\n", personName, stop);
    System.out.printf("\nAll passengers dropped.\n", stop);

    // don't forget to close the scanner
    sc.close();
  }

  private static String randomPlateNumber()
  {
    Random rnd = new Random();
    String s = "";
    for (int i = 0; i < 3; i++)
      s += (char)('A' + rnd.nextInt(26));
    for (int i = 0; i < 3; i++)
      s += (char)('0' + rnd.nextInt(10));
    return s;
  }
}
