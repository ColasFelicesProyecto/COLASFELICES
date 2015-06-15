package domainapp.dom.FichaMedica;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.util.ObjectContracts;

import domainapp.dom.Perro.Perro;


@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="FICHAMEDICA_ID")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@javax.jdo.annotations.Queries( {
	@javax.jdo.annotations.Query(
            name = "ListarTodos", language = "JDOQL",
            value = "SELECT "
                    + "FROM dom.simple.FichaMedica"),
    
    @javax.jdo.annotations.Query(
            name = "buscarPorPerro", language = "JDOQL",
            value = "SELECT "
                    + "FROM dom.simple.FichaMedica "
                    + "WHERE perro.startsWith(:perro)")
})
@javax.jdo.annotations.Unique(name="fichaMedica_name_UNQ", members = {"name"})


@DomainObject( objectType = "FICHAMEDICA")
@DomainObjectLayout( bookmarking = BookmarkPolicy.AS_CHILD)
public class FichaMedica{
	
	
	private Perro perro;
	
	@MemberOrder(sequence = "1")
	@Column(name="Perro")
	public Perro getPerro() {
		return perro;
	}
	public void setPerro(Perro perro) {
		this.perro = perro;
	}

	private Tratamiento tratamiento;
	@Persistent
	@MemberOrder(sequence = "2")
	@Column(allowsNull="true")
	public Tratamiento getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}

	// Catracion (property)
	private String castracion;
	@Persistent
	@MemberOrder(sequence = "3")
	@Column(allowsNull="true")
	public String getCastracion() {
		return castracion;
	}
	public void setCastracion(String castracion) {
		this.castracion = castracion;
	}


	private Vacuna vacuna;
	@Persistent
	@MemberOrder(sequence = "4")
	@Column(allowsNull="true")
	public Vacuna getVacuna() {
		return vacuna;
	}
	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}
/*	//Vacuna (property)
	private SortedSet<Vacuna> listvacuna=new TreeSet<Vacuna>();

	@MemberOrder(sequence="4")
	@Persistent(mappedBy="fichaMedica")
	@Join 
	public SortedSet<Vacuna> getListvacuna() {
		return listvacuna;
	}
	public void setListvacuna(SortedSet<Vacuna> listvacuna) {
		listvacuna = listvacuna;
	}*/

	
}