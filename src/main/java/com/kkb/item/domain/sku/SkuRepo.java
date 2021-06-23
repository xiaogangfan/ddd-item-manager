package com.kkb.item.domain.sku;

import java.util.List;

import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.sku.model.Sku;
import com.kkb.item.domain.sku.model.SkuId;
import com.kkb.item.domain.spu.SpuId;


/**
 * Created by xiaogangfan.
 * Time 2018/8/17 下午5:33
 */
public interface SkuRepo {
  
  void save(Sku sku);
  
  void batchSave(List<Sku> skus);
  
  List<Sku> findBySpuId(ShopId shopId, SpuId spuId);
  
  Sku findBySkuId(ShopId shopId, SkuId skuId);
  
  SkuId nextId();
  
  void updateSku(Sku sku);
}
