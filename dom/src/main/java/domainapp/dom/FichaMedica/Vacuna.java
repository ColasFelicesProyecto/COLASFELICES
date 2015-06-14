package domainapp.dom.FichaMedica;

import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;

@PersistenceCapable
public class Vacuna {
	
	@Column(allowsNull="false")
	private String vacuna;
	
	
	@MemberOrder(sequence = "1")
	public String getVacuna() {
		return vacuna;
	}

	public void setVacuna(String vacuna) {
		this.vacuna = vacuna;
	}


	private Date fechaColocacion;
	@Persistent
	@MemberOrder(sequence = "2")
	@Column(allowsNull="false")
	public Date getFechaColocacion() {
		return fechaColocacion;
	}
	public void setFechaColocacion(Date fechaColocacion) {
		this.fechaColocacion = fechaColocacion;
	}

	
	private Date fechaProxima;
	
	@Persistent
	@MemberOrder(sequence = "3")
	@Column(allowsNull="false")
	public Date getFechaProxima() {
		return fechaProxima;
	}


	public void setFechaProxima(Date fechaProxima) {
		this.fechaProxima = fechaProxima;
	}

	
}
