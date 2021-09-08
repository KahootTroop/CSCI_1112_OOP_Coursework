import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;

public class TicTacToe extends Application {
	Scene scene1, scene2;
	private Label turn = new Label("It is Player One's turn");
	private char currentTurn = 'X';
	private String[] names = new String[2];
	Cell[][] cell = new Cell[3][3];
	BorderPane border = new BorderPane();
	VBox box3 = new VBox(20);
	Button exit = new Button("Exit Game");
	@Override
	public void start(Stage stage) {
		stage.setTitle("TicTacToe");
		Label question1 = new Label("Enter name for player one: ");
		Label question2 = new Label("Enter name for player two: ");
		GridPane grid = new GridPane();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				grid.add(cell[i][j] = new Cell(), j, i);
			}
		}
		TextField answer1 = new TextField();
		TextField answer2 = new TextField();
		answer1.setAlignment(Pos.CENTER);
		answer1.setOnAction(e -> {
			answer2.requestFocus();
		});
		answer2.setAlignment(Pos.CENTER);
		answer2.setOnAction(e -> {
			names[0] = answer1.getText();
			names[1] = answer2.getText();
			turn.setText("It is " + names[0] + "'s turn");
			stage.setScene(scene2);
		});
		Button submit = new Button("Submit");
		exit.setOnAction(e -> {
			stage.close();
		});
		submit.setOnAction(e -> {
			names[0] = answer1.getText();
			names[1] = answer2.getText();
			turn.setText("It is " + names[0] + "'s turn");
			stage.setScene(scene2);
		});
		VBox box1 = new VBox(20);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().addAll(question1, answer1, question2, answer2, submit);
		border.setCenter(grid);
		border.setBottom(turn);
		border.setAlignment(turn, Pos.CENTER);
		scene1 = new Scene(box1, 500, 200);
		scene2 = new Scene(border, 500, 400);
		
		stage.setScene(scene1);
		stage.show();
	}
	public boolean isWon(char symbol) {
			for(int i = 0; i < 3; i++) {
				if(cell[i][0].getSymbol() == symbol && cell[i][1].getSymbol() == symbol && cell[i][2].getSymbol() == symbol) {
					return true;
				}
			}
			for(int i = 0; i < 3; i++) {
				if(cell[0][i].getSymbol() == symbol && cell[1][i].getSymbol() == symbol && cell[2][i].getSymbol() == symbol) {
					return true;
				}
			}
			if(cell[0][0].getSymbol() == symbol && cell[1][1].getSymbol() == symbol && cell[2][2].getSymbol() == symbol) {
				return true;
			}
			if(cell[0][2].getSymbol() == symbol && cell[1][1].getSymbol() == symbol && cell[2][0].getSymbol() == symbol) {
				return true;
			}
			else {
				return false;
			}
		}
		public boolean isDraw() {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(cell[i][j].getSymbol() == 'n') {
						return false;
					}
				}
			}
			return true;
		}
	public class Cell extends Pane {
		private char symbol = 'n';
		public Cell() {
			setStyle("-fx-border-color: black");
			this.setPrefSize(800, 800);
			this.setOnMouseClicked(e -> clickHandle());
		}
		private void clickHandle() {
			if(names[1] == null) {
				names[1] = "Player Two";
			}
			if(names[0] == null) {
				names[0] = "Player One";
			}
			if(symbol == 'n') {
				if(currentTurn != 'n') {
					fillCell(currentTurn);
				}
				if(isWon(currentTurn)) {
					if(currentTurn == 'X') {
						turn.setText("Game Over! " + names[0] + " Wins");
						border.setBottom(exit);
						border.setTop(turn);
						border.setAlignment(exit, Pos.CENTER);
						border.setAlignment(turn, Pos.CENTER);
						currentTurn = 'n';
					}
					else if(currentTurn == 'O'){
						turn.setText("Game Over! " + names[1] + " Wins");
						border.setBottom(exit);
						border.setTop(turn);
						border.setAlignment(exit, Pos.CENTER);
						border.setAlignment(turn, Pos.CENTER);
						currentTurn = 'n';
					}
				}
				else if(isDraw() == true) {
					turn.setText("Game Over! The game ended in a draw");
					border.setBottom(exit);
					border.setTop(turn);
					border.setAlignment(exit, Pos.CENTER);
					border.setAlignment(turn, Pos.CENTER);
					currentTurn = 'n';
				}
				if(!isWon(currentTurn) && !isDraw()){
					if(currentTurn == 'X') {
						currentTurn = 'O';
						turn.setText("It is " + names[1] + "'s turn");
					}
					else if(currentTurn == 'O'){
						currentTurn = 'X';
						turn.setText("It is " + names[0] + "'s turn");
					}
				}
			}
		}
		public char getSymbol() {
			return symbol;
		}
		public void setSymbol(char sym) {
			symbol = sym;
		}
		public void fillCell(char s) {
			if(currentTurn != 'n') {
				symbol = s;
				if(s == 'X') {
					Line one = new Line(10, 10, this.getWidth() - 10, this.getHeight() - 10);
					one.endXProperty().bind(this.widthProperty().subtract(10));
					one.endYProperty().bind(this.heightProperty().subtract(10));
					Line two = new Line(10, this.getHeight() - 10, this.getWidth() - 10, 10);
					two.startYProperty().bind(this.heightProperty().subtract(10));
					two.endXProperty().bind(this.widthProperty().subtract(10));
					this.getChildren().addAll(one, two);
				}
				if(s == 'O') {
					Ellipse circle = new Ellipse(this.getWidth() / 2 - 10, this.getHeight() / 2 - 10);
					circle.centerXProperty().bind(this.widthProperty().divide(2));
					circle.centerYProperty().bind(this.heightProperty().divide(2));
					circle.radiusXProperty().bind(this.widthProperty().divide(2).subtract(30));
					circle.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
					circle.setStroke(Color.RED);
					circle.setFill(Color.WHITE);
					this.getChildren().addAll(circle);
				}
			}
		}
	}
}
