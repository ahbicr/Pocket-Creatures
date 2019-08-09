package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
    static int down= 70;
    static Monster you;
    static Bot bot;
    static Buttons b;
    static Pane root = new Pane();
    static Group field = new Group();
    static Group end = new Group();
    static Group start = new Group();
    static int tok;
    static boolean instruct = true;

    @Override
    public void start(Stage stage) {
        LeaderBoard.acessfile();
        tok=LeaderBoard.tokens;
        PreStartScreen sttart = new PreStartScreen();

        root.getChildren().add(start);
        Scene scene = new Scene(root,1280,720, Color.LIGHTBLUE);
        stage.setScene(scene);

        stage.setTitle("Game");
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}