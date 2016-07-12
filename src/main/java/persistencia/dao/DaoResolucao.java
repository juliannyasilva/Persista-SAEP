package persistencia.dao;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import dominio.Resolucao;
import dominio.Tipo;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import persistencia.conversores.Conversor;

/**
 *
 * @author JuliannyAS
 */
public class DaoResolucao extends OperacoesMongo {

    public Resolucao mostrarPorId(String idResolucao) {

        DBObject dbResolucao = findOne(mapId, getDbCollectionResolucao());
        Resolucao resolucao = new Conversor().converterDBObjectToResolucao(dbResolucao);
        return resolucao;
    }

    public boolean salvarResolucao(Resolucao resolucao) {
        
        Map<String, Object> mapResolucao = new Conversor().converterResolucaoToMap(resolucao);
        save(mapResolucao, getDbCollectionResolucao());   
        
        if(mapResolucao != null){
            return true;
        }else{
            return false;
        }
    }

    public Boolean removerResolucao(String idResolucao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<String> mostrarTodosPorId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void salvarTipo(Tipo tipo) {

    }

    public void removerTipo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Tipo mostrarTipoPorId(String id) {
        String json = findOne(id);
        Tipo tipo = gson.fromJson(json, Tipo.class);
        return tipo;
    }

    public List<Tipo> mostrarTiposPorNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
