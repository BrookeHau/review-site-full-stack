package org.wecancodeit.reviewsitefullstack;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String tagWord;

	public Tag() {

	}

	public Tag(String tagWord, Review... reviews) {
		this.tagWord = tagWord;
		this.reviews = new HashSet<>(asList(reviews));
	}

	public String getTagWord() {
		return tagWord;
	}

	public long getId() {
		return id;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}

	@JsonIgnore
	@ManyToMany(mappedBy = "tags")
	private Collection<Review> reviews;

	@Override
	public String toString() {
		return tagWord;
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
		return id == ((Tag) obj).id;
	}

	public void addReview(Review review) {
		reviews.add(review);
	}

}
