package com.kkb.item.application.sales.param;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;
import com.kkb.item.domain.sales.SaleChannel;


/**
 * Created by xiaogangfan.
 * Time 2018/10/6 下午3:46
 */
@Data
@Accessors(chain = true)
public class SpuSaleCreateParam {
  private Long shopId;
  private Long spuId;
  private SaleChannel saleChannel;
  private List<SkuSaleCreateParam> skuSales = new ArrayList<>();
}
