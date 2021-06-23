package com.kkb.item.domain.spec;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import base.core.model.IdentifiedEntity;
import com.kkb.item.domain.shop.ShopId;


/**
 * Created by xiaogangfan.
 * Time 2018/8/17 上午9:49
 */
@Getter
@Setter(AccessLevel.PACKAGE)
@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SpecKey extends IdentifiedEntity {
  private ShopId shopId;
  private String name;
}
