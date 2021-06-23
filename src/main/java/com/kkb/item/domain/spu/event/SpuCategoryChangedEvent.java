package com.kkb.item.domain.spu.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import base.core.model.BaseDomainEvent;
import com.kkb.item.domain.category.model.CategoryId;
import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.spu.SpuId;


/**
 * Created by xiaogangfan.
 * Time 2018/8/18 下午4:43
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SpuCategoryChangedEvent extends BaseDomainEvent {
  private ShopId shopId;
  private SpuId spuId;
  private CategoryId origin;
  private CategoryId target;
}
