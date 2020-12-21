package metro.model;

public class Arret_String {

		private  String Num_arret;
		private  String Nom_arret;
		
		private String Nom_ligne;
		private String Nom_zonne;
		private String Nom_station;
		
		
		
		public Arret_String() {
			
		}
		
		public Arret_String(String num_arret, String nom_arret, String nom_ligne, String nom_zonne, String nom_station) {
		
			Num_arret = num_arret;
			Nom_arret = nom_arret;
			Nom_ligne = nom_ligne;
			Nom_zonne = nom_zonne;
			Nom_station = nom_station;
		}
		public String getNum_arret() {
			return Num_arret;
		}
		public void setNum_arret(String num_arret) {
			Num_arret = num_arret;
		}
		public String getNom_arret() {
			return Nom_arret;
		}
		public void setNom_arret(String nom_arret) {
			Nom_arret = nom_arret;
		}
		public String getNom_ligne() {
			return Nom_ligne;
		}
		public void setNom_ligne(String nom_ligne) {
			Nom_ligne = nom_ligne;
		}
		public String getNom_zonne() {
			return Nom_zonne;
		}
		public void setNom_zonne(String nom_zonne) {
			Nom_zonne = nom_zonne;
		}
		public String getNom_station() {
			return Nom_station;
		}
		public void setNom_station(String nom_station) {
			Nom_station = nom_station;
		}
		
		
		
		
	}
