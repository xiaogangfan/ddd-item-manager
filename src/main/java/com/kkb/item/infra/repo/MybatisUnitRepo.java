package com.kkb.item.infra.repo;

import base.boot.idgen.IdGen;
import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.unit.UnitRepo;
import com.kkb.item.infra.repo.mapper.UnitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.kkb.item.domain.unit.model.Unit;
import com.kkb.item.domain.unit.model.UnitId;


@Repository
public class MybatisUnitRepo implements UnitRepo {
  
  @Autowired
  private UnitMapper unitMapper;
  
  @Autowired
  private IdGen idGen;
  
  @Override
  public UnitId nextId() {
    return new UnitId(idGen.generateId());
  }
  
  @Override
  public void save(Unit unit) {
    unitMapper.create(unit);
  }
  
  @Override
  public Unit findById(ShopId shopId, UnitId unitId) {
    return unitMapper.findById(shopId.getId(), unitId.getId());
  }
  
  @Override
  public List<Unit> list(ShopId shopId) {
    return unitMapper.findByShopId(shopId.getId());
  }
}
