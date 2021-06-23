package com.kkb.item.infra.repo.handler;

import com.kkb.item.domain.spu.code.SpuBarCodeTuple;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import base.boot.mybatis.handler.JsonTypeHandler;


@MappedTypes(SpuBarCodeTuple.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class SpuBarCodeTupleHandler extends JsonTypeHandler<SpuBarCodeTuple> {
  
}
