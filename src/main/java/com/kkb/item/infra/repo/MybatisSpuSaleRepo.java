package com.kkb.item.infra.repo;

import base.boot.idgen.IdGen;
import com.kkb.item.infra.repo.mapper.SpuSaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kkb.item.domain.sales.SpuSale;
import com.kkb.item.domain.sales.SpuSaleRepo;


/**
 * Created by xiaogangfan.
 * Time 2018/10/6 下午4:49
 */
@Repository
public class MybatisSpuSaleRepo implements SpuSaleRepo {
  
  @Autowired
  private SpuSaleMapper spuSaleMapper;
  
  @Autowired
  private IdGen idGen;
  
  
  @Override
  public Long nextId() {
    return idGen.generateId();
  }
  
  
  @Override
  public void save(SpuSale sale) {
    spuSaleMapper.create(sale);
  }
  
  @Override
  public SpuSale findById(Long shopId, Long saleId) {
    return spuSaleMapper.findById(shopId,saleId);
  }
}
