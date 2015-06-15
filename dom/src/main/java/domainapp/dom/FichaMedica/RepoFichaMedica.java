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
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.query.QueryDefault;

import domainapp.dom.Perro.Perro;

@DomainService(repositoryFor = FichaMedica.class)
@DomainServiceLayout(menuOrder = "30",named="Ficha Medica")
public class RepoFichaMedica  {
	
    
    @MemberOrder(sequence = "1")
    public FichaMedica crearFichaMedica(
    	final @ParameterLayout(named="Perro.Nombre") Perro perro,
	    final @ParameterLayout(named="Tratamiento") @Parameter(regexPattern="[A-Za-z]+")String tratamient,
	    final @ParameterLayout(named="FechaInicio") Date fechaInicio,
	    final @ParameterLayout(named="FechaTermino") Date fechaTermino,
	    final @ParameterLayout(named="Costo") Double costo,
	    final@Parameter(optionality = Optionality.OPTIONAL,regexPattern="[A-Za-z]+") @ParameterLayout(named="Observaciones")String observaciones,    	
    	final @Parameter(optionality = Optionality.OPTIONAL,regexPattern="[A-Za-z]+")@ParameterLayout(named="Castracion") String castracion,
    	final @Parameter(optionality = Optionality.OPTIONAL)@ParameterLayout(named="Vacuna") Vacuna vacuna)
    {
        final FichaMedica obj = container.newTransientInstance(FichaMedica.class);
        final Tratamiento tratamiento= new Tratamiento();
    	tratamiento.setTratamiento(tratamient);
    	tratamiento.setFechaInicio(fechaInicio);
    	tratamiento.setFechaTermino(fechaTermino);
    	tratamiento.setCosto(costo);
    	tratamiento.setObservaciones(observaciones);
        
        obj.setPerro(perro);
        obj.setTratamiento(tratamiento);
        obj.setCastracion(castracion);
        obj.setVacuna(vacuna);
        
        container.persistIfNotAlready(obj);
        return obj;
   

	}
    

    
	@MemberOrder(sequence = "2")
	public List<FichaMedica> listarTodos(){
	       return container.allInstances(FichaMedica.class);
	   }

	@MemberOrder(sequence = "3")
	public List<FichaMedica> buscarPorPerro(@ParameterLayout(named="perro")final String perro){
	       return container.allMatches(new QueryDefault<>(FichaMedica.class,"BuscarPorPerro","perro", perro));
	   }
    
    @javax.inject.Inject 
    DomainObjectContainer container;
}