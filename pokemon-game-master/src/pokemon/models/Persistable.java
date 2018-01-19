package pokemon.models;

/**
 * Implement it to allow the model to be persistable.
 */
public interface Persistable {

	/**
	 * To save it.
	 *
	 * @throws Exception
	 */
	void save() throws Exception;

	/**
	 * To delete it.
	 *
	 * @throws Exception
	 */
	void delete() throws Exception;

}
