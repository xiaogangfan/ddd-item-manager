package com.kkb.item.domain.spu.code;

import com.kkb.item.domain.shop.ShopId;
import lombok.Data;
import lombok.experimental.Accessors;
import com.kkb.item.domain.spu.SpuId;
import com.kkb.item.domain.sku.model.SkuId;


/**
 * Created by xiaogangfan.
 * Time 2018/8/17 下午3:11
 */
@Data
@Accessors(chain = true)
public class CodeLock {
  
  private ShopId shopId;
  
  private String code;
  
  private CodeType codeType;
  
  private SpuId spuId;
  
  private SkuId skuId;
  
  public enum CodeType{
    SPU_NO,
    SPU_BAR,
    SKU_NO,
    SKU_BAR
  }
}
