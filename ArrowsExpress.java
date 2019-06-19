import java.util.*;

public class ArrowsExpress
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    List passengerList = new ArrayList<Passenger>();
    
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
      passengerList.add(new Passenger(name, pLvl, route, stop));

      System.out.print("Add new entry? (Y/N): ");
      reply = sc.nextChar();
      if (reply == "Y" || reply == "y")
        run = 1;
      else
        run = 0;
    } while(run);
    //Headcount for specific ROUTES
    System.out.printf("\n Buses arriving in terminal. . .\n");
  }
}
