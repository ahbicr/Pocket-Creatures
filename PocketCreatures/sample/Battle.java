package sample;

import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

class Battle {

    public static void asses(Monster one, Group root, Monster them, int a1){

        if (one.health<=0)
            one.Dies(root);
        else {
            one.printStatBox(root);
        }

    }

    static void GO(Monster a, Monster b, int a1, int b1, Group root){

        a.Turn();
        b.Turn();
        if (Main.instruct=true){

            Main.field.getChildren().remove(Help.help);
            Main.instruct=false;
        }

        boolean ablock=(a1==2);
        boolean bblock=(b1==2);

        if (ablock) {

            Circle Blocke = new Circle(400, 430, 150);

            Blocke.setFill(Color.color(0.5, 0.5, 0.75, 0.5));
            Blocke.setStroke(Color.WHITESMOKE);
            Blocke.setStrokeWidth(4);
            root.getChildren().add(Blocke);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), Blocke);
            fadeTransition.setFromValue(1);

            fadeTransition.setToValue(0);

            fadeTransition.setCycleCount(1);
            fadeTransition.play();
            

        }
        if (bblock){
            Circle Blocked = new Circle(1280-380,370,90);

            Blocked.setFill(Color.color(0.5,0.5,0.75,0.5));
            Blocked.setStroke(Color.WHITESMOKE);
            Blocked.setStrokeWidth(2);
            root.getChildren().add(Blocked);

            FadeTransition fadeTransitionn = new FadeTransition(Duration.seconds(3), Blocked);
            fadeTransitionn.setFromValue(1.0);
            fadeTransitionn.setToValue(0.0);
            fadeTransitionn.setCycleCount(1);
            fadeTransitionn.play();
        }

        if(a1==1 && !bblock){

            a.Attacks(b);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(.25), b.body);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);

            fadeTransition.setCycleCount(1);
            fadeTransition.play();

        }

        if(a1==3 && !bblock){
            a.SuperAttacks(b,root);

        }

        if (b1==1 && !ablock){
            b.Attacks(a);

            FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(.25), a.body);
            fadeTransition2.setFromValue(0);

            fadeTransition2.setToValue(1);

            fadeTransition2.setCycleCount(1);
            fadeTransition2.play();
        }

        if(b1==3 && !ablock){
            b.SuperAttacks(a,root);
        }

        asses(b, root, a, a1);
        asses(a, root, b, a1);
        a.PrintMonster(root);

        if(a.superOkay() && a.buildup==a.turnsForSuper) {
            Main.b.SuperButton(1100, 650, root);

        }

        if (a1==3) {
            a.buildup = 0;
            a.turnsSinceSuper = 0;

        }
        if(b1==3) {
            b.buildup = 0;
            b.turnsSinceSuper = 0;
        }




    }



}
