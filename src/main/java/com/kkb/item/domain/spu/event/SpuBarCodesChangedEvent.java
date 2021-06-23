package com.kkb.item.domain.spu.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import base.core.model.BaseDomainEvent;
import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.spu.SpuId;
import com.kkb.item.domain.spu.code.SpuBarCodeTuple;


@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SpuBarCodesChangedEvent extends BaseDomainEvent {
  private ShopId shopId;
  private SpuId spuId;
  private SpuBarCodeTuple origin;
  private SpuBarCodeTuple target;
}
