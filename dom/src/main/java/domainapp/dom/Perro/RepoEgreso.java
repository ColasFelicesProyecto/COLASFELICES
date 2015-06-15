package domainapp.dom.Perro;


import java.util.Date;
import java.util.List;

import javax.validation.constraintvalidation.ValidationTarget;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.events.ValidityEvent;

import domainapp.dom.FichaMedica.FichaMedica;
import domainapp.dom.Perro.Egreso.E_tipo;

@DomainService(repositoryFor = Egreso.class)
@DomainServiceLayout(menuOrder = "20.1",named="Perro")
public class RepoEgreso {
	
	 //region > create (action)
    @MemberOrder(sequence = "1")
    public Egreso crearEgreso(
    		
    		final @ParameterLayout(named="Fecha :") Date fechaEgreso,
    		final @ParameterLayout(named="Tipo :") E_tipo tipo,
    		final @ParameterLayout(named="Apellido :")@Parameter(regexPattern="[A-Za-z]+") String apellido,
    		final @Parameter(optionality=  Optionality.OPTIONAL ,regexPattern="[A-Za-z]+")@ParameterLayout(named="Nombre :") String nombre,
    		final @Parameter(optionality = Optionality.OPTIONAL)@ParameterLayout(named="Domicilio :") String domicilio,
    		final @Parameter(optionality = Optionality.OPTIONAL)@ParameterLayout(named="Fecha seguimiento") Date fecha_seguimiento,
    		final @Parameter(optionality = Optionality.OPTIONAL,regexPattern="[A-Za-z]+")@ParameterLayout(named="Detalle seguimiento") String seguimiento,
    		final @Parameter(optionality = Optionality.OPTIONAL)@ParameterLayout(named="Fecha muerto :") Date fecha_muerte,
    		final @Parameter(optionality = Optionality.OPTIONAL,regexPattern="[A-Za-z]+")@ParameterLayout(named="Causa muerte :" ) String causa_muerte
    		){
    		final Egreso obj = container.newTransientInstance(Egreso.class);
    		final Adopcion adopcion = new Adopcion();
    		final Fallecimiento fallecimiento = new Fallecimiento();
    		
    	      obj.setFechaEgreso(fechaEgreso);
    	      obj.setTipo(tipo);
    	      
    	      adopcion.setApellido(apellido);
    	      adopcion.setNombre(nombre);
    	      adopcion.setDomicilio(domicilio);
    	      adopcion.setFechaSeguimiento(fecha_seguimiento);
    	      adopcion.setSeguimiento(seguimiento);
    	      obj.setAdopcion(adopcion);
    	      
    	      
    	      fallecimiento.setFechaMuerte(fecha_muerte);
    	      fallecimiento.setCausa(causa_muerte);
    	      obj.setFallecimiento(fallecimiento);
    	      
    	      container.persistIfNotAlready(obj);
    	      return obj;
    	      
    	    //endregion

    	      //region > injected services

    	      //endregion
    }
    @MemberOrder(sequence = "2")
	public List<Egreso> listarTodos(){
	       return container.allInstances(Egreso.class);
	   }
    
    
    @javax.inject.Inject 
    DomainObjectContainer container;
    
    
}
