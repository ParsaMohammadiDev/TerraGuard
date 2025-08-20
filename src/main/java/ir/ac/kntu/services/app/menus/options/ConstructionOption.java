package ir.ac.kntu.services.app.menus.options;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public abstract class ConstructionOption implements MenuOption {
    private static final String COIN_ICON_PATH = "/app/coin.png";
    private static final Image COIN_ICON_IMAGE = new Image(COIN_ICON_PATH);

    private Text nameText;
    private Text priceText;
    private Image itemImage;

    public ConstructionOption(String name, String price, Image itemImage) {
        this.nameText = new Text(name);
        this.priceText = new Text(price);
        this.itemImage = itemImage;
    }

    @Override
    public Node getView() {
        HBox optionPane = new HBox();
        optionPane.setAlignment(Pos.CENTER);
        optionPane.setSpacing(50);
        optionPane.getChildren().addAll(getTitlePane(), getPricePane());
        return optionPane;
    }

    private Pane getTitlePane() {
        HBox titlePane = new HBox();
        ImageView itemImageView = new ImageView(itemImage);
        itemImageView.setFitHeight(50);
        styleText(nameText);
        itemImageView.setPreserveRatio(true);
        titlePane.getChildren().addAll(itemImageView, nameText);
        titlePane.setAlignment(Pos.CENTER_LEFT);
        return titlePane;
    }

    private Pane getPricePane() {
        HBox pricePane = new HBox();
        ImageView coinIcon = new ImageView(COIN_ICON_IMAGE);
        coinIcon.setFitHeight(30);
        styleText(priceText);
        coinIcon.setPreserveRatio(true);
        pricePane.getChildren().addAll(coinIcon, priceText);
        pricePane.setAlignment(Pos.CENTER_RIGHT);
        return pricePane;
    }

    private void styleText(Text text) {
        text.setFont(Font.font("Berlin Sans FB", FontWeight.EXTRA_BOLD, 20));
        priceText.setFill(Color.BLACK);
    }
}