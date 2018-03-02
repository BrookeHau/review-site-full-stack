package org.wecancodeit.reviewsitefullstack;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	public Category() {

	}

	@Id
	@GeneratedValue
	private long id;
	private String category;

	public Category(String category, Review... reviews) {
		this.category = category;
		this.reviews = new HashSet<>(asList(reviews));
	}

	public String getCategory() {
		return category;
	}

	public long getId() {
		return id;
	}

	@OneToMany(mappedBy = "category")
	private Collection<Review> reviews;

	public Collection<Review> getReviews() {
		return reviews;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Category) obj).id;
	}

}
