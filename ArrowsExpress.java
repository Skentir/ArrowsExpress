import java.util.*;

public class ArrowsExpress
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    List passengerListA = new ArrayList<Passenger>();

    String name; int route, stop, pLvl; boolean run = 1;
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
      passengerListA.add(new Passenger(name, pLvl, route, stop));

      System.out.print("Add new entry? (Y/N): ");
      reply = sc.nextChar();
      if (reply == "Y" || reply == "y")
        run = 1;
      else
        run = 0;
    } while(run);

    /* Headcount for specific ROUTES.
      Put people in MNL-STC (Route 0) to passengerListA
      Put people in STC-MNL (Route 1) to passengerListB
    */
    List passengerListB = new ArrayList<Passenger>();

    /*
      Create BusA. Load passengerListA to BusA.
      Create BusB. Load passengerListB to BusB.
    */
    Bus BusA = new Bus("SJUVX93",0); //Have a random plateNumber
    Bus BusB = new Bus("LVR1984",1); //Have a random plateNumber
    System.out.printf("\nBuses arriving in terminal. . .\n");
    /* Insert Load codes here*/
    System.out.printf("\nSuccess! All passengers are loaded to a bus.\n");
    /*
      Bus A and Bus B moves to stop 1.
      Unload passengers. Priority goes first.
      Repeat until it goes beyond last stop.
    */
    System.out.printf("\nMoving to %s. . .\n", stop);
    System.out.printf("\n%s has been dropped to %s.\n", personName, stop);
    System.out.printf("\nAll passengers dropped.\n", stop);
  }
}
