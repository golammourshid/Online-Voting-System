import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class DisplayCanditate extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        GridPane grid = new GridPane();

        Label[] name = new Label[5];
        TextField[] canditate = new TextField[5];
        Button[] selection = new Button[5];
        String[] namelist = new String[5];
        String[] logolist = new String[5];
        new retriveCanditate(namelist,logolist);

        for (int i=0;i<5;i++)
        {
            System.out.println("name = "+namelist[i]+" \nLogo = "+logolist[i]);
        }

        Map<String,Integer> map=new HashMap<String,Integer>();

        ChoiceBox<String>[] LogoChoiceBox = new ChoiceBox[5];
        Scene scene = new Scene(grid,600,500);
        window.setScene(scene);
        window.show();
        makeWindow2 m1 = new makeWindow2(window,grid,namelist,logolist);
    }
}
