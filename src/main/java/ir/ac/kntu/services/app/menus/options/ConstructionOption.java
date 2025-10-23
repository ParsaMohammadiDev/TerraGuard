package ir.ac.kntu.services.app.menus.options;

import ir.ac.kntu.services.app.animations.factories.AnimationFactory;
import ir.ac.kntu.services.app.menus.Menu;
import ir.ac.kntu.services.game.components.defenders.types.DefenderType;
import ir.ac.kntu.services.game.core.markets.Market;
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

    private final AnimationFactory animFactory;
    private final Market market;
    private final DefenderType defenderType;

    private final Text nameText;
    private final Text priceText;
    private final Image itemImage;
    private Menu menu;

    private final HBox optionPane = new HBox();

    public ConstructionOption(DefenderType defenderType, AnimationFactory animFactory, Market market) {
        this.nameText = new Text(defenderType.getName());
        this.priceText = new Text(String.valueOf((int)defenderType.getPrice()));
        this.itemImage = defenderType.getImage();
        this.animFactory = animFactory;
        this.market = market;
        this.defenderType = defenderType;
        styleMenuPane(market, defenderType);
        optionPane.setOnMouseClicked(event -> executeOnAction());
    }

    @Override
    public Node getView() {
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
        coinIcon.setFitHeight(25);
        styleText(priceText);
        coinIcon.setPreserveRatio(true);
        pricePane.getChildren().addAll(coinIcon, priceText);
        pricePane.setAlignment(Pos.CENTER_RIGHT);
        return pricePane;
    }

    private void styleText(Text text) {
        text.setFont(Font.font("Berlin Sans FB", FontWeight.EXTRA_BOLD, 20));
        text.setFill(Color.BLACK);
    }

    private void styleMenuPane(Market market, DefenderType defenderType) {
        optionPane.setAlignment(Pos.CENTER_LEFT);
        optionPane.setSpacing(20);
        optionPane.getChildren().addAll(getTitlePane(), getPricePane());
        optionPane.disableProperty().bind(market.isAffordable(defenderType).not());
        optionPane.opacityProperty().bind(
                market.isAffordable(defenderType).map(affordable -> affordable ? 1.0 : 0.5)
        );
        animFactory.getButtonHoverAnimation().animate(optionPane);
    }

    public Market getMarket() {
        return market;
    }

    public DefenderType getDefenderType() {
        return defenderType;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }
}