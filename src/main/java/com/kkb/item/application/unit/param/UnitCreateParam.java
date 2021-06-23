package com.kkb.item.application.unit.param;

import com.kkb.item.domain.shop.ShopId;
import lombok.Data;
import lombok.experimental.Accessors;
import com.kkb.item.domain.unit.model.UnitStatus;


/**
 * Created by xiaogangfan.
 * Time 2018/10/6 下午9:47
 */
@Data
@Accessors(chain = true)
public class UnitCreateParam {
  
  private ShopId shopId;
  
  private String name;
  
  private UnitStatus status;
}
