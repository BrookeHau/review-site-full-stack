package org.wecancodeit.reviewsitefullstack;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewRestController {

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TagRepository tagRepo;

	@RequestMapping("/review/{reviewId}/addtag/{tagWord}")
	public Tag addTagtoReview(@PathVariable Long reviewId, @PathVariable String tagWord) {
		Review newReview = reviewRepo.findOne(reviewId);
		if (newReview != null && tagWord != null) {
			Tag existingTag = tagRepo.findByTagWord(tagWord);
			if (existingTag == null) {
				Tag newTag = new Tag(tagWord, newReview);
				newTag = tagRepo.save(newTag);
				newReview.addTag(newTag);
				reviewRepo.save(newReview);
			}
		}

		return null;
	}

	/*@RequestMapping("/review/{reviewId}/tag/{tagId}/deletetag")
	public String deleteTagFromReview(@PathVariable Long reviewId, @PathVariable Long tagId) {
		Review review = reviewRepo.findOne(reviewId);
		Tag tag = tagRepo.findOne(tagId);
		review.removeTag(tag);
		reviewRepo.save(review);

		if (tag.getReviews().size() == 0) {
			tagRepo.delete(tag);
		}

		return null;
	}*/
}
