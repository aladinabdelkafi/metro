package metro.viewController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import metro.DAO.Arret_DAO;
import metro.DAO.LigneDAO;
import metro.DAO.Station_DAO;
import metro.DAO.Zonne_DAO;
import metro.model.Arret;
import metro.model.Arret_String;
import metro.model.Ligne;
import metro.model.Station;
import metro.model.Zonne;

public class MenuGestionArretTab {

    @FXML
    private JFXTabPane tabPane;

    @FXML
    private Tab tab_modeles;

    @FXML
    private StackPane stackPane;

    @FXML
    private TableView<Arret_String> ArretTableView;

    @FXML
    private TableColumn<String, String> cl_numeroArret;

    @FXML
    private TableColumn<String, String> cl_NomArret;

    @FXML
    private TableColumn<String, String> cl_Ligne;

    @FXML
    private TableColumn<String, String> cl_zone;


    @FXML
    private TableColumn<String, String> cl_station;
    
    
    
    @FXML
    private JFXTextField numarret_txt;

    @FXML
    private JFXTextField nomarret_txt;

    @FXML
    private JFXComboBox<Zonne> combo_zone;

    @FXML
    private JFXComboBox<Ligne> combo_ligne;

    @FXML
    private JFXComboBox<Station> combo_station;

    @FXML
    private JFXButton btn_ajoutaarret;

    
    
    
    @FXML
    private TableView<Zonne> ZoneTableView_ZONE;

    @FXML
    private TableColumn<Zonne, Integer> cl_numerzone_Zone;

    @FXML
    private TableColumn<Zonne, String>  cl_nomzone_Zone;

    @FXML
    private TableColumn<Zonne, String>  cl_tarf_Zone;

    @FXML
    private TableView<Arret_String> ArretTableView1_ZONE;

    @FXML
    private TableColumn<String, String>  cl_numeroArret1_ZONE;

    @FXML
    private TableColumn<String, String>  cl_NomArret1_ZONE;

    @FXML
    private TableColumn<String, String> cl_Ligne1_ZONE;

    @FXML
    private TableColumn<String, String> cl_zone1_ZONE;

    @FXML
    private TableColumn<String, String> cl_station1_ZONE;

    @FXML
    private JFXTextField nomzone_txt_Zone;

    @FXML
    private JFXButton afficherArret;

    
    
    @FXML
    private TableView<Ligne> lignesTableView_LIGNE;

    @FXML
    private TableColumn<Ligne,Integer> cl_numero__LIGNE;

    @FXML
    private TableColumn<Ligne,String> cl_nom_LIGNEEE;

    @FXML
    private TableColumn<Ligne,String> cl_dep_LIGNNE;

    @FXML
    private TableColumn<Ligne,String> cl_term_LIGNNE;

    @FXML
    private TableView<Arret_String> ArretTableView2_LIGNE;

    @FXML
    private TableColumn<String,String> cl_numeroArret1_LIGNE;

    @FXML
    private TableColumn<String,String> cl_NomArret1_LIGNE;

    @FXML
    private TableColumn<String,String> cl_Ligne1_LIGNE;

    @FXML
    private TableColumn<String,String> cl_zone1_LIGNE;

    @FXML
    private TableColumn<String,String> cl_station1_LIGNE;

    
    
    
    
    
    
    
    @FXML
    private ImageView imageView;

    @FXML
    private JFXTextField t_ref;

    @FXML
    private JFXTextField t_designation;

    @FXML
    private JFXTextField t_prix_ht;

    @FXML
    private JFXTextField t_tva;

    @FXML
    private JFXTextField t_prix_ttc;

    @FXML
    private JFXButton b_ajouter;

    @FXML
    private JFXButton b_modifier;

    @FXML
    private JFXButton b_supprimer;

    @FXML
    private JFXComboBox<?> c_categorie;

    @FXML
    private Tab tab_produits;

    @FXML
    private StackPane stackPane1;

    @FXML
    private TableView<?> produitsTableView;

    @FXML
    private TableColumn<?, ?> p_idColumn;

    @FXML
    private TableColumn<?, ?> p_desColumn;

    @FXML
    private TableColumn<?, ?> p_modeleColumn;

    @FXML
    private TableColumn<?, ?> p_couleurColumn;

    @FXML
    private TableColumn<?, ?> p_pointureColumn;

    @FXML
    private ImageView p_imageView;

    @FXML
    private JFXTextField p_t_id;

    @FXML
    private JFXTextField p_t_designation;

    @FXML
    private JFXComboBox<?> p_c_couleur;

    @FXML
    private JFXTextField p_t_prix_ttc;

    @FXML
    private JFXButton p_b_ajouter;

    @FXML
    private JFXButton p_b_supprimer;

