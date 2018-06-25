package app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TBillets")
public class Billet implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idBillet")
	private int idBillet;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "dateDepart")
	private Date dateDepart;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "dateArrivee")
	private Date dateArrivee;

	@Column(name = "prixBill")
	private double prixBill;

	@Column(name = "dureeBill")
	private double dureeBill;

	@Column(name = "destinationBill")
	private String destinationBill;

	@ManyToOne
	private Voyageur voyageur;

	public int getIdBillet() {
		return idBillet;
	}

	public void setIdBillet(int idBillet) {
		this.idBillet = idBillet;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public double getPrixBill() {
		return prixBill;
	}

	public void setPrixBill(double prixBill) {
		this.prixBill = prixBill;
	}

	public double getDureeBill() {
		return dureeBill;
	}

	public void setDureeBill(double dureeBill) {
		this.dureeBill = dureeBill;
	}

	public String getDestinationBill() {
		return destinationBill;
	}

	public void setDestinationBill(String destinationBill) {
		this.destinationBill = destinationBill;
	}

	public Voyageur getVoyageur() {
		return voyageur;
	}

	public void setVoyageur(Voyageur voyageur) {
		this.voyageur = voyageur;
	}

	@Override
	public String toString() {
		return "Billet [id =" + idBillet + ", dateDepart =" + dateDepart + ", dateArrivee =" + dateArrivee + ", duree ="
				+ dureeBill + ", prix =" + prixBill + ", destination=" + destinationBill + "]";
	}

}
