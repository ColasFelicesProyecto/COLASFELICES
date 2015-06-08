package domainapp.dom.modules.simple;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.query.QueryDefault;

import domainapp.dom.modules.simple.FichaMedica.E_raza;
import domainapp.dom.modules.simple.FichaMedica.E_sexo;
import domainapp.dom.modules.simple.FichaMedica.E_tamaño;
import domainapp.dom.modules.simple.FichaMedica.E_vacuna;

@DomainService(repositoryFor = FichaMedica.class)
@DomainServiceLayout(menuOrder = "10")
public class FichasMedicas  {
	
	 //region > listAll (action)
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "1")
    public List<FichaMedica> listAll() {
        return container.allInstances(FichaMedica.class);
    }
    //endregion

    //region > findByName (action)
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "2")
    public List<FichaMedica> findByName(
            @ParameterLayout(named="Sexo")
            final String name
    ) {
        return container.allMatches(
                new QueryDefault<>(
                        FichaMedica.class,
                        "findByName",
                        "Perro", name));}
    
    //endregion

    //region > create (action)
    @MemberOrder(sequence = "3")
    public FichaMedica create(
            
    	final @ParameterLayout(named="Raza") E_raza raza,
    	final @ParameterLayout(named="Color") String color,
    	final @ParameterLayout(named="Sexo") E_sexo sexo,
    	final @ParameterLayout(named="Tamaño") E_tamaño tamaño,
    	final @ParameterLayout(named="Vacuna") E_vacuna vacuna,
    	final @ParameterLayout(named="Tratamiento.Descripcion") String descripcion,
    	final @ParameterLayout(named="Tratamiento.FechaInicio") Date fechaInicio,
    	final @ParameterLayout(named="Tratamiento.FechaTermino") Date fechaTermino,
    	final @ParameterLayout(named="Tratamiento.Costo") Double costo,
    	final @ParameterLayout(named="Tratamiento.Observaciones") String observaciones,
    	final @ParameterLayout(named="Castracion") String castracion,
    	final @ParameterLayout(named="Perro") String perro)
    {
        final FichaMedica obj = container.newTransientInstance(FichaMedica.class);
        final Tratamiento tratamiento = new Tratamiento();
        
        tratamiento.setDescripcion(descripcion);
        tratamiento.setFechaInicio(fechaInicio);
        tratamiento.setFechaTermino(fechaTermino);
        tratamiento.setCosto(costo);
        tratamiento.setObservaciones(observaciones);
        
        obj.setSexo(sexo);
        obj.setColor(color);
        obj.setTamaño(tamaño);
        obj.setVacuna(vacuna);
        obj.setRaza(raza);
        obj.setCastracion(castracion);
        obj.setTratamiento(tratamiento);
        obj.setPerro(perro);
        container.persistIfNotAlready(obj);
        return obj;
   

    //endregion

    //region > injected services

    //endregion 
	}
    @javax.inject.Inject 
    DomainObjectContainer container;
}