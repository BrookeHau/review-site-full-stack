package org.wecancodeit.reviewsitefullstack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String tag;

	public Tag(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

}
