package com.kkb.item.domain.category;

import java.util.List;

import com.kkb.item.domain.category.model.Category;
import com.kkb.item.domain.category.model.CategoryId;
import com.kkb.item.domain.shop.ShopId;


public interface CategoryRepo {
  
  CategoryId nextId();
  
  void save(Category category);
  
  void delete(CategoryId id);
  
  List<Category> findByShopId(ShopId shopId);
  
  Long countByShopId(ShopId shopId);
  
  Category findByShopIdAndId(ShopId shopId, CategoryId id);
  
  List<Category> findByShopIdAndParentId(ShopId shopId, CategoryId parentId);
}
