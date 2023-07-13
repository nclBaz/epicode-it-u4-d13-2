package u4d13.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import u4d13.dao.BlogsDAO;
import u4d13.dao.CategoriesDAO;
import u4d13.dao.DocumentDAO;
import u4d13.dao.UserDAO;
import u4d13.entities.BlogPost;
import u4d13.entities.Category;
import u4d13.util.JpaUtil;

public class Application {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();


	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		UserDAO ud = new UserDAO(em);
		DocumentDAO dd = new DocumentDAO(em);
		BlogsDAO bd = new BlogsDAO(em);
		CategoriesDAO cd = new CategoriesDAO(em);


		// *************** 1 to 1 ***************
//		Document ajejeDoc = new Document("asdasd", LocalDate.now(), "IT");
//		User ajeje = new User("Giovanni", "Baglio");
////		dd.save(ajejeDoc);
////		ajeje.setDocument(ajejeDoc);
//		ud.save(ajeje);
//
//		User u = ud.findById(15);
//		if (u != null)
//		System.out.println(u.getDocument());
//
//		Document d = dd.findById(3);
//		if (d != null)
//		System.out.println(d.getUser());

		// *************** DELETE ***************
		// ud.findByIdAndDelete(4);

		// *************** 1 to N ***************
//		BlogPost angular = new BlogPost("JS", "Bellissimo", u);
//		bd.save(angular);

		// Torna l'utente che ha scritto il blog Java
		// System.out.println(java.getUser());
		// Torna tutti i blog scritti dall'utente u
//		Set<BlogPost> blogsDellUtente = u.getBlogs(); // qua va a "caricare" i blog di tale utente in un Set
//		blogsDellUtente.stream().forEach(b -> System.out.println(b));

		// *************** N to N ***************
		// cd.insertMany(new HashSet<>(Arrays.asList("Java", "Backend", "Frontend",
		// "Angular", "JS", "CSS", "HTML")));

		Category frontend = cd.findById(11);
		Category js = cd.findById(12);
		BlogPost jsBlog = bd.findById(18);

//		if (frontend != null && js != null) {
//			jsBlog.setCategories(new HashSet<>(Arrays.asList(frontend, js)));
//			bd.save(jsBlog);
//		}

		// Torna tutte le categorie di quel blog
		jsBlog.getCategories().forEach(c -> System.out.println(c));

		// Torna tutti i blog facenti parte di una categoria
		frontend.getBlogs().forEach(b -> System.out.println(b));
		em.close();
		emf.close();

	}

}
