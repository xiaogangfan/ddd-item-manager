package com.kkb.item.infra.repo.handler;

import com.kkb.item.domain.spu.spec.SpecTuple;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import base.boot.mybatis.handler.JsonTypeHandler;


/**
 * Created by xiaogangfan.
 * Time 2018/8/19 下午7:43
 */
@MappedTypes(SpecTuple.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class SpecTupleHandler extends JsonTypeHandler<SpecTuple> {
  
}
