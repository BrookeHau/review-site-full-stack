package org.wecancodeit.reviewsitefullstack;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

	@Resource
	CategoryRepository catRepo;

	@Resource
	TagRepository tagRepo;

	@Resource
	ReviewRepository reviewRepo;
	
	@Resource
	CommentRepository commentRepo;

	@RequestMapping("/categories")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", catRepo.findAll());
		return "categoriesView";
	}

	@RequestMapping("/category")
	public String getACategory(@RequestParam Long id, Model model) {
		Category category = catRepo.findOne(id);
		model.addAttribute("category", category);
		model.addAttribute("reviews", reviewRepo.findByCategory(category));
		return "singleCategoryView";
	}

	@RequestMapping("/review")
	public String getAReview(@RequestParam Long id, Model model) {
		model.addAttribute("reviews", reviewRepo.findOne(id));
		return "reviewModel";
	}

	@RequestMapping("/tags")
	public String showAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tagsView";
	}

	@RequestMapping("/tag")
	public String showOneTag(@RequestParam Long id, Model model) {
		model.addAttribute("tag", tagRepo.findOne(id));
		return "tagView";
	}
	
	@RequestMapping("/add-comment")
	public String addComment(String commentText, String userName, Long reviewId)
	{
		Date date = new Date();
		Review review = reviewRepo.findOne(reviewId);
		Comment comment = new Comment(userName, commentText, date, review);
		comment = commentRepo.save(comment);
		return "redirect:/review?id=" + reviewId;
	}
}
