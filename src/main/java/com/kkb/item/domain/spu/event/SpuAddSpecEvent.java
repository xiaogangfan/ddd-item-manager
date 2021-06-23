package com.kkb.item.domain.spu.event;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import base.core.model.BaseDomainEvent;
import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.spu.SpuId;
import com.kkb.item.domain.sku.model.SkuId;
import com.kkb.item.domain.spu.spec.SpecDefineTuple;


/**
 * Created by xiaogangfan.
 * Time 2018/8/19 上午10:07
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SpuAddSpecEvent extends BaseDomainEvent {
  private ShopId shopId;
  private SpuId spuId;
  private SpecDefineTuple origin;
  private SpecDefineTuple target;
  private List<SkuId> skusAdded;
}
