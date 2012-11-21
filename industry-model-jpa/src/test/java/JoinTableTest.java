import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AppUser;
import model.Institution;
import model.InstitutionType;
import model.Project;
import model.Task;
import model.TaskSolution;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class JoinTableTest {

	@Test
	public void test() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("model-jpa");
		EntityManager em= emf.createEntityManager();
		em.getTransaction().begin();

			InstitutionType institutionType = new InstitutionType();
			institutionType.setName("testType");
			institutionType.setDescription("This is just test state for base test cases.");
			em.persist(institutionType);
		
		em.getTransaction().commit();
		assertNotNull(institutionType.getInstitutionTypeID());
		
		em.getTransaction().begin();
		
		
			AppUser appUser=new AppUser();
			Institution institution=new Institution();
			
			institution.setInstitutionType(institutionType);
			em.persist(institution);
			em.persist(appUser);
			
		em.getTransaction().commit();
		em.getTransaction().begin();
				
			Project project=new Project();
			
			project.setInstitution(institution);
			project.setProject(project);
			project.setName("root");
			em.persist(project);
			
		em.getTransaction().commit();
		em.getTransaction().begin();
			
			
			Task task=new Task();
			TaskSolution taskSolution = new TaskSolution();
				
			task.setAppUser(appUser);
			task.setName("testTask");
			task.setProject(project);
			em.persist(task);
			em.persist(taskSolution);
					
		em.getTransaction().commit();
		em.getTransaction().begin();
			
		
		
		List<Task> tasks = new ArrayList<Task>();
		List<TaskSolution> solutions = new ArrayList<TaskSolution>();
		
		
		if(taskSolution.getTasks()!=null){
			tasks.addAll(taskSolution.getTasks());
		}
		tasks.add(task);
		
		if(task.getTaskSolutions()!=null){
			solutions.addAll(task.getTaskSolutions());
		}
		solutions.add(taskSolution);

		em.persist(task);
		em.persist(taskSolution);
		em.getTransaction().commit();
		
		assertNotNull(taskSolution.getTaskSolutionID());
		assertNotNull(task.getTaskId());
		assertNotNull(
		    em.createQuery(
		    		"select tasksolution.* " +
		    		"from tasksolution " +
		    		"where tasksolution " +
		    		"natural join task_tasksolution;"
		    		).getSingleResult()
			);
	}

}
