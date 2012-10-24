import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Task;
import model.TaskSolution;

import org.junit.Test;


public class JoinTableTest {

	@Test
	public void test() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("model-jpa");
		EntityManager em= emf.createEntityManager();
		em.getTransaction().begin();
		
		Task task=new Task();
		TaskSolution solution = new TaskSolution();
		
		
		
		
		
		
		List<Task> tasks = new ArrayList<Task>();
		List<TaskSolution> solutions = new ArrayList<TaskSolution>();
		
		
		if(solution.getTasks()!=null){
			tasks.addAll(solution.getTasks());
		}
		tasks.add(task);
		
		if(task.getTaskSolutions()!=null){
			solutions.addAll(task.getTaskSolutions());
		}
		solutions.add(solution);
		em.persist(task);
		em.persist(solution);
		em.getTransaction().commit();
		
		assertNotNull(solution.getTaskSolutionID());
		assertNotNull(task.getTaskId());
		
		
	}

}
