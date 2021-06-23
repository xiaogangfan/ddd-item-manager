package com.kkb.item.domain.spu;

import java.util.List;

import com.kkb.item.domain.shop.ShopId;


public interface SpuRepo {
  
  List<Spu> findByShopId(ShopId shopId);
  
  SpuId nextId();
  
  void save(Spu spu);
  
  Spu findById(ShopId shopId, SpuId spuId);
  
  int updateBarCodes(Spu spu);
  
  int updateBasic(Spu spu);
  
  int updateCategory(Spu spu);
  
  int updateName(Spu spu);
  
  int updatePhotoTuple(Spu spu);
  
  int updateUnit(Spu spu);
  
  void addSpecs(Spu spu);
}
