package DataBase;

import Simulador.Rarity;

import javax.swing.*;
import java.util.Objects;

public class Summonable {
    protected int id;
    protected String name;
    protected ImageIcon icon;
    protected Rarity rarity;
    protected boolean rateUp;
    protected int cantidad;
    protected String userId;


    public Summonable() {
    }

    public Summonable(int id, String name, ImageIcon icon, Rarity rarity, int cantidad, String idu) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.rarity = rarity;
        this.cantidad = cantidad;
        this.userId = idu;
    }

    public Summonable(int id, String name, Rarity rarity, boolean rateUp) {
        this.name = name;
        this.id = id;
        this.rarity = rarity;
        this.rateUp = rateUp;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summonable that = (Summonable) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }
}