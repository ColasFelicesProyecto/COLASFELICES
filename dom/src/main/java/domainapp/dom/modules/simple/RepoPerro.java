package domainapp.dom.modules.simple;

import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.query.QueryDefault;

import domainapp.dom.modules.simple.Egreso.E_Motivo;
import domainapp.dom.modules.simple.Perro.E_raza;
import domainapp.dom.modules.simple.Perro.E_tamaño;



@DomainService(repositoryFor = Perro.class)
@DomainServiceLayout(menuOrder = "20")
public class RepoPerro {
	 //region > listAll (action)
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "1")
    public List<Perro> listAll() {
        return container.allInstances(Perro.class);
    }
    //endregion

    //region > findByLegajo (action)
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "2")
    public List<Perro> findByLegajo(
            @ParameterLayout(named="Legajo")
            final int legajo
    ) {
        return container.allMatches(
                new QueryDefault<>(
                        Perro.class,
                        "listarPorLegajo",
                        "Legajo", legajo));}
    
    
    

   public Perro crearPerro(
		    final @ParameterLayout(named="Legajo") int legajo,
	    	final @ParameterLayout(named="Nombre")String nombre,
	    	final @ParameterLayout(named="Edad") int edad,
	    	final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Color") String color,
	    	final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Raza") E_raza raza,
	    	final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Tamaño") E_tamaño tamaño,
	    	final @ParameterLayout(named="Direccion")String direccion ,
	    	final @ParameterLayout(named="Barrio") String barrio,
	    	final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="DiagnosticoPresuntivo") String diagnosticoPresuntivo,
	    	final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Egreso.Fecha") Date egresoFecha,
	    	final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Egreso.Motivo") E_Motivo motivo,
	    	final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Egreso.Detalle") String detalle
	    	)
   {
	    	final Perro perro = container.newTransientInstance(Perro.class);
	    	perro.setLegajo(legajo);
	    	perro.setNombre(nombre);
	    	perro.setColor(color);
	    	perro.setBarrio(barrio);
	    	perro.setDiagnosticoPresuntivo(diagnosticoPresuntivo);
	    	perro.setEdad(edad);
	    	perro.setDireccion(direccion);
	    	perro.setRaza(raza);
	    	perro.setBarrio(barrio);
	    	
	    	final Egreso egreso= new Egreso();
	    	egreso.setMotivo(motivo);
	    	egreso.setFecha(egresoFecha);
	    	egreso.setDetalles(detalle);
	    	
	    	perro.setEgreso(egreso);
	    	
	    	container.persistIfNotAlready(perro);
	        return perro;
	        
	    	} 
    

    @javax.inject.Inject 
    DomainObjectContainer container;
    

}
