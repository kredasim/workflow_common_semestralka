import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AppUser;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class BaseConectionTest {

	@Test
	public void test() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("model-jpa");
		EntityManager em= emf.createEntityManager();
		em.getTransaction().begin();
			AppUser appUser= new AppUser();
			appUser.setFirstName("Honza");
			appUser.setSurName("vomka");
			em.persist(appUser);
		em.getTransaction().commit();
		assertNotNull(appUser.getAppUserID());
	}

}
