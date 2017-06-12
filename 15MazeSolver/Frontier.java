public interface Frontier{

    public int size();

    public boolean aStar();
    
    public void add(Location l);

    public Location next();

}
