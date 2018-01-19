package pokemon.repositories.mysql;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pokemon.models.Pokemon;
import pokemon.repositories.DAO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLException;
import java.util.List;

public class PokemonsRepository extends Database implements DAO<Pokemon> {

	@Override
	public List<Pokemon> find() throws SQLException {
		setupConnection();
		String query = "select * from pokemons where initial = true order by id asc";
		List<Pokemon> pokemons = db.query(connection, query, new BeanListHandler<Pokemon>(Pokemon.class));
		closeConnection();
		return pokemons;
	}

	public Pokemon findRandom() throws SQLException {
		setupConnection();
		String query = "select * from pokemons order by rand() limit 1";
		Pokemon pokemon = db.query(connection, query, new BeanHandler<Pokemon>(Pokemon.class));
		closeConnection();
		return pokemon;
	}

	@Override
	public Pokemon findById(long id) throws NotImplementedException {
		throw new NotImplementedException();
	}

	@Override
	public List<Pokemon> findByProperty(Enum property, Pokemon entry) throws NotImplementedException {
		throw new NotImplementedException();
	}

	@Override
	public long create(Pokemon entry) throws NotImplementedException {
		throw new NotImplementedException();
	}

	@Override
	public boolean update(Pokemon entry) throws NotImplementedException {
		throw new NotImplementedException();
	}

	@Override
	public boolean delete(Pokemon entry) throws NotImplementedException {
		throw new NotImplementedException();
	}

}
