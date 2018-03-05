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
}
