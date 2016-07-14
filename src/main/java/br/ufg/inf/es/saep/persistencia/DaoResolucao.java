package br.ufg.inf.es.saep.persistencia;

import com.google.gson.Gson;
import br.ufg.inf.es.saep.dominio.Resolucao;
import br.ufg.inf.es.saep.dominio.Tipo;
import com.mongodb.DBCollection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author JuliannyAS
 */
public class DaoResolucao {

    private final Mongo mongo;
    private final Gson gson;
    private final String resolucaoCollection = "resolucao";
    private final String tipoCollection = "tipo";

    /**
     * Construtor que instancia as variaveis mongo e gson. Sendo a variavel
     * mongo responsavel por chamar os metodos nativos do mongodb. E a variavel
     * gson responsavel pela serialização dos objetos e documentos.
     */
    public DaoResolucao() {
        this.mongo = new Mongo();
        this.gson = new Gson();
    }

    /**
     * Busca uma Resolução correspondente ao codigo identificador fornecido.
     *
     * @param idResolucao codigo identificador da resolucao a ser buscada.
     * @return um objeto do tipo Resolucao.
     */
    public Resolucao mostrarResolucaoPorId(String idResolucao) {
        Resolucao resolucao = gson.fromJson(mongo.findOne("id", idResolucao, resolucaoCollection), Resolucao.class);
        return resolucao;
    }

    /**
     * Salva uma objeto do tipo Resolução dentro da coleção resolucao, e
     * verifica se o mesmo esta salvo.
     *
     * @param resolucao objeto Resolucao a ser salvo.
     * @return valor falso caso a resoluçaõ não tenha sido salva, ou verdadeiro
     * caso a resolução tenha salva com sucesso.
     */
    public boolean salvarResolucao(Resolucao resolucao) {
        mongo.insert(gson.toJson(resolucao), resolucaoCollection);
        String json = mongo.findOne("id", resolucao.getId(), resolucaoCollection);
        if (json != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove uma Resolucao pertecente a coleção resolucao, e verifca se a mesma
     * foi removida.
     *
     * @param idResolucao identificador unico da resolução a ser removida.
     * @return falso caso a Resolução não tenha sido removida ou verdadeiro caso
     * tenha sido removido da base de dados.
     */
    public Boolean removerResolucao(String idResolucao) {
        mongo.delete("id", idResolucao, resolucaoCollection);
        String json = mongo.findOne("id", idResolucao, resolucaoCollection);
        if (json != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca e retorna uma lista com todos os jsons da coleção resolucao.
     * Transforma a lista de json em uma lista de objetos do tipo Resolucão.
     * Assim recupera todos os identificadores de cada Resolução da lista.
     *
     * @return lista de identificadores da resoluções persistidas na coleção
     * resolução.
     */
    public List<String> mostrarTodosPorId() {
        List<String> listJsons = mongo.findAll(tipoCollection);
        List<Resolucao> listResolucoes = new ArrayList<>();
        for (String list : listJsons) {
            listResolucoes.add(gson.fromJson(list, Resolucao.class));
        }
        List<String> listId = new ArrayList<>();
        listResolucoes.stream().forEach((list) -> {
            listId.add(list.getId());
        });
        return listId;
    }

    /**
     * Salva um objeto do tipo Tipo dentro da coleção tipo.
     *
     * @param tipo objeto Tipo a ser salvo.
     */
    public void salvarTipo(Tipo tipo) {
        mongo.insert(gson.toJson(tipo), tipoCollection);
    }

    /**
     * Remove um Tipo pertecente a coleção tipo.
     *
     * @param idTipo identificador unico do Tipo a ser removido.
     */
    public void removerTipo(String idTipo) {
        mongo.delete("id", idTipo, tipoCollection);
    }

    /**
     * Busca um objeto do tipo Tipo correspondente ao codigo identificador
     * fornecido.
     *
     * @param idTipo codigo identificador do Tipo a ser buscado.
     * @return um objeto do tipo Tipo.
     */
    public Tipo mostrarTipoPorId(String idTipo) {
        String json = mongo.findOne("id", idTipo, tipoCollection);
        Tipo tipo = gson.fromJson(json, Tipo.class);
        return tipo;
    }

    /**
     *Busca todos os objetos do tipo Tipo que tem em seu contexto uma string de filtragem.
     * @param nome
     * @return lista de objetos do tipo Tipo.
     */
    public List<Tipo> mostrarTiposPorNome(String nome) {
        List<Tipo> listTipos = new ArrayList<>();
        for (Document json : mongo.findMany("nome", nome, tipoCollection)) {
            listTipos.add(gson.fromJson(json.toJson(), Tipo.class));
        }
        return listTipos;
    }
}
