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
	private String tag;
	
	public Tag() {
		
	}

	public Tag(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}
	
	public long getId() {
		return id;
	}
	
	@ManyToMany (mappedBy="tags")
	private Collection<Review> reviews;
	
	@Override
	public int hashCode() {
		return((Long) id).hashCode();
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
