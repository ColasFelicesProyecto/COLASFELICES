package domainapp.dom.FichaMedica;

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

import domainapp.dom.Perro.Perro;

@DomainService(repositoryFor = FichaMedica.class)
@DomainServiceLayout(menuOrder = "30",named="Ficha Medica")
public class RepoFichaMedica  {
	
    
    @MemberOrder(sequence = "1.1")
    public FichaMedica crearFichaMedica(
    	final @ParameterLayout(named="Perro.Nombre") Perro perro,
    	final @ParameterLayout(named="Tratamiento") Tratamiento tratamiento,
    	final @Parameter(optionality = Optionality.OPTIONAL)@ParameterLayout(named="Castracion") String castracion)
    {
        final FichaMedica obj = container.newTransientInstance(FichaMedica.class);
        
        obj.setPerro(perro);
        obj.setTratamiento(tratamiento);
        obj.setCastracion(castracion);
        
        container.persistIfNotAlready(obj);
        return obj;
   

	}
    
    @MemberOrder(sequence = "1.2")
	   public Tratamiento crearTratamiento(
			   final @ParameterLayout(named="Tratamiento") String tratamiento,
		       final @ParameterLayout(named="FechaInicio") Date fechaInicio,
		       final @ParameterLayout(named="FechaTermino") Date fechaTermino,
		       final @ParameterLayout(named="Costo") Double costo,
		       final@Parameter(optionality = Optionality.OPTIONAL) @ParameterLayout(named="Observaciones") String observaciones
		    	)
	   {
		 		final Tratamiento tratamient= container.newTransientInstance(Tratamiento.class);
		    	tratamient.setTratamiento(tratamiento);
		    	tratamient.setFechaInicio(fechaInicio);
		    	tratamient.setFechaTermino(fechaTermino);
		    	tratamient.setCosto(costo);
		    	tratamient.setObservaciones(observaciones);
		    	container.persistIfNotAlready(tratamient);
		        return tratamient;
		        
		    	} 
	
    
    @javax.inject.Inject 
    DomainObjectContainer container;
}