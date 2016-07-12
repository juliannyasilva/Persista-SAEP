package persistencia.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import dominio.Parecer;
import dominio.Radoc;
import dominio.Resolucao;
import dominio.Tipo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JuliannyAS
 */
public class OperacoesMongo {

    public DBCollection getDbCollectionParecer() {
        DBCollection dbCollection = MongoConnection.getInstance().getDB().getCollection(Parecer.class.getSimpleName());
        return dbCollection;
    }

    public DBCollection getDbCollectionResolucao() {
        DBCollection dbCollection = MongoConnection.getInstance().getDB().getCollection(Resolucao.class.getSimpleName());
        return dbCollection;

    }
    
    public DBCollection getDbCollectionRadoc() {
        DBCollection dbCollection = MongoConnection.getInstance().getDB().getCollection(Radoc.class.getSimpleName());
        return dbCollection;

    }
    
    public DBCollection getDbCollectionTipo() {
        DBCollection dbCollection = MongoConnection.getInstance().getDB().getCollection(Tipo.class.getSimpleName());
        return dbCollection;

    }

    public void save(Map<String, Object> mapEntity, DBCollection dbCollection) {
        BasicDBObject document = new BasicDBObject(mapEntity);

        dbCollection.save(document);

        System.out.println("Save :> " + document);
    }

    public void update(Map<String, Object> mapQuery, Map<String, Object> mapEntity, DBCollection dbCollection) {
        BasicDBObject query = new BasicDBObject(mapQuery);

        BasicDBObject entity = new BasicDBObject(mapEntity);

        dbCollection.update(query, entity);
    }

    public void delete(Map<String, Object> mapEntity, DBCollection dbCollection) {
        BasicDBObject entity = new BasicDBObject(mapEntity);

        dbCollection.remove(entity);
    }

    public DBObject findOne(Map<String, Object> mapEntity, DBCollection dbCollection) {
        BasicDBObject query = new BasicDBObject(mapEntity);

        return dbCollection.findOne(query);
    }

    public List<DBObject> findAll(DBCollection dbCollection) {
        List<DBObject> list = new ArrayList<DBObject>();

        DBCursor cursor = dbCollection.find();

        while (cursor.hasNext()) {
            list.add(cursor.next());
        }

        return list;
    }

    public List<DBObject> findLisKeyValue(Map<String, Object> keyValue, DBCollection dbCollection) {
        List<DBObject> list = new ArrayList<DBObject>();

        DBCursor cursor = dbCollection.find(new BasicDBObject(keyValue));

        while (cursor.hasNext()) {
            list.add(cursor.next());
        }

        return list;
    }    
}
