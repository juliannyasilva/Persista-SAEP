package br.ufg.inf.es.saep.persistencia;

import com.google.gson.Gson;
import br.ufg.inf.es.saep.dominio.Resolucao;
import br.ufg.inf.es.saep.dominio.Tipo;
import com.mongodb.DBCollection;
import java.util.List;

/**
 *
 * @author JuliannyAS
 */
public class DaoResolucao{
    
    Mongo mongo = new Mongo();
    Gson gson = new Gson();   
    
    public Resolucao mostrarPorId(String idResolucao) {
        Resolucao resolucao;
        String json = mongo.findDocument("id",idResolucao, "resolucao").toJson();
        return resolucao = gson.fromJson(json, Resolucao.class);
    }

    public boolean salvarResolucao(Resolucao resolucao) {        
        Boolean inseriu = false;
        mongo.insert(gson.toJson(resolucao), "resolucao");
        
        if (fi) {
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
        mongo.insert(gson.toJson(tipo), "resolucao");
    }

    public void removerTipo(String idTipo) {
        mongo.delete("id", idTipo, "resolucao");
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
