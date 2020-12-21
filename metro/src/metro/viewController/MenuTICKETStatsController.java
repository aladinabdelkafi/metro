package metro.viewController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import metro.DAO.Arret_DAO;
import metro.DAO.Station_DAO;
import metro.DAO.StatsDAO;
import metro.DAO.Ticket_DAO;
import metro.DAO.Zonne_DAO;
import metro.model.Count;
import metro.model.Station;
import metro.model.Ticket_String;
import metro.model.Zonne;

public class MenuTICKETStatsController {

    @FXML
    private JFXTabPane jfxTabPane;

    @FXML
    private Tab tab_ca;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Tab tab_bestselling;

    @FXML
    private BorderPane borderPane1;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private Tab tab_bestClients;

    @FXML
    private BorderPane borderPane2;

    @FXML
    private PieChart pieChart;

    @FXML
    private Tab tab_bestClients1;

    @FXML
    private BorderPane borderPane21;

    @FXML
    private PieChart pieChart1;

    @FXML
    private Tab tab_bestClients11;

    @FXML
    private BorderPane borderPane211;

    @FXML
    private PieChart pieChart11;

    @FXML
    private Tab tab_bestClients111;

    @FXML
    private BorderPane borderPane2111;

    @FXML
    private PieChart pieChart111;
    
    
    @FXML
    private TableView<Zonne> ZoneTableView;

    @FXML
    private TableColumn<Zonne, Integer> cl_numerzone;

    @FXML
    private TableColumn<Zonne, String> cl_nomzone;

    @FXML
    private TableColumn<Zonne, String> cl_tarf;
    
    
    @FXML
    private TableView<Ticket_String> TicketTableView;

    @FXML
    private TableColumn<Ticket_String, Integer> cl_numticket;

    @FXML
    private TableColumn<Ticket_String, String> cl_datachat;

    @FXML
    private TableColumn<Ticket_String, String> cl_destination;

    @FXML
    private TableColumn<Ticket_String, String> cl_typeTicket;
    
    @FXML
    private Label label;

    @FXML
    private Label labelZONEEE;
    
    
    @FXML
    private TableView<Ticket_String> TicketTableView1_Station;

    @FXML
    private TableColumn<Ticket_String, Integer> cl_numticket_Station;

    @FXML
    private TableColumn<Ticket_String, String> cl_datachat1_Station;

    @FXML
    private TableColumn<Ticket_String, String> cl_destination1_Station;

    @FXML
    private TableColumn<Ticket_String, String> cl_typeTicket1_Station;
    
    @FXML
    private TableView<Station> stationTableView;

    @FXML
    private TableColumn<Station, Integer> cl_numerStation;

    @FXML
    private TableColumn<Station, String> cl_nomstation;

    
    Zonne_DAO zonne_DAO = new Zonne_DAO();
    Arret_DAO arret_DAO = new Arret_DAO();
    Ticket_DAO ticket_DAO  = new Ticket_DAO();
    Zonne_DAO zoneDAO = new Zonne_DAO();
    Station_DAO station_DAO = new Station_DAO();
	ObservableList<Zonne> zoneList = FXCollections.observableArrayList(zoneDAO.findAll_Zonne());
	ObservableList<Station> stationList = FXCollections.observableArrayList(station_DAO.findAll_Station());

    @FXML
    void affecterFILED(MouseEvent event) {
        Zonne zz= ZoneTableView.getSelectionModel().getSelectedItem();
        System.out.println(zz.getNom_zone());
        this.labelZONEEE.setVisible(true);
        this.labelZONEEE.setText(zz.getNom_zone());
        this.TicketTableView.setVisible(true);
    	ObservableList<Ticket_String> tick_String = FXCollections.observableArrayList(ticket_DAO.findAll_Ticket_Zone(zz.getNum_zonne()));
    	cl_numticket.setCellValueFactory(new PropertyValueFactory<Ticket_String, Integer>("Num"));
        cl_datachat.setCellValueFactory(new PropertyValueFactory<Ticket_String, String>("date_heure_achat"));
        cl_destination.setCellValueFactory(new PropertyValueFactory<Ticket_String, String>("Nom_zonne"));
        cl_typeTicket.setCellValueFactory(new PropertyValueFactory<Ticket_String, String>("Nom_type"));
        TicketTableView.setItems(tick_String);


    }
 
    

    @FXML
    private Label labelZONEEE_Station;
    
