package domainapp.dom.modules.simple;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;



@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
    strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
     column="id")
@javax.jdo.annotations.Version(
    strategy=VersionStrategy.VERSION_NUMBER, 
    column="version")
@javax.jdo.annotations.Queries( {
@javax.jdo.annotations.Query(
        name = "findByLegajo", language = "JDOQL",
        value = "SELECT "
                + "FROM dom.simple.Perro "
                + "WHERE nombre.startsWith(:nombre)"),

})
@javax.jdo.annotations.Unique(name="Perro_name_UNQ", members = {"name"})
@DomainObject(
        objectType = "Perro"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class Perro {
	
	private int legajo;
	
	@PrimaryKey
	@Persistent(valueStrategy= IdGeneratorStrategy.SEQUENCE)
	@MemberOrder(sequence = "1")
	@javax.jdo.annotations.Column(allowsNull="false")
	
    public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	
	private String nombre;
	
	@Persistent
	@MemberOrder(sequence = "2")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	private int edad;
	
	@Persistent
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Column(allowsNull="true")
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	private String color;
	
	@Persistent
	@MemberOrder(sequence = "4")
	@javax.jdo.annotations.Column(allowsNull="true")
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	private E_raza raza;
	
	@Persistent
	@MemberOrder(sequence = "5")
	@javax.jdo.annotations.Column(allowsNull="true")
	public E_raza getRaza() {
		return raza;
	}
	public void setRaza(E_raza raza) {
		this.raza = raza;
	}
	
	
	private E_tamaño tamaño;
	
	@Persistent
	@MemberOrder(sequence = "6")
	@javax.jdo.annotations.Column(allowsNull="true")
	public E_tamaño getTamaño() {
		return tamaño;
	}
	public void setTamaño(E_tamaño tamaño) {
		this.tamaño = tamaño;
	}
	
	
	private String direccion;
	
	@Persistent
	@MemberOrder(sequence = "7")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	private String barrio;
	
	@Persistent
	@MemberOrder(sequence = "8")
	@javax.jdo.annotations.Column(allowsNull="false")
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	
	
	private String diagnosticoPresuntivo;
	
	@Persistent
	@MemberOrder(sequence = "9")
	@javax.jdo.annotations.Column(allowsNull="true")
	public String getDiagnosticoPresuntivo() {
		return diagnosticoPresuntivo;
	}
	public void setDiagnosticoPresuntivo(String diagnosticoPresuntivo) {
		this.diagnosticoPresuntivo = diagnosticoPresuntivo;
	}
	
	
	private Egreso egreso;
	
	@Persistent
	@MemberOrder(sequence = "10")
	@javax.jdo.annotations.Column(allowsNull="true")
	public Egreso getEgreso() {
		return egreso;
	}
	public void setEgreso(Egreso egreso) {
		this.egreso = egreso;
	}
	
	
	private FichaMedica fichaMedica;
	
	@Persistent
	@MemberOrder(sequence = "11")
	@javax.jdo.annotations.Column(allowsNull="true")
	public FichaMedica getFichaMedica() {
		return fichaMedica;
	}
	public void setFichaMedica(FichaMedica fichaMedica) {
		this.fichaMedica = fichaMedica;
	}
	
    private List<Perro> listaPerro= new ArrayList<Perro>();
    
    @Persistent
	@MemberOrder(sequence = "12")
	@javax.jdo.annotations.Column(allowsNull="true")
	public List<Perro> getListaPerro() {
		return listaPerro;
	}
	public void setListaPerro(List<Perro> listaPerro) {
		this.listaPerro = listaPerro;
	}
	public enum E_tamaño{
		PEQUEÑO,MEDIANO,GRANDE;
	}
	public enum E_raza{
		PITBULL,DOGO,LABRADOR,OBEJERO, CRUZA;
	}
}
