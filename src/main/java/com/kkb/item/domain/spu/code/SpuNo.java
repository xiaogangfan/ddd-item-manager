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


/**
 * Created by xiaogangfan.
 * Time 2018/8/17 下午3:18
 */
@ToString
@EqualsAndHashCode
@Getter
@Setter(AccessLevel.PROTECTED)
@Accessors(chain = true)
public class SpuNo extends AssertionConcern {
  
  @NotNull(message = "商家不能为空")
  private ShopId shopId;
  
  @NotNull(message = "spuID不能为空")
  private SpuId spuId;
  
  @NotNull(message = "spu编码不能为空")
  @Size(max = 20, message = "条码最多20个字符")
  @Pattern(regexp = "^[-a-zA-Z0-9]+$", message = "商品条码不合法")
  private String code;
  
  protected SpuNo(){
  
  }
  
  public SpuNo(ShopId shopId, SpuId spuId, String code){
    this.shopId = shopId;
    this.spuId = spuId;
    this.code = code;
    this.validate();
  }
}
