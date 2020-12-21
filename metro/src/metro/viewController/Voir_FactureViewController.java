package metro.viewController;

import com.jfoenix.controls.JFXTextField;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import metro.DAO.Ligne_factureDAO;
import metro.model.Ligne_facture;

public class Voir_FactureViewController 
{
	ObservableList<Ligne_facture> lignesFactureList = FXCollections.observableArrayList();

    @FXML
    JFXTextField fac_t_num;

    @FXML
    JFXTextField fac_t_client;

    @FXML
    JFXTextField fac_t_date;

    @FXML
    private Label label;

    @FXML
    JFXTextField fac_t_numBL;

    @FXML
    private TableView<Ligne_facture> lignesFactureTableView;

    @FXML
    private TableColumn<Ligne_facture, String> fac_produitColumn;

    @FXML
    private TableColumn<Ligne_facture, Integer> fac_qteColumn;
    
    @FXML
    private TableColumn<Ligne_facture, String> fac_prixUHTColumn;
    
    @FXML
    private TableColumn<Ligne_facture, Integer> fac_tvaColumn;

    @FXML
    private TableColumn<Ligne_facture, String> fac_prixUTTCColumn;

    @FXML
    private TableColumn<Ligne_facture, String> fac_totalTTCColumn;

    @FXML 
    JFXTextField fac_t_totalHT;

    @FXML
    JFXTextField fac_t_timbre;

    @FXML
    JFXTextField fac_t_totalTTC;
    
    
    @FXML
    void initialize()
    {  	
    	fac_produitColumn.setCellValueFactory(
    			c -> Bindings.concat(
    	c.getValue().getProduit().getModele_couleur().modeleProperty(), " - ", 
    	c.getValue().getProduit().getModele_couleur().getCouleur().nomProperty(), "-",
    	c.getValue().getProduit().pointureProperty() ) 
    	);   	
    	fac_qteColumn.setCellValueFactory(new PropertyValueFactory<Ligne_facture, Integer>("qte"));
    	fac_prixUHTColumn.setCellValueFactory(c->Bindings.format("%,.3f", c.getValue().prixU_HTProperty()));
    	fac_tvaColumn.setCellValueFactory(new PropertyValueFactory<Ligne_facture, Integer>("tva"));
    	fac_prixUTTCColumn.setCellValueFactory(c->Bindings.format("%,.3f", c.getValue().prixU_TTCProperty()));
    	fac_totalTTCColumn.setCellValueFactory(c->Bindings.format("%,.3f", 
    			                                                c.getValue().total_TTCProperty()) );

    	fac_prixUHTColumn.setComparator((t1,t2)->{
    		return Double.compare(
    		Double.parseDouble(t1.replace(',', '.').replaceAll("\\s|\\u00A0", "")),
    				Double.parseDouble(t2.replace(',', '.').replaceAll("\\s|\\u00A0", "")));
    	});
    	fac_prixUTTCColumn.setComparator((t1,t2)->{
    		return Double.compare(
    		Double.parseDouble(t1.replace(',', '.').replaceAll("\\s|\\u00A0", "")),
    				Double.parseDouble(t2.replace(',', '.').replaceAll("\\s|\\u00A0", "")));
    	});
    	fac_totalTTCColumn.setComparator((t1,t2)->{
    		return Double.compare(
    		Double.parseDouble(t1.replace(',', '.').replaceAll("\\s|\\u00A0", "")),
    				Double.parseDouble(t2.replace(',', '.').replaceAll("\\s|\\u00A0", "")));
    	});
    	
    	
    	//*** just to avoid NullPointerException :p
    	fac_t_num.textProperty().addListener(
    			(observable, oldValue, newValue) -> {
    				if(!newValue.isEmpty())
    					lignesFactureList.setAll(Ligne_factureDAO.findAll(fac_t_num.getText()));   					
    			}); 	

        lignesFactureTableView.setItems(lignesFactureList);
        
        fac_t_num.requestFocus();
        
        
    }

}
