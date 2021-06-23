package com.kkb.item.domain.sales;

import base.core.model.IdentifiedEntity;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class SkuSale extends IdentifiedEntity {
  private Long shopId;
  private Long saleId;
  private SaleChannel saleChannel;
  private Long spuId;
  private Long skuId;
  private Long price;
  
  private SkuSale(){}
  
  
  public SkuSale(SpuSale spuSale, Long skuId, Long price) {
    this.shopId = spuSale.getShopId();
    this.saleId = spuSale.getSaleId();
    this.saleChannel = spuSale.getSaleChannel();
    this.spuId = spuSale.getSpuId();
    
    this.skuId = skuId;
    this.price = price;
  }
}
