package base.core.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


/**
 * Created by xiaogangfan.
 * Time 2018/6/30 下午1:51
 */
public class IdentifiedValueObject extends ValueObject {

  @Getter
  @Setter(AccessLevel.PROTECTED)
  private long id = -1L;
}
