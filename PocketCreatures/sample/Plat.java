package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Plat{

    private int height=3;
    private int width=40;




    public Plat(int x, int y, int multiplier, Group root){
        Rectangle r = new Rectangle(x,y,width*multiplier, height*multiplier);


        r.setArcWidth(width*multiplier);
        r.setArcHeight(height*multiplier);
        r.setFill(Color.GRAY);


        Rectangle o = new Rectangle(x,y,width*multiplier-1,height*multiplier);
        o.setArcWidth(width*multiplier);
        o.setArcHeight(height*multiplier);
        o.setFill(Color.TRANSPARENT);
        o.setStroke(Color.WHITESMOKE);
        o.setStrokeWidth(1.5);
        o.setX(x);
        o.setY(y);

        root.getChildren().add(r);
        root.getChildren().add(o);

    }



}