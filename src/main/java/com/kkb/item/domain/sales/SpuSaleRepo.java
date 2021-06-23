package com.kkb.item.domain.sales;

/**
 * Created by xiaogangfan.
 * Time 2018/10/6 下午3:41
 */
public interface SpuSaleRepo {
  Long nextId();
  void save(SpuSale sale);
  SpuSale findById(Long shopId, Long saleId);
  
}
