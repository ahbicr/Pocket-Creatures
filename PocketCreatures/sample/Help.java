package sample;

import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Help {

    static Group help = new Group();

    Help(){
        Text Attack = new Text(900,650,"Attack");
        Attack.setFont(Font.font(50));

        Text Block = new Text(1025,570,"Block");
        Block.setFont(Font.font(50));

        Text Supp= new Text(1185,670,"Super\nAttack");
        Supp.setFont(Font.font(15));
        help.getChildren().addAll(Attack,Block,Supp);
    }
}
