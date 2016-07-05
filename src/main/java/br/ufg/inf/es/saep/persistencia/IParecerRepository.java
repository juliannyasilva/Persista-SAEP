package br.ufg.inf.es.saep.persistencia;

import br.ufg.inf.es.saep.sandbox.dominio.Avaliavel;
import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.ParecerRepository;
import br.ufg.inf.es.saep.sandbox.dominio.Radoc;

/**
 *
 * @author JuliannyAS
 */
public class IParecerRepository implements ParecerRepository {

    @Override
    public void adicionaNota(String parecer, Nota nota) {
        DaoNota daoNota = new DaoNota();
        daoNota.adiciona();        
    }

    @Override
    public void removeNota(Avaliavel original) {
        
    }

    @Override
    public void persisteParecer(Parecer parecer) {
        
    }

    @Override
    public void atualizaFundamentacao(String parecer, String fundamentacao) {
        
    }

    @Override
    public Parecer byId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeParecer(String id) {
        
    }

    @Override
    public Radoc radocById(String identificador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String persisteRadoc(Radoc radoc) {
        
        return "";
    }

    @Override
    public void removeRadoc(String identificador) {
        
    }
    
}
