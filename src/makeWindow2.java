import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class makeWindow2 {
    Stage window;
    GridPane grid;
    String[] namelist;
    String[] logolist;
    makeWindow2(Stage window,GridPane grid,String[] namelist,String[] logolist)
    {
        this.window = window;
        this.grid = grid;
        this.namelist=namelist;
        this.logolist=logolist;
        window.setTitle("Voter selection");
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));
        loop();
    }


    void loop()
    {
        Label name1 = new Label("Canditate Name");
        Label logo = new Label("  Logo  ");
        name1.setFont(new Font("Cambria", 20));
        logo.setFont(new Font("Cambria", 20));

        grid.add(name1,1,0);
        grid.add(logo,3,0);
        for (int i=0;i<5;i++)
        {

            int row = (i*2)+1;
            Label name = new Label(namelist[i]);
            ImageView imageHouse = new ImageView(new Image("Logo\\" + logolist[i] + ".jpg"));
            imageHouse.setFitWidth(40);
            imageHouse.setFitHeight(40);
            grid.add(name,1,row,2,1);
            grid.add(imageHouse, 3, row);

        }
    }



}
