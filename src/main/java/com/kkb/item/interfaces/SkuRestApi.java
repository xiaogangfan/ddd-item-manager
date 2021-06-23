package com.kkb.item.interfaces;

import base.core.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kkb.item.application.SkuAppService;
import com.kkb.item.application.spu.param.SkuUpdateParam;

@RestController
@RequestMapping("/v1/sku")
public class SkuRestApi {

    @Autowired
    private SkuAppService skuService;

    @PostMapping("/update")
    public Result<Boolean> updateSku(@RequestBody SkuUpdateParam param) {
        skuService.updateSku(param);
        return Result.ok(true);
    }
}
