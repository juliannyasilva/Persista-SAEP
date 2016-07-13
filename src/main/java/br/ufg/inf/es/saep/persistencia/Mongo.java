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

    public void insert(String document, Class<Resolucao> aClass) {
        db.getCollection(aClass.getSimpleName()).insertOne(Document.parse(document));
    }
    
     public void delete(String idDocument, Class<Resolucao> aClass) {
        db.getCollection(aClass.getSimpleName()).deleteOne(new Document("id", idDocument));
    }
     
     public void find(String idDocument, Class<Resolucao> aClass){
          db.getCollection(aClass.getSimpleName()).
     }
    

 
}
