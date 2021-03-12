import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Exercise_15_Animation extends Application {
    @Override
    public void start(Stage stage) {
        Polygon pentagon = new Polygon();
        Rectangle rectangle = new Rectangle (150, 130, 25, 50);
        rectangle.setFill(Color.ORANGE);
        pentagon.getPoints().addAll(
                250.0, 130.0,
                330.0, 200.0,
                300.0, 300.0,
                200.0, 300.0,
                170.0, 200.0
        );
        pentagon.setFill(Color.CORNFLOWERBLUE);
        Polygon inside = new Polygon();
        inside.getPoints().addAll(
                250.0, 132.0,
                328.0, 200.0,
                299.0, 298.0,
                201.0, 298.0,
                172.0, 200.0
        );
        inside.setFill(Color.WHITE);
        Group pent = new Group(pentagon, inside, rectangle);
        Scene scene = new Scene(pent, 500, 500);
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(pentagon);
        pt.setNode(rectangle);
        pt.setOrientation(
        PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();
        FadeTransition ft = new FadeTransition(Duration.millis(3000), rectangle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.play();
        scene.setOnMousePressed(e -> {
            ft.pause();
            pt.pause();
        });
        scene.setOnMouseReleased(e -> {
            ft.play();
            pt.play();
        });

        stage.setTitle("Pentagon Outline");

        stage.setScene(scene);

        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}