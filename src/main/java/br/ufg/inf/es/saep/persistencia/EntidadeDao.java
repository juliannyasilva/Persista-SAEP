/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.persistencia;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JuliannyAS
 */
public class EntidadeDao {

    private Class<Class> classePersistente;
    private DBCollection dbColecao;

    public EntidadeDao(Class<Class> classePersistente) {
        this.classePersistente = classePersistente;
        this.dbColecao
                = ConexaoMongo.getInstance()
                .getDB().getCollection(classePersistente.getSimpleName());
    }

    protected DBCollection getDbColecao() {
        return dbColecao;
    }

    public void save(Map<String, Object> mapEntity) {
        BasicDBObject document = new BasicDBObject(mapEntity);

        dbColecao.save(document);

        System.out.println("Save :> " + document);
    }

    public void update(Map<String, Object> mapQuery,
            Map<String, Object> mapEntity) {
        BasicDBObject query = new BasicDBObject(mapQuery);

        BasicDBObject entity = new BasicDBObject(mapEntity);

        dbColecao.update(query, entity);
    }

    public void delete(Map<String, Object> mapEntity) {
        BasicDBObject entity = new BasicDBObject(mapEntity);

        dbColecao.remove(entity);
    }

    public DBObject findOne(Map<String, Object> mapEntity) {
        BasicDBObject query = new BasicDBObject(mapEntity);

        return dbColecao.findOne(query);
    }

    public List<DBObject> findAll() {
        List<DBObject> list = new ArrayList<DBObject>();

        DBCursor cursor = dbColecao.find();

        while (cursor.hasNext()) {
            list.add(cursor.next());
        }

        return list;
    }

    public List<DBObject> findKeyValue(Map<String, Object> keyValue) {
        List<DBObject> list = new ArrayList<DBObject>();

        DBCursor cursor = dbColecao.find(new BasicDBObject(keyValue));

        while (cursor.hasNext()) {
            list.add(cursor.next());
        }

        return list;
    }
    
}
