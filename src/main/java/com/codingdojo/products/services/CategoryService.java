package com.codingdojo.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.products.Repos.CategoryRepo;
import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;


@Service
public class CategoryService {
	private final CategoryRepo categoryRepo;
	
	public CategoryService (CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	public List<Category> allCategories(){
		return categoryRepo.findAll();
	}
	
	public List<Category> getAssignedProducts(Product product){
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> getUnassignedProducts(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public Category findById(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}
	
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public void deleteCategory(Category category) {
		categoryRepo.delete(category);
	}
}
