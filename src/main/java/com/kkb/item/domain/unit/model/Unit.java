package com.kkb.item.domain.unit.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import base.core.model.IdentifiedEntity;
import com.kkb.item.domain.shop.ShopId;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * Created by xiaogangfan.
 * Time 2018/8/17 下午2:59
 */
@Data
@Accessors(chain = true)
public class Unit extends IdentifiedEntity {
  
  private ShopId shopId;
  
  private UnitId unitId;
  
  
  @Size(min = 1, max = 20, message = "单位名称字符数为[1-20]")
  private String name;
  
  @NotNull(message = "单位状态不能为空")
  private UnitStatus status;
  
  protected Unit(){}
  
  
  public Unit(ShopId shopId, UnitId unitId, String name, UnitStatus status) {
    this.shopId = shopId;
    this.unitId = unitId;
    this.name = name;
    this.status = status;
    
    this.validate();
  }
  
  
}
