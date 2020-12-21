package metro.viewController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import metro.Main;
import metro.DAO.Guichet_DAO;
import metro.DAO.LigneDAO;
import metro.DAO.Ticket_DAO;
import metro.DAO.Zonne_DAO;
import metro.model.Ligne;
import metro.model.Ticket;
import metro.model.Ticket_String;
import metro.model.Zonne;

public class MenuTicketTabPaneController {

    @FXML
    private JFXTabPane tabPane;

    @FXML
    private Tab tab_Ticket;

    @FXML
    private StackPane stackPane;

    @FXML
    private TableView<Ticket_String> TicketTableView;

    @FXML
    private TableColumn<Ticket_String,Integer> cl_numticket;

    @FXML
    private TableColumn<Ticket_String, String> cl_datachat;

    @FXML
    private TableColumn<Ticket_String, String> cl_destination;

    @FXML
    private JFXTextField numguichet_TXT;

    @FXML
    private JFXComboBox<Zonne> combo_zoneDest;

    @FXML
    private JFXComboBox<String> combo_type_tickt;

    @FXML
    private ImageView ticket_print;

    @FXML
    private Label label1;

    @FXML
    private Label label11;

    @FXML
    private JFXTextField Nom_Station_Txt1;

    @FXML
    private Tab tabStation;

    @FXML
    private StackPane stackPane1;

    @FXML
    private Label label_LIGNEE;

    @FXML
    private Tab tab_depots;

    @FXML
    private StackPane stackPane2;

    @FXML
    private Label label_ZONNNE;

    @FXML
    private JFXTimePicker timepicker;

    @FXML
    private TableColumn<Ticket_String, String> cl_typeTicket;
    
    LigneDAO ligneDAO = new LigneDAO();
    Zonne_DAO zoneDao = new Zonne_DAO();
    Ticket_DAO daTicket_DAO = new Ticket_DAO();
    Guichet_DAO guichet_DAO = new Guichet_DAO();


	ObservableList<Zonne> zoneList = FXCollections.observableArrayList(zoneDao.findAll_Zonne());
	//ObservableList<Ticket_String> tick_String = FXCollections.observableArrayList(daTicket_DAO.findAll_Ticket_ByGuichet(Main.guitchetID));

	ObservableList<Ticket_String> tick_String = FXCollections.observableArrayList(
			daTicket_DAO.findAll_Ticket_param(Main.guitchetID)
			);
	@FXML
	void initialize(){ 
		this.Nom_Station_Txt1.setText(Main.guichetOb.getStation().getNom_station()+"");
		this.numguichet_TXT.setText(Main.guitchetID+"");
    	combo_type_tickt.getItems().addAll("Type 1:Déplacement","Type 2:Aller-Retour");
		combo_zoneDest.getItems().addAll(zoneList);

    	
     cl_numticket.setCellValueFactory(new PropertyValueFactory<Ticket_String, Integer>("Num"));
     cl_datachat.setCellValueFactory(new PropertyValueFactory<Ticket_String, String>("date_heure_achat"));
     cl_destination.setCellValueFactory(new PropertyValueFactory<Ticket_String, String>("Nom_zonne"));
     cl_typeTicket.setCellValueFactory(new PropertyValueFactory<Ticket_String, String>("Nom_type"));
 
     TicketTableView.setItems(tick_String);

     
 	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
 	timepicker.setPromptText(formatter.format(date));
	}


    
    @FXML
    void Ticket_print_Click(MouseEvent event) {
    	int indexType1,indexZone,n1,nZone=0;
		if (combo_type_tickt.getSelectionModel().isEmpty() || combo_zoneDest.getSelectionModel().isEmpty()) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Veuillez sélectionner les informations  ");
			alert.showAndWait();


		} else {

			int n3 = 0;
			indexType1 = combo_type_tickt.getSelectionModel().getSelectedIndex();
			indexZone = combo_zoneDest.getSelectionModel().getSelectedIndex();
			if (combo_type_tickt.getItems().get(indexType1).equals("Type 1:Déplacement"))
				n1 = 1;
			else
				n1 = 2;

			nZone = combo_zoneDest.getItems().get(indexZone).getNum_zonne();

			if (daTicket_DAO.add_Ticket(Main.guitchetID, combo_zoneDest.getItems().get(indexZone).getNum_zonne(), n1)) {
				tick_String.clear();
				ObservableList<Ticket_String> tick_String = FXCollections.observableArrayList(
						daTicket_DAO.findAll_Ticket_param(Main.guitchetID)
						);

				cl_numticket.setCellValueFactory(new PropertyValueFactory<Ticket_String, Integer>("Num"));
				cl_datachat.setCellValueFactory(new PropertyValueFactory<Ticket_String, String>("date_heure_achat"));
				cl_destination.setCellValueFactory(new PropertyValueFactory<Ticket_String, String>("Nom_zonne"));
				TicketTableView.setItems(tick_String);

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("Ajoute avec succées  ");
				alert.showAndWait();
				

			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Veuillez sélectionner les informations  ");
				alert.showAndWait();
			}

		}

}
    @FXML
    private Label labelPrix;

    @FXML
    void calculerPRix(ActionEvent event) {

		int n1 =0;
		int indexPrix = combo_zoneDest.getSelectionModel().getSelectedIndex();
		int numStat = Main.guichetOb.getStation().getNum_station();
		int numZone = daTicket_DAO.find_Zonne_of_station(numStat);
		int indexType1 = combo_type_tickt.getSelectionModel().getSelectedIndex();

		if (combo_type_tickt.getItems().get(indexType1).equals("Type 1:Déplacement"))
			n1 = 1;
		else
			n1 = 2;

		this.labelPrix.setVisible(true);
		this.labelPrix.setText(daTicket_DAO.prix(numZone, combo_zoneDest.getItems().get(indexPrix).getNum_zonne(), n1) + "");

    }
    

    @FXML
    void calculerPRIX23(MouseEvent event) {
    	System.out.println("haaha");
    }

    
    @FXML
    void calculerPRIX22(KeyEvent event) {

    }
    

    @FXML
    void modifier_ClickSorti(ActionEvent event) {
    	
    	
    }

    @FXML
    void modifier_Click_Enter(ActionEvent event) {
    	System.out.println("houn");
    	daTicket_DAO.Entree_Ticket(2, numticket);

    }
    public int numticket=0;
	public void remplirr(Ticket_String z){
		int numticket=z.getNum();
	}
    @FXML
    void affecterAuFieldTicket(MouseEvent event) {
    	  Ticket_String tick=TicketTableView.getSelectionModel().getSelectedItem();
	    	remplirr(tick);
			this.numticket=tick.getNum();
			System.out.println(numticket);


    }
    
    
}
