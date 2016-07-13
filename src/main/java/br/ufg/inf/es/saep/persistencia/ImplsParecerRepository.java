package br.ufg.inf.es.saep.persistencia;

import br.ufg.inf.es.saep.dominio.Avaliavel;
import br.ufg.inf.es.saep.dominio.ExisteParecerReferenciandoRadoc;
import br.ufg.inf.es.saep.dominio.IdentificadorDesconhecido;
import br.ufg.inf.es.saep.dominio.IdentificadorExistente;
import br.ufg.inf.es.saep.dominio.Nota;
import br.ufg.inf.es.saep.dominio.Parecer;
import br.ufg.inf.es.saep.dominio.ParecerRepository;
import br.ufg.inf.es.saep.dominio.Radoc;
import br.ufg.inf.es.saep.persistencia.DaoParecer;

/**
 *
 * @author JuliannyAS
 */
public class ImplsParecerRepository implements ParecerRepository {

    @Override
    public void adicionaNota(String idParecer, Nota nota) {
        DaoParecer daoParecer = new DaoParecer();
        Parecer parecer = daoParecer.mostrarPorId(idParecer);
        if (parecer != null) {
            daoParecer.adicionarNota(idParecer, parecer, nota);
        } else {
            throw new IdentificadorDesconhecido("Não existe um parecer para este id!");
        }
    }

    @Override
    public void removeNota(String idParecer, Avaliavel original) {
        DaoParecer daoParecer = new DaoParecer();
        Parecer parecer = daoParecer.mostrarPorId(idParecer);
        if (parecer != null) {
            daoParecer.removerNota(idParecer, parecer, original);
        } else {
            throw new IdentificadorDesconhecido("Não existe um parecer para este id!");
        }
    }

    @Override
    public void persisteParecer(Parecer parecer) {
        DaoParecer daoParecer = new DaoParecer();
        Parecer tempParecer = null;
        tempParecer = daoParecer.mostrarPorParecer(parecer);
        if (tempParecer != null) {
            daoParecer.salvarParecer(parecer);
        } else {
            throw new IdentificadorExistente("Este parecer ja foi persistido!");
        }
    }

    @Override
    public void atualizaFundamentacao(String idParecer, String fundamentacao) {
        DaoParecer daoParecer = new DaoParecer();
        Parecer parecer = daoParecer.mostrarPorId(idParecer);
        if (parecer != null) {
            daoParecer.atualizarFundamentacao(idParecer, parecer, fundamentacao);
        } else {
            throw new IdentificadorDesconhecido("Não existe um parecer para este id!");
        }
    }

    @Override
    public Parecer byId(String id) {
        DaoParecer daoParecer = new DaoParecer();
        Parecer parecer = daoParecer.mostrarPorId(id);
        if (parecer != null) {
            return parecer;
        } else {
            throw new IdentificadorDesconhecido("Não existe um parecer para este id!");
        }
    }

    @Override
    public void removeParecer(String id) {
        DaoParecer daoParecer = new DaoParecer();
        daoParecer.removerParecer(id);
    }

    @Override
    public Radoc radocById(String idRadoc) {
        DaoParecer daoParecer = new DaoParecer();
        Radoc radoc = daoParecer.mostrarRadocPorId(idRadoc);
        return radoc;
    }

    @Override
    public String persisteRadoc(Radoc radoc) {
        DaoParecer daoParecer = new DaoParecer();
        String idRadoc = daoParecer.salvarRadoc(radoc);
        return idRadoc;
    }

    @Override
    public void removeRadoc(String idRadoc) {
        DaoParecer daoParecer = new DaoParecer();
        Boolean excluido = daoParecer.removerRadoc(idRadoc);
        if (excluido != true) {
            throw new ExisteParecerReferenciandoRadoc("possui parecer");
        }
    }
}
