package metro;
	
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import metro.model.Bon_commande;
import metro.model.Bon_livraison;
import metro.model.Facture;
import metro.model.Guichet;
import metro.viewController.ForAllViewController;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application 
{
	public static String role="amdin";
	public static int IDrole;
	public static int guitchetID;
	public static Guichet guichetOb;
	public static Stage primaryStage;
	public static ImageView search_icon;
	public static TextField t_search;
	public static ComboBox<String> c_searchBy;
	
	public static ForAllViewController forAllViewController;
	public static BorderPane forAllBorderPane;
	
	public static ObservableList<Bon_commande> cmdsList;
	public static ObservableList<Bon_livraison> livList;
	public static ObservableList<Facture> facList;
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			
			//AnchorPane root = (AnchorPane)FXMLLoader.load(Main.class.getResource("view/SplashScreen.fxml"));
			AnchorPane root = (AnchorPane)FXMLLoader.load(Main.class.getResource("view/Login.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			
			Main.primaryStage = primaryStage;
			
			primaryStage.show();
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
