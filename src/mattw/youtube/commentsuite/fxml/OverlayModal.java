package mattw.youtube.commentsuite.fxml;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Base template for modal format overlaying parent StackPane.
 *
 * @param <T> Custom modal content fxml controller class
 *
 * @since 2018-12-30
 * @author mattwright324
 */
public class OverlayModal<T extends Pane> extends StackPane {

    private @FXML Label title;
    private @FXML Label divider;
    private @FXML StackPane content;
    private @FXML VBox modalContainer;

    public OverlayModal() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OverlayModal.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    public String getTitle() {
        return this.title.getText();
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setContent(T content) {
        this.content.getChildren().clear();
        this.content.getChildren().add(content);
    }

    public void setDividerClass(String cssClass) {
        divider.getStyleClass().clear();
        divider.getStyleClass().addAll("divider", cssClass);
    }

    public T getContent() {
        return (T) this.content.getChildren().get(0);
    }

    public VBox getModalContainer() {
        return this.modalContainer;
    }
}
