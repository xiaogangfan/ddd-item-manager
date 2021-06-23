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


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CategoryCreatedEvent extends BaseDomainEvent {
  private ShopId shopId;
  private CategoryId categoryId;
  private String name;
}
