package com.kkb.item.domain.spu.code;


public interface CodeLockRepo {
  
  void remove(CodeLock code);
  
  CodeLock tryAcquire(Long shopId, String code);
}
