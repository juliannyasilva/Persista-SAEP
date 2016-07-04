package br.ufg.inf.es.saep.sandbox.persistencia;

/**
 * Created by JuliannyAS on 03/07/2016.
 */
import com.mongodb.DB;
import com.mongodb.Mongo;
import java.net.UnknownHostException;

public class ConexaoMongo {
    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DB_NAME = "simple-mongodb";

    private static MongoConnection uniqInstance;
    private static int mongoInstance = 1;

    private Mongo mongo;
    private DB db;

    private ConexaoMongo() {

    }

    public static synchronized MongoConnection getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new MongoConnection();
        }
        return uniqInstance;
    }

    public DB getDB() {
        if (mongo == null) {
            try {
                mongo = new Mongo(HOST, PORT);
                db = mongo.getDB(DB_NAME);
                System.out.println("Mongo instance equals :> " + mongoInstance++);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return db;
    }
}
