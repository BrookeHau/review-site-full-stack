package org.wecancodeit.reviewsitefullstack;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		assertThat(tag.getTagWord(), is("Tag"));
	}

	@Test
	public void saveLoadReview() {
		Tag tag = new Tag("Tag");
		tag = tagRepo.save(tag);
		Tag tag2 = new Tag("tag2");
		tag2 = tagRepo.save(tag2);
		Category category = new Category("cat");
		category = catRepo.save(category);
		Review review = new Review("Review", "description", "image", "URL",category, tag, tag2);
		review = reviewRepo.save(review);
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		review = reviewRepo.findOne(reviewId);
		assertThat(review.getReview(), is("Review"));
	}

	@Test
	public void saveAndLoadTagsInReviews() {
		Tag tag = new Tag("Tag");
		tag = tagRepo.save(tag);
		Tag tag2 = new Tag("tag2");
		tag2 = tagRepo.save(tag2);
		Category category = new Category("cat");
		category = catRepo.save(category);
		Review review = new Review("Review", "description", "image", "URL", category, tag, tag2);
		review = reviewRepo.save(review);
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		review = reviewRepo.findOne(reviewId);
		assertThat(review.getTags(), containsInAnyOrder(tag, tag2));
	}

	@Test
	public void callCategoryInReview() {
		Tag tag = new Tag("Tag");
		tag = tagRepo.save(tag);
		Tag tag2 = new Tag("tag2");
		tag2 = tagRepo.save(tag2);
		Category category = new Category("cat");
		category = catRepo.save(category);
		Review review = new Review("Review", "description", "image", "URL", category, tag, tag2);
		review = reviewRepo.save(review);
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		review = reviewRepo.findOne(reviewId);
		assertThat(review.getCategory().getCategory(), is("cat"));
	}

	@Test
	public void callCategoryWithinReview() {
		Category category = new Category("Cat Name");
		category = catRepo.save(category);
		Tag tag = new Tag("tag");
		tag = tagRepo.save(tag);
		Review review = new Review("Review", "description","image", "URL", category, tag);
		review = reviewRepo.save(review);
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		review = reviewRepo.findOne(reviewId);
		assertThat(review.getCategory(), is(category));

	}

	@Test
	public void categoryShouldHaveMultipleReview() {
		Category category = new Category("Cat Name");
		category = catRepo.save(category);
		Tag tag = new Tag("tag");
		tag = tagRepo.save(tag);
		Review review = new Review("review", "image", "description", "URL",category, tag);
		review = reviewRepo.save(review);
		Review review2 = new Review("review2", "image", "description", "URL", category, tag);
		review2 = reviewRepo.save(review2);
		Review review3 = new Review("review3", "image", "description","URL", category, tag);
		review3 = reviewRepo.save(review3);
		long categoryId = category.getId();

		entityManager.flush();
		entityManager.clear();

		category = catRepo.findOne(categoryId);
		assertThat(category.getReviews(), containsInAnyOrder(review, review2, review3));

	}
	
	@Test
	public void testReviewAndCategory() {
		Category category = new Category("Cat Name");
		category = catRepo.save(category);
		Tag tag = new Tag("tag");
		tag = tagRepo.save(tag);
		Review review = new Review("review", "image", "URL","description", category, tag);
		review = reviewRepo.save(review);
		Review review2 = new Review("review2", "image", "URL","description", category, tag);
		review2 = reviewRepo.save(review2);
		Review review3 = new Review("review3", "image", "URL","description", category, tag);
		review3 = reviewRepo.save(review3);
		long categoryId = category.getId();

		entityManager.flush();
		entityManager.clear();

		category = catRepo.findOne(categoryId);
		Collection<Review> reviewsForCategory = reviewRepo.findByCategory(category);
		assertThat(reviewsForCategory, containsInAnyOrder(review, review2, review3));

	}

	@Test
	public void callTagWithinReview() {
		Category category = new Category("Cat Name");
		category = catRepo.save(category);
		Tag tag = new Tag("tag");
		tag = tagRepo.save(tag);
		Tag tag2 = new Tag("tag2");
		tag2 = tagRepo.save(tag2);
		Review review = new Review("review", "image", "URL", "description", category, tag, tag2);
		review = reviewRepo.save(review);
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		review = reviewRepo.findOne(reviewId);
		assertThat(review.getTags(), contains(tag, tag2));
	}
	
}
