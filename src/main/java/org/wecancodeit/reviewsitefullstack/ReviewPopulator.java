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
		category2 = catRepo.save(category2);
		Category category3 = new Category("Pilates");
		category3 = catRepo.save(category3);
		Category category4 = new Category("Mix");
		category4 = catRepo.save(category4);
		Tag tag1 = new Tag("high cost");
		tag1 = tagRepo.save(tag1);
		Review review = new Review("Yoga Six", "Yoga Six has a studio in Upper Arlington.  It has a variety of class types such as Hot Yoga, Slow Flow, Power Yoga, and Performance.", category1,  tag1);
		review = reviewRepo.save(review);
		Review review2 = new Review("CorePower Yoga", "CorePower has an Easton and Short North Location.  Benefits of this studio include: membership is valid at both locations, all classes are hot (>80 degrees), and a variation of classes from recovery-style classes to more intense scuplting ones. ", category1, tag1);
		review2 = reviewRepo.save(review2);
		Review review3 = new Review("Barre3", "Barre3 is an amazing workout! The workout incorporates cardio and weights throughout the workout to give you a total body workout. \\n Not only that, but it targets muscles you never knew you had.  Unlike a lot of workouts, barre3 has modifications for every move, so if you have a bad knee or back there will be a modification to alleviate the pain and make each posture work for you. I've never been in better shape, and a lot of that has to do with barre3.", category2, tag1);
		review3 = reviewRepo.save(review3);
		Review review4 = new Review("Pilates", "excellent", category3, tag1);
		review4 = reviewRepo.save(review4);
		Review review5 = new Review("SOS", "excellent", category4, tag1);
		review5 = reviewRepo.save(review5);
	}
}
