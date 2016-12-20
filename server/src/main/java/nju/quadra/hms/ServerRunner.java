package nju.quadra.hms;

import javafx.application.Application;
import javafx.stage.Stage;
import nju.quadra.hms.ui.serverUI.ServerMainView;

/**
 * Created by adn55 on 2016/11/22.
 */
public class ServerRunner extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = new ServerMainView();
        primaryStage.show();
    }

}
