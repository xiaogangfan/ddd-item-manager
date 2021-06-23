package com.kkb.item.infra.repo;

import base.boot.idgen.IdGen;
import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.infra.repo.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kkb.item.domain.category.CategoryRepo;
import com.kkb.item.domain.category.model.Category;
import com.kkb.item.domain.category.model.CategoryId;

import java.util.List;

@Repository
public class MybatisCategoryRepo implements CategoryRepo {

    @Autowired
    private CategoryMapper mapper;

    @Autowired
    private IdGen idGen;

    @Override
    public CategoryId nextId() {
        return new CategoryId(idGen.generateId());
    }

    @Override
    public void save(Category category) {
        if (category.getId() == -1) {
            mapper.create(category);
        } else {
            mapper.update(category);
        }
    }

    @Override
    public void delete(CategoryId id) {
        mapper.delete(id.getId());
    }

    @Override
    public List<Category> findByShopId(ShopId shopId) {
        return mapper.findByShopId(shopId.getId());
    }


    @Override
    public Long countByShopId(ShopId shopId) {
        return mapper.countByShopId(shopId.getId());
    }


    @Override
    public Category findByShopIdAndId(ShopId shopId, CategoryId id) {
        return mapper.findByShopIdAndId(shopId.getId(), id.getId());
    }


    @Override
    public List<Category> findByShopIdAndParentId(ShopId shopId, CategoryId parentId) {
        return mapper.findByShopIdAndParentId(shopId.getId(), parentId.getId());
    }
}
