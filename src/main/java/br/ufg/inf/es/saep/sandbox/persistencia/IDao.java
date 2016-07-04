package br.ufg.inf.es.saep.sandbox.persistencia;

/**
 * Created by JuliannyAS on 03/07/2016.
 */

import com.mongodb.DBObject;
import com.sun.javafx.collections.MappingChange;
import java.util.Map;
import java.util.List;

public interface IDao {
    void save(MappingChange.Map<String, Object> mapEntity);

    void update(Map<String, Object> mapQuery, Map<String, Object> mapEntity);

    void delete(Map<String, Object> mapEntity);

    DBObject findOne(Map<String, Object> mapEntity);

    List<DBObject> findAll();

    List<DBObject> findKeyValue(Map<String, Object> keyValue);
}
