package ir.ac.kntu.services.game.components.defenders.types;

import javafx.scene.image.Image;

public abstract class DefenderType {
    private String name;
    private double price;

    public DefenderType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract Image getImage();

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof DefenderType otherType)) return false;
        return otherType.name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}