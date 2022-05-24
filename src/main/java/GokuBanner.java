import javax.swing.*;

public class GokuBanner extends Summonable {

    public GokuBanner(int id, String name, Rarity rarity, boolean rateUp) {
        super(id, name, rarity, rateUp);
        this.icon = new ImageIcon(" " + id + ".png");
    }
}
