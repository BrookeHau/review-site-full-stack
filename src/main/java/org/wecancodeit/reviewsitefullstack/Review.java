package org.wecancodeit.reviewsitefullstack;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;
	private String review;

	@Lob
	private String description;

	@ManyToOne
	private Category category;

	@ManyToMany
	private Collection<Tag> tags;

	public Review() {

	}

	public Review(String review, String description, Category category, Tag... tags) {
		this.review = review;
		this.description = description;
		this.category = category;
		this.tags = new HashSet<>(asList(tags));
	}

	public String getReview() {
		return review;
	}

	public long getId() {
		return id;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public Category getCategory() {
		return category;
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
		return id == ((Review) obj).id;
	}

	public String getDescription() {
		return description;
	}

}
