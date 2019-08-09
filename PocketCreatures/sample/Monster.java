package sample;

import javafx.animation.FillTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Monster {

    String monsterName,Name;
    int level;
    int type;
    int exp,expNeeded;
    int evolutionStage;
    int turnsSinceSuper, turnsForSuper;
    int buildup;
    int health,totalHealth;
    double pow = (3.0/5);
    int counter=0;

    Group box;
    String color;
    Circle base, middle, top;

    Group body= new Group();



    void Attacks(Monster enemy){
        double multiplier=multiplier(type,enemy.type);
        enemy.health -= (int)(multiplier*Math.pow(level,pow));

    }

    boolean superOkay(){
        return (turnsSinceSuper==turnsForSuper);
    }


    void Turn(){
        buildup++;
        if (!superOkay())
            turnsSinceSuper++;
    }

    void SuperAttacks(Monster enemy, Group root){
        String col= enemy.color;
        String attkcol="YELLOW";
        double dur=.75;
        enemy.health -= 2 * Math.pow(level,pow);
        if (enemy.evolutionStage>1){
            if (evolutionStage>2){
                FillTransition trans = new FillTransition(Duration.seconds(dur), enemy.top);
                trans.setFromValue(Color.valueOf(attkcol));
                trans.setToValue(Color.valueOf(col));
                trans.setCycleCount(2);
                trans.play();
            }
            FillTransition trans = new FillTransition(Duration.seconds(dur), enemy.middle);
            trans.setFromValue(Color.valueOf(attkcol));
            trans.setToValue(Color.valueOf(col));
            trans.setCycleCount(2);
            trans.play();

        }
        FillTransition trans = new FillTransition(Duration.seconds(dur), enemy.base);
        trans.setFromValue(Color.valueOf(attkcol));
        trans.setToValue(Color.valueOf(col));
        trans.setCycleCount(2);
        trans.play();
    }



    private double multiplier(int attacker, int attacked){

        double[][] multi ={
                {1,1,1,1,1,1,1},
                {1,1,0.8333333333,1.166666667,1,1,1},
                {1,1.166666667,1,0.8333333333,1,1.116666667,0.9},
                {1,0.8333333333,1.166666667,1,1,1,1},
                {1,1.033333333,0.8833333333,1,1,1,1},
                {1,0.9166666667,1,1.083333333,0.9166666667,1,1.166666667},
                {1,1,1.266666667,1,0.8333333333,0.8333333333,1},
        };

        return multi[attacker-1][attacked-1];

    }

    public void Dies(Group root){
            EndScreen cover = new EndScreen();
            Main.root.getChildren().add(Main.end);
    }


    void giveExp(int give, Group root){
        exp+=give;
        if (exp>=expNeeded)
            this.levelUp(root);

    }

    void assesStats(){
        turnsForSuper=(int) Math.pow(level,pow);

        expNeeded=level*19;
        totalHealth = 6 * (int) Math.pow(level,pow);
    }

    public void levelUp(Group root){
        exp=exp-expNeeded;
        level++;

        int totHelHol = totalHealth/2;

        assesStats();

        health+=(totalHealth-totHelHol);

        //this keeps your current health below your max health
        health= Math.min(health,totalHealth);

        root.getChildren().remove(body);

        PrintMonster(root);

        if (evoStage(level)>evolutionStage){

            evolutionStage++;

            boolean specialName = false;
            if (!Name.equals(monsterName)) specialName = true;

            this.Pokedex(type);

            if (!specialName)
                Name=monsterName;


        }


    }

    int evoStage(int level){
        if (level<10) return 1;
        if (level<20) return 2;
        return 3;
    }

    void Pokedex(int n){

        switch(n){
            case 1: //normal
                color="GRAY";
                if (evolutionStage == 1) monsterName = "NORMAL 1";
                else if (evolutionStage == 2) monsterName = "NORMAL 2";
                else if (evolutionStage == 3) monsterName = "NORMAL 3";

                break;


            case 2: //fire starter
                color="TOMATO";
                if (evolutionStage == 1) monsterName = "FIRE 1";
                else if (evolutionStage == 2) monsterName = "FIRE 2";
               else if (evolutionStage == 3) monsterName = "FIRE 3";

                break;

            case 3: //fire starter

                color="DARKTURQUOISE";
                if (evolutionStage == 1) monsterName = "WATER 1";
                else if (evolutionStage == 2) monsterName = "WATER 2";
                else if (evolutionStage == 3) monsterName = "WATER 3";

                break;

            case 4: //fire starter

                color="DARKGREEN";
                if (evolutionStage == 1) monsterName = "GRASS 1";
                else if (evolutionStage == 2) monsterName = "GRASS 2";
                else if (evolutionStage == 3) monsterName = "GRASS 3";

                break;

            case 5: //fire starter

                color="CADETBLUE";
                if (evolutionStage == 1) monsterName = "FLYING 1";
                else if (evolutionStage == 2) monsterName = "FLYING 2";
                else if (evolutionStage == 3) monsterName = "FLYING 3";

                break;

            case 6: //fire starter

                color="SADDLEBROWN";

                if (evolutionStage == 1) monsterName = "GROUND 1";
                else if (evolutionStage == 2) monsterName = "GROUND 2";
                else if (evolutionStage == 3) monsterName = "GROUND 3";

                break;

            case 7: //fire starter

                color ="GOLD";

                if (evolutionStage == 1) monsterName = "ELECTRIC 1";
                else if (evolutionStage == 2) monsterName = "ELECTRIC 2";
                else if (evolutionStage == 3) monsterName = "ELECTRIC 3";

                break;


        }

    }

    public void PrintMonster(Group root){
        Main.root.getChildren().remove(body);
        body = new Group();
        int x=350;
        int y=540;

        Circle base = new Circle(100);
        base.setCenterX(x);
        base.setCenterY(y);
        base.setFill(Paint.valueOf(color));
        body.getChildren().add(base);
        if (evolutionStage>1){
            Circle middle = new Circle(75);
            middle.setCenterX(x);
            middle.setCenterY(y-150);
            middle.setFill(Paint.valueOf(color));
            body.getChildren().add(middle);
            if (evolutionStage>2){
                Circle top = new Circle(50);
                top.setCenterX(x);
                top.setCenterY(y-262.5);
                top.setFill(Paint.valueOf(color));
                body.getChildren().add(top);
            }
        }
        printStatBox(root);
        root.getChildren().add(body);
    }

    public void printStatBox(Group root){
        root.getChildren().remove(box);
        box=new Group();

        int BoxHeight = 125;
        int BoxWidth = 380;
        int boxY=20;

        Rectangle r = new Rectangle(20,boxY,BoxWidth,BoxHeight);
        r.setStroke(Color.GREY);
        r.setStrokeWidth(1);
        r.setFill(Color.WHITE);
        r.setArcHeight(50);
        r.setArcWidth(50);


        Text t = new Text();

        t.setX(35);
        t.setY(boxY+37);
        t.setFont(Font.font(30));
        if (!Name.equals(monsterName))
            t.setText(Name+" LV. "+level+" ("+monsterName+")");
        else
            t.setText(Name+" LV. "+level);

        Text detail = new Text();
        detail.setX(35);
        detail.setY(boxY+80);
        detail.setText("\nHealth: "+health+"/"+totalHealth+
                       "\nBuildup: "+turnsSinceSuper+"/"+turnsForSuper+
                       "\t"+exp+"/"+expNeeded+ " exp");



        Rectangle hBar = new Rectangle(35,boxY+50,350,30);
        hBar.setFill(Color.TRANSPARENT);
        hBar.setStroke(Color.BLACK);
        hBar.setStrokeWidth(1);
        hBar.setArcWidth(3);
        hBar.setArcHeight(3);


        double Percentage = 1000*health/totalHealth;


        Rectangle inBar= new Rectangle(35,boxY+50, Percentage*.35,30);

        if (Percentage>500) inBar.setFill(Color.GREEN);
        else if (Percentage>200) inBar.setFill(Color.ORANGE);
        else inBar.setFill(Color.RED);
        hBar.setArcWidth(3);
        hBar.setArcHeight(3);

        Text n = new Text (35,200,Integer.toString(counter));
        n.setFont(Font.font("Verdana", FontWeight.BOLD, 60));
        box.getChildren().addAll(r,inBar,hBar,t,n);

        box.getChildren().add(detail);
        root.getChildren().add(box);



    }

    Monster(){ }


    Monster(int type, int level, Group field){


        this.level = level;

        evolutionStage = evoStage(level);
        this.type = type;
        this.Pokedex(type);
        Name = this.monsterName;

        exp=0;
        assesStats();

        health = totalHealth;

        Main.bot = new Bot(field);

        PrintMonster(field);


    }
}
