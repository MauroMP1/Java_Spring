package net.registro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facturas")
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private Integer idFactura;
	private Double importe;
	private String dateI;
	private String dateV;
	private String numFact;
	
	

	public Integer getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public String getDateI() {
		return dateI;
	}
	public void setDateI(String dateI) {
		this.dateI = dateI;
	}
	public String getDateV() {
		return dateV;
	}
	public void setDateV(String dateV) {
		this.dateV = dateV;
	}
	public String getNumFact() {
		return numFact;
	}
	public void setNumFact(String numFact) {
		this.numFact = numFact;
	}
	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", importe=" + importe + ", dateE=" + dateI + ", dateV=" + dateV + ", numFact="
				+ numFact + "]";
	}
	
	
	
	
	

}
