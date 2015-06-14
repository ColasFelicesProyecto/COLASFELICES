package domainapp.dom.Perro;


import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
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
     column="PERRO_ID")
@javax.jdo.annotations.Version(
    strategy=VersionStrategy.VERSION_NUMBER, 
    column="version")
@javax.jdo.annotations.Queries( {
@javax.jdo.annotations.Query(
	            name = "ListarTodos", language = "JDOQL",
	            value = "SELECT "
	                    + "FROM dom.simple.Perro"),
@javax.jdo.annotations.Query(
        name = "BuscarPorLegajo", language = "JDOQL",
        value = "SELECT "
                + "FROM dom.simple.Perro "
                + "WHERE legajo.startsWith(:legajo)"),
 @javax.jdo.annotations.Query(
        name = "BuscarPorNombre", language = "JDOQL",
        value = "SELECT "
                + "FROM dom.simple.Perro "
                + "WHERE nombre.startsWith(:nombre)")

})
@DomainObject(objectType = "PERRO", bounded=true)
@DomainObjectLayout(bookmarking = BookmarkPolicy.AS_ROOT)
@Sequence(name = "legajo", strategy = SequenceStrategy.CONTIGUOUS)
public class Perro {
	
	private int legajo;
	
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT, sequence = "legajo")
	//@Persistent
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
	@javax.jdo.annotations.Column(allowsNull="false")
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
		
	
	private Raza raza;
	
	@Persistent
	@MemberOrder(sequence = "5")
	@Column(allowsNull="true")
	public Raza getRaza() {
		return raza;
	}
	public void setRaza(Raza raza) {
		this.raza = raza;
	}
	
	
	private E_tamaño tamaño;
	
	@Persistent
	@MemberOrder(sequence = "6")
	@Column(allowsNull="true")
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

	
    
	public enum E_tamaño{
		PEQUEÑO,MEDIANO,GRANDE;
	}
	
	public enum E_sexo{
		MACHO,HEMBRA
	}

	@Override
	public String toString() {
		return "" + nombre + "";
	}
	public Perro(int legajo, String nombre, int edad, String color,
			E_sexo sexo, Raza raza, E_tamaño tamaño, String direccion,
			String barrio, String diagnosticoPresuntivo, Egreso egreso) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.edad = edad;
		this.color = color;
		this.sexo = sexo;
		this.raza = raza;
		this.tamaño = tamaño;
		this.direccion = direccion;
		this.barrio = barrio;
		this.diagnosticoPresuntivo = diagnosticoPresuntivo;
		this.egreso = egreso;
	}
	public Perro() {
		super();
	}
	

	
}
