package com.kkb.item.application;

import com.google.common.base.Strings;

import base.core.exception.BusinessException;
import com.kkb.item.application.category.param.CategoryCreateParam;
import com.kkb.item.application.category.param.CategoryUpdateParam;
import com.kkb.item.domain.shop.ShopId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

import com.kkb.item.domain.category.model.Category;
import com.kkb.item.domain.category.model.CategoryId;
import com.kkb.item.domain.category.CategoryRepo;


/**
 * Created by xiaogangfan.
 * Time 2018/8/13 上午10:12
 */
@Service
public class CategoryAppService {
  
  private final CategoryRepo categoryRepo;

  @Autowired
  public CategoryAppService(CategoryRepo categoryRepo) {
    this.categoryRepo = categoryRepo;
  }
  
  public Optional<Category> findByIdOptional(Long shopId, Long categoryId){
    return Optional.ofNullable(categoryRepo.findByShopIdAndId(new ShopId(shopId), new CategoryId(categoryId)));
  }
  
  public Category findById(Long shopId, Long categoryId){
    if(categoryId==0L){
      return Category.root(new ShopId(shopId));
    }
    return Optional.ofNullable(categoryRepo.findByShopIdAndId(new ShopId(shopId), new CategoryId(categoryId)))
        .orElseThrow(()-> new BusinessException("分类不存在"));
  }
  
  /**
   * 创建分类
   *
   * @param param
   * @return
   */
  @Transactional
  public Category create(CategoryCreateParam param){
    
    Category parent = findById(param.getShopId(), param.getParentId());
    
    Category category = new Category(
        new ShopId(param.getShopId()),
        categoryRepo.nextId(),
        param.getName(),
        parent);
    
    categoryRepo.save(category);
    
    return category;
  }
  
  
  /**
   * 删除分类
   *
   * @param shopId
   * @param id
   * @return
   */
  @Transactional
  public void delete(Long shopId, Long id){
    
    Category category = findById(shopId, id);
    
    this.delete(category);
  }
  
  /**
   * 删除分类
   *
   */
  public void delete(Category category){
    
    category.loadDescendants();

    category.getDescendants().forEach(c -> categoryRepo.delete(c.getCategoryId()));
    category.setDescendants(Collections.emptyList());
    
    categoryRepo.delete(category.getCategoryId());
  }
  
  @Transactional
  public void update(CategoryUpdateParam param){
    
    if(! Strings.isNullOrEmpty(param.getName())) {
      changeName(param.getShopId(), param.getId(), param.getName());
    }else if(param.getParentId()!=null) {
      changeParent(param.getShopId(), param.getId(), param.getParentId());
    }
  }
  
  @Transactional
  public void changeName(Long shopId, Long categoryId, String name){
    Category category = findById(shopId,categoryId);
    category.changeName(name);
    categoryRepo.save(category);
  }
  
  /**
   * 更新父分类
   *
   * @param parentId
   * @return
   */
  @Transactional
  public void changeParent(Long shopId, Long categoryId, Long parentId){
    
    Category category = findById(shopId,categoryId)
        .loadParent()
        .loadDescendants();
    
    Category parent = findById(shopId,parentId);
    
    category.changeParent(parent);
    
    categoryRepo.save(category);
    category.getDescendants().forEach(categoryRepo::save);
  }
  
}
