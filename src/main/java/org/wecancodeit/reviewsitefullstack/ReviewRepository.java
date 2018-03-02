package org.wecancodeit.reviewsitefullstack;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long>{

//	List<Review> findByName(String name);
//	
//	Collection<Review> findByCategoriesContains(Category category);
}


