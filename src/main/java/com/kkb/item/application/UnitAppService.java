package com.kkb.item.application;

import base.boot.event.publish.DomainEventPublisher;
import base.core.exception.BusinessException;
import com.kkb.item.application.unit.param.UnitCreateParam;
import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.unit.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import com.kkb.item.domain.unit.model.Unit;
import com.kkb.item.domain.unit.model.UnitId;
import com.kkb.item.domain.unit.event.UnitCreatedEvent;


/**
 * Created by xiaogangfan.
 * Time 2018/8/20 下午1:28
 */
@Service
public class UnitAppService {
  
  @Autowired
  private UnitRepo unitRepo;
  
  public Unit findById(Long shopId, Long unitId){
    return Optional.ofNullable(unitRepo.findById(new ShopId(shopId), new UnitId(unitId)))
        .orElseThrow(()->new BusinessException("单位不存在"));
  }
  
  public List<Unit> list(Long shopId){
    return unitRepo.list(new ShopId(shopId));
  }

  @Transactional
  public Long create(@RequestBody UnitCreateParam param){
    
    Unit unit = new Unit(
        param.getShopId(),
        unitRepo.nextId(),
        param.getName(),
        param.getStatus()
    );
  
    DomainEventPublisher.publish(new UnitCreatedEvent()
        .setShopId(unit.getShopId())
        .setName(unit.getName())
        .setStatus(unit.getStatus())
        .setUnitId(unit.getUnitId())
    );
    
    unitRepo.save(unit);
    
    return unit.getUnitId().getId();
  }
  
}
