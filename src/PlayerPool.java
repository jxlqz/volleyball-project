import java.util.ArrayList;

public class PlayerPool {
    private ArrayList<Player> setters;
    private ArrayList<Player> liberos;
    private ArrayList<Player> outsides;

    public PlayerPool() {
        setters = new ArrayList<Player>();
        liberos = new ArrayList<Player>();
        outsides = new ArrayList<Player>();

        setters.add(new Player("Setter 1", new Setter()));
        setters.add(new Player("Setter 2", new Setter()));
        setters.add(new Player("Setter 3", new Setter()));
        setters.add(new Player("Setter 4", new Setter()));

        liberos.add(new Player("Libero 1", new Libero()));
        liberos.add(new Player("Libero 2", new Libero()));
        liberos.add(new Player("Libero 3", new Libero()));
        liberos.add(new Player("Libero 4", new Libero()));

        outsides.add(new Player("Outside 1", new Outside()));
        outsides.add(new Player("Outside 2", new Outside()));
        outsides.add(new Player("Outside 3", new Outside()));
        outsides.add(new Player("Outside 4", new Outside()));
        outsides.add(new Player("Outside 5", new Outside()));
        outsides.add(new Player("Outside 6", new Outside()));
        outsides.add(new Player("Outside 7", new Outside()));
        outsides.add(new Player("Outside 8", new Outside()));
    }

    public ArrayList<Player> getSetters() {
        return setters;
    }

    public ArrayList<Player> getLiberos() {
        return liberos;
    }

    public ArrayList<Player> getOutsides() {
        return outsides;
    }

    public void displaySetters() {
        System.out.println("SETTERS");

        for (int i = 0; i < setters.size(); i++) {
            System.out.println((i + 1) + ". " + setters.get(i));
        }
    }

    public void displayLiberos() {
        System.out.println("LIBEROS");

        for (int i = 0; i < liberos.size(); i++) {
            System.out.println((i + 1) + ". " + liberos.get(i));
        }
    }

    public void displayOutsides() {
        System.out.println("OUTSIDES");

        for (int i = 0; i < outsides.size(); i++) {
            System.out.println((i + 1) + ". " + outsides.get(i));
        }
    }
}