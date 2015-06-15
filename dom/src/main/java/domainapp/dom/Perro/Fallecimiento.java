package domainapp.dom.Perro;


import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;

@PersistenceCapable
public class Fallecimiento {
	// FechaMuerte (property)
	
	private Date fechaMuerte;
	@Persistent
	@MemberOrder(sequence = "1")
	@Column(allowsNull="true")
	
	public Date getFechaMuerte() {
		return fechaMuerte;
	}
	public void setFechaMuerte(Date fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}
	
	
	// Causa (property)
	private String causa;
	@Persistent
	@MemberOrder(sequence = "2")
	@Column(allowsNull="true")
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}

}
