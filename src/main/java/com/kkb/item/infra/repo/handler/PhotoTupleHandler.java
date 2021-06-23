package com.kkb.item.infra.repo.handler;

import com.kkb.item.domain.spu.photo.PhotoTuple;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import base.boot.mybatis.handler.JsonTypeHandler;


@MappedTypes(PhotoTuple.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class PhotoTupleHandler extends JsonTypeHandler<PhotoTuple> {
  
}
