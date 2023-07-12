package u4d13.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
//@IdClass(CompositeStudentKey.class)
// @AllArgsConstructor
public class User {
	@Id
	@GeneratedValue
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
//	@SequenceGenerator(name = "seq", sequenceName = "my_sequence", allocationSize = 50)
	private long id;
//	@Id
	private String firstName;
//	@Id
	private String lastName;

	@OneToOne
	private Document document;

	@OneToMany(mappedBy = "user")
	private Set<BlogPost> blogs;
	// Non viene creato a DB, serve solo lato Java per
	// poter ottenere la lista di tutti i blog scritti
	// da questo utente

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", document=" + document
				+ "]";
	}

}
