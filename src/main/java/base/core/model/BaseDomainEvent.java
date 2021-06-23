package base.core.model;

import lombok.Getter;

import java.util.Date;


public abstract class BaseDomainEvent implements DomainEvent {
  
  @Getter
  protected int eventVersion = 1;
  
  @Getter
  protected Date OccurredOn = new Date();
}
