package base.boot.validate.spec;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.List;

public class CheckerRegistry implements ApplicationContextAware {
  
  @Setter
  private static ApplicationContext applicationContext;
  
  @Getter
  @Setter
  private static List<Checker> checkers;
  
  public static void check(List<Class<? extends Checker>> checkerClasses, Object entity){
    if(checkers!=null) {
      checkers.stream()
          .filter(x-> checkerClasses.contains(x.getClass()))
          .filter(x -> entity.getClass().equals(x.supports()))
          .forEach(spec -> spec.check(entity));
    }
  }
  
  public static void check(Object entity){
    if(checkers!=null) {
      checkers.stream().filter(x -> entity.getClass().equals(x.supports())).forEach(spec -> spec.check(entity));
    }
  }
  
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    CheckerRegistry.applicationContext = applicationContext;
    checkers = new ArrayList<>(applicationContext.getBeansOfType(Checker.class).values());
  }
}
