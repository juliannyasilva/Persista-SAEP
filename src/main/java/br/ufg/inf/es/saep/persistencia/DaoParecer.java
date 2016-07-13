package br.ufg.inf.es.saep.persistencia;

import com.mongodb.DBCollection;
import br.ufg.inf.es.saep.dominio.Avaliavel;
import br.ufg.inf.es.saep.dominio.Nota;
import br.ufg.inf.es.saep.dominio.Parecer;
import br.ufg.inf.es.saep.dominio.Radoc;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author JuliannyAS
 */
public class DaoParecer {

    private Mongo mongo = new Mongo();
    private Gson gson = new Gson();
    private String collectionParecer = "parecer";
    private String collectionRadoc = "radoc";
    

    public Parecer mostrarPorId(String idParecer) {

    }

    public void removerNota(String idParecer, Parecer parecer, Avaliavel original) {
        mongo.d
    }

    public void adicionarNota(String idParecer, Parecer parecer, Nota nota) {

    }

    public Parecer mostrarPorParecer(Parecer parecer) {

    }

    public void salvarParecer(Parecer parecer) {
        mongo.insert(gson.toJson(parecer), collectionParecer);
    }

    public void atualizarFundamentacao(String idParecer, Parecer parecer, String fundamentacao) {

    }

    public void removerParecer(String id) {
        mongo.delete("id", id, "parecer");
    }

    public Radoc mostrarRadocPorId(String idRadoc) {

    }

    public String salvarRadoc(Radoc radoc) {

    }

    public Boolean removerRadoc(String idRadoc) {

    }

    public DBCollection getDbCollectionParecer() {

    }

    public DBCollection getDbCollectionRadoc() {

    }

}
