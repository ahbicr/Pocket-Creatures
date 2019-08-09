package sample;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PreStartScreen {

    PreStartScreen(){
        Group Start = new Group();
        Rectangle R = new Rectangle(1280,720);
        R.setFill(Color.LIGHTBLUE);


        Pane pane = new Pane();
        pane.setPrefSize(1280, 720);
        Font font = Font.font(100);
        String pocket ="POCKET";
        String welcome = "CREATURES";
        double rotation = -102.5;
       double offset = pane.getPrefWidth()/2 ;
        double radius = 2000;
        double x;
        double y;

        // Loop
        for (int i = 0; i < welcome.length(); i++) {
            x = offset + Math.cos(Math.toRadians(rotation)) * radius;
            y = offset+1750+ Math.sin(Math.toRadians(rotation)) * radius;
            Text text = new Text(x, y, welcome.substring(i,i+1));

            text.setFont(font);
            //text.setRotate(rotation);
            pane.getChildren().add(text);
            rotation += 2.9;
        }


        rotation =-125;

        font = Font.font("Verdana", FontWeight.BOLD, 200);
        for (int j = 0; j < pocket.length(); j++) {
            x = offset + Math.cos(Math.toRadians(rotation)) * 1000;
            y = offset +100+ Math.sin(Math.toRadians(rotation)) * 500;
            Text ppp = new Text(x, y, pocket.substring(j,j+1));

            ppp.setFont(font);
            //text.setRotate(rotation);
            pane.getChildren().add(ppp);
            rotation += 12.5;
        }


        Group r = new Group();
        Rectangle restart = new Rectangle(176,500,400,120);
        restart.setArcWidth(40);
        restart.setArcHeight(30);
        restart.setFill(Color.RED);
        restart.setStrokeWidth(3);
        restart.setStroke(Color.BLACK);
        Text RE = new Text(190,580,"LEADERBOARDS");
        RE.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        RE.setFill(Color.WHITE);
        RE.setStroke(Color.BLACK);
        r.getChildren().addAll(restart,RE);


        Group c = new Group();
        Rectangle continu = new Rectangle(704,500,400,120);
        continu.setArcWidth(40);
        continu.setArcHeight(30);
        continu.setFill(Color.BLUE);
        continu.setStrokeWidth(3);
        continu.setStroke(Color.BLACK);
        Text CU = new Text(810,580,"START");
        CU.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        CU.setFill(Color.WHITE);
        CU.setStroke(Color.BLACK);
        c.getChildren().addAll(continu,CU);



        EventHandler<MouseEvent> Startt = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                Main.root.getChildren().remove(Main.start);

                Rectangle r = new Rectangle(0,480,1280,240);
                r.setFill(Color.FORESTGREEN);
                Main.field.getChildren().add(r);
                if (Main.instruct=true){
                    Help rip = new Help();
                    Main.field.getChildren().add(Help.help);
                }
                Plat p = new Plat(150,625,10, Main.field);
                Plat ep = new Plat(780,400+ Main.down,7, Main.field);


                Main.you=new Monster();
                Main.you.level=8;

                Main.b = new Buttons(1100,650, Main.field);


                StartScreen riip = new StartScreen(Main.root, Main.field);



            }
        };
        c.addEventFilter(MouseEvent.MOUSE_CLICKED, Startt);



        EventHandler<MouseEvent> Lead = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                Main.root.getChildren().remove(Main.start);
                LeaderBoard leader = new LeaderBoard();
                Main.root.getChildren().add(LeaderBoard.Lead);


            }
        };
        r.addEventFilter(MouseEvent.MOUSE_CLICKED, Lead);

        Main.start.getChildren().addAll(R,pane,c,r);

    }

}
