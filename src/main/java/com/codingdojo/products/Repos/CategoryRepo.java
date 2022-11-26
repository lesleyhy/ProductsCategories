package com.codingdojo.products.Repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
	List<Category> findAll();
	Category findByIdIs(Long id);
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);
}
