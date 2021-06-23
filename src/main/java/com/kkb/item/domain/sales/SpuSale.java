package com.kkb.item.domain.sales;

import java.util.ArrayList;
import java.util.List;

import base.core.model.IdentifiedEntity;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * Created by xiaogangfan.
 * Time 2018/10/6 下午3:31
 */
@Data
@Accessors(chain = true)
public class SpuSale extends IdentifiedEntity {
  private Long shopId;
  private Long saleId;
  private SaleChannel saleChannel;
  private Long spuId;
  private List<SkuSale> skuSales = new ArrayList<>();
  
  
  private SpuSale() {
  
  }
  
  public SpuSale(Long shopId, Long saleId, SaleChannel saleChannel, Long spuId) {
    this.shopId = shopId;
    this.saleId = saleId;
    this.saleChannel = saleChannel;
    this.spuId = spuId;
  }
  
  public SpuSale addSku(Long skuId, Long price){
    skuSales.add(new SkuSale(this, skuId, price));
    return this;
  }
}
