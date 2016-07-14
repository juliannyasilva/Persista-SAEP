package br.ufg.inf.es.saep.persistencia;

import com.mongodb.DBCollection;
import br.ufg.inf.es.saep.dominio.Avaliavel;
import br.ufg.inf.es.saep.dominio.Nota;
import br.ufg.inf.es.saep.dominio.Parecer;
import br.ufg.inf.es.saep.dominio.Radoc;
import com.google.gson.Gson;

/**
 *
 * @author JuliannyAS
 */
public class DaoParecer {

    private final Mongo mongo;
    private final Gson gson;
    private final String parecerCollection = "parecer";
    private final String radocCollection = "radoc";

    /**
     * Construtor que instancia as variaveis mongo e gson. Sendo a variavel
     * mongo responsavel por chamar os metodos nativos do mongodb. E a variavel
     * gson responsavel pela serialização dos objetos e documentos.
     */
    public DaoParecer() {
        this.mongo = new Mongo();
        this.gson = new Gson();
    }

    public Parecer mostrarParecerPorId(String idParecer) {
        Parecer parecer = gson.fromJson(mongo.findOne("id", idParecer, parecerCollection), Parecer.class);
        return parecer;
    }

    public void removerNota(String idParecer, Parecer parecer, Avaliavel original) {

    }

    public void adicionarNota(String idParecer, Parecer parecer, Nota nota) {

    }

    public Parecer mostrarPorParecer(Parecer parecer) {

    }

    public void salvarParecer(Parecer parecer) {
        mongo.insert(gson.toJson(parecer), parecerCollection);
    }

    public void atualizarFundamentacao(String idParecer, Parecer parecer, String fundamentacao) {

    }

    public void removerParecer(String id) {
        mongo.delete("id", id, "parecer");
    }

    public Radoc mostrarRadocPorId(String idRadoc) {
        Radoc radoc = gson.fromJson(mongo.findOne("id", idRadoc, radocCollection), Radoc.class);
        return radoc;
    }

    public String salvarRadoc(Radoc radoc) {
        mongo.insert(gson.toJson(radoc), radocCollection);
        String json = mongo.findOne("id", radoc.getId(), radocCollection);
        return json;
    }

    public Boolean removerRadoc(String idRadoc) {
        mongo.delete("id", idRadoc, radocCollection);
        String json = mongo.findOne("id", idRadoc, radocCollection);
        if (json != null) {
            return true;
        } else {
            return false;
        }
    }

    Parecer mostrarNotaPorId(String idParecer) {
        
    }
}
