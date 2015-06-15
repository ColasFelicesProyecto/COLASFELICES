package domainapp.dom.FichaMedica;

import java.util.Date;
import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.query.QueryDefault;

import domainapp.dom.Perro.Perro;

@DomainService(repositoryFor = Vacuna.class)
@DomainServiceLayout(menuOrder = "30.1", named="Ficha Medica")
public class RepoVacuna {
    @MemberOrder(sequence = "1")
	public Vacuna agregarVacuna(
		   final @ParameterLayout(named="vacuna")String vac,
		   final @ParameterLayout(named="FechaColocacion") Date fechaColocacion,
	       final @ParameterLayout(named="FechaProxima") Date fechaProxima){
		   
	       final Vacuna vacuna = container.newTransientInstance(Vacuna.class);
		   vacuna.setVacuna(vac);
		   vacuna.setFechaColocacion(fechaColocacion);
		   vacuna.setFechaProxima(fechaProxima);
	container.persistIfNotAlready(vacuna);
    return vacuna;
}
    @MemberOrder(sequence = "2")
    public List<Vacuna> buscarPorVacuna(@ParameterLayout(named="nombre") final String nombre){
        return container.allMatches(new QueryDefault<>(Vacuna.class,"BuscarPorNombre","nombre", nombre));
    }

 	@MemberOrder(sequence = "3")
    public List<Vacuna> listarTodos(){
        return container.allInstances(Vacuna.class);
    }

    
    
    @javax.inject.Inject 
    DomainObjectContainer container;
    

}
