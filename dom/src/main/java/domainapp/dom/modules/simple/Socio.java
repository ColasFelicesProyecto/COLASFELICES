package domainapp.dom.modules.simple;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.SequenceStrategy;
import javax.jdo.annotations.VersionStrategy;
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
        name = "findByNumero", language = "JDOQL",
        value = "SELECT "
                + "FROM dom.simple.Socio "
                + "WHERE nombre.startsWith(:nombre)"),

})


@Sequence(name = "numero", strategy = SequenceStrategy.CONTIGUOUS)
public class Socio {
	
	
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
	
	private String Apellido;
	
	@Persistent
	@MemberOrder(sequence = "3")
	@javax.jdo.annotations.Column(allowsNull="true")
	
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	private int documento;
	
	@Persistent
	@MemberOrder(sequence = "4")
	@javax.jdo.annotations.Column(allowsNull="true")
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}

	private Tipo tipo;
	
	@Persistent
	@MemberOrder(sequence = "5")
	@javax.jdo.annotations.Column(allowsNull="true")
	
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	private Cuota cuota;
	
	
	@Persistent
	@MemberOrder(sequence = "6")
	@javax.jdo.annotations.Column(allowsNull="true")
	public Cuota getCuota() {
		return cuota;
	}
	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
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
	
	
	
    private List<Socio> listaSocio= new ArrayList<Socio>();
    
    @Persistent
	@MemberOrder(sequence = "12")
	@javax.jdo.annotations.Column(allowsNull="true")
	public List<Socio> getListaSocio() {
		return listaSocio;
	}
	public void setListaSocio(List<Socio> listaSocio) {
		this.listaSocio = listaSocio;
	}
	public enum Cuota{
		MES,SEMESTRAL,ANUAL;
	}
	public enum Tipo{
		ACTIVO,COLABORADOR;
		}
}
