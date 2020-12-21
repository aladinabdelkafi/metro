package metro.viewController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import metro.DAO.LigneDAO;
import metro.DAO.Zonne_DAO;
import metro.model.Ligne;
import metro.model.Zonne;

public class MenuGestionZone {

    @FXML
    private BorderPane root;

    @FXML
    private JFXTextField numzone;

    @FXML
    private Label label;

    @FXML
    private JFXTextField nomzone;

    @FXML
    private JFXTextField tarifzone;
    @FXML
    private TableColumn<Zonne, Integer> cl_numerzone;

    @FXML
    private TableColumn<Zonne,String> cl_nomzone;

    @FXML
    private TableColumn<Zonne, String> cl_tarf;

    @FXML
    private TableView<Zonne> ZoneTableView;

    Zonne_DAO zoneDAO = new Zonne_DAO();
	ObservableList<Zonne> zoneList = FXCollections.observableArrayList(zoneDAO.findAll_Zonne());
	
	public void vider(){
		nomzone.setText("");
		numzone.setText("");
		tarifzone.setText("");

	}

	
	public void remplirr(Zonne z){
		nomzone.setText(z.getNom_zone()+"");
		numzone.setText(z.getNum_zonne()+"");
		tarifzone.setText(z.getTarif()+"");

	}

    @FXML
    void affecterAuField(MouseEvent event) {
  	  Zonne zone=ZoneTableView.getSelectionModel().getSelectedItem();
  	    	remplirr(zone);

    }
	
    void ExtractData() {
    	cl_nomzone.setCellValueFactory(new PropertyValueFactory<Zonne,String >("Nom_zone"));
    	cl_numerzone.setCellValueFactory(new PropertyValueFactory<Zonne, Integer>("Num_zonne"));
    	cl_tarf.setCellValueFactory(new PropertyValueFactory<Zonne, String>("tarif"));
    	ZoneTableView.setItems(zoneList);

    }
    
	@FXML
    void initialize(){
		ExtractData();

		
	}
	
    @FXML
    void modifier_Click(ActionEvent event) {
    	Zonne z = new Zonne(Integer.parseInt(this.numzone.getText()),this.nomzone.getText(),Float.parseFloat(this.tarifzone.getText()));
		zoneDAO.update_Zonne(z);
		zoneList.clear();
		zoneList = FXCollections.observableArrayList(zoneDAO.findAll_Zonne());
		ExtractData();
		vider();

    }

	 
}
