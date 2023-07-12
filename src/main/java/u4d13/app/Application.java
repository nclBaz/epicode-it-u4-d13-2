package u4d13.app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import u4d13.dao.BlogsDAO;
import u4d13.dao.DocumentDAO;
import u4d13.dao.UserDAO;
import u4d13.entities.BlogPost;
import u4d13.entities.Document;
import u4d13.entities.User;
import u4d13.util.JpaUtil;

public class Application {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		UserDAO ud = new UserDAO(em);
		DocumentDAO dd = new DocumentDAO(em);
		BlogsDAO bd = new BlogsDAO(em);


		// *************** 1 to 1 ***************
		Document ajejeDoc = new Document("asdasd", LocalDate.now(), "IT");
		User ajeje = new User("Giovanni", "Baglio");
//		dd.save(ajejeDoc);
//		ajeje.setDocument(ajejeDoc);
//		ud.save(ajeje);

		User u = ud.findById(4);
		System.out.println(u.getDocument());

		Document d = dd.findById(3);
		System.out.println(d.getUser());

		// *************** 1 to N ***************
		// BlogPost angular = new BlogPost("Angular", "Bellissimo", u);
		// bd.save(angular);
		BlogPost java = bd.findById(5);

		// Torna l'utente che ha scritto il blog Java
		System.out.println(java.getUser());
		// Torna tutti i blog scritti dall'utente u
		u.getBlogs().stream().forEach(b -> System.out.println(b));

		em.close();
		emf.close();

	}

}
