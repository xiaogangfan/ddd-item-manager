package com.kkb.item.domain.spu.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import base.core.model.BaseDomainEvent;
import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.spu.SpuId;
import com.kkb.item.domain.unit.model.UnitId;


/**
 * Created by xiaogangfan.
 * Time 2018/8/18 下午4:58
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SpuUnitChangedEvent extends BaseDomainEvent {
  private ShopId shopId;
  private SpuId spuId;
  private UnitId origin;
  private UnitId target;
}
