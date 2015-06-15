package domainapp.dom.FichaMedica;

import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="VACUNA_ID")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@javax.jdo.annotations.Queries( {
	@javax.jdo.annotations.Query(
            name = "ListarTodos", language = "JDOQL",
            value = "SELECT "
                    + "FROM dom.simple.FichaMedica"),
    
    @javax.jdo.annotations.Query(
            name = "buscarPorNombre", language = "JDOQL",
            value = "SELECT "
                    + "FROM dom.simple.FichaMedica "
                    + "WHERE nombre.startsWith(:nombre)")
})
@javax.jdo.annotations.Unique(name="vacuna_name_UNQ", members = {"name"})


@DomainObject( objectType = "VACUNA", bounded=true)
@DomainObjectLayout( bookmarking = BookmarkPolicy.AS_CHILD)
public class Vacuna {
	
	private String vacuna;
	
	@Column(allowsNull="false")
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
