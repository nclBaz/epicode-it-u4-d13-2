package u4d13.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import u4d13.entities.BlogPost;

public class BlogsDAO {
	private final EntityManager em;

	public BlogsDAO(EntityManager em) {
		this.em = em;
	}

	public void save(BlogPost s) {
		EntityTransaction t = em.getTransaction();
		t.begin(); // inizia la transazione

		em.persist(s);
		// qua l'oggetto viene aggiunto al persistence context, non viene ancora salvato
		// a db

		t.commit(); // termina la transazione, qua l'oggetto viene salvato
		System.out.println("Blog salvato correttamente");
	}

	public BlogPost findById(long id) {
		// SELECT * FROM students WHERE id=id;
		BlogPost found = em.find(BlogPost.class, id);
		return found;
	}

	public void findByIdAndDelete(long id) {
		// 1. Faccio una find prima per ottenere lo studente
		BlogPost found = em.find(BlogPost.class, id);
		if (found != null) {
			// 2. Poi elimino quello studente
			// 2.1 Ottengo la transazione
			EntityTransaction t = em.getTransaction();
			// 2.2 Faccio partire la transazione
			t.begin();
			// 2.3 Rimuovo l'oggetto
			em.remove(found);
			// 2.4 Faccio il commit della transazione
			t.commit();
			System.out.println("Blog eliminato correttamente");
		} else {
			System.out.println("Blog non trovato");
		}
	}
}
