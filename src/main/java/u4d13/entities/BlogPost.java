package u4d13.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "blogposts")
@Getter
@Setter
@NoArgsConstructor
public class BlogPost {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String content;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false) // Per customizzare la FK
	private User user; // Colonna Foreign Key di nome "user_id" NON NULL

	@ManyToMany
	@JoinTable(name = "blogs_categories", joinColumns = @JoinColumn(name = "blog_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories;

	public BlogPost(String title, String content, User user) {
		this.title = title;
		this.content = content;
		this.user = user;
	}

	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", title=" + title + ", content=" + content + ", user=" + user + "]";
	}

}
