package chapter4.exercise10;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MyWebView extends Application {
    public static final String HOME_LOCATION = "http://google.com";

    @Override
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 800, 800);

        stage.setScene(scene);
        stage.setTitle(this.getClass().getSimpleName());

        Button back = new Button("Back");
        back.setMinWidth(80);
        TextField urlBar = new TextField(HOME_LOCATION);
        urlBar.minWidthProperty().bind(scene.widthProperty().subtract(back.widthProperty()));

        HBox topBar = new HBox();
        topBar.getChildren().addAll(back, urlBar);
        pane.setTop(topBar);

        WebView browser = new WebView();
        browser.minWidthProperty().bind(scene.widthProperty());
        browser.minHeightProperty().bind(scene.heightProperty());
        pane.setBottom(browser);

        WebEngine engine = browser.getEngine();
        engine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
                    @Override
                    public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
                        if ( newState == State.SUCCEEDED) {
                            stage.setTitle(engine.getLocation());
                            urlBar.setText(engine.getLocation());
                        }
                    }
                });
        engine.load(HOME_LOCATION);

        back.setOnAction(event -> {
            if ( engine.getHistory().getCurrentIndex() != 0 ) {
                engine.getHistory().go(-1);
            }
        });
        urlBar.setOnAction(event -> {
            engine.load(urlBar.getText());
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
