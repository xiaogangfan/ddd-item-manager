package com.kkb.item.domain.spu.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import base.core.model.BaseDomainEvent;
import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.spu.SpuId;


/**
 * Created by xiaogangfan.
 * Time 2018/8/18 上午10:28
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SpuCreatedEvent extends BaseDomainEvent {
  private ShopId shopId;
  private SpuId spuId;
}
