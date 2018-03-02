package org.wecancodeit.reviewsitefullstack;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator implements CommandLineRunner {

	@Resource
	CategoryRepository catRepo;

	@Resource
	TagRepository tagRepo;

	@Resource
	ReviewRepository reviewRepo;

	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category("Yoga");
		category1 = catRepo.save(category1);
		Category category2 = new Category("Barre");
		category1 = catRepo.save(category2);
		Category category3 = new Category("Pilates");
		category1 = catRepo.save(category3);
		Category category4 = new Category("Mix");
		category1 = catRepo.save(category4);
		Tag tag1 = new Tag("high cost");
		tag1 = tagRepo.save(tag1);
		Review review = new Review("Yoga1", "Great time", category1,  tag1);
		review = reviewRepo.save(review);
		Review review2 = new Review("Yoga2", "excellent", category1, tag1);
		review2 = reviewRepo.save(review2);
		Review review3 = new Review("Barre", "excellent", category2, tag1);
		review3 = reviewRepo.save(review3);
	}
}
