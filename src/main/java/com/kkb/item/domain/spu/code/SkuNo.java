package com.kkb.item.domain.spu.code;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.kkb.item.domain.shop.ShopId;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import base.core.model.AssertionConcern;
import com.kkb.item.domain.spu.SpuId;
import com.kkb.item.domain.sku.model.SkuId;


/**
 * Created by xiaogangfan.
 * Time 2018/8/17 下午3:19
 */
@EqualsAndHashCode
@ToString
@Getter
@Setter(AccessLevel.PROTECTED)
@Accessors(chain = true)
public class SkuNo extends AssertionConcern {
  
  @NotNull(message = "商家不能为空")
  private ShopId shopId;
  @NotNull(message = "spuID不能为空")
  private SpuId spuId;
  @NotNull(message = "skuID不能为空")
  private SkuId skuId;
  @NotNull(message = "sku编码不能为空")
  @Size(max = 20, message = "条码最多20个字符")
  @Pattern(regexp = "^[-a-zA-Z0-9]+$", message = "商品条码不合法")
  private String code;
  
  protected SkuNo() {
  }
  
  public SkuNo(ShopId shopId, SpuId spuId, SkuId skuId,String code) {
    this.shopId = shopId;
    this.spuId = spuId;
    this.skuId = skuId;
    this.code = code;
    
    this.validate();
  }
  
}
