package metro.viewController;

import com.jfoenix.controls.JFXTextField;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import metro.DAO.Ligne_blDAO;
import metro.model.Ligne_bl;

public class Voir_BonLivraisonViewController 
{
	ObservableList<Ligne_bl> lignesBLList = FXCollections.observableArrayList();
	FilteredList<Ligne_bl> filteredLignesBLList = new FilteredList<Ligne_bl>(lignesBLList);
	SortedList<Ligne_bl> sortedLignesBLList = new SortedList<Ligne_bl>(filteredLignesBLList);

    @FXML 
    JFXTextField bl_t_num;

    @FXML
    JFXTextField bl_t_client;

    @FXML
    JFXTextField bl_t_date;

    @FXML
    private Label label;

    @FXML
    JFXTextField bl_t_numCMD;

    @FXML
    JFXTextField bl_t_adrLiv;

    @FXML
    private TableView<Ligne_bl> lignesBLTableView;

    @FXML
    private TableColumn<Ligne_bl, String> bl_depotColumn;

    @FXML
    private TableColumn<Ligne_bl, String> bl_produitColumn;

    @FXML
    private TableColumn<Ligne_bl, Integer> bl_qteColumn;

    @FXML
    private TableColumn<Ligne_bl, String> bl_observationColumn;
    
    @FXML
    void initialize()
    {  	
    	bl_depotColumn.setCellValueFactory(c->c.getValue().getDepot().id_depotProperty());
    	bl_produitColumn.setCellValueFactory(
    			c -> Bindings.concat(
    	c.getValue().getProduit().getModele_couleur().modeleProperty(), " ", 
    	c.getValue().getProduit().getModele_couleur().getCouleur().nomProperty(), " ",
    	c.getValue().getProduit().pointureProperty() ) 
    	);   	
    	bl_qteColumn.setCellValueFactory(new PropertyValueFactory<Ligne_bl, Integer>("qte"));
    	bl_observationColumn.setCellValueFactory(new PropertyValueFactory<Ligne_bl, String>("observation"));
    	
    	//*** just to avoid NullPointerException :p
    	bl_t_num.textProperty().addListener(
    			(observable, oldValue, newValue) -> {
    				if(!newValue.isEmpty())
    					lignesBLList.setAll(Ligne_blDAO.findAll(bl_t_num.getText()));   					
    			}); 	
    	
        sortedLignesBLList.comparatorProperty().bind(lignesBLTableView.comparatorProperty());
        lignesBLTableView.setItems(sortedLignesBLList);
        
        bl_t_num.requestFocus();
        
        
    }


}
