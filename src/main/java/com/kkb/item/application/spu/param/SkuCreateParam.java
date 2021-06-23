package com.kkb.item.application.spu.param;

import java.util.List;

import com.kkb.item.domain.spu.spec.SpecTuple;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * Created by chensu on 2018/5/23.
 */
@Data
@Accessors(chain = true)
public class SkuCreateParam implements SkuSaveParam {
  
  /**
   * 店铺ID
   */
  private Long shopId;
  
  /**
   * 建议零售价
   */
  private Long retailPrice;
  /**
   * 商品编码
   */
  private String skuNo;

  /**
   * 一品多码
   */
  private List<String> barCodes;//一品多码
  
  /**
   *规格属性
   */
  private SpecTuple specTuple;
  
}

