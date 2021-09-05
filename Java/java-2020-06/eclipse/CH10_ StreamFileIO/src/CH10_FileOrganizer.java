import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class CH10_FileOrganizer extends Application {
	private TextField fileNameField;
	private TextField integerField;
	private ObjectInputStream inputStream = null;
	private ObjectOutputStream outputStream = null;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final int WIDTH = 400;
		final int HEIGHT = 300;
		final int NUMBER_OF_PIXELS = 300;
		FlowPane root = new FlowPane();
		Button showButton = new Button("Multiply");
		root.getChildren().add(showButton);
		showButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				connectToInputFile();
				connectToOutputFile();
				multiply();
				closeFiles();
				
			}
		});
		Button removeButton = new Button("Reset");
		root.getChildren().add(removeButton);
		removeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				resetFields();
			}
		});

		fileNameField = new TextField("Enter output file name here.");
		fileNameField.setPrefWidth(NUMBER_OF_PIXELS);
		root.getChildren().add(fileNameField);
		integerField = new TextField("Enter Integer Number");
		integerField.setPrefWidth(NUMBER_OF_PIXELS);
		root.getChildren().add(integerField);
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		primaryStage.setTitle("File Organizer");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void resetFields() {
		fileNameField.setText("Enter output file name here.");
		integerField.setText("Enter Integer Number");
	}

	private void showResult() {
		Scanner fileInput = null;
		String fileName = fileNameField.getText();
		File fileObject = new File(fileName);
		
		if (!fileObject.exists())
			integerField.setText("No such file");
		else if (!fileObject.canRead())
			integerField.setText("That file is not readable.");
		else {
			try {
				fileInput = new Scanner(fileObject);
			} catch (FileNotFoundException e) {
				integerField.setText("Error opening the file " + fileName);
			}
			String firstLine = fileInput.nextLine();
			integerField.setText(firstLine);
			fileInput.close();
		}
	}

	public void connectToOutputFile() {
		String outputFileName = "C:\\Users\\82109\\Desktop\\자바\\".concat(fileNameField.getText());
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(outputFileName));
		} catch (IOException e) {
			System.out.println("Error opening output file " + outputFileName);
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public void connectToInputFile() {
		String inputFileName = "C:\\Users\\82109\\Desktop\\자바\\input2.txt";
		try {
			inputStream = new ObjectInputStream(new FileInputStream(inputFileName));
		} catch (FileNotFoundException e) {
			System.out.println("File " + inputFileName + " not found.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Error opening input file " + inputFileName);
			System.exit(0);
		}
	}

	public void multiply() {
		int next;
		int num;
		try {
			while (true) {
				num = Integer.parseInt(integerField.getText());
				next = inputStream.readInt();
				outputStream.writeInt(num * next);
			}
		} catch (EOFException e) {
//Do nothing. This just ends the loop.
		} catch (IOException e) {
			System.out.println("Error: reading or writing files.");
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public void closeFiles() {
		try {
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Error closing files " + e.getMessage());
			System.exit(0);
		}
	}
}