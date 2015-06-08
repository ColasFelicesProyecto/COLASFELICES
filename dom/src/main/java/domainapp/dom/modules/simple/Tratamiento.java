package domainapp.dom.modules.simple;

import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;


@PersistenceCapable
public class Tratamiento {
		
	
	    // Descripcion(property)
		private  String descripcion;
		@Persistent
		@MemberOrder(sequence = "1")
		@Column(allowsNull="false")
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		
		
		// FechaInicio (property)
		private Date fechaInicio;
		@Persistent
		@MemberOrder(sequence = "2")
		@Column(allowsNull="false")
		public Date getFechaInicio() {
			return fechaInicio;
		}
		public void setFechaInicio(Date fechaInicio) {
			this.fechaInicio = fechaInicio;
		}
		
		
		// FechaTermino (property)
		private Date fechaTermino;
		@Persistent
		@MemberOrder(sequence = "3")
		@Column(allowsNull="false")
		public Date getFechaTermino() {
			return fechaTermino;
		}
		public void setFechaTermino(Date fechaTermino) {
			this.fechaTermino = fechaTermino;
		}
		

		// Costo(property)
		private Double costo;
		@Persistent
		@MemberOrder(sequence = "4")
		@Column(allowsNull="false")
		public Double getCosto() {
			return costo;
		}
		public void setCosto(Double costo) {
			this.costo = costo;
		}
		
		
		// Observaciones(property)
		private String observaciones;
		@Persistent
		@MemberOrder(sequence = "5")
		@Column(allowsNull="true")
		public String getObservaciones() {
			return observaciones;
		}
		public void setObservaciones(String observaciones) {
			this.observaciones = observaciones;
		}
		
		
		
		
	}