    @FXML
    private JFXComboBox<?> p_c_modeles;

    @FXML
    private JFXTextField p_t_pointure;

    @FXML
    private Tab tab_depots;

    @FXML
    private StackPane stackPane2;

    @FXML
    private TableView<?> depotsTableView;

    @FXML
    private TableColumn<?, ?> d_idColumn;

    @FXML
    private TableColumn<?, ?> d_adresse_Column;

    @FXML
    private TableColumn<?, ?> d_telColumn;

    @FXML
    private JFXTextField d_t_id;

    @FXML
    private JFXTextField d_t_adresse;

    @FXML
    private JFXButton d_b_ajouter;

    @FXML
    private JFXButton d_b_modifier;

    @FXML
    private JFXButton d_b_supprimer;

    @FXML
    private JFXTextField d_t_tel;

    @FXML
    private Tab tab_stock;

    @FXML
    private StackPane stackPane3;

    @FXML
    private TableView<?> stockTableView;

    @FXML
    private TableColumn<?, ?> s_depotColumn;

    @FXML
    private TableColumn<?, ?> s_produit_Column;

    @FXML
    private TableColumn<?, ?> s_qteColumn;

    @FXML
    private ImageView s_imageView;

    @FXML
    private JFXTextField s_t_qte;

    @FXML
    private JFXButton s_b_ajouter;

    @FXML
    private JFXButton s_b_modifier;

    @FXML
    private JFXButton s_b_supprimer;

    @FXML
    private JFXComboBox<?> s_c_depots;

    @FXML
    private JFXComboBox<?> s_c_produits;

    @FXML
    void b_ajouter_Click(ActionEvent event) {

    }

    @FXML
    void b_modifier_Click(ActionEvent event) {

    }

    @FXML
    void b_supprimer_Click(ActionEvent event) {

    }

    @FXML
    void d_b_ajouter_Click(ActionEvent event) {

    }

    @FXML
    void d_b_modifier_Click(ActionEvent event) {

    }

    @FXML
    void d_b_supprimer_Click(ActionEvent event) {

    }

    @FXML
    void imageView_Click(MouseEvent event) {

    }

    @FXML
    void p_b_ajouter_Click(ActionEvent event) {

    }

    @FXML
    void p_b_supprimer_Click(ActionEvent event) {

    }

    @FXML
    void s_b_ajouter_Click(ActionEvent event) {

    }

    @FXML
    void s_b_modifier_Click(ActionEvent event) {

    }

    @FXML
    void s_b_supprimer_Click(ActionEvent event) {

    }
    
    Arret_DAO arretDAO = new Arret_DAO();
    /*  Ligne ch1=arretDAO.findAll_Arrets().get(0).getLigne();
    Zonne ch2=arretDAO.findAll_Arrets().get(0).getZonne();
    Station ch3=arretDAO.findAll_Arrets().get(0).getStation();
    String ch4=arretDAO.findAll_Arrets().get(0).getNom_arret();
    String ch5=arretDAO.findAll_Arrets().get(0).getNum_arret();*/
//Arret ar = new Arret(ch5,ch4,ch1,ch2,ch3);

	ObservableList<Arret_String> arretList = FXCollections.observableArrayList(arretDAO.findAll_Arrets());

    LigneDAO ligneDAO = new LigneDAO();
    Zonne_DAO zonedao = new Zonne_DAO();
    Arret_DAO arretdao = new Arret_DAO();
    Station_DAO stationdao = new Station_DAO();
	@FXML
    void initialize(){
		/*ll zonnne*/
		ObservableList<Zonne> zoneList = FXCollections.observableArrayList(zonedao.findAll_Zonne());
    	cl_nomzone_Zone.setCellValueFactory(new PropertyValueFactory<Zonne,String >("Nom_zone"));
    	cl_numerzone_Zone.setCellValueFactory(new PropertyValueFactory<Zonne, Integer>("Num_zonne"));
    	cl_tarf_Zone.setCellValueFactory(new PropertyValueFactory<Zonne, String>("tarif"));
    	ZoneTableView_ZONE.setItems(zoneList);
    	
		ObservableList<Ligne> ligneLIST = FXCollections.observableArrayList(ligneDAO.findAll_lignes());
		cl_numero__LIGNE.setCellValueFactory(new PropertyValueFactory<Ligne ,Integer>("Num_Ligne"));
		cl_nom_LIGNEEE.setCellValueFactory(new PropertyValueFactory<Ligne ,String>("Nom_ligne"));
		cl_dep_LIGNNE.setCellValueFactory(new PropertyValueFactory<Ligne, String>("Depart"));
    	cl_term_LIGNNE.setCellValueFactory(new PropertyValueFactory<Ligne, String>("Terminus"));
    	lignesTableView_LIGNE.setItems(ligneLIST);



 cl_numeroArret.setCellValueFactory(new PropertyValueFactory<String, String>("Num_arret"));
 cl_Ligne.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_ligne"));
 cl_NomArret.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_arret"));
 cl_station.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_station"));
 cl_zone.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_zonne"));
    	ArretTableView.setItems(arretList);

    	
		ObservableList<Ligne> ligneList = FXCollections.observableArrayList(ligneDAO.findAll_lignes());

		ObservableList<Zonne> ZoneList = FXCollections.observableArrayList(zonedao.findAll_Zonne());

		ObservableList<Station> StationList = FXCollections.observableArrayList(stationdao.findAll_Station());
    	
		combo_ligne.getItems().addAll(ligneList);
		combo_zone.getItems().addAll(ZoneList);
		combo_station.getItems().addAll(StationList);
		
	}
	

