package com.kkb.item.interfaces;

import base.core.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kkb.item.application.SalesAppService;
import com.kkb.item.application.sales.param.SpuSaleCreateParam;
import com.kkb.item.domain.sales.SpuSale;


@RestController
@RequestMapping("/v1/sales")
public class SalesApi {

    @Autowired
    private SalesAppService salesService;

    @GetMapping("")
    public Result<SpuSale> findById(Long shopId, Long saleId) {
        return Result.ok(salesService.findById(shopId, saleId));
    }

    @PostMapping("")
    public Result<Long> sell(@RequestBody SpuSaleCreateParam param) {
        return Result.ok(salesService.sell(param));
    }
}
