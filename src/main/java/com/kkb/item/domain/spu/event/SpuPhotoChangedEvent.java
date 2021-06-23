package com.kkb.item.domain.spu.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import base.core.model.BaseDomainEvent;
import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.spu.SpuId;
import com.kkb.item.domain.spu.photo.PhotoTuple;


/**
 * Created by xiaogangfan.
 * Time 2018/8/19 上午9:44
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SpuPhotoChangedEvent extends BaseDomainEvent {
  private ShopId shopId;
  private SpuId spuId;
  private PhotoTuple origin;
  private PhotoTuple target;
}
