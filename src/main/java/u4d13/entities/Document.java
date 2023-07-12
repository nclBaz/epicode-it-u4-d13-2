package u4d13.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "documents")
@Getter
@Setter
@NoArgsConstructor
//@ToString
public class Document {
	@Id
	@GeneratedValue
	private long id;
	private String code;
	private LocalDate issueDate;
	@Column(length = 2)
	private String country;

	@OneToOne(mappedBy = "document")
	// questo "document" si riferisce al nome dell'attributo
	// nella classe User
	private User user;

	public Document(String code, LocalDate issueDate, String country) {
		super();
		this.code = code;
		this.issueDate = issueDate;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", code=" + code + ", issueDate=" + issueDate + ", country=" + country + "]";
	}

}
