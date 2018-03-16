package org.wecancodeit.reviewsitefullstack;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private long commentId;

	private String userName;
	private String comment;
	private Date date;

	public Comment() {
		
	}
	public Comment(String userName, String comment, Date date) {
		this.userName = userName;
		this.comment = comment;
	}

	@ManyToOne
	public Review review;
	
	public Review getReview() {
		return review;
	}
	
	public String getuserName() {
		return userName;
	}

	public String getCommentText() {
		return comment;
	}

	public Date getDate() {
		return date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (commentId ^ (commentId >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (commentId != other.commentId)
			return false;
		return true;
	}

}
