package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calculator of customs dues");
        primaryStage.setScene(new Scene(root, 390, 465))    ;

        primaryStage.show();


    }

    public static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            System.out.print("Incorrect conditions\nclean or incorrect text field of cost or value");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
