package app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TVoyageurs")
public class Voyageur implements java.io.Serializable {

	private static final long serialVersionUID = -6501314037110899206L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idVoyageur")
	private int idVoyageur;

	@Column(name = "nomVoy")
	private String nomVoy;

	@Column(name = "adresseVoy")
	private String adresseVoy;

	@Column(name = "telVoy")
	private String telVoy;

	public Voyageur() {
		super();

	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "voyageur")
	private List<Billet> billets = new ArrayList<Billet>() ;

	public int getIdVoyageur() {
		return idVoyageur;
	}

	public void setIdVoyageur(int idVoyageur) {
		this.idVoyageur = idVoyageur;
	}

	public String getNomVoy() {
		return nomVoy;
	}

	public void setNomVoy(String nomVoy) {
		this.nomVoy = nomVoy;
	}

	public String getAdresseVoy() {
		return adresseVoy;
	}

	public void setAdresseVoy(String adresseVoy) {
		this.adresseVoy = adresseVoy;
	}

	public String getTelVoy() {
		return telVoy;
	}

	public void setTelVoy(String telVoy) {
		this.telVoy = telVoy;
	}

	public List<Billet> getBillets() {
		return billets;
	}

	public void setBillets(List<Billet> billets) {
		this.billets = billets;
	}

	@Override
	public String toString() {
		String result = String.format("Voyageur [id =" + idVoyageur + ", nom =" + nomVoy + ", adresse =" + adresseVoy + ", telephone ="
				+ telVoy + "]") ; 
		if (billets != null) {
            for(Billet bill : billets) {
                result += String.format(
                        "Billet[id=%d, destination='%s']%n",
                        bill.getIdBillet(), bill.getDestinationBill());
            }
        }
		return result ; 
	}
	
	public int count(){
		return billets.size() ;
		
	}
	
}
