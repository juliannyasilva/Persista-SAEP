package br.ufg.inf.es.saep.persistencia;
import br.ufg.inf.es.saep.sandbox.dominio.Resolucao;
import br.ufg.inf.es.saep.sandbox.dominio.ResolucaoRepository;
import br.ufg.inf.es.saep.sandbox.dominio.Tipo;
import java.util.List;

/**
 *
 * @author JuliannyAS
 */
public class IResolucaoRepository implements ResolucaoRepository{

    @Override
    public Resolucao byId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String persiste(Resolucao resolucao) {
        return "";
    }

    @Override
    public boolean remove(String identificador) {
       return false;
    }

    @Override
    public List<String> resolucoes() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void persisteTipo(Tipo tipo) {
        
    }

    @Override
    public void removeTipo(String codigo) {
       
    }

    @Override
    public Tipo tipoPeloCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Tipo> tiposPeloNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
