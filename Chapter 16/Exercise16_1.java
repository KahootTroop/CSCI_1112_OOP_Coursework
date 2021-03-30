import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;     
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;    
public class Exercise16_1 extends Application {
	Text text = new Text(50, 50, "Programming is fun");
	BorderPane getPane() {
		double width = 600.0;
		double height = 200.0;
		BorderPane pane = new BorderPane();
		HBox forColorButtons = new HBox(50);
		HBox forMovementButtons = new HBox(50);
		Pane textPane = new Pane();
		Button right = new Button("->");
		Button left = new Button("<-");
		forMovementButtons.getChildren().addAll(left, right);
		forMovementButtons.setAlignment(Pos.BOTTOM_CENTER);
		textPane.getChildren().add(text);
		pane.setCenter(textPane);
		forMovementButtons.setStyle("-fx-border-width: 3px; -fx-border-color: black");
		forColorButtons.setStyle("-fx-border-width: 3px; -fx-border-color: black");
		RadioButton bRed = new RadioButton("Red");
		RadioButton bYellow = new RadioButton("Yellow");
		RadioButton bBlack = new RadioButton("Black");
		RadioButton bOrange = new RadioButton("Orange");
		RadioButton bGreen = new RadioButton("Green");
		forColorButtons.getChildren().addAll(bRed, bYellow, bBlack, bOrange, bGreen);
		pane.setTop(forColorButtons);
		pane.setBottom(forMovementButtons);
		
		ToggleGroup group = new ToggleGroup();
		bRed.setToggleGroup(group);
		bYellow.setToggleGroup(group);
		bBlack.setToggleGroup(group);
		bOrange.setToggleGroup(group);
		bGreen.setToggleGroup(group);
		bRed.setOnAction(e -> {
			if(bRed.isSelected()) {
				text.setFill(Color.RED);
			}
		});
		bYellow.setOnAction(e -> {
			if(bYellow.isSelected()) {
				text.setFill(Color.YELLOW);
			}
		});
		bBlack.setOnAction(e -> {
			if(bBlack.isSelected()) {
				text.setFill(Color.BLACK);
			}
		});
		bOrange.setOnAction(e -> {
			if(bOrange.isSelected()) {
				text.setFill(Color.ORANGE);
			}
		});
		bGreen.setOnAction(e -> {
			if(bGreen.isSelected()) {
				text.setFill(Color.GREEN);
			}
		});
		left.setOnAction(e -> {
			if(text.getX() - 10 <= 0) {
				return;
			}
			else {
				text.setX(text.getX() - 10);
			}
		});
		right.setOnAction(e -> {
			if(text.getX() + 130 >= pane.getWidth()) {
				return;
			}
			else {
				text.setX(text.getX() + 10);
			}
		});
		return pane;
	}
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(getPane(), 600, 200);
		primaryStage.setTitle("ButtonControls");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}