import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
public class CH04_MyMultipleFaces extends Application
{
	public static final int WINDOW_WIDTH = 650;
	public static final int WINDOW_HEIGHT = 400;
	public static final int FACE_DIAMETER = 50;
	public static final int X_FACE0 = 10;
	public static final int Y_FACE0 = 5;
	public static final int EYE_WIDTH = 5;
	public static final int EYE_HEIGHT = 10;
	public static final int X_RIGHT_EYE0 = 20;
	public static final int Y_RIGHT_EYE0 = 15;
	public static final int X_LEFT_EYE0 = 45;
	public static final int Y_LEFT_EYE0 = Y_RIGHT_EYE0;
	public static final int NOSE_DIAMETER = 5;
	public static final int X_NOSE0 = 32;
	public static final int Y_NOSE0 = 25;
	public static final int MOUTH_WIDTH = 30;
	public static final int MOUTH_HEIGHT0 = 0;
	public static final int X_MOUTH0 = 20;
	public static final int Y_MOUTH0 = 35;
	public static final int MOUTH_START_ANGLE = 180;
	public static final int MOUTH_EXTENT_ANGLE = 180;
	public static void main(String[] args)
	{
		launch(args);
	}
@Override
	public void start(Stage primaryStage) throws Exception
{
	Group root = new Group();
	Scene scene = new Scene(root);
	Canvas canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
	GraphicsContext gc = canvas.getGraphicsContext2D();
	int i, xOffset, yOffset; //Want i to exist after the loop ends
	for (i = 1; i <= 9; i++)
	{//Draw one face:
	
		xOffset = 50 * (i-1);
		yOffset = 30 * (i-1);
		//Draw face circle:
		if (i % 3 == 1)
		{//Make face yellow
			gc.setFill(Color.YELLOW);
			gc.fillOval(X_FACE0 + xOffset, Y_FACE0 + 30 * (i-1),
					FACE_DIAMETER, FACE_DIAMETER);
		}
		else if (i % 3 == 2)
		{//Make face green
			gc.setFill(Color.GREEN);
			gc.fillOval(X_FACE0 + xOffset, Y_FACE0 + 30 * (i-1),
					FACE_DIAMETER, FACE_DIAMETER);
		}
		else if (i % 3 == 0)
		{//Make face gray
			gc.setFill(Color.GRAY);
			gc.fillOval(X_FACE0 + xOffset, Y_FACE0 + 30 * (i-1),
					FACE_DIAMETER, FACE_DIAMETER);
		}
		gc.setStroke(Color.BLACK);
		gc.setFill(Color.BLACK);
		gc.strokeOval(X_FACE0 + xOffset, Y_FACE0 + yOffset,
				FACE_DIAMETER, FACE_DIAMETER);
		//Draw eyes:
		gc.setFill(Color.BLUE);
		gc.fillOval(X_RIGHT_EYE0 + xOffset, Y_RIGHT_EYE0 + yOffset,
				EYE_WIDTH, EYE_HEIGHT);
		gc.fillOval(X_LEFT_EYE0 + xOffset, Y_LEFT_EYE0 + yOffset,
				EYE_WIDTH, EYE_HEIGHT);
		//Draw nose:
		gc.setFill(Color.BLACK);
		gc.fillOval(X_NOSE0 + xOffset, Y_NOSE0 + yOffset,
				NOSE_DIAMETER, NOSE_DIAMETER);
		//Draw mouth:
		gc.setStroke(Color.RED);
		gc.setFill(Color.RED);
		gc.strokeArc(X_MOUTH0 + xOffset, Y_MOUTH0 + yOffset,
				MOUTH_WIDTH, MOUTH_HEIGHT0 + i ,
				MOUTH_START_ANGLE,
				MOUTH_EXTENT_ANGLE,
				ArcType.OPEN);
		gc.setFill(Color.BLACK);
		gc.setFont(Font.font("Times New Roman", 12));
		gc.fillText("Kiss!!.",
				X_FACE0 + xOffset + FACE_DIAMETER, Y_FACE0 +
				yOffset + 10);
	}//i is 5 when the previous loop ends
	xOffset = 50 * (i-1);
	yOffset = 30 * (i-1);
	//Draw kissing face:
	//Draw face circle:
	gc.setStroke(Color.BLACK);
	gc.setFill(Color.BLACK);
	gc.strokeOval(X_FACE0 + xOffset, Y_FACE0 + yOffset,
			FACE_DIAMETER, FACE_DIAMETER);
	//Draw eyes:
	gc.setFill(Color.BLUE);
	gc.fillOval(X_RIGHT_EYE0 + xOffset, Y_RIGHT_EYE0 + yOffset,
			EYE_WIDTH, EYE_HEIGHT);
	gc.fillOval(X_LEFT_EYE0 + xOffset, Y_LEFT_EYE0 + yOffset,
			EYE_WIDTH, EYE_HEIGHT);
	//Draw nose:
	gc.setFill(Color.BLACK);
	gc.fillOval(X_NOSE0 + xOffset, Y_NOSE0 + yOffset,
			NOSE_DIAMETER, NOSE_DIAMETER);
	//Draw mouth in shape of a kiss:
	gc.setFill(Color.RED);
	gc.fillOval(X_MOUTH0 + xOffset + 10, Y_MOUTH0 + yOffset,
			MOUTH_WIDTH - 20, MOUTH_WIDTH - 20);
	//Add text in Times New Roman, 12 point:
	gc.setFill(Color.BLACK);
	gc.setFont(Font.font("Times New Roman", 12));
	gc.fillText("Kiss, Kiss.",
			X_FACE0 + xOffset + FACE_DIAMETER, Y_FACE0 +
			yOffset);
	//Draw blushing face:
	i++;
	xOffset = 50 * (i-1);
	yOffset = 30 * (i-1);
	//Draw face circle:
	gc.setFill(Color.GRAY);
	gc.fillOval(X_FACE0 + xOffset, Y_FACE0 + yOffset,
			FACE_DIAMETER, FACE_DIAMETER);
	gc.setFill(Color.BLACK);
	gc.strokeOval(X_FACE0 + xOffset, Y_FACE0 + yOffset,
			FACE_DIAMETER, FACE_DIAMETER);
	//Draw eyes:
	gc.setFill(Color.BLUE);
	gc.fillOval(X_RIGHT_EYE0 + xOffset, Y_RIGHT_EYE0 + yOffset,
			EYE_WIDTH, EYE_HEIGHT);
	gc.fillOval(X_LEFT_EYE0 + xOffset, Y_LEFT_EYE0 + yOffset,
			EYE_WIDTH, EYE_HEIGHT);
	//Draw nose:
	gc.setFill(Color.BLACK);
	gc.fillOval(X_NOSE0 + xOffset, Y_NOSE0 + yOffset,
			NOSE_DIAMETER, NOSE_DIAMETER);
	//Draw mouth:
	gc.setStroke(Color.RED);
	gc.strokeArc(X_MOUTH0 + xOffset, Y_MOUTH0 + yOffset, MOUTH_WIDTH,
			MOUTH_HEIGHT0 + i,
			MOUTH_START_ANGLE, MOUTH_EXTENT_ANGLE, ArcType.OPEN);
	gc.setFill(Color.BLACK);
	//Add text in Courier New Font, 16 point:
	gc.setFont(Font.font("Courier New ", 16));
	gc.fillText("Tee Hee.",
			X_FACE0 + xOffset + FACE_DIAMETER, Y_FACE0 + yOffset);
	root.getChildren().add(canvas);
	primaryStage.setTitle("MultipleFaces in JavaFX");
	primaryStage.setScene(scene);
	primaryStage.show();
	}
}
