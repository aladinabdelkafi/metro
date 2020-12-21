package metro.viewController;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXDialog.DialogTransition;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import metro.Main;
import metro.DAO.UsersDAO;
import metro.model.Users;

public class MenuUsersViewController 
{

	@FXML
    private StackPane stackPane;
	
    @FXML
    private JFXTabPane jfxTabPane;

    @FXML
    private Tab tab_users;

    @FXML
    private BorderPane borderPane;

    @FXML
    private JFXButton u_b_ajouter;

    @FXML
    private JFXButton u_b_supprimer;

    @FXML
    private JFXButton u_b_modifier;
    
    @FXML
    private JFXTextField t_login;

    @FXML
    private JFXPasswordField t_password;

    @FXML
    private JFXComboBox<String> c_role;

    @FXML
    private TableView<Users> usersTableView;

    @FXML
    private TableColumn<Users, String> loginColumn;

    @FXML
    private TableColumn<Users, String> passwordColumn;

    @FXML
    private TableColumn<Users, String> roleColumn;

    @FXML
    void u_b_ajouter_Click(ActionEvent event) 
    {
    	if(u_b_ajouter.getText().equals("Ajouter"))
    	{
    		usersTableView.setDisable(true);
    		
    		u_b_ajouter.setText("Valider");
    		u_b_modifier.setDisable(true);
    		u_b_supprimer.setDisable(true);
    		
    		c_role.setDisable(false);
    		t_login.setEditable(true);
    		t_password.setEditable(true);

    		
    		c_role.setValue(null);t_login.clear();t_password.clear();
    	}
    	else
    	{
    		if(c_role.getValue()!=null && !t_login.getText().isEmpty() &&
    				!t_password.getText().isEmpty() )
    		{
    			Users u = new Users( t_login.getText(), 
    					             t_password.getText(), 
    					             c_role.getValue() );
            	UsersDAO.add(u);
            	usersTableView.getItems().setAll( UsersDAO.findAll() );
            	c_role.setValue(null);t_login.clear();t_password.clear();
    		}
    		else
    		{
    			try 
    			{
					GridPane layout = FXMLLoader.load(Main.class.getResource("view/ErrorDialog.fxml"));
					JFXDialog dialog = new JFXDialog(stackPane, layout, DialogTransition.CENTER);
					JFXButton ok = (JFXButton)layout.getChildren().get(2);
					ok.setOnAction(e -> {
						dialog.close();
						c_role.setValue(null);t_login.clear();t_password.clear();
					});
					dialog.show();
				} 
    			catch (IOException e) {
					e.printStackTrace();
				} 			
    		}
        	
        	u_b_ajouter.setText("Ajouter");
        	u_b_modifier.setDisable(false);
    		u_b_supprimer.setDisable(false);
    		
    		c_role.setDisable(true);
    		t_login.setEditable(false);
    		t_password.setEditable(false);
    		
    		usersTableView.setDisable(false);
    	}
    }

    String oldLogin;
    @FXML
    void u_b_modifier_Click(ActionEvent event) 
    {   	
    	if(u_b_modifier.getText().equals("Modifier"))
    	{
    		oldLogin = t_login.getText();
    		
    		usersTableView.setDisable(true);
    		
    		u_b_modifier.setText("Valider");
    		u_b_ajouter.setDisable(true);
    		u_b_supprimer.setDisable(true);
    		
    		t_login.setEditable(true);
    		t_password.setEditable(true);
    		c_role.setDisable(false);
    	}
    	else
    	{
    		if(c_role.getValue()!=null && !t_login.getText().isEmpty() &&
    				!t_password.getText().isEmpty() )
    		{
    			Users u = new Users( t_login.getText(), 
			             t_password.getText(), 
			             c_role.getValue() );
	            UsersDAO.update(oldLogin, u);
	            usersTableView.getItems().setAll( UsersDAO.findAll() );      
	            c_role.setValue(null);t_login.clear();t_password.clear();
    		}
    		else
    		{
    			try 
    			{
					GridPane layout = FXMLLoader.load(Main.class.getResource("view/ErrorDialog.fxml"));
					JFXDialog dialog = new JFXDialog(stackPane, layout, DialogTransition.CENTER);
					JFXButton ok = (JFXButton)layout.getChildren().get(2);
					ok.setOnAction(e -> {
						dialog.close();
					});
					dialog.show();
				} 
    			catch (IOException e) {
					e.printStackTrace();
				} 			
    		}
        	
        	u_b_modifier.setText("Modifier");
        	u_b_ajouter.setDisable(false);
    		u_b_supprimer.setDisable(false);
    		
    		t_login.setEditable(false);
    		t_password.setEditable(false);
    		c_role.setDisable(true);
    		
    		usersTableView.setDisable(false);
    	}
    }

    @FXML
    void u_b_supprimer_Click(ActionEvent event) 
    {
    	Users u = new Users( t_login.getText(), 
	             t_password.getText(), 
	             c_role.getValue() );
        UsersDAO.delete(u);
        usersTableView.getItems().setAll( UsersDAO.findAll() );
        c_role.setValue(null);t_login.clear();t_password.clear();
    }
    
    @FXML
    void initialize()
    {
    	Main.search_icon.setDisable(true);

    		Main.t_search.setPrefWidth(0.0);
    		Main.c_searchBy.setPrefWidth(0.0);
    		Main.c_searchBy.setVisible(false);

    	loginColumn.setCellValueFactory(new PropertyValueFactory<Users, String>("login"));
    	passwordColumn.setCellValueFactory(new PropertyValueFactory<Users, String>("password"));
    	roleColumn.setCellValueFactory(new PropertyValueFactory<Users, String>("role"));
    	
    	usersTableView.getItems().setAll(UsersDAO.findAll());
    	
    	usersTableView.getSelectionModel().selectedItemProperty().addListener(
    			(observable, oldValue, newValue) -> {
    				if(usersTableView.getSelectionModel().getSelectedItem() != null)
    				{
        				t_login.setText(newValue.getLogin());
        				t_password.setText(newValue.getPassword());
        				c_role.setValue(newValue.getRole());
    				}		
    			});
    	c_role.getItems().setAll("admin", "stock", "commercial");
    	
    }

}
