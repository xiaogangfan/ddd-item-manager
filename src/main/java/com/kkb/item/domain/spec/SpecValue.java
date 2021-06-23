package com.kkb.item.domain.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import base.core.model.IdentifiedEntity;
import com.kkb.item.domain.shop.ShopId;


/**
 * Created by xiaogangfan.
 * Time 2018/8/17 上午9:50
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SpecValue extends IdentifiedEntity {
  private ShopId shopId;
  private SpecKey key;
  private String name;
}
