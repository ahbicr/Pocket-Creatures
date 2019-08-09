package sample;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class StartScreen {

    int startLevel=8;





    StartScreen(Pane root, Group field) {
        Group startScren = new Group();
        int x= -100;
        int y=400;
        String str = "-fx-font:100px Tahoma;-fx-font-weight: bold;-fx-rotate: 75;";

        Rectangle normal = new Rectangle(0, 0, 182, 720);
        normal.setFill(Color.GRAY);
        Text n = new Text(x-20, y, "NORMAL");
        n.setStyle(str);

        Rectangle fire = new Rectangle(182, 0, 182, 720);
        fire.setFill(Color.TOMATO);
        Text f = new Text(246+x,y,"FIRE");
        f.setStyle(str);

        Rectangle water = new Rectangle(364, 0, 182, 720);
        water.setFill(Color.DARKTURQUOISE);
        Text w = new Text(370+x,y,"WATER");
        w.setStyle(str);

        Rectangle grass = new Rectangle(546, 0, 184, 720);
        grass.setFill(Color.DARKGREEN);
        Text g = new Text(560+x,y,"GRASS");
        g.setStyle(str);

        Rectangle flying = new Rectangle(730, 0, 183, 720);
        flying.setFill(Color.CADETBLUE);
        Text fl= new Text(735+x,y,"FLYING");
        fl.setStyle(str);

        Rectangle ground = new Rectangle(913, 0, 185, 720);
        ground.setFill(Color.SADDLEBROWN);
        Text gr = new Text(880+x,y,"GROUND");
        gr.setStyle(str);


        Rectangle electric = new Rectangle(1098, 0, 182, 720);
        electric.setFill(Color.GOLD);
        Text el = new Text(1050+x,y,"ELECTRIC");
        el.setStyle(str);



        EventHandler<MouseEvent> norm = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                root.getChildren().remove(startScren);
                Main.you= new Monster(1,startLevel,field);
                root.getChildren().add(field);

            }
        };
        normal.addEventFilter(MouseEvent.MOUSE_CLICKED, norm);
        n.addEventFilter(MouseEvent.MOUSE_CLICKED, norm);

        EventHandler<MouseEvent> fir = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                root.getChildren().remove(startScren);
                Main.you= new Monster(2,startLevel,field);
                root.getChildren().add(field);

            }
        };
        fire.addEventFilter(MouseEvent.MOUSE_CLICKED, fir);
        f.addEventFilter(MouseEvent.MOUSE_CLICKED, fir);

        EventHandler<MouseEvent> wat = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                root.getChildren().remove(startScren);
                Main.you= new Monster(3,startLevel,field);
                root.getChildren().add(field);

            }
        };
        water.addEventFilter(MouseEvent.MOUSE_CLICKED, wat);
        w.addEventFilter(MouseEvent.MOUSE_CLICKED, wat);

        EventHandler<MouseEvent> gras = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                root.getChildren().remove(startScren);
                Main.you= new Monster(4,startLevel,field);
                root.getChildren().add(field);

            }
        };
        grass.addEventFilter(MouseEvent.MOUSE_CLICKED, gras);
        g.addEventFilter(MouseEvent.MOUSE_CLICKED, gras);

        EventHandler<MouseEvent> fly = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                root.getChildren().remove(startScren);
                Main.you= new Monster(5,startLevel,field);
                root.getChildren().add(field);

            }
        };
        flying.addEventFilter(MouseEvent.MOUSE_CLICKED, fly);
        fl.addEventFilter(MouseEvent.MOUSE_CLICKED, fly);

        EventHandler<MouseEvent> grd = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                root.getChildren().remove(startScren);
                Main.you= new Monster(6,startLevel,field);
                root.getChildren().add(field);

            }
        };
        ground.addEventFilter(MouseEvent.MOUSE_CLICKED, grd);
        gr.addEventFilter(MouseEvent.MOUSE_CLICKED, grd);

        EventHandler<MouseEvent> ele = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                Main.you= new Monster(7,startLevel,field);
                root.getChildren().remove(startScren);
                root.getChildren().add(field);

            }
        };
        electric.addEventFilter(MouseEvent.MOUSE_CLICKED, ele);
        el.addEventFilter(MouseEvent.MOUSE_CLICKED, ele);


        // add button
        startScren.getChildren().addAll(normal, fire, water, grass, flying, ground, electric,n,f,w,g,fl,gr,el);
        root.getChildren().add(startScren);

    }

}
