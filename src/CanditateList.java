import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.awt.*;

public class CanditateList {
    GridPane gridPane;
    CanditateList(GridPane gridPane,int row)
    {
        this.gridPane = gridPane;

        Label name = new Label("Name");
        TextField canditate = new TextField();
        gridPane.add(name,0,row);
        gridPane.add(canditate,1,row);
    }
}
