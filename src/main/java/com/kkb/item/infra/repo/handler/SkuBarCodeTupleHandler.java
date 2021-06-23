package com.kkb.item.infra.repo.handler;

import com.kkb.item.domain.spu.code.SkuBarCodeTuple;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import base.boot.mybatis.handler.JsonTypeHandler;


@MappedTypes(SkuBarCodeTuple.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class SkuBarCodeTupleHandler extends JsonTypeHandler<SkuBarCodeTuple> {
  
}
