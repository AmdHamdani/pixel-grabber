package com.azure.application;

import java.io.File;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

	private String dir;
	private String typeValue;

	private TextField field;
	private TextArea text;
	private Button browse;
	private Button convert;
	private ComboBox type;
	private Group root;
	private FileChooser fileChooser;

	private ConvertToPixel grabber;

	private void initialize() {
		root = new Group();
		fileChooser = new FileChooser();

		ObservableList<String> options = FXCollections.observableArrayList("Alpha", "RGB");

		field = new TextField();
		field.setPrefWidth(210);
		field.setPromptText("Browse file...");
		field.setLayoutX(10);
		field.setLayoutY(10);
		field.setEditable(false);

		browse = new Button("Browse");
		browse.setLayoutX(232);
		browse.setLayoutY(10);

		text = new TextArea();
		text.setLayoutX(10);
		text.setLayoutY(50);
		text.setPrefSize(210, 180);
		text.setEditable(false);

		type = new ComboBox(options);
		type.setPrefSize(52, 10);
		type.setLayoutX(232);
		type.setLayoutY(50);

		convert = new Button("Convert");
		convert.setLayoutX(232);
		convert.setLayoutY(85);

		root.getChildren().addAll(field, browse, text, type, convert);
	}

	public void OnAction() {
		convert.setOnAction((final ActionEvent e) -> {
			try {
				grabber = new ConvertToPixel(dir, type.getSelectionModel().getSelectedItem().toString());
				text.setText(grabber.getPixelValue());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}

	@Override
	public void start(Stage stage) {
		initialize();

		Scene scene = new Scene(root, 290, 250);
		stage.setTitle("Pixel Grabber");
		stage.setScene(scene);
		stage.setResizable(false);

		browse.setOnAction((final ActionEvent e) -> {
			File file = fileChooser.showOpenDialog(stage);
			dir = file.getAbsolutePath();
			field.setText(dir);
		});

		OnAction();
		
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}