
public class Route
{
  private final String name;
  private final String[] stops;

  public Route(String name, String[] stops)
  {
    this.name = name;
    this.stops = stops;
  }

  public int getCount()
  {
    return stops.length;
  }

  public String getStop(int index)
  {
    if (index < 0 || index >= stops.length)
      return null;

    return stops[index];
  }

  @Override
  public String toString()
  {
    return this.name;
  }
}
