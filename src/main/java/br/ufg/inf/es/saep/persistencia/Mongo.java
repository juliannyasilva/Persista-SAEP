package br.ufg.inf.es.saep.persistencia;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import static java.util.regex.Pattern.compile;
import org.bson.Document;

/**
 *
 * @author JuliannyAS
 */
public class Mongo {

    String databaseName = "test";
    MongoClient mongoClient = new MongoClient();
    MongoDatabase db = mongoClient.getDatabase(databaseName);

    /**
     * Insere um json no banco de dados mongodb
     *
     * @param json a ser gravado no banco
     * @param dbCollection nome da coleção que ira armazenar o json
     */
    public void insert(String json, String dbCollection) {
        db.getCollection(dbCollection).insertOne(Document.parse(json));
    }

    /**
     * Busca por um json no banco de dados mongodb atraves de seu identificador
     *
     * @param key nome que identifica o valor passado como parametro de busca
     * @param value valor identificador do json a ser buscado
     * @param dbCollection coleção no qual esta armazenado o json
     */
    public void search(String key, String value, String dbCollection) {
        db.getCollection(dbCollection).find(new Document(key, value));
    }

    /**
     * Busca um json atraves de seu identificador e deleta o mesmo do banco de
     * dados mongodb
     *
     * @param key nome que identifica o valor passado como parametro de busca e
     * remoção
     * @param value valor identificador do json a ser buscado e removido
     * @param dbCollection coleção no qual esta armazenado o json
     */
    public void delete(String key, String value, String dbCollection) {
        db.getCollection(dbCollection).findOneAndDelete(new Document(key, value));
    }

    /**
     * Busca um json no banco de dados mongodb e retorna seus dados.
     *
     * @param key nome que identifica o valor passado como parametro para a
     * busca
     * @param value valor identificador do json a ser buscado
     * @param dbCollection coleção no qual esta armazenado o json
     * @return json retorna a string referente ao json encontrado
     */
    public String findOne(String key, String value, String dbCollection) {
        String json = db.getCollection(dbCollection).find(new Document(key, value)).toString();
        return json;
    }

    /**
     * Retorna uma lista de jsons armazenados dentro de uma coleção no banco de
     * dados mongodb
     *
     * @param dbCollection coleção que armazena os jsons
     * @return lista tipo string com os jsons armaezanos
     */
    public List<String> findAll(String dbCollection) {
        List<String> listResult = new ArrayList<>();
        for (Document json : db.getCollection(dbCollection).find()) {
            listResult.add(json.toString());
        }
        return listResult;
    }
    
    public Iterable<Document> findMany(String key, String value, String dbCollection) {
        FindIterable<Document> listJson = db.getCollection(dbCollection).find(new Document(key, compile(value)));      
        return listJson;
    }
}
