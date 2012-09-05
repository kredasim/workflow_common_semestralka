import static org.junit.Assert.*;

import java.util.Map;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import model.AppUser;

import org.junit.Test;


public class BaseConectionTest {

	@Test
	public void test() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("model-jpa");
		EntityManager em= emf.createEntityManager();
		em.getTransaction().begin();
		AppUser appUser= new AppUser();
		appUser.setFirstname("Honza");
		appUser.setSurname("vom·Ëka");
		em.persist(appUser);
		em.getTransaction().commit();
		assertNotNull(appUser.getAppuserid());
	}

}
