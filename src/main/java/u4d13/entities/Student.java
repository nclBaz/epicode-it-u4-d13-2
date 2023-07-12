package u4d13.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
@NoArgsConstructor
@IdClass(CompositeStudentKey.class)
// @AllArgsConstructor
public class Student {
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
//	@SequenceGenerator(name = "seq", sequenceName = "my_sequence", allocationSize = 50)
//	private long id;
	@Id
	private String firstName;
	@Id
	private String lastName;

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
