package sample;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


class EndScreen{


    static void NextRound(){

        Rectangle rr = new Rectangle(1280, 720);
        rr.setFill(Color.LIGHTBLUE);
        Main.field.getChildren().add(rr);
        Rectangle r = new Rectangle(0, 480, 1280, 240);
        r.setFill(Color.FORESTGREEN);
        Main.field.getChildren().add(r);

        Plat p = new Plat(150, 625, 10, Main.field);
        Plat ep = new Plat(780, 400 + Main.down, 7, Main.field);

        Main.b = new Buttons(1100, 650, Main.field);
        StartScreen nuevo = new StartScreen(Main.root, Main.field);
    }


    EndScreen() {
        Main.end = new Group();
        Rectangle Back = new Rectangle(1280,210);
        Back.setFill(Color.LIGHTBLUE);
        Back.setOpacity(.85);
        Rectangle Dim = new Rectangle(1280,720);
        Dim.setFill(Color.WHITE);
        Dim.setOpacity(.4);


        int centerX=1100;
        int centerY = 650;
        int radius=35;
        Circle attack = new Circle();
        Circle block = new Circle();
        Circle supp = new Circle();

        attack.setCenterX(centerX);
        attack.setCenterY(centerY);
        attack.setRadius(radius);
        attack.setFill(Color.GRAY);


        block.setCenterX(centerX+100);
        block.setCenterY(centerY-60);
        block.setRadius(radius);
        block.setFill(Color.GRAY);

        supp.setRadius(radius/1.5);
        supp.setCenterX(centerX+65);
        supp.setCenterY(centerY-5);
        supp.setFill(Color.GRAY);


        Text t = new Text(65,300,"YOU LOSE");
        t.setFont(Font.font(225));
        t.setFill(Color.BLACK);
        t.setStroke(Color.WHITE);


        Group r = new Group();
        Rectangle restart = new Rectangle(176,350,400,120);
        restart.setArcWidth(40);
        restart.setArcHeight(30);
        restart.setFill(Color.RED);
        restart.setStrokeWidth(3);
        restart.setStroke(Color.BLACK);
        Text RE = new Text(190,430,"RESTART");
        RE.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        RE.setFill(Color.WHITE);
        RE.setStroke(Color.BLACK);
        r.getChildren().addAll(restart,RE);

        Text count = new Text(10,590,"Your Score: "+ Main.you.counter+
                "\nYour Tokens: "+Main.tok+"\nHigh Score: 42");
        count.setFont(Font.font(50));
        Group c = new Group();
        if (Main.tok>0) {
            Rectangle continu = new Rectangle(704, 350, 400, 120);
            continu.setArcWidth(40);
            continu.setArcHeight(30);
            continu.setFill(Color.BLUE);
            continu.setStrokeWidth(3);
            continu.setStroke(Color.BLACK);
            Text CU = new Text(710, 430, "CONTINUE");
            CU.setFont(Font.font("Verdana", FontWeight.BOLD, 65));
            CU.setFill(Color.WHITE);
            CU.setStroke(Color.BLACK);
            Text note = new Text(860,450,"(ONE TOKEN)");
            note.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
            note.setFill(Color.WHITE);
            note.setStroke(Color.BLACK);
            c.getChildren().addAll(continu, CU,note);

            EventHandler<MouseEvent> Conin = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    Main.root.getChildren().remove(Main.end);
                    Main.you.health = Main.you.totalHealth;
                    Main.you.printStatBox(Main.field);
                    Main.tok -= 1;
                    Main.root.getChildren().remove(Main.you.body);
                }
            };
            c.addEventFilter(MouseEvent.MOUSE_CLICKED, Conin);
        }else{
            Rectangle continu = new Rectangle(704, 350, 400, 120);
            continu.setArcWidth(40);
            continu.setArcHeight(30);
            continu.setFill(Color.GRAY);
            continu.setStrokeWidth(3);
            continu.setStroke(Color.BLACK);
            Text CU = new Text(710, 430, "CONTINUE");
            CU.setFont(Font.font("Verdana", FontWeight.BOLD, 65));
            CU.setFill(Color.BLUE);
            CU.setStroke(Color.WHITE);
            c.getChildren().addAll(continu, CU);


        }

        EventHandler<MouseEvent> Res = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Main.root.getChildren().remove(Main.end);
                Main.root.getChildren().remove(Main.field);
                NextRound();
            }
        };
        r.addEventFilter(MouseEvent.MOUSE_CLICKED, Res);

        //this one adds the stuff to blur the background
        Main.end.getChildren().addAll(Back,attack,block,supp,Dim);

        //this one adds the new UI
        Main.end.getChildren().addAll(t,r,c,count);

    }

}