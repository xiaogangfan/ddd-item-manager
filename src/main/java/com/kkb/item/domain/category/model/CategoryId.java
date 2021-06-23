package com.kkb.item.domain.category.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Created by xiaogangfan.
 * Time 2018/8/13 上午10:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryId implements Serializable {
  private Long id;
  
  public static CategoryId root(){
    return new CategoryId(0L);
  }
}
