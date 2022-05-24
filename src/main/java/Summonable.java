import javax.swing.*;

public abstract class Summonable {
    protected String name;
    protected int id;
    protected ImageIcon icon;
    protected Rarity rarity;
    protected boolean rateUp;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public boolean isRateUp() {
        return rateUp;
    }
}
