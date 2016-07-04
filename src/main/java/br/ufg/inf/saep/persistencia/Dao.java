/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.saep.persistencia;

import com.mongodb.DBObject;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JuliannyAS
 */
public interface Dao {

    void save(Map<String, Object> mapEntity);

    void update(Map<String, Object> mapQuery, Map<String, Object> mapEntity);

    void delete(Map<String, Object> mapEntity);

    DBObject findOne(Map<String, Object> mapEntity);

    List<DBObject> findAll();

}
