package org.wecancodeit.reviewsitefullstack;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
	public Collection<Review> findByCategoryId(long categoryId);
	public Collection<Review> findByCategory(Category category);
	public Collection<Review> findByTagsContains(Tag tag);
}
