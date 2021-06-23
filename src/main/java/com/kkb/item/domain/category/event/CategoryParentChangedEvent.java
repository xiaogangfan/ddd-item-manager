package com.kkb.item.domain.category.event;

import base.core.model.BaseDomainEvent;
import com.kkb.item.domain.category.model.CategoryId;
import com.kkb.item.domain.shop.ShopId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


/**
 * Created by xiaogangfan.
 * Time 2018/8/13 上午10:52
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CategoryParentChangedEvent extends BaseDomainEvent {
  private ShopId shopId;
  private CategoryId categoryId;
  private CategoryId originParent;
  private CategoryId nowParent;
  private Integer levelChanged;
}
