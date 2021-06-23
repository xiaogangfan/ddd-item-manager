package com.kkb.item.domain.spu.spec;

import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import base.core.model.AssertionConcern;


@Getter
@Setter(AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode(exclude = "order")
public class Spec extends AssertionConcern {
  
  @Size(max=10, min=1, message = "规格项字符数必须在1-10")
  private String key;
  
  @Size(max=10, min=1, message = "规格项字符数必须在1-10")
  private String value;
  
  private String order;
  
  protected Spec(){}
  
  public Spec(String key, String value) {
    this.key = key;
    this.value = value;
    this.validate();
  }
  
  public Spec setOrder(String order){
    this.order = order;
    return this;
  }
}
