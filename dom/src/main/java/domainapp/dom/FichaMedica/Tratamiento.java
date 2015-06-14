package domainapp.dom.FichaMedica;

import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;



@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
    strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
     column="TRATAMIENTO_ID")
@javax.jdo.annotations.Version(
    strategy=VersionStrategy.VERSION_NUMBER, 
    column="version")
@javax.jdo.annotations.Queries( {
@javax.jdo.annotations.Query(
	            name = "ListarTodos", language = "JDOQL",
	            value = "SELECT "
	                    + "FROM dom.simple.FichaMedica"),

})
@DomainObject(objectType = "TRATAMIENTO", bounded=true)
@DomainObjectLayout(bookmarking = BookmarkPolicy.AS_ROOT)
public class Tratamiento {
	
	    // Descripcion(property)
		private  String tratamiento;
		@Persistent
		@MemberOrder(sequence = "1")
		@Column(allowsNull="false")
		public String getTratamiento() {
			return tratamiento;
		}
		public void setTratamiento(String tratamiento) {
			this.tratamiento = tratamiento;
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
		public Tratamiento(String tratamiento, Date fechaInicio,
				Date fechaTermino, Double costo, String observaciones) {
			super();
			this.tratamiento = tratamiento;
			this.fechaInicio = fechaInicio;
			this.fechaTermino = fechaTermino;
			this.costo = costo;
			this.observaciones = observaciones;
		}
		public Tratamiento() {
			super();
		}
		@Override
		public String toString() {
			return "" + tratamiento + "]";
		}
		
		
		
		
	}
