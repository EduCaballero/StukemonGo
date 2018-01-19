package pokemon.repositories.mysql;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pokemon.models.Player;
import pokemon.repositories.DAO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLException;
import java.util.List;

public class PlayersRepository extends Database implements DAO<Player> {

	@Override
	public List<Player> find() throws SQLException {
		setupConnection();
		String query = "select * from players";
		List<Player> players = db.query(connection, query, new BeanListHandler<Player>(Player.class));
		closeConnection();
		return players;
	}

	@Override
	public Player findById(long id) throws NotImplementedException {
		throw new NotImplementedException();
	}

	@Override
	public List<Player> findByProperty(Enum property, Player entry) throws NotImplementedException {
		throw new NotImplementedException();
	}

	@Override
	public long create(Player player) throws SQLException {
		setupConnection();
		String query;
		long id = 0L;
		if (player.getId() <= 0L) {
			query = "insert into players(name) values(?)";
			id = db.insert(connection, query, new ScalarHandler<Long>(), player.getName());
		}
		closeConnection();
		return id;
	}

	@Override
	public boolean update(Player player) throws SQLException {
		setupConnection();
		String query;
		boolean result = false;
		if (player.getId() > 0L) {
			query = "update players set " +
				"pokemon = ?, " +
				"type = ?, " +
				"level = ?, " +
				"exp = ?, " +
				"maxHp = ?, " +
				"hp = ?, " +
				"damage = ?, " +
				"hunger = ?, " +
				"move1 = ?, " +
				"power1 = ?, " +
				"move2 = ?, " +
				"power2 = ?, " +
				"move3 = ?, " +
				"power3 = ? where id = ?";
			result = db.update(connection, query,
				player.getPokemon(),
				player.getType(),
				player.getLevel(),
				player.getExp(),
				player.getMaxHp(),
				player.getHp(),
				player.getDamage(),
				player.getHunger(),
				player.getMove1(),
				player.getPower1(),
				player.getMove2(),
				player.getPower2(),
				player.getMove3(),
				player.getPower3(), player.getId()) == 1;
		}
		closeConnection();
		return result;
	}

	@Override
	public boolean delete(Player player) throws SQLException {
		setupConnection();
		String query = "delete from players where id = ?";
		boolean result = db.update(connection, query, player.getId()) == 1;
		closeConnection();
		return result;
	}
}
