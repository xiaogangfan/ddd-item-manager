package com.kkb.item.domain.unit;

import java.util.List;

import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.unit.model.Unit;
import com.kkb.item.domain.unit.model.UnitId;

public interface UnitRepo {
  UnitId nextId();
  void save(Unit unit);
  Unit findById(ShopId shopId, UnitId unitId);
  List<Unit> list(ShopId shopId);
}
