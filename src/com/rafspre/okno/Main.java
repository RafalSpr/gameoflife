/**
 * Prosta gra w ¿ycie z wykorzystaniem w¹tku
 * @author Rafcio
 */

package com.rafspre.okno;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		//	BorderPane root = new BorderPane();
			//Group group = new Group();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("FXMLokno.fxml"));
			StackPane stackPane = loader.load();
			Scene scene = new Scene(stackPane);
		//	Scene scene1 = new Scene(group,400,400);
		//	Line linia1 = new Line(1, 1,111, 111);
			
		//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Gra w ¿ycie");
		//	group.getChildren().addAll(linia1);
			primaryStage.setScene(scene);
		//	primaryStage.setScene(scene1);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
