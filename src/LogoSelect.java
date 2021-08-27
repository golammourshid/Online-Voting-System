import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.Map;


public class LogoSelect {
    Label messege;
    Map<String,Integer> map;
    GridPane grid;
    ChoiceBox<String> LogoChoiceBox;
    String logolist;
    LogoSelect(Label messege,Map<String,Integer> map,GridPane gridPane,ChoiceBox<String> LogoChoiceBox,String logolist)
    {
        this.messege=messege;
        this.map=map;
        grid = gridPane;
        this.LogoChoiceBox=LogoChoiceBox;
        this.logolist=logolist;
    }

    public void action()
    {
            //messege.setText("  ");
            //grid.add(messege,1,2);
        if (LogoChoiceBox.getValue() == null){
            System.out.println("selet koro");
            messege.setText("Please Select a logo");
            messege.setTextFill(Color.web("#ff0000"));

        }
        else {
            String choice = LogoChoiceBox.getValue();
            if (map.get(choice)==0)
            {
                map.put(choice,1);
                map.put(logolist,0);
                logolist=choice;
                messege.setText("Logo adder Successfully!");
                messege.setTextFill(Color.web("#008000"));
                ImageView imageHouse = new ImageView(new Image("Logo\\"+choice+".jpg"));
                imageHouse.setFitWidth(40);
                imageHouse.setFitHeight(40);
                //imageViews[0]=imageHouse;
                grid.add(imageHouse,4,1);
            }
            else {
                messege.setText("Logo Already taken!");
                messege.setTextFill(Color.web("#ff0000"));
            }

        }

        System.out.println("but 1");
        grid.add(new Label("                       "),1,2);
        grid.add(messege,1,2);
    }
}
