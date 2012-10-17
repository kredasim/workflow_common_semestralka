import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AppUser;

import org.junit.Test;


public class BaseConectionTest {

	@Test
	public void test() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("model-jpa");
		EntityManager em= emf.createEntityManager();
		em.getTransaction().begin();
		AppUser appUser= new AppUser();
		appUser.setFirstName("Honza");
		appUser.setSurName("vom·Ëka");
		em.persist(appUser);
		em.getTransaction().commit();
		assertNotNull(appUser.getAppUserID());
	}

}
