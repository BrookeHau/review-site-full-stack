package org.wecancodeit.reviewsitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
		Review review = new Review("Name");
		String check = review.getReview();
		assertThat(check, is("Name"));
	}
	
	@Test
	public void setUpTag() {
		Tag tag = new Tag("Tag");
		String check = tag.getTag();
		assertThat(check, is("Tag"));
		
	}
}
