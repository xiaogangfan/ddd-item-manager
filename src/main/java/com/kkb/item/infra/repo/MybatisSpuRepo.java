package com.kkb.item.infra.repo;

import base.boot.idgen.IdGen;
import com.kkb.item.domain.shop.ShopId;
import com.kkb.item.domain.spu.Spu;
import com.kkb.item.domain.spu.SpuId;
import com.kkb.item.domain.spu.SpuRepo;
import com.kkb.item.infra.repo.mapper.SkuMapper;
import com.kkb.item.infra.repo.mapper.SpuMapper;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Repository
public class MybatisSpuRepo implements SpuRepo {
  
  @Autowired
  private IdGen idGen;
  
  @Autowired
  private SpuMapper spuMapper;
  
  @Autowired
  private SkuMapper skuMapper;
  
  @Override
  public List<Spu> findByShopId(ShopId shopId) {
    return spuMapper.findByShopId(shopId.getId());
  }
  
  @Override
  public SpuId nextId() {
    return new SpuId(idGen.generateId());
  }
  
  @Override
  public void save(Spu spu) {
    spuMapper.create(spu);
    spu.getSkus().forEach(sku -> skuMapper.create(sku));
  }
  
  @Override
  public Spu findById(ShopId shopId, SpuId spuId) {
    return spuMapper.findById(shopId.getId(), spuId.getId());
  }
  
  @Override
  public int updateBasic(Spu spu) {
    return spuMapper.update(spu);
  }
  
  @Override
  public int updateBarCodes(Spu spu) {
    return spuMapper.update(spu);
  }
  
  
  @Override
  public int updateCategory(Spu spu) {
    return spuMapper.update(spu);
  }
  
  
  @Override
  public int updateName(Spu spu) {
    return spuMapper.update(spu);
  }
  
  
  @Override
  public int updatePhotoTuple(Spu spu) {
    return spuMapper.update(spu);
  }
  
  
  @Override
  public int updateUnit(Spu spu) {
    return spuMapper.update(spu);
  }
  
  @Override
  public void addSpecs(Spu spu) {
    spuMapper.update(spu);
    val groups = spu.getSkus().stream().collect(Collectors.partitioningBy(s-> Objects.equals(-1L, s.getId())));
    if(! groups.get(true).isEmpty()) {
      groups.get(true).forEach(sku->skuMapper.create(sku));
    }
  }
  
  
}
