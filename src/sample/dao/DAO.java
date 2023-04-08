package sample.dao;

/**
 * All DAO interfaces must extend this interface
 * @param <K> type of id used by the object in the database
 * @param <T> type of object
 */
public interface DAO<K,T> {
    /**
     * Creates a new object of type T in the database
     * @param obj object to be created in the db
     * @return the object created null if not successfully updated
     */
    T createNew(T obj);

    /**
     * Gets the object from the database by the type ID
     * @param id id of type ID
     * @return object of type T from database null if not successfully updated
     */
    T getObjectById(K id);

    /**
     * Updates object of type T in database
     * @param obj object to be updated
     * @return updated object or null if not successfully updated
     */
    T updateObject(T obj);

    /**
     * Deletes an object by Id of type K
     * @param id id of objecct of type T
     * @return deleted object
     */
    T deleteObjectById(K id);

    /**
     * Delete object
     * @param obj object of type T to be deleted
     * @return deleted Object
     */
    T deleteObject(T obj);
}
