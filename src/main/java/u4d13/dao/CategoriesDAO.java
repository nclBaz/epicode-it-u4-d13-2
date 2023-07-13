package u4d13.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import u4d13.entities.Category;

public class CategoriesDAO {
	private final EntityManager em;

	public CategoriesDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Category s) {
		EntityTransaction t = em.getTransaction();
		t.begin(); // inizia la transazione

		em.persist(s);
		// qua l'oggetto viene aggiunto al persistence context, non viene ancora salvato
		// a db

		t.commit(); // termina la transazione, qua l'oggetto viene salvato
		System.out.println("Categoria salvata correttamente");
	}

	public Category findById(long id) {
		// SELECT * FROM students WHERE id=id;
		Category found = em.find(Category.class, id);
		return found;
	}

	public void findByIdAndDelete(long id) {
		// 1. Faccio una find prima per ottenere lo studente
		Category found = em.find(Category.class, id);
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
			System.out.println("Categoria eliminata correttamente");
		} else {
			System.out.println("Categoria non trovata");
		}
	}

	public void insertMany(Set<String> categories) {
		for (String cat : categories) {
			EntityTransaction t = em.getTransaction();
			Category newCategory = new Category(cat);
			t.begin();
			em.persist(newCategory);
			t.commit();
		}
		System.out.println("Categorie inserite");
	}
}
