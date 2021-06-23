package com.kkb.item.domain.spu.spec;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import base.core.model.AssertionConcern;

import static java.util.stream.Collectors.joining;


@Data
public class SpecTuple extends AssertionConcern {
  
  @NotNull
  @Size(max = 3, message = "规格项最多3层")
  private List<Spec> specs = new ArrayList<>();
  
  public SpecTuple(List<Spec> specs) {
    this.specs = specs;
    this.validate();
  }
  
  protected SpecTuple(){
  
  }
  
  public String makeOrder(){
    return specs.stream().map(Spec::getOrder).collect(joining("_"));
  }
  
}
