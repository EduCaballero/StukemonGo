package pokemon.repositories;

import java.util.List;

public interface DAO<T> {

	/**
	 * Fetch and return all the entries.
	 *
	 * @return A list with all the entries.
	 * @throws Exception
	 */
	List<T> find() throws Exception;

	/**
	 * Try to get an entry with the given id.
	 *
	 * @param id
	 * @return The found entry.
	 * @throws Exception
	 */
	T findById(long id) throws Exception;

	/**
	 * Fetch and return all the entries that match with the given property.
	 *
	 * @param property
	 * @param entry
	 * @return A list with all the entries.
	 * @throws Exception
	 */
	List<T> findByProperty(Enum property, T entry) throws Exception;

	/**
	 * Insert a new entry.
	 *
	 * @param entry
	 * @return The id of the inserted entry.
	 * @throws Exception
	 */
	long create(T entry) throws Exception;

	/**
	 * Try to update the given entry.
	 *
	 * @param entry
	 * @return The result if the entry was updated or not.
	 * @throws Exception
	 */
	boolean update(T entry) throws Exception;

	/**
	 * Try to delete the given entry.
	 *
	 * @param entry
	 * @return The result if the entry was deleted or not.
	 * @throws Exception
	 */
	boolean delete(T entry) throws Exception;

}
