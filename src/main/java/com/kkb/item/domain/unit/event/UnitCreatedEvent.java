package com.kkb.item.domain.unit.event;

import base.core.model.BaseDomainEvent;
import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.unit.model.UnitId;
import com.kkb.item.domain.unit.model.UnitStatus;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;


/**
 * Created by xiaogangfan.
 * Time 2018/8/25 下午8:01
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class UnitCreatedEvent extends BaseDomainEvent {
  
  private ShopId shopId;
  
  private UnitId unitId;
  
  private String name;
  
  private UnitStatus status;
}