    @FXML
    void affecterFILED_Station(MouseEvent event) {
        Station stat= stationTableView.getSelectionModel().getSelectedItem();
        this.labelZONEEE_Station.setVisible(true);
       // this.labelZONEEE_Station.setText(stat.getNom_station());

        this.TicketTableView1_Station.setVisible(true);
    	ObservableList<Ticket_String> tick_String1 = FXCollections.observableArrayList(ticket_DAO.findAll_Ticket_Station(stat.getNum_station()));
    	cl_numticket_Station.setCellValueFactory(new PropertyValueFactory<Ticket_String, Integer>("Num"));
        cl_datachat1_Station.setCellValueFactory(new PropertyValueFactory<Ticket_String, String>("date_heure_achat"));
        cl_destination1_Station.setCellValueFactory(new PropertyValueFactory<Ticket_String, String>("Nom_zonne"));
        cl_typeTicket1_Station.setCellValueFactory(new PropertyValueFactory<Ticket_String, String>("Nom_type"));
        TicketTableView1_Station.setItems(tick_String1);


    }

    @FXML
    private BarChart<String, Integer> barChar_Mois;

	@FXML
    void initialize(){
    	cl_nomzone.setCellValueFactory(new PropertyValueFactory<Zonne,String >("Nom_zone"));
    	cl_numerzone.setCellValueFactory(new PropertyValueFactory<Zonne, Integer>("Num_zonne"));
    	cl_tarf.setCellValueFactory(new PropertyValueFactory<Zonne, String>("tarif"));
    	ZoneTableView.setItems(zoneList);
    	
    	cl_numerStation.setCellValueFactory(new PropertyValueFactory<Station,Integer >("num_station"));
    	cl_nomstation.setCellValueFactory(new PropertyValueFactory<Station, String>("nom_station"));
    	stationTableView.setItems(stationList);


/*Charttt Zone*/
    	barChart11.getXAxis().setStyle("-fx-font-size: 17pt;-fx-font-weight:bold;");
    	barChart11.getYAxis().setStyle("-fx-font-size: 17pt;-fx-font-weight:bold;");
    	XYChart.Series<String, Integer> series = new Series<String, Integer>();
    	
    	ticket_DAO.Stat_Ticket_Zone_ArrayList().forEach( a_ca -> {
    		series.getData().add(new Data<String, Integer>(a_ca.getDb().toString(),a_ca.getCount()));
    	});

    		barChart11.getData().add(series);
    		
    		/*chart ll mois*/
    		
    		barChar_Mois.getXAxis().setStyle("-fx-font-size: 17pt;-fx-font-weight:bold;");
    		barChar_Mois.getYAxis().setStyle("-fx-font-size: 17pt;-fx-font-weight:bold;");
        	XYChart.Series<String, Integer> seriesMois = new Series<String, Integer>();
        	
        	ticket_DAO.Stat_Ticket_month_array().forEach( a_ca -> {
        		seriesMois.getData().add(new Data<String, Integer>(a_ca.getDb().toString(),a_ca.getCount()));
        	});
        	Date date = new Date();
        	barChar_Mois.getData().add(seriesMois);
        	SimpleDateFormat formatter = new SimpleDateFormat("yyyy");  
        	this.label21.setVisible(true);
            this.label21.setText(formatter.format(date));


	}
	
    Tooltip tooltip1 = new Tooltip();
    Tooltip tooltip2 = new Tooltip();
    Tooltip tooltip3 = new Tooltip();

    @FXML
    private Label label11;

    @FXML
    private Label label_Anne;

	@FXML
    private BarChart<String, Integer> barChart11;
	
    @FXML
    private JFXTextField annne_txt;
    

    @FXML
    private BarChart<String, Integer> barChart_ANNNER;
    @FXML
    void onEnter(ActionEvent event) {

    	barChart_ANNNER.getXAxis().setStyle("-fx-font-size: 17pt;-fx-font-weight:bold;");
    	barChart_ANNNER.getYAxis().setStyle("-fx-font-size: 17pt;-fx-font-weight:bold;");
    	XYChart.Series<String, Integer> series3 = new Series<String, Integer>();

    	ArrayList<Ticket_String>x=ticket_DAO.findAll_Ticket_year_arrayList(Integer.parseInt(annne_txt.getText()));

    	
    	ticket_DAO.Stat_Ticket_Zone_ArrayList().forEach( a_ca -> {
    		series3.getData().add(new Data<String, Integer>(annne_txt.getText(),x.size()));
    	});

    	barChart_ANNNER.getData().add(series3);


    }
    

    @FXML
    private Label label21;


}