    @FXML
    void AjouterArret_Click(ActionEvent event) {
    	int indexLigne,indexZone,indexStation=0;
    	
    	if(combo_ligne.getSelectionModel().isEmpty()|| combo_zone.getSelectionModel().isEmpty()||combo_station.getSelectionModel().isEmpty()  ) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setContentText("Veuillez sélectionner les informations  ");
    		alert.showAndWait();

    	}
    	else {
       	 indexLigne = combo_ligne.getSelectionModel().getSelectedIndex();
       	 indexZone = combo_zone.getSelectionModel().getSelectedIndex();
       	 indexStation = combo_station.getSelectionModel().getSelectedIndex();
       int	 numlign=combo_ligne.getItems().get(indexLigne).getNum_Ligne();
       int 	 numzone=combo_zone.getItems().get(indexZone).getNum_zonne();
       	int  numstation=combo_station.getItems().get(indexStation).getNum_station();
       	int numArret=arretdao.max_Arret(numlign);

    		arretdao.add_Arret(numlign, numzone, numstation);
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setContentText("Insertion Avec succéess  ");
    		alert.showAndWait();
           	arretList.clear();
       	 arretList = FXCollections.observableArrayList(arretDAO.findAll_Arrets());

       		 cl_numeroArret.setCellValueFactory(new PropertyValueFactory<String, String>("Num_arret"));
       		 cl_Ligne.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_ligne"));
       		 cl_NomArret.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_arret"));
       		 cl_station.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_station"));
       		 cl_zone.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_zonne"));
       		 ArretTableView.setItems(arretList);



    	}
    	
    }
    
    
    @FXML
    void afficherArret_Click(ActionEvent event) {

    }
    
    


    @FXML
    private Label label_ZONNNE;
 
    @FXML
    void affecterAuField(MouseEvent event) {
        Zonne zz= ZoneTableView_ZONE.getSelectionModel().getSelectedItem();
        System.out.println(zz.getNom_zone());
        this.label_ZONNNE.setVisible(true);
        this.label_ZONNNE.setText(zz.getNom_zone());
        this.ArretTableView1_ZONE.setVisible(true);
        System.out.println(zz.getNum_zonne());
		ObservableList<Arret_String> zoneList1 = FXCollections.observableArrayList(arretdao.find_Arret_Zonne(zz.getNum_zonne()));
  		 cl_numeroArret1_ZONE.setCellValueFactory(new PropertyValueFactory<String, String>("Num_arret"));
  		 cl_Ligne1_ZONE.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_ligne"));
  		 cl_NomArret1_ZONE.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_arret"));
  		 cl_station1_ZONE.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_station"));
  		 cl_zone1_ZONE.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_zonne"));
    	ArretTableView1_ZONE.setItems(zoneList1);
    }
    

    @FXML
    private Label label_LIGNEE;

    @FXML
    void affecterAuFieldZONE(MouseEvent event) {
    	
        Ligne ll= lignesTableView_LIGNE.getSelectionModel().getSelectedItem();
        this.label_LIGNEE.setVisible(true);
        this.label_LIGNEE.setText(ll.getNom_ligne());
        this.ArretTableView2_LIGNE.setVisible(true);
		ObservableList<Arret_String> zoneList2 = FXCollections.observableArrayList(arretdao.findArretsOfLigne(ll.getNum_Ligne()));
		cl_numeroArret1_LIGNE.setCellValueFactory(new PropertyValueFactory<String, String>("Num_arret"));
		cl_Ligne1_LIGNE.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_Ligne"));
  		cl_NomArret1_LIGNE.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_arret"));
  		cl_station1_LIGNE.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_station"));
  		cl_zone1_LIGNE.setCellValueFactory(new PropertyValueFactory<String, String>("Nom_zonne"));
    	ArretTableView2_LIGNE.setItems(zoneList2);
    	
    	
    	
    	

    	
    	
    	

    }
    



}
