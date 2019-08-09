package sample;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;


class Bot extends Monster {


    int choosesMove(){

        int number = (int)(Math.random()*10)+1;
        if (number<7) return 1;
        if (number<10) return 2;
        if (number == 10 && !superOkay())
            return choosesMove();
        return 3;

    }

    public void PrintMonster(Group root){
        body = new Group();
        int x=1280-350;
        int y=365+ Main.down;

        base = new Circle(50);
        base.setCenterX(x);
        base.setCenterY(y);
        base.setFill(Paint.valueOf(color));
        body.getChildren().add(base);
        if (evolutionStage>1){
            middle = new Circle(35);
            middle.setCenterX(x);
            middle.setCenterY(y+75);
            middle.setFill(Paint.valueOf(color));
            body.getChildren().add(middle);
            if (evolutionStage>2){
                top = new Circle(25);
                top.setCenterX(x);
                top.setCenterY(y+131.25);
                top.setFill(Paint.valueOf(color));
                body.getChildren().add(top);
            }
        }


        switch (evolutionStage){
            case 1: y=y; break;
            case 2: y-=30; break;
            case 3: y-=55; break;
        }


        Path path = new Path();

        path.getElements().add (new MoveTo (x+300, y));
        path.getElements().add (new LineTo (x,y));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(900));
        pathTransition.setNode(body);

        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(true);





        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(.5), body);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();


        pathTransition.play();




        printStatBox(root);
        root.getChildren().add(body);



    }
    public void Dies(Group root){
        Main.you.counter++;
        root.getChildren().remove(body);
        Main.you.giveExp(level*23, root);



        type= (int)(Math.random()*7)+1;
        double lm=0.0;

        while(lm<.4||lm>.7){
           lm=Math.random();
        }
        this.level = (int)(Main.you.level*lm);

        evolutionStage = evoStage(level);
        this.Pokedex(type);
        Name = this.monsterName;


        assesStats();
        buildup =0;
        turnsSinceSuper=0;

        health = totalHealth;


        PrintMonster(root);


    }
    public void printStatBox(Group root){

        int BoxHeight = 125;
        int BoxWidth = 380;
        int boxY=20;

        Rectangle r = new Rectangle(880,boxY,BoxWidth,BoxHeight);
        r.setStroke(Color.GREY);
        r.setStrokeWidth(1);
        r.setFill(Color.WHITE);
        r.setArcHeight(50);
        r.setArcWidth(50);


        Text t = new Text();

        t.setX(895);
        t.setY(boxY+37);
        t.setFont(Font.font(30));
        if (!Name.equals(monsterName))
            t.setText(Name+" LV. "+level+" ("+monsterName+")");
        else
            t.setText(Name+" LV. "+level);

        Text detail = new Text();
        detail.setX(880+15);
        detail.setY(boxY+80);
        detail.setText("\nHealth: "+health+"/"+totalHealth+
                "\nBuildup: "+turnsSinceSuper+"/"+turnsForSuper+
                "\t"+exp+"/"+expNeeded+ " exp");

        Rectangle hBar = new Rectangle(895,boxY+50,350,30);
        hBar.setFill(Color.TRANSPARENT);
        hBar.setStroke(Color.BLACK);
        hBar.setStrokeWidth(1);
        hBar.setArcWidth(3);
        hBar.setArcHeight(3);
        double Percentage;

        if (totalHealth == 0) Percentage = 1000;
        else Percentage = 1000*health/totalHealth;



        Rectangle inBar= new Rectangle(895,boxY+50, Percentage*.35,30);

        if (Percentage>500) inBar.setFill(Color.GREEN);
        else if (Percentage>200) inBar.setFill(Color.ORANGE);
        else inBar.setFill(Color.RED);

        hBar.setArcWidth(3);
        hBar.setArcHeight(3);

        root.getChildren().addAll(r,inBar,hBar,t);
        root.getChildren().add(detail);

    }

    Bot(Group root){

        type= (int)(Math.random()*7)+1;
        double lm=0.0;

        while(lm<.3||lm>.6){
            lm=Math.random();
        }
        this.level = (int)(Main.you.level*lm);

        evolutionStage = evoStage(level);
        this.Pokedex(type);
        Name = this.monsterName;


        assesStats();
        buildup =0;
        turnsSinceSuper=0;

        health = totalHealth;


        PrintMonster(root);

    }


}
