package com.kkb.item.interfaces;

import base.core.response.Result;
import com.kkb.item.domain.shop.ShopId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kkb.item.application.CategoryAppService;
import com.kkb.item.application.category.param.CategoryCreateParam;
import com.kkb.item.application.category.param.CategoryUpdateParam;
import com.kkb.item.domain.category.CategoryRepo;
import com.kkb.item.domain.category.model.Category;
import com.kkb.item.domain.category.model.CategoryId;

import java.util.List;


@RestController
@RequestMapping("/v1/category")
public class CategoryRestApi {

    @Autowired
    private CategoryAppService categoryService;

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("detail")
    public Result<Category> findByShopIdAndId(Long shopId, Long categoryId) {
        return Result.ok(categoryRepo.findByShopIdAndId(new ShopId(shopId), new CategoryId(categoryId)));
    }

    @GetMapping("count")
    public Result<Long> count(Long shopId) {
        return Result.ok(categoryRepo.countByShopId(new ShopId(shopId)));
    }

    @GetMapping("list")
    public Result<List<Category>> findByShopId(Long shopId) {
        return Result.ok(categoryRepo.findByShopId(new ShopId(shopId)));
    }

    @PostMapping("/create")
    public Result<Category> create(@RequestBody CategoryCreateParam param) {
        return Result.ok(categoryService.create(param));
    }

    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody CategoryUpdateParam param) {
        categoryService.update(param);
        return Result.ok(true);
    }
}
