package org.wecancodeit.reviewsitefullstack;

import java.util.Date;

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
	
	@Resource
	CommentRepository commentRepo;

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
		Tag tag1 = new Tag("High Cost");
		tag1 = tagRepo.save(tag1);
		Tag tag2 = new Tag("Low Impact");
		tag2 = tagRepo.save(tag2);
		Review review = new Review("Yoga Six",
				"Yoga Six has a studio in Upper Arlington.  It has a variety of class types such as Hot Yoga, Slow Flow, Power Yoga, and Performance.",
				"./yogasix.jpg", "https://yogasix.com/studio/upper-arlington/", category1, tag1, tag2);
		review = reviewRepo.save(review);
		Review review2 = new Review("CorePower Yoga",
				"CorePower has an Easton and Short North Location.  Benefits of this studio include: membership is valid at both locations, all classes are hot (>80 degrees), and a variation of classes from recovery-style classes to more intense scuplting ones. ",
				"./corepower.jpg", "https://www.corepoweryoga.com/", category1, tag1, tag2);
		review2 = reviewRepo.save(review2);
		Review review3 = new Review("Barre3",
				"Barre3 is an amazing workout! The workout incorporates cardio and weights throughout the workout to give you a total body workout. \\n Not only that, but it targets muscles you never knew you had.  Unlike a lot of workouts, barre3 has modifications for every move, so if you have a bad knee or back there will be a modification to alleviate the pain and make each posture work for you. I've never been in better shape, and a lot of that has to do with barre3.",
				"./barre3.jpg", "https://barre3.com/", category2, tag1, tag2);
		review3 = reviewRepo.save(review3);
		Review review4 = new Review("The Butcher Shop",
				"Similar to barre, this workout targets muscles you've never worked before. And a big reason for that is due to the machine's design. Each workout is 50 minutes (or 40 if you are doing the ab class), and consists of slow, controlled movements. This workout is so hard that you will need to take a break, and I don't mean the classic break during a workout where it's mostly in your head. I mean these moves are so challenging and target muscles you rarely use that you will need to take breaks. However, as I've continued to go, I've noticed I'm getting stronger, and am taking fewer breaks.",
				"lagree.jpg",
				"https://thebutchershopfitness.zingfit.com/reserve/index.cfm?action=Reserve.chooseClass&site=1",
				category3, tag1, tag2);
		review4 = reviewRepo.save(review4);
		Review review5 = new Review("SOS",
				"This workout consists of a variety of workouts, from yoga to HIIT workouts.  The atmosphere and community behind this gym is amazing.",
				"SOS.jpg", "https://systemofstrength.com/", category4, tag1);
		review5 = reviewRepo.save(review5);
		Review review6 = new Review("Corus45",
				"Corus is another la gree studio located in Cleveland, Ohio. The atmosphere is very fun and upbeat.  What I love about Corus is they incorporate ab moves throughout the entire workout, not just in the beginning or end.",
				"./corus.jpg", "http://www.corus45.com/", category3, tag1, tag2);
		review6 = reviewRepo.save(review6);
		Date date = new Date();
		Comment comment1 = new Comment("BHau", "testing", date,  review);
		comment1 = commentRepo.save(comment1);
	}
}
