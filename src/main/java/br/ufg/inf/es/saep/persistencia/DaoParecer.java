package br.ufg.inf.es.saep.persistencia;

import br.ufg.inf.es.saep.dominio.Avaliavel;
import br.ufg.inf.es.saep.dominio.Nota;
import br.ufg.inf.es.saep.dominio.Parecer;
import br.ufg.inf.es.saep.dominio.Radoc;
import com.google.gson.Gson;
import java.util.List;

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

    /**
     * Busca um Parecer correspondente ao codigo identificador fornecido.
     *
     * @param idParecer codigo identificador do parecer a ser buscado.
     * @return um objeto do tipo Parecer.
     */
    public Parecer mostrarParecerPorId(String idParecer) {
        Parecer parecer = gson.fromJson(mongo.findOne("id", idParecer, parecerCollection), Parecer.class);
        return parecer;
    }

    public void adicionarNota(String idParecer, Parecer parecer, Nota nota) {
        List<Nota> notas = parecer.getNotas();

    }

    public void removerNota(String idParecer, Parecer parecer, Avaliavel original) {

    }

    public Parecer mostrarParecer(Parecer parecer) {
        String json = mongo.findOne("id", parecer.getId(), parecerCollection);
        Parecer parecerFinal = gson.fromJson(json, Parecer.class);
        return parecerFinal;
    }

    /**
     * Salva uma objeto do tipo Parecer dentro da coleção parecer.
     *
     * @param parecer objeto Resolucao a ser salvo.
     */
    public void salvarParecer(Parecer parecer) {
        mongo.insert(gson.toJson(parecer), parecerCollection);
    }

    public void atualizarFundamentacao(String idParecer, Parecer parecer, String fundamentacao) {

    }

    /**
     * Remove um Parecer pertecente a coleção parecer.
     *
     * @param idParecer identificador unico do parecer a ser removido.
     */
    public void removerParecer(String idParecer) {
        mongo.delete("id", idParecer, "parecer");
    }

    /**
     * Busca uma Resolução correspondente ao codigo identificador fornecido.
     *
     * @param idRadoc codigo identificador do parecer a ser buscad.
     * @return
     */
    public Radoc mostrarRadocPorId(String idRadoc) {
        Radoc radoc = gson.fromJson(mongo.findOne("id", idRadoc, radocCollection), Radoc.class);
        return radoc;
    }

    /**
     * Salva uma objeto do tipo Radoc dentro da coleção radoc, e mostra que foi
     * salvo, retornando seu identificador.
     *
     * @param radoc objeto Resolucao a ser salvo.
     * @return json falso caso a resoluçaõ não tenha sido salva, ou verdadeiro
     * caso a resolução tenha salva com sucesso.
     */
    public String salvarRadoc(Radoc radoc) {
        mongo.insert(gson.toJson(radoc), radocCollection);
        String json = mongo.findOne("id", radoc.getId(), radocCollection);
        return json;
    }

    public Boolean removerRadoc(String idRadoc) {
        mongo.delete("id", idRadoc, radocCollection);
        String json = mongo.findOne("id", idRadoc, radocCollection);
        if (json != null) {
            return false;
        } else {
            return true;
        }
    }
}
