package domainapp.dom.Perro;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.query.QueryDefault;

import domainapp.dom.Perro.Perro.E_tamaño;



@DomainService(repositoryFor = Perro.class)
@DomainServiceLayout(menuOrder = "20", named="Perro")
public class RepoPerro {
	
   @MemberOrder(sequence = "1")
   public Perro crearPerro(
		   // final @ParameterLayout(named="Legajo")int legajo,
	    	final @ParameterLayout(named="Nombre")@Parameter(regexPattern="[A-Za-z]+") String nombre,
	    	final @ParameterLayout(named="Edad") @Parameter(regexPattern="/d{5}")  int edad,
	    	final @Parameter(optionality = Optionality.OPTIONAL,regexPattern="[A-Za-z]+") @ParameterLayout(named="Color") String color,
	    	final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Raza") Raza raza,
	    	final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Tamaño") E_tamaño tamaño,
	    	final @ParameterLayout(named="Direccion") String direccion ,
	    	final @ParameterLayout(named="Barrio") String barrio,
	    	final @Parameter(optionality = Optionality.OPTIONAL,regexPattern="[A-Za-z]+") @ParameterLayout(named="DiagnosticoPresuntivo") String diagnosticoPresuntivo,
	    	final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Egreso") Egreso egreso
	    	)
   {
	    	final Perro perro = container.newTransientInstance(Perro.class);
	    //	perro.setLegajo(legajo);
	    	perro.setNombre(nombre);
	    	perro.setColor(color);
	    	perro.setBarrio(barrio);
	    	perro.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
	    	perro.setEdad(edad);
	    	perro.setDireccion(direccion);
	    	perro.setRaza(raza);
	    	perro.setBarrio(barrio);
	    	perro.setEgreso(egreso);
	    	
	    	container.persistIfNotAlready(perro);
	        return perro;
	        
	    	} 
   @MemberOrder(sequence = "2")
   public List<Perro> buscarPorNombre(@ParameterLayout(named="nombre") final String nombre){
       return container.allMatches(new QueryDefault<>(Perro.class,"BuscarPorNombre","nombre", nombre));
   }

	@MemberOrder(sequence = "4")
   public List<Perro> listarTodos(){
       return container.allInstances(Perro.class);
   }

	@MemberOrder(sequence = "3")
   public List<Perro> buscarPorLegajo(@ParameterLayout(named="Legajo")final int legajo){
       return container.allMatches(new QueryDefault<>(Perro.class,"BuscarPorLegajo","legajo", legajo));
   }
    

	 @javax.inject.Inject 
	    DomainObjectContainer container;
	    

}
