package domainapp.dom.modules.simple;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.util.ObjectContracts;


@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@javax.jdo.annotations.Queries( {
    @javax.jdo.annotations.Query(
            name = "findByRaza", language = "JDOQL",
            value = "SELECT "
                    + "FROM dom.simple.FichaMedica "
                    + "WHERE raza.startsWith(:raza)"),
    @javax.jdo.annotations.Query(
            name = "findByTamaño", language = "JDOQL",
            value = "SELECT "
                    + "FROM dom.simple.FichaMedica "
                    + "WHERE tamaño.startsWith(:tamaño)"),
    @javax.jdo.annotations.Query(
            name = "findBySexo", language = "JDOQL",
            value = "SELECT "
                    + "FROM dom.simple.FichaMedica "
                    + "WHERE sexo.startsWith(:sexo)"),
    @javax.jdo.annotations.Query(
            name = "findByCatracion", language = "JDOQL",
            value = "SELECT "
                    + "FROM dom.simple.FichaMedica "
                    + "WHERE castracion.startsWith(:castracion)")
})
public class FichaMedica implements Comparable<FichaMedica>{
	
	
	// Raza (property)
	private E_raza raza; 
	@Persistent
	@MemberOrder(sequence = "1")
	@javax.jdo.annotations.Column(allowsNull="false")
	public E_raza getRaza() {
		return raza;
	}
	public void setRaza(E_raza raza) {
		this.raza = raza;
	}
	
	
	// Tamaño (property)
	private E_tamaño tamaño;
	
	@Persistent
	@MemberOrder(sequence = "2")
	@javax.jdo.annotations.Column(allowsNull="false")
	public E_tamaño getTamaño() {
		return tamaño;
	}
	public void setTamaño(E_tamaño tamaño) {
		this.tamaño = tamaño;
	}
	
	
	// Sexo (property)
	private E_sexo sexo;
	@Persistent
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Column(allowsNull="false")
	public E_sexo getSexo() {
		return sexo;
	}
	public void setSexo(E_sexo sexo) {
		this.sexo = sexo;
	}
	
	
	// Tratamiento (property)
	private Tratamiento tratamiento;
	@Persistent
	@MemberOrder(sequence = "4")
	@javax.jdo.annotations.Column(allowsNull="false")
	public Tratamiento getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	
	// Catracion (property)
	private String castracion;
	@Persistent
	@MemberOrder(sequence = "5")
	@javax.jdo.annotations.Column(allowsNull="true")
	public String getCastracion() {
		return castracion;
	}
	public void setCastracion(String castracion) {
		this.castracion = castracion;
	}

	
	// Vacuna (property)
	private E_vacuna vacuna;
	@Persistent
	@MemberOrder(sequence = "6")
	@javax.jdo.annotations.Column(allowsNull="false")
	public E_vacuna getVacuna() {
		return vacuna;
	}
	public void setVacuna(E_vacuna vacuna) {
		this.vacuna = vacuna;
	}

	
	// Color (property)
	private String color; 
	@Persistent
	@MemberOrder(sequence = "7")
	@javax.jdo.annotations.Column(allowsNull="true")
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	
	// Perro (property)
	private String perro;
	@Persistent
	@MemberOrder(sequence = "8")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getPerro() {
		return perro;
	}
	public void setPerro(String perro) {
		this.perro = perro;
	}

	public enum E_sexo {
		MACHO,HEMBRA;
	}
	
	public enum E_vacuna{
		Triple, Parvovirus,RefuerzoTriple, RefuerzoParvovirus,Rabia;
	}
	
	public enum E_tamaño{
		PEQUEÑO, MEDIANO, GRANDE;
	}
	
	public enum E_raza{
		LABRADOR, BULLDOG, DOGO,PITBULL, BOXER, CHIHUHUA, BEAGLE, PERRO, SALCHICHA, POLICIA;
	}

	@Override
	public int compareTo(FichaMedica ficha) {
		return ObjectContracts.compare(this, ficha.perro, "legajo");
	}

	
}