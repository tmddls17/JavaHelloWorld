import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class ReportCH0301 extends Application
{
	public static final int WINDOW_WIDTH = 300;
	public static final int WINDOW_HEIGHT = 200;
	public static final int CIRCLE_DIAMETER = 70;
	public static final int X_CIRCLE0 = 5;
	public static final int Y_CIRCLE0 = 5;
	public static void main(String[] args)
	{
		launch(args);
	}
	public void start(Stage primaryStage) throws Exception
{
	Group root = new Group();
	Scene scene = new Scene(root);
	Canvas canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
	GraphicsContext gc = canvas.getGraphicsContext2D();
	int xOffset = 0, yOffset = 0;
	for (int i = 1; i <= 5; i++)
	{//Draw one face:
	
		xOffset = 40 * (i-1);
		if(i % 2 == 0)
			yOffset = 60;
		else
			yOffset = 20;
		if(i == 1)
		{//Make face yellow
			gc.setStroke(Color.BLUE);
			gc.strokeOval(X_CIRCLE0 + xOffset, Y_CIRCLE0 + yOffset,CIRCLE_DIAMETER, CIRCLE_DIAMETER);
		}
		else if (i == 2)
		{//Make face green
			gc.setStroke(Color.YELLOW);
			gc.strokeOval(X_CIRCLE0 + xOffset, Y_CIRCLE0 + yOffset,CIRCLE_DIAMETER, CIRCLE_DIAMETER);
		}
		else if (i == 3)
		{//Make face gray
			gc.setStroke(Color.BLACK);
			gc.strokeOval(X_CIRCLE0 + xOffset, Y_CIRCLE0 + yOffset,CIRCLE_DIAMETER, CIRCLE_DIAMETER);
		}
		else if (i == 4)
		{//Make face gray
			gc.setStroke(Color.GREEN);
			gc.strokeOval(X_CIRCLE0 + xOffset, Y_CIRCLE0 + yOffset,CIRCLE_DIAMETER, CIRCLE_DIAMETER);
		}
		else if (i == 5)
		{//Make face gray
			gc.setStroke(Color.RED);
			gc.strokeOval(X_CIRCLE0 + xOffset, Y_CIRCLE0 + yOffset,CIRCLE_DIAMETER, CIRCLE_DIAMETER);
		}
	}
	root.getChildren().add(canvas);
	primaryStage.setTitle("Rings in JavaFX");
	primaryStage.setScene(scene);
	primaryStage.show();
	}
}