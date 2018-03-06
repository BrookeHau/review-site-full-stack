package org.wecancodeit.reviewsitefullstack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String tagWord;

	public Tag() {

	}

	public Tag(String tagWord) {
		this.tagWord = tagWord;
	}

	public String getTagWord() {
		return tagWord;
	}

	public long getId() {
		return id;
	}
	
	public Collection<Review> getReviews(){
		return reviews;
	}

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

}
