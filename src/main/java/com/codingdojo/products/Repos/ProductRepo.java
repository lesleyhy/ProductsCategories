package com.codingdojo.products.Repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;


@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	List<Product> findAll();
	Product findByIdIs(Long id);
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContains(Category category);
}
