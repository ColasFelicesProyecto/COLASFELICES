package domainapp.dom.modules.simple;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;


@PersistenceCapable
public class Egreso {
	
	private Date fecha;
	@Persistent
	@MemberOrder(sequence = "1")
	@javax.jdo.annotations.Column(allowsNull="true")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	private E_Motivo motivo;
	@Persistent
	@MemberOrder(sequence = "2")
	@javax.jdo.annotations.Column(allowsNull="true")
	public E_Motivo getMotivo() {
		return motivo;
	}
	public void setMotivo(E_Motivo motivo) {
		this.motivo = motivo;
	}
	
	
	
	private String detalles;
	@Persistent
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Column(allowsNull="true")
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}




	public enum E_Motivo{
		ADOPCION,FALLECIMIENTO;
	}
}
