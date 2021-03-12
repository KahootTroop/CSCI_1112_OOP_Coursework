import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import java.awt.event.*;

public class Exercise_15_Listeners extends Application {
	private CirclePane circle = new CirclePane();
	public double height = 300;
	public double width = 300; 
	@Override
	public void start(Stage primaryStage) {
		circle.setX(width / 2);
		circle.setY(height / 2);
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.BOTTOM_CENTER);
		Button btUp = new Button("Up");
		btUp.setFocusTraversable(false);
		btUp.setOnAction(new UpHandler());
		Button btDown = new Button("Down");
		btDown.setFocusTraversable(false);
		btDown.setOnAction(new DownHandler());
		Button btLeft = new Button("Left");
		btLeft.setFocusTraversable(false);
		btLeft.setOnAction(new LeftHandler());
		Button btRight = new Button("Right");
		btRight.setFocusTraversable(false);
		btRight.setOnAction(new RightHandler());
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(circle);
		borderPane.setBottom(hBox);
		circle.setOnKeyPressed(k -> {
			switch(k.getCode()) {
				case UP: 
					circle.up();
					circle.requestFocus();
					break;
				case DOWN: 
					circle.down(); 
					circle.requestFocus();
					break;
				case RIGHT: 
					circle.right();
					circle.requestFocus();
					break;
				case LEFT: 
					circle.left();
					circle.requestFocus();
					break;
			}
		});
		BorderPane.setAlignment(hBox, Pos.CENTER);
		hBox.getChildren().addAll(btUp, btDown, btLeft, btRight);
		Scene scene = new Scene(borderPane, 300, 300);
		primaryStage.setTitle("Ball");
		primaryStage.setScene(scene);
		primaryStage.show();
		circle.requestFocus();
		borderPane.widthProperty().addListener(ov -> 
			width = borderPane.getWidth()
		);
		borderPane.heightProperty().addListener(ov ->
			height = borderPane.getHeight()
		);
	}
	class UpHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			circle.up();
		}
	}
	class DownHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			circle.down();
		}
	}
	class RightHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			circle.right();
		}
	}
	class LeftHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			circle.left();
		}
	}
	class CirclePane extends Pane {
		private Circle circle = new Circle(50);
		
		public CirclePane() {
			getChildren().add(circle);
			circle.setStroke(Color.BLACK);
			circle.setFill(Color.WHITE);
			//Pane.setAlignment(circle, Pos.CENTER);
		}
		
		public void up() {
			if(circle.getTranslateY() - circle.getRadius() - 2 < 0) return;
			double upY = circle.getTranslateY() - 2;
			circle.setTranslateY(upY);
		}
		
		public void down() {
			if(circle.getTranslateY() + circle.getRadius() + 2 > height) return;
			double upY = circle.getTranslateY() + 2;
			circle.setTranslateY(upY);
		}
		
		public void right() {
			if(circle.getTranslateX() + circle.getRadius() + 2 > width) return;
			double upY = circle.getTranslateX() + 2;
			circle.setTranslateX(upY);
		}
		
		public void left() {
			if(circle.getTranslateX() - circle.getRadius() - 2 < 0) return;
			double upY = circle.getTranslateX() - 2;
			circle.setTranslateX(upY);
		}
		public void setX(double x) {
			circle.setTranslateX(x);
		}
		public void setY(double y) {
			circle.setTranslateY(y);
		} 
	}
}
