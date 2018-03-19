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
import javax.persistence.OneToMany;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;
	private String review;
	private String image;
	private String websiteUrl;

	@Lob
	private String description;

	@ManyToOne
	private Category category;

	@ManyToMany
	private Collection<Tag> tags;

	@OneToMany(mappedBy = "review")
	private Collection<Comment> comments;

	public Collection<Comment> getComments() {
		return comments;
	}
	

	public Review() {

	}

	public Review(String review, String description, String image, String websiteUrl, Category category, Tag... tags) {
		this.review = review;
		this.image = image;
		this.websiteUrl = websiteUrl;
		this.category = category;
		this.description = description;
		this.tags = new HashSet<>(asList(tags));
	}

	public String getReview() {
		return review;
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	public String getUrl() {
		return websiteUrl;
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



	public void addTag(Tag tag) {
		tags.add(tag);
	}

}
