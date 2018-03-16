package org.wecancodeit.reviewsitefullstack;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

public class ClassTest {

	@Test
	public void setUpCategory() {
		Category category = new Category("Yoga");
		String check = category.getCategory();
		assertThat(check, is("Yoga"));
	}

	@Test
	public void setUpReview() {
		Review review = new Review("Name", "description", "image", "URL", new Category("category"), new Tag("tag"));
		String check = review.getReview();
		String check2 = review.getDescription();
		String image = review.getImage();
		String url = review.getUrl();
		assertThat(check, is("Name"));
		assertThat(check2, is("description"));
		assertThat(image, is("image"));
		assertThat(url, is("URL"));
	}

	@Test
	public void setUpTag() {
		Tag tag = new Tag("Tag");
		String check = tag.getTagWord();
		assertThat(check, is("Tag"));
	}
	
	@Test
	public void setUpComments() {
		Date date = new Date();
		Comment comment = new Comment("userName", "comment", date);
		String check = comment.getuserName();
		String check2 = comment.getCommentText();
		Date date2 = comment.getDate();
		assertThat(check, is("userName"));
		assertThat(check2, is("comment"));
	}
}
