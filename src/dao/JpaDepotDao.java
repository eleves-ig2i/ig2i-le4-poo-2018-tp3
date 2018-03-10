package dao;

import java.util.Collection;
import metier.Depot;

/**
 * Représente un DAO de type Depot utilisant comme source de données une bdd.
 * @author user
 */
public class JpaDepotDao extends JpaDao<Depot> implements DepotDao {

	/**
	 * Constructeur par données.
	 * @param entite TODO
	 */
	public JpaDepotDao(Class<Depot> entite) {
		super(entite);
	}

	@Override
	public boolean deleteAll() {
		return super.deleteAll();
	}

	@Override
	public Collection<Depot> findAll() {
		return super.findAll();
	}

	@Override
	public Depot find(Integer id) {
		return super.find(id);
	}

	@Override
	public void close() {
		super.close();
	}

	@Override
	public boolean delete(Depot obj) {
		return super.delete(obj);
	}

	@Override
	public boolean update(Depot obj) {
		return super.update(obj);
	}

	@Override
	public boolean create(Depot obj) {
		return super.create(obj);
	}
	
}