package domainapp.dom.Perro;

import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
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
         column="EGRESO_ID")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@javax.jdo.annotations.Queries( {
@javax.jdo.annotations.Query(
	            name = "ListarTodos", language = "JDOQL",
	            value = "SELECT "
	                    + "FROM dom.simple.Perro")

})

@DomainObject(objectType = "EGRESO", bounded=true)
@DomainObjectLayout(bookmarking = BookmarkPolicy.AS_CHILD)
public class Egreso {
	
	// FechaEgreso (property)
	private Date fechaEgreso;
	@Persistent
	@MemberOrder(sequence = "1")
	@Column(allowsNull="false")
	public Date getFechaEgreso() {
		return fechaEgreso;
	}
	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	
	// TipoEgreso (property)
	private E_tipo tipo;
	@Persistent
	@MemberOrder(sequence = "1")
	@Column(allowsNull="false")
	public E_tipo getTipo() {
		return tipo;
	}
	public void setTipo(E_tipo tipo) {
		this.tipo = tipo;
	}
	
	// Fallecimiento (property)
	private Fallecimiento fallecimiento;
	@Persistent
	@MemberOrder(sequence = "2")
	@Column(name="Fallecimiento")
	public Fallecimiento getFallecimiento() {
		return fallecimiento;
	}
	public void setFallecimiento(Fallecimiento fallecimiento) {
		this.fallecimiento = fallecimiento;
	}
	
	// Adopcion (property)
	private Adopcion adopcion;
	@Persistent
	@MemberOrder(sequence = "3")
	@Column(name="Adopcion")
	
	
	public Adopcion getAdopcion() {
		return adopcion;
	}
	public void setAdopcion(Adopcion adopcion) {
		this.adopcion = adopcion;
	}
	
	
	public enum E_tipo{
		Adopcion,Fallecimiento
	}

	@Override
	public String toString() {
		return "" + tipo + "";
	}
}
