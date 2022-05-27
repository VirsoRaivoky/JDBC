package pkg;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.DriverManager;

public class Painel implements Initializable {

    @FXML
    private Button bt_edit;

    @FXML
    private Button bt_reg;

    @FXML
    private Button bt_remove;

    @FXML
    private TableColumn<Cidade, String> col_cep;

    @FXML
    private TableView<Cidade> col_cidades;

    @FXML
    private TableColumn<Cidade, Integer> col_id;

    @FXML
    private TableColumn<Cidade, String> col_nome;

    @FXML
    private TableColumn<Cidade, String> col_uf;
    
    @FXML
    private AnchorPane scenePane;

    @FXML
    private TextField tx_cep;

    @FXML
    private TextField tx_id;

    @FXML
    private TextField tx_nome;

    @FXML
    private TextField tx_uf;
    
    Stage stage;
    
    public void sair (ActionEvent event) {
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Sair");
    	alert.setHeaderText("Deseja Sair?");
    	
    if(alert.showAndWait().get() == ButtonType.OK) {
    	 	
    	stage = (Stage) scenePane.getScene().getWindow();
    	System.out.println("Você saiu do Aplicativo");
    	stage.close();
    	}
    }
    
    public ObservableList<Cidade> cidadeList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	showCidade();
    	/*
 
 
    	ResultSet rs = con.createStatement().executeQuery("select * from cidade");
    	while (rs.next()) {
    		oblist.add(new Cidade(rs.getInt("id"),rs.getString("nome"),rs.getString("cep"),rs.getString("uf")));
    	}
    	
    	}
    	catch (SQLException ex) {
    		Logger.getLogger(Painel.class.getName()).log(Level.SEVERE, null, ex);
    	}
    	col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	col_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	col_cep.setCellValueFactory(new PropertyValueFactory<>("cep"));
    	col_uf.setCellValueFactory(new PropertyValueFactory<>("uf"));
    	*/
    
    	}
   public Connection getConnection() {
	   Connection conn;
	   try {
		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC","root","info2k21");
		   return conn;
	   }catch(Exception ex) {
		   System.out.println("Erro: Não foi possivel conectar no sistema");
		   return null;
	   }
   }
   public ObservableList<Cidade> getCidadeList(){
	   Connection conn = getConnection();
	   String query = "SELECT * FROM cidade";
	   Statement st;
	   ResultSet rs;
	   
	   try {
		   st = conn.createStatement();
		   rs = st.executeQuery(query);
		   Cidade cidade;
		   while(rs.next()) {
			   cidade = new Cidade(rs.getInt("id"),rs.getString("nome"),rs.getString("cep"),rs.getString("uf"));
			   cidadeList.add(cidade);
		   }
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }
	   return cidadeList;
   }
   
   public void showCidade() {
	   ObservableList<Cidade> list = getCidadeList();
	   
	col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
   	col_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
   	col_cep.setCellValueFactory(new PropertyValueFactory<>("cep"));
   	col_uf.setCellValueFactory(new PropertyValueFactory<>("uf"));
   	
   	col_cidades.setItems(list);
   }
}
