package org.wecancodeit.reviewsitefullstack;

import javax.annotation.Resource;

import org.junit.Test;

public class ReviewSiteMappingTest {

	@Resource
	private CategoryRepository catRepo;
	
	@Test
	public void saveAndLoadCategory() {
		Category category = new Category("Name");
		category = catRepo.save(category);
	}
}
