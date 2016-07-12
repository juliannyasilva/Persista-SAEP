package persistencia.conversores;

import com.mongodb.DBObject;
import dominio.Resolucao;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JuliannyAS
 */
public class Conversor {

     public Map<String, Object> converterResolucaoToMap(Resolucao resolucao) {
        Map<String, Object> mapResolucao = new HashMap<String, Object>();
        mapResolucao.put("id", resolucao.getId());
        mapResolucao.put("nome", resolucao.getNome());
        mapResolucao.put("dataAprovacao", resolucao.getDataAprovacao());
        mapResolucao.put("regras", resolucao.getRegras());
        mapResolucao.put("descricao", resolucao.getDescricao());

        return mapResolucao;
    }

    public Resolucao converterDBObjectToResolucao(DBObject dbResolucao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
