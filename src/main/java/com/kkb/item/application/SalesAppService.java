package com.kkb.item.application;

import base.core.exception.BusinessException;
import com.kkb.item.application.sales.param.SpuSaleCreateParam;
import com.kkb.item.domain.spu.Spu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkb.item.domain.sales.SpuSale;
import com.kkb.item.domain.sales.SpuSaleRepo;


/**
 * Created by xiaogangfan.
 * Time 2018/10/6 下午3:48
 */
@Service
public class SalesAppService {
  
  @Autowired
  private SpuSaleRepo spuSaleRepo;
  
  @Autowired
  private SpuAppService spuService;
  
  
  public SpuSale findById(Long shopId, Long saleId) {
    return spuSaleRepo.findById(shopId,saleId);
  }
  
  
  public Long sell(SpuSaleCreateParam param){
    
    Spu spu = spuService.findSpuById(param.getShopId(), param.getSpuId()).orElseThrow(()-> new BusinessException("spu不存在"));
    
    Long saleId = spuSaleRepo.nextId();
    
    SpuSale spuSale = new SpuSale(
        param.getShopId(),
        saleId,
        param.getSaleChannel(),
        param.getSpuId()
    );
    
    param.getSkuSales().forEach(skuSaleCreateParam ->
        spuSale.addSku(skuSaleCreateParam.getSkuId(), skuSaleCreateParam.getPrice()));
    
    spuSaleRepo.save(spuSale);
    
    return saleId;
  }
  
}
