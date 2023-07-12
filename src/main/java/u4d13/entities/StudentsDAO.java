package u4d13.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudentsDAO {
	private final EntityManager em;

	public StudentsDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Student s) {
		EntityTransaction t = em.getTransaction();
		t.begin(); // inizia la transazione

		em.persist(s);
		// qua l'oggetto viene aggiunto al persistence context, non viene ancora salvato
		// a db

		t.commit(); // termina la transazione, qua l'oggetto viene salvato
		System.out.println("Studente salvato correttamente");
	}

	public Student findById(long id) {
		// SELECT * FROM students WHERE id=id;
		Student found = em.find(Student.class, id);
		return found;
	}

	public void findByIdAndDelete(long id) {
		// 1. Faccio una find prima per ottenere lo studente
		Student found = em.find(Student.class, id);
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
			System.out.println("Studente eliminato correttamente");
		} else {
			System.out.println("Studente non trovato");
		}
	}

	public void refresh(long id) {
		Student found = em.find(Student.class, id);

		found.setFirstName("Gerry");

		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		// ripristina l'oggetto modificato con i valori provenienti dal db
		System.out.println("POST REFRESH");
		System.out.println(found);

	}

}
