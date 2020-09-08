package main.java.farrell.duke.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class DukeDialog extends HBox {
    private Label textLabel;
    private ImageView displayPicture;
    private Image image = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    /**
     * Creates a new DukeDialog containing some text.
     * @param text Text to display in the dialog.
     */
    public DukeDialog(String text) {
        textLabel = new Label(text);
        displayPicture = new ImageView(image);

        textLabel.setWrapText(true);
        displayPicture.setFitWidth(100);
        displayPicture.setFitHeight(100);

        this.setAlignment(Pos.TOP_LEFT);
        this.getChildren().addAll(displayPicture, textLabel);
    }
}