	package metro.viewController;


	import javafx.scene.control.TableCell;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.cell.PropertyValueFactory;
	import javafx.stage.Stage;
	import javafx.util.Callback;
import metro.DAO.LigneDAO;
import metro.model.Ligne;
import metro.model.Ligne_bc;
import metro.model.Modele;
import net.sourceforge.barbecue.Main;

import com.jfoenix.controls.JFXButton;
	import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.StackPane;

	public class MenuGestionLigneController {


		
	    @FXML
	    private BorderPane root;

	    
	    @FXML
	    private JFXTextField num;

	    @FXML
	    private Label label; 

	    @FXML
	    private JFXTextField term;

	    @FXML
	    private JFXTextField nom;

	    @FXML
	    private JFXTextField dep;

	    
	    @FXML
	    private JFXButton bl_b_ajouter;

	    @FXML
	    private StackPane stackPane;

	    @FXML
	    private TableView<Ligne> lignesBLTableView;


	    @FXML
	    private TableColumn<Ligne, Integer> cl_numero;

	    @FXML
	    private TableColumn<Ligne, String> cl_nom;

	    @FXML
	    private TableColumn<Ligne, String> cl_dep;

	    @FXML
	    private TableColumn<Ligne, String> cl_term;
	    
	    @FXML
	    void bl_b_ajouter_Click(ActionEvent event) {
	    	if(this.bl_b_ajouter.getText().equals("Ajouter")) {
	    		Ligne l = new Ligne(dep.getText()+"/"+term.getText(),dep.getText(),term.getText());
	    	ligneDAO.add_ligne(l);
	    	l.setNum_Ligne(ligneDAO.max_Ligne());
	    	lignesList.add(l);

	    		System.out.println("ajoute!");
	    		vider();
	    		
	    	}else {
	    		nom.setVisible(false);
	    		Ligne l = new Ligne(Integer.parseInt(num.getText()),dep.getText(),term.getText());
	    		ligneDAO.update_ligne(l);
	    		vider();
	    		nom.setVisible(false);
	    		  nom.setEditable(false);
	    		  lignesList.clear();
	    			lignesList = FXCollections.observableArrayList(ligneDAO.findAll_lignes());
	    		  System.out.println("modifier ");
	  	    	cl_numero.setCellValueFactory(new PropertyValueFactory<Ligne, Integer>("Num_Ligne"));
		    	cl_nom.setCellValueFactory(new PropertyValueFactory<Ligne, String>("Nom_ligne"));
		    	cl_dep.setCellValueFactory(new PropertyValueFactory<Ligne, String>("Depart"));
		    	cl_term.setCellValueFactory(new PropertyValueFactory<Ligne, String>("Terminus"));
		    	lignesBLTableView.setItems(lignesList);
	    	}

	    }

	    /* __when the observableList changed, the filteredList automatically changed__ */
	    LigneDAO ligneDAO = new LigneDAO();
		ObservableList<Ligne> lignesList = FXCollections.observableArrayList(ligneDAO.findAll_lignes());

		Ligne l = new Ligne();
	    @FXML
	    
	    
	    private void addButtonToTable() {
	        TableColumn<Ligne, Void> colBtn = new TableColumn("");

	        Callback<TableColumn<Ligne, Void>, TableCell<Ligne, Void>> cellFactory = 
	        		new Callback<TableColumn<Ligne, Void>, TableCell<Ligne, Void>>() {
	            @Override
	            public TableCell<Ligne, Void> call(final TableColumn<Ligne, Void> param) {
	                final TableCell<Ligne, Void> cell = new TableCell<Ligne, Void>() {

	                    private final Button btn = new Button("Supprimer");

	                    {
	                        btn.setOnAction((ActionEvent event) -> {
	                        	Ligne data = getTableView().getItems().get(getIndex());
	                        	int val=data.getNum_Ligne();
	                        	ligneDAO.Delete_ligne(val);
	                        	
	                            Ligne selectedItem = lignesBLTableView.getSelectionModel().getSelectedItem();
	                            lignesBLTableView.getItems().remove(selectedItem);

	                        });
	                    }

	                    @Override
	                    public void updateItem(Void item, boolean empty) {
	                        super.updateItem(item, empty);
	                        if (empty) {
	                            setGraphic(null);
	                        } else {
	                            setGraphic(btn);
	                        }
	                    }
	                };
	                return cell;
	            }
	        };

	        colBtn.setCellFactory(cellFactory);

	        lignesBLTableView.getColumns().add(colBtn);

	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    @FXML
	    void initialize(){ 
	    	
	    	
	    	nom.setVisible(false);

	    	
	    	if(num.getText().equals("")) {
	    		this.bl_b_ajouter.setText("Ajouter");
	    	}
	    	else {
	    		this.bl_b_ajouter.setText("Modifier");
	    	}
	    	System.out.println("init");
	    	cl_numero.setCellValueFactory(new PropertyValueFactory<Ligne, Integer>("Num_Ligne"));
	    	cl_nom.setCellValueFactory(new PropertyValueFactory<Ligne, String>("Nom_ligne"));
	    	cl_dep.setCellValueFactory(new PropertyValueFactory<Ligne, String>("Depart"));
	    	cl_term.setCellValueFactory(new PropertyValueFactory<Ligne, String>("Terminus"));
	    	lignesBLTableView.setItems(lignesList);
	        addButtonToTable();

	    	
	    }
	    
		public void remplirr(Ligne l){
			num.setText(l.getNum_Ligne()+"");
			nom.setText(l.getNom_ligne()+"");
			term.setText(l.getTerminus()+"");
			dep.setText(l.getDepart()+"");

		}
void vider(){
	num.setText("");
	nom.setText("");
	term.setText("");
	dep.setText("");

}
	    @FXML
	    void affecterAuField(MouseEvent event) {
	  Ligne ligne=lignesBLTableView.getSelectionModel().getSelectedItem();
	  nom.setVisible(true);
	  nom.setDisable(true);
	    	remplirr(ligne);
	    	num.setEditable(true);
	    	nom.setEditable(true);
	    	term.setEditable(true);
	    	dep.setEditable(true);
	    	this.bl_b_ajouter.setText("modifier");


	    }

}
