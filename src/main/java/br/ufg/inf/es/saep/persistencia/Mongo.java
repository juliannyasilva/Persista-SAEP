package br.ufg.inf.es.saep.persistencia;

import br.ufg.inf.es.saep.dominio.Resolucao;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author JuliannyAS
 */
public class Mongo {

    String databaseName = "test";
    MongoClient mongoClient = new MongoClient();
    MongoDatabase db = mongoClient.getDatabase(databaseName);

    public void insert(String document, String dbCollection) {
        db.getCollection(dbCollection).insertOne(Document.parse(document));
    }
    
     public void delete(String key, String value, String dbCollection) {
        db.getCollection(dbCollection).deleteOne(new Document(key, value));
    }
     
     public void find(String key, String  value, String dbCollection){
          db.getCollection(dbCollection).find(new Document(key, value));
     }
     
     public void deleteField(String key, String value, String dbCollection) {
        db.getCollection(dbCollection).findOneAndDelete(new Document(key, value));
    }
     
    Document findDocument(String key, String value, String dbCollection) {
       Document document = db.getCollection(dbCollection).find(new Document(key, value)).first();
       return document;
    }
}
