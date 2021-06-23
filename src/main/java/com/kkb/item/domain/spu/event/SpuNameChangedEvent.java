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
 * Time 2018/8/18 下午4:34
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SpuNameChangedEvent extends BaseDomainEvent {
  private ShopId shopId;
  private SpuId spuId;
  private String origin;
  private String target;
}
