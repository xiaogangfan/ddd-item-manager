package com.kkb.item.application.spu.param;

import java.util.ArrayList;
import java.util.List;

import com.kkb.item.domain.spu.spec.SpecDefineTuple;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * Created by xiaogangfan.
 * Time 2018/8/18 下午9:54
 */
@Data
@Accessors(chain = true)
public class SpuAddSpecParam {
  
  private Long shopId;
  
  private Long spuId;
  
  private SpecDefineTuple specDefineTuple;
  
  private List<SkuCreateParam> skus = new ArrayList<>();
  
}
