package domainapp.dom.Perro;


import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;

@PersistenceCapable
public class Adopcion {

	// Apellido (property)
	private String apellido;
	@Persistent
	@MemberOrder(sequence = "1")
	@Column(allowsNull="true")
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	// Nombre (property)
	private String nombre;
	@Persistent
	@MemberOrder(sequence = "2")
	@Column(allowsNull="true")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Domicilio (property)
	private String domicilio;
	@Persistent
	@MemberOrder(sequence = "3")
	@Column(allowsNull="true")
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	// FechaSeguimiento (property)
	private Date fechaSeguimiento;
	@Persistent
	@MemberOrder(sequence = "4")
	@Column(allowsNull="true")
	public Date getFechaSeguimiento() {
		return fechaSeguimiento;
	}
	public void setFechaSeguimiento(Date fechaSeguimiento) {
		this.fechaSeguimiento = fechaSeguimiento;
	}
	
	// Seguimiento (property)
	private String seguimiento;
	@Persistent
	@MemberOrder(sequence = "5")
	@Column(allowsNull="true")
	public String getSeguimiento() {
		return seguimiento;
	}
	public void setSeguimiento(String seguimiento) {
		this.seguimiento = seguimiento;
	}
	

}
