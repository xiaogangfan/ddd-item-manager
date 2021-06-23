package com.kkb.item.infra.repo.handler;

import org.apache.ibatis.type.MappedTypes;

import java.util.List;

import base.boot.mybatis.handler.ListJsonTypeHandler;
import com.kkb.item.domain.sales.SkuSale;


/**
 * Created by xiaogangfan.
 * Time 2018/10/6 下午4:48
 */
@MappedTypes(List.class)
public class SkuSalesListHandler extends ListJsonTypeHandler<SkuSale> {
  
}
