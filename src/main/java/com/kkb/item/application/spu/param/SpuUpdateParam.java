package com.kkb.item.application.spu.param;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.kkb.item.domain.spu.photo.PhotoTuple;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * Created by xiaogangfan.
 * Time 2018/8/18 下午5:32
 */
@Data
@Accessors(chain = true)
public class SpuUpdateParam {
  
  private Long shopId;
  /**
   * 商品id
   */
  private Long spuId;
  /**
   * 分类
   */
  @NotNull(message = "商品分类不能为空")
  private Long categoryId;
  
  /**
   * 单位
   */
  @NotNull(message = "单位不能为空")
  private Long unitId;
  /**
   * 名称
   */
  private String name;
  
  /**
   * 图片地址 如不设置 前端会默认传一个默认图片 json格式
   */
  private PhotoTuple photoTuple;
  
  /**
   * 一品多码
   */
  private List<String> barCodes = new ArrayList<>();//一品多码
  
}
