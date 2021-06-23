package com.kkb.item.domain.sku;

import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.spu.code.CodeLockService;
import com.kkb.item.domain.spu.code.SkuBarCodeTuple;
import com.kkb.item.domain.spu.code.SkuNo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kkb.item.domain.sku.model.Sku;
import com.kkb.item.domain.sku.model.SkuId;
import com.kkb.item.domain.spu.SpuId;
import com.kkb.item.application.spu.param.SkuCreateParam;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SkuService {

    @Autowired
    private SkuRepo skuRepo;

    @Autowired
    private CodeLockService codeLockService;

    //延迟初始化sku,让其他校验都执行完
    public List<Sku> buildSkus(ShopId shopId, SpuId spuId, List<SkuCreateParam> param) {
        return convertSkuBuilders(shopId, spuId, param).stream().map(Sku.SkuBuilder::build).collect(Collectors.toList());
    }

    private List<Sku.SkuBuilder> convertSkuBuilders(ShopId shopId, SpuId spuId, List<SkuCreateParam> param) {
        return param.stream().map(s -> {
            SkuId skuId = skuRepo.nextId();
            return Sku.builder()
                    .shopId(shopId)
                    .spuId(spuId)
                    .skuId(skuId)
                    .specTuple(s.getSpecTuple())
                    .no(codeLockService.lockSkuNo(new SkuNo(shopId, spuId, skuId, s.getSkuNo())))
                    .barCodes(codeLockService.lockSkuBarCodes(new SkuBarCodeTuple(shopId, spuId, skuId, s.getBarCodes())))
                    .retailPrice(s.getRetailPrice());
        }).collect(Collectors.toList());
    }
}
