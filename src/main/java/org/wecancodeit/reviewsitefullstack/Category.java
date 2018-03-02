package org.wecancodeit.reviewsitefullstack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private long id;
	private String category;
	
	public Category() {
		
	}

	public Category(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}
	
	public long getId() {
		return id;
	}
	
	@OneToMany (mappedBy="category")
	private Collection<Review> reviews;

}
