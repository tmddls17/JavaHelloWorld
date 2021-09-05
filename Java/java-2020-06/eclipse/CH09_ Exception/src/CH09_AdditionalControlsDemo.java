import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Simple demonstration of some additional JavaFX UI controls.
 */
public class CH09_AdditionalControlsDemo extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
// Demonstrate radio buttons
		root.getChildren().add(new Label("Select First Day - Radio Button"));
		ToggleGroup toggleDay = new ToggleGroup();
		RadioButton rbMon = new RadioButton("Mon 1");
		rbMon.setToggleGroup(toggleDay);
		rbMon.setSelected(true);
		RadioButton rbTue = new RadioButton("Tue 1");
		rbTue.setToggleGroup(toggleDay);
		RadioButton rbWed = new RadioButton("Wed 1");
		rbWed.setToggleGroup(toggleDay);
		RadioButton rbThu = new RadioButton("Thu 1");
		rbThu.setToggleGroup(toggleDay);
		root.getChildren().add(rbMon);
		root.getChildren().add(rbTue);
		root.getChildren().add(rbWed);
		root.getChildren().add(rbThu);
// Demonstrate checkboxes
		root.getChildren().add(new Label("Select Second Day - Checkbox"));
		CheckBox cbMon = new CheckBox("Mon 2");
		CheckBox cbTue = new CheckBox("Tue 2");
		CheckBox cbWed = new CheckBox("Wed 2");
		CheckBox cbThu = new CheckBox("Thu 2");
		root.getChildren().add(cbMon);
		root.getChildren().add(cbTue);
		root.getChildren().add(cbWed);
		root.getChildren().add(cbThu);
//Demonstrate Spinner with integer values from 1-4
		root.getChildren().add(new Label("Select Third Day - Spinner with integer(1~4)"));
		Spinner<Integer> spinnerQuantity = new Spinner();
		final int defaultValue = 1;
//Value factory.
		SpinnerValueFactory<Integer> quantityFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4,
				defaultValue);
		spinnerQuantity.setValueFactory(quantityFactory);
		root.getChildren().add(spinnerQuantity);
//Demonstrate ChoiceBox with delivery options
		root.getChildren().add(new Label("Select Fourth Day - ChoiceBox"));
		ChoiceBox<String> cbDays = new ChoiceBox<String>(
				FXCollections.observableArrayList("Mon 4", "Tue 4", "Wed 4", "Thu 4"));
		root.getChildren().add(cbDays);
//Button to display selections
		Button btnSelections = new Button("Get Selections");
//Set the event handler when the button is clicked
		btnSelections.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("First Day - Radio Button");
				System.out.println("Mon 1: " + rbMon.isSelected());
				System.out.println("Tue 1: " + rbTue.isSelected());
				System.out.println("Wed 1: " + rbWed.isSelected());
				System.out.println("Thu 1: " + rbThu.isSelected() + "\n");
				System.out.println("Second Day - Checkbox");
				System.out.println("Mon 2: " + cbMon.isSelected());
				System.out.println("Tue 2: " + cbTue.isSelected());
				System.out.println("Wed 2: " + cbWed.isSelected());
				System.out.println("Thu 2: " + cbThu.isSelected() + "\n");
				System.out.println("Third Day - Spinner with Integer");
				System.out.println("Third Day: " + spinnerQuantity.getValue() + "\n");
				System.out.println("Fourth Day - ChoiceBox");
				System.out.println("Fourth Day: " + cbDays.getValue());
			}
		});
		root.getChildren().add(btnSelections);
		Scene scene = new Scene(root, 350, 300);
		primaryStage.setTitle("Additional Controls Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}