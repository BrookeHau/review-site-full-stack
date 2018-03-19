package org.wecancodeit.reviewsitefullstack;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewRestController {

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TagRepository tagRepo;

	
	/*
	 * @RequestMapping("/add-tag") public String addTag(String tagWord, Long
	 * reviewId) { Review review = reviewRepo.findOne(reviewId);
	 * if(!(tagRepo.findByTagWord(tagWord)==null)) { Tag tag =
	 * tagRepo.findByTagWord(tagWord); tag.addReview(review); return
	 * "redirect:/review?id=" + reviewId; } Tag tag = new Tag(tagWord); tag =
	 * tagRepo.save(tag); tag.addReview(review); tagRepo.save(tag); return
	 * "redirect:/review?id=" + reviewId; }
	 */
}
