package persistencia.repository;

import dominio.CampoExigidoNaoFornecido;
import dominio.IdentificadorDesconhecido;
import dominio.Resolucao;
import dominio.ResolucaoRepository;
import dominio.Tipo;
import java.util.List;
import persistencia.dao.DaoResolucao;

/**
 *
 * @author JuliannyAS
 */
public class ImplsResolucaoRepository implements ResolucaoRepository {

    @Override
    public Resolucao byId(String idResolucao) {
        DaoResolucao daoResolucao = new DaoResolucao();
        Resolucao resolucao;
        resolucao = daoResolucao.mostrarPorId(idResolucao);
        return resolucao;
    }

    @Override
    public String persiste(Resolucao resolucao) {

        if (resolucao.getId() != null) {
            DaoResolucao daoResolucao = new DaoResolucao();
            Boolean persistiu = daoResolucao.salvarResolucao(resolucao);
            if (persistiu) {
                return resolucao.getId();
            } else {
                throw new IdentificadorDesconhecido("id ja existente!");
            }
        } else {
            throw new CampoExigidoNaoFornecido("id");
        }
    }

    @Override
    public boolean remove(String idResolucao) {
        DaoResolucao daoResolucao = new DaoResolucao();
        Boolean removido = daoResolucao.removerResolucao(idResolucao);
        return removido;
    }

    @Override
    public List<String> resolucoes() {
        DaoResolucao daoResolucao = new DaoResolucao();
        List<String> identificadores = daoResolucao.mostrarTodosPorId();
        return identificadores;
    }

    @Override
    public void persisteTipo(Tipo tipo) {
        DaoResolucao daoResolucao = new DaoResolucao();
        daoResolucao.salvarTipo(tipo);
    }

    @Override
    public void removeTipo(String codigo) {
        DaoResolucao daoResolucao = new DaoResolucao();
        daoResolucao.removerTipo(codigo);
    }

    @Override
    public Tipo tipoPeloCodigo(String id) {
        DaoResolucao daoResolucao = new DaoResolucao();
        Tipo tipo = daoResolucao.mostrarTipoPorId(id);
        return tipo;
    }

    @Override
    public List<Tipo> tiposPeloNome(String nome) {
        DaoResolucao daoResolucao = new DaoResolucao();
        List<Tipo> tipos = daoResolucao.mostrarTiposPorNome(nome);
        return tipos;
    }
}
