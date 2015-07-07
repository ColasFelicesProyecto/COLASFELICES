package domainapp.dom.modules.simple;

import java.util.Date;
import java.util.List;

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


import domainapp.dom.modules.simple.Socio.Tipo;
import domainapp.dom.modules.simple.Socio.Cuota;



@DomainService(repositoryFor = Socio.class)
@DomainServiceLayout(menuOrder = "20")
public class Socios {
	 
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "1")
    public List<Socio> listAll() {
        return container.allInstances(Socio.class);
    }
   
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "2")
    public List<Socio> findByNumero(
            @ParameterLayout(named="Numero")
            final int numero
    ) {
        return container.allMatches(
                new QueryDefault<>(
                        Socio.class,
                        "findByNumero",
                        "Numero", numero));}
    
   public Socio crearSocio(
	    	final @ParameterLayout(named="Nombre")String nombre,
	    	final @ParameterLayout(named="Apellido")String apellido,
	    	final @ParameterLayout(named="Documento")int documento,
	    	final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Tipo") Tipo tipo,
	    	final @Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Cuota") Cuota cuota,
	    	final @ParameterLayout(named="Direccion")String direccion ,
	    	final @ParameterLayout(named="Barrio") String barrio)
   {
	    	final Socio socio = container.newTransientInstance(Socio.class);
	    	socio.setNombre(nombre);
	    	socio.setApellido(apellido);
	    	socio.setDocumento(documento);
	    	socio.setDireccion(direccion);
	    	socio.setBarrio(barrio);
	    	socio.setTipo (tipo);
	    	socio.setCuota (cuota);
	    	
	    	
	    	container.persistIfNotAlready(socio);
	        return socio;
	        
	    	} 
    

    @javax.inject.Inject 
    DomainObjectContainer container;
    

}
