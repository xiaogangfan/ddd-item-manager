package com.kkb.item.interfaces;

import base.core.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kkb.item.application.UnitAppService;
import com.kkb.item.application.unit.param.UnitCreateParam;
import com.kkb.item.domain.unit.model.Unit;

import java.util.List;


@RestController
@RequestMapping("/v1/unit")
public class UnitRestApi {

    @Autowired
    private UnitAppService unitService;

    @GetMapping
    public Result<Unit> findById(Long shopId, Long unitId) {
        return Result.ok(unitService.findById(shopId, unitId));
    }

    @GetMapping("list")
    public Result<List<Unit>> list(Long shopId) {
        return Result.ok(unitService.list(shopId));
    }

    @PostMapping
    public Result<Long> create(@RequestBody UnitCreateParam param) {
        return Result.ok(unitService.create(param));
    }
}
