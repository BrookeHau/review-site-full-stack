package org.wecancodeit.reviewsitefullstack;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ReviewSiteMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private CategoryRepository catRepo;

	@Resource
	private TagRepository tagRepo;

	@Resource
	private ReviewRepository reviewRepo;

	@Test
	public void saveAndLoadCategory() {
		Category category = new Category("Name");
		category = catRepo.save(category);
		long categoryId = category.getId();

		entityManager.flush();
		entityManager.clear();

		category = catRepo.findOne(categoryId);
		assertThat(category.getCategory(), is("Name"));
	}

	@Test
	public void saveAndLoadTags() {
		Tag tag = new Tag("Tag");
		tag = tagRepo.save(tag);
		long tagId = tag.getId();

		entityManager.flush();
		entityManager.clear();

		tag = tagRepo.findOne(tagId);
		assertThat(tag.getTag(), is("Tag"));
	}

	@Test
	public void saveAndLoadTagsInReviews() {
		Tag tag = new Tag("Tag");
		tag = tagRepo.save(tag);
		Tag tag2 = new Tag("tag2");
		tag2 = tagRepo.save(tag2);
		Category category = new Category("cat");
		category = catRepo.save(category);
		Review review = new Review("Review", category, tag, tag2);
		review = reviewRepo.save(review);
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		review = reviewRepo.findOne(reviewId);
		assertThat(review.getTags(), containsInAnyOrder(tag, tag2));
	}

	@Test
	public void testCategoryToReviewRelationship() {
		Category category = new Category("Cat Name");
		category = catRepo.save(category);
		Tag tag = new Tag("tag");
		tag = tagRepo.save(tag);
		Review review = new Review("Review", category, tag);
		review = reviewRepo.save(review);
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		review = reviewRepo.findOne(reviewId);
		assertThat(review.getCategory(), is(category));

	}

}
