package u4d13.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import u4d13.entities.Student;
import u4d13.entities.StudentsDAO;
import u4d13.util.JpaUtil;

public class Application {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		System.out.println("CIAO");

		Student ajeje = new Student("Giovanni", "Baglio");
		StudentsDAO sd = new StudentsDAO(em);

		// *************** SAVE ***************

		sd.save(ajeje);

		em.close();
		emf.close();

	}

}
