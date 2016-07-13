package br.ufg.inf.es.saep.persistencia;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import br.ufg.inf.es.saep.dominio.Resolucao;
import br.ufg.inf.es.saep.dominio.Tipo;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JuliannyAS
 */
public class DaoResolucao{
    
    Mongo mongo = new Mongo();
    Gson gson = new Gson();

    
    
    public Resolucao mostrarPorId(String idResolucao) {
        
        return resolucao;
    }

    public boolean salvarResolucao(Resolucao resolucao) {

        if (mapResolucao != null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean removerResolucao(String idResolucao) {

    }

    public List<String> mostrarTodosPorId() {

    }

    public void salvarTipo(Tipo tipo) {

    }

    public void removerTipo(String codigo) {
        
    }

    public Tipo mostrarTipoPorId(String id) {
        String json = findOne(id);
        Tipo tipo = gson.fromJson(json, Tipo.class);
        return tipo;
    }

    public List<Tipo> mostrarTiposPorNome(String nome) {
        
    }

    public DBCollection getDbCollectionResolucao() {
        
    }
    
     public DBCollection getDbCollectionTipo() {
        
     }
}
