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
import metro.DAO.Ligne_bcDAO;
import metro.model.Ligne_bc;

public class Voir_BonCommandeViewController 
{
	ObservableList<Ligne_bc> lignesBCList = FXCollections.observableArrayList();
	FilteredList<Ligne_bc> filteredLignesBCList = new FilteredList<Ligne_bc>(lignesBCList);
	SortedList<Ligne_bc> sortedLignesBCList = new SortedList<Ligne_bc>(filteredLignesBCList);

    @FXML
    JFXTextField bc_t_num;

    @FXML
    JFXTextField bc_t_client;

    @FXML
    JFXTextField bc_t_date;
    
    @FXML
    Label label;

    @FXML
    private TableView<Ligne_bc> lignesBCTableView;

    @FXML
    private TableColumn<Ligne_bc, String> bc_produitColumn;

    @FXML
    private TableColumn<Ligne_bc, Integer> bc_qteColumn;
    
    @FXML
    private TableColumn<Ligne_bc, Integer> bc_qteNonLivreeColumn;

    @FXML
    private TableColumn<Ligne_bc, String> bc_prixUHTColumn;

    @FXML
    private TableColumn<Ligne_bc, Integer> bc_tvaColumn;
    
    @FXML
    private TableColumn<Ligne_bc, String> bc_prixUTTCColumn;

    @FXML
    private TableColumn<Ligne_bc, String> bc_totalTTCColumn;

    @FXML
    JFXTextField bc_t_totalHT;

    @FXML
    JFXTextField bc_t_timbre;

    @FXML
    JFXTextField bc_t_totalTTC;
    
    @FXML
    void initialize()
    {  	
    	bc_produitColumn.setCellValueFactory(
    			c -> Bindings.concat(
    	c.getValue().getProduit().getModele_couleur().modeleProperty(), " - ", 
    	c.getValue().getProduit().getModele_couleur().getCouleur().nomProperty(), "-",
    	c.getValue().getProduit().pointureProperty() ) 
    	);   	
    	bc_qteColumn.setCellValueFactory(new PropertyValueFactory<Ligne_bc, Integer>("qte_cmde"));
    	bc_qteNonLivreeColumn.setCellValueFactory(new PropertyValueFactory<Ligne_bc, Integer>("qte_nonLivree"));
    	bc_prixUHTColumn.setCellValueFactory(c->Bindings.format("%,.3f", c.getValue().prixU_HTProperty()));
    	bc_tvaColumn.setCellValueFactory(new PropertyValueFactory<Ligne_bc, Integer>("tva"));
    	bc_prixUTTCColumn.setCellValueFactory(c->Bindings.format("%,.3f", c.getValue().prixU_TTCProperty()));
    	bc_totalTTCColumn.setCellValueFactory(c->Bindings.format("%,.3f", 
    			                                                c.getValue().total_TTCProperty()) );
    	
    	bc_prixUHTColumn.setComparator((t1,t2)->{
    		return Double.compare(
    		Double.parseDouble(t1.replace(',', '.').replaceAll("\\s|\\u00A0", "")),
    				Double.parseDouble(t2.replace(',', '.').replaceAll("\\s|\\u00A0", "")));
    	});
    	bc_prixUTTCColumn.setComparator((t1,t2)->{
    		return Double.compare(
    		Double.parseDouble(t1.replace(',', '.').replaceAll("\\s|\\u00A0", "")),
    				Double.parseDouble(t2.replace(',', '.').replaceAll("\\s|\\u00A0", "")));
    	});
    	bc_totalTTCColumn.setComparator((t1,t2)->{
    		return Double.compare(
    		Double.parseDouble(t1.replace(',', '.').replaceAll("\\s|\\u00A0", "")),
    				Double.parseDouble(t2.replace(',', '.').replaceAll("\\s|\\u00A0", "")));
    	});
    	
    	
    	//*** just to avoid NullPointerException :p
    	bc_t_num.textProperty().addListener(
    			(observable, oldValue, newValue) -> {
    				if(!newValue.isEmpty())
    					lignesBCList.setAll(Ligne_bcDAO.findAll(bc_t_num.getText()));   					
    			}); 	
    	
        sortedLignesBCList.comparatorProperty().bind(lignesBCTableView.comparatorProperty());
        lignesBCTableView.setItems(sortedLignesBCList);
        
        bc_t_num.requestFocus();
        
        
    }

}
