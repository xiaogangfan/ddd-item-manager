package com.kkb.item.application;

import com.kkb.item.application.spu.param.SkuUpdateParam;
import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.sku.SkuRepo;
import com.kkb.item.domain.sku.model.Sku;
import com.kkb.item.domain.sku.model.SkuId;
import com.kkb.item.domain.spu.code.CodeLockService;
import com.kkb.item.domain.spu.code.SkuBarCodeTuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * Created by xiaogangfan.
 * Time 2018/8/19 下午1:28
 */
@Service
public class SkuAppService {
  
  @Autowired
  private SkuRepo skuRepo;
  
  @Autowired
  private CodeLockService codeLockService;
  
  public Optional<Sku> findBySkuId(Long shopId, Long skuId){
    return Optional.ofNullable(skuRepo.findBySkuId(new ShopId(shopId), new SkuId(skuId)));
  }
  
  @Transactional
  public void updateSku(SkuUpdateParam param){
    
    this.findBySkuId(param.getShopId(),param.getSkuId())
        .map(sku-> {
          SkuBarCodeTuple skuBarCodeTuple = codeLockService.lockSkuBarCodes(
              new SkuBarCodeTuple(
                sku.getShopId(),sku.getSpuId(),sku.getSkuId(),param.getBarCodes()
              )
          );
          return sku.changeBarCodes(skuBarCodeTuple);
        })
        .map(sku-> sku.changeRetailPrice(param.getRetailPrice()))
        .ifPresent(sku-> skuRepo.updateSku(sku));
  }

}
