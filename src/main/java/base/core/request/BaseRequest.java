package base.core.request;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * Created by xiaogangfan.
 * Time 2018/4/19 下午12:35
 */
@Data
@Accessors(chain = true)
public abstract class BaseRequest implements Request {
  
  private String source;
  private Operator operator;
}
