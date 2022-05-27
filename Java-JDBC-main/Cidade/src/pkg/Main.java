package pkg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;


public class Main extends Application {

	@Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Painel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest(event -> sair(stage));
    }
	

    public static void main(String[] args) {
        launch();
    }


	Stage stage;

	public void sair (Stage stage) {
	
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Sair");
		alert.setHeaderText("Deseja sair?");
		
	if(alert.showAndWait().get() == ButtonType.OK) {
	 	
	
		System.out.println("Você saiu");
		stage.close();
	}
}
	
}