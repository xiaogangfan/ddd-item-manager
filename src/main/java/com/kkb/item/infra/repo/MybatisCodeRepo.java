package com.kkb.item.infra.repo;

import com.kkb.item.domain.spu.code.CodeLock;
import com.kkb.item.domain.spu.code.CodeLockRepo;
import org.springframework.stereotype.Repository;


@Repository
public class MybatisCodeRepo implements CodeLockRepo {
  
  @Override
  public void remove(CodeLock code) {
  
  }
  
  
  @Override
  public CodeLock tryAcquire(Long shopId, String code) {
    return null;
  }
}
