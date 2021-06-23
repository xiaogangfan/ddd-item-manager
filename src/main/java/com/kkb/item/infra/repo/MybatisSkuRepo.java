package com.kkb.item.infra.repo;

import base.boot.idgen.IdGen;
import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.sku.SkuRepo;
import com.kkb.item.domain.sku.model.Sku;
import com.kkb.item.domain.sku.model.SkuId;
import com.kkb.item.domain.spu.SpuId;
import com.kkb.item.infra.repo.mapper.SkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MybatisSkuRepo implements SkuRepo {
  
  @Autowired
  private IdGen idGen;
  
  @Autowired
  private SkuMapper skuMapper;
  
  @Override
  public void save(Sku sku) {
    skuMapper.create(sku);
  }
  
  
  @Override
  public void batchSave(List<Sku> skus) {
    skus.forEach(sku-> skuMapper.create(sku));
//    skuMapper.batchCreate(skus);
  }
  
  
  @Override
  public List<Sku> findBySpuId(ShopId shopId, SpuId spuId) {
    return skuMapper.findBySpuId(shopId.getId(), spuId.getId());
  }
  
  
  @Override
  public Sku findBySkuId(ShopId shopId, SkuId skuId) {
    return skuMapper.findBySkuId(shopId.getId(), skuId.getId());
  }
  
  
  @Override
  public SkuId nextId() {
    return new SkuId(idGen.generateId());
  }
  
  
  @Override
  public void updateSku(Sku sku) {
    skuMapper.update(sku);
  }
}
