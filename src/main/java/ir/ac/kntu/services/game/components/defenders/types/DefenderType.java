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
}
