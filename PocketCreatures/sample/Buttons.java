package sample;

import javafx.animation.FillTransition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

class Buttons {


    public void SuperButton(int centerX, int centerY, Group root) {
        Circle supper = new Circle();
        supper.setRadius(35 / 1.5);
        supper.setCenterX(centerX + 65);
        supper.setCenterY(centerY - 5);
        supper.setFill(Color.YELLOW);
        EventHandler<MouseEvent> superHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                Battle.GO(Main.you, Main.bot, 3, Main.bot.choosesMove(), root);
                root.getChildren().remove(supper);

            }
        };


        supper.addEventFilter(MouseEvent.MOUSE_CLICKED, superHandler);

        root.getChildren().add(supper);
    }





    Buttons(int centerX, int centerY, Group root) {

        int radius=35;
        Circle attack = new Circle();
        Circle block = new Circle();
        Circle supp = new Circle();

        attack.setCenterX(centerX);
        attack.setCenterY(centerY);
        attack.setRadius(radius);
        attack.setFill(Color.CRIMSON);
        Text a = new Text(centerX-22,centerY+20,"A");
        a.setFont(Font.font("Verdana", FontWeight.BOLD, 60));

        Text b = new Text(centerX+75,centerY-40,"B");
        b.setFont(Font.font("Verdana", FontWeight.BOLD, 60));


        block.setCenterX(centerX+100);
        block.setCenterY(centerY-60);
        block.setRadius(radius);
        block.setFill(Color.BLUE);

        supp.setRadius(radius/1.5);
        supp.setCenterX(centerX+65);
        supp.setCenterY(centerY-5);
        supp.setFill(Color.GRAY);



        EventHandler<MouseEvent> attackHandler = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent e) {
                Battle.GO(Main.you, Main.bot,1, Main.bot.choosesMove(), root);
                

                FillTransition fadeTransition = new FillTransition(Duration.seconds(.1), attack);
                fadeTransition.setFromValue(Color.DARKRED);
                fadeTransition.setToValue(Color.CRIMSON);
                fadeTransition.play();


            }
        };

        attack.addEventFilter(MouseEvent.MOUSE_CLICKED, attackHandler);
        a.addEventFilter(MouseEvent.MOUSE_CLICKED, attackHandler);

        EventHandler<MouseEvent> BlockHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                Battle.GO(Main.you, Main.bot,2, Main.bot.choosesMove(),root);

                FillTransition fadeTransition = new FillTransition(Duration.seconds(.1), block);
                fadeTransition.setFromValue(Color.DARKBLUE);
                fadeTransition.setToValue(Color.BLUE);
                fadeTransition.play();

            }
        };

        block.addEventFilter(MouseEvent.MOUSE_CLICKED, BlockHandler);
        b.addEventFilter(MouseEvent.MOUSE_CLICKED, BlockHandler);


        root.getChildren().addAll(attack,block,supp,a,b);


    }

}
