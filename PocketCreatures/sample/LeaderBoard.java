package sample;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.util.Scanner;


public class LeaderBoard {


    static String First;
    static String Second;
    static String Third;
    static int tokens;
    static Group Lead = new Group();

    static void acessfile(){
        try {

            File thhe = new File(" ");
            String path = thhe.getAbsolutePath();
            System.out.println(path);
            int lastDash = path.lastIndexOf('/');
            path = path.substring(0,lastDash)+"/sample/stats.txt";
            File file = new File(path);

            Scanner input = new Scanner(file);

            First=input.nextLine();
            Second=input.nextLine();
            Third=input.nextLine();
            tokens=input.nextInt();
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    LeaderBoard() {
        acessfile();

        Group cross = new Group();
        Rectangle ex = new Rectangle(40,20,75,80);
        ex.setFill(Color.TRANSPARENT);
        Text t = new Text(40,100,"X");
        t.setFont(Font.font(110));
        cross.getChildren().addAll(ex,t);
        EventHandler<MouseEvent> superHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                Main.root.getChildren().remove(Lead);
                Main.root.getChildren().add(Main.start);

            }
        };


        cross.addEventFilter(MouseEvent.MOUSE_CLICKED, superHandler);


        int one = Integer.valueOf(First.substring(0,First.indexOf(',')));
        int two = Integer.valueOf(Second.substring(0,Second.indexOf(',')));
        int three = Integer.valueOf(Third.substring(0,Third.indexOf(',')));
        String fir =First.substring(First.indexOf(',')+1);
        String sec = Second.substring(Second.indexOf(',')+1);
        String thir = Third.substring(Third.indexOf(',')+1);
        Text name = new Text(200,300,fir+"\n"+sec+"\n"+thir);
        name.setFont(Font.font(100));
        name.setFill(Color.BLACK);
        name.setStroke(Color.WHITE);
        Text score = new Text(1000,300,one+"\n"+two+"\n"+three);
        score.setFont(Font.font(100));
        score.setFill(Color.BLACK);
        score.setStroke(Color.WHITE);

        Lead.getChildren().addAll(name,score,cross);

    }
}
