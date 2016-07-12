package persistencia.resolucao;

import dominio.Atributo;
import dominio.Tipo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import java.util.List;
import java.util.Set;
import persistencia.dao.DaoTipo;
import persistencia.dao.MongoConnection;

/**
 *
 * @author JuliannyAS
 */
public class TestarTipo {

    public static void main(String args[]) {
        MongoConnection mongo = new MongoConnection();
        DB db = mongo.getDB();
        System.out.println("Connect to database successfully");
        Set<Atributo> atributos1 = (Set<Atributo>) new Atributo("aula", "nome do predio", 1);
        Set<Atributo> atributos2 = (Set<Atributo>) new Atributo("aula", "nome do predio", 1);
        Set<Atributo> atributos3 = (Set<Atributo>) new Atributo("aula", "nome do predio", 1);
        DBCollection collection = db.getCollection("Resolucao");
        Tipo tipo1 = new Tipo("1", "aula presencial","ministrada na graduacao", atributos1);
        Tipo tipo2 = new Tipo("2", "aula a distancia", "ministrada na pos", atributos2);
        Tipo tipo3 = new Tipo("3", "congresso", "outro campus", atributos3);
        new DaoTipo().salvar(tipo1);
        new DaoTipo().salvar(tipo2);
        new DaoTipo().salvar(tipo3);
        
             
    }
}
