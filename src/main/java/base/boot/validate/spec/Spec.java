package base.boot.validate.spec;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaogangfan.
 * Time 2018/2/3 下午3:46
 */
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { Spec.SpecChecker.class })
public @interface Spec {
  
  Class<? extends Checker>[] value();
  
  String message() default "列表元素大小不符合定义";
  
  Class<?>[] groups() default {};
  
  Class<? extends Payload>[] payload() default {};
  
  
  public static class SpecChecker implements ConstraintValidator<Spec, Object> {
  
    Spec annotation;
    
    List<Class<? extends Checker>> checkerClasses;
    
    @Override
    public void initialize(Spec constraintAnnotation) {
      annotation = constraintAnnotation;
      checkerClasses = Arrays.asList(annotation.value());
    }
    
    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
      try {
        CheckerRegistry.check(checkerClasses, object);
      }catch (Exception e){
        return false;
      }
      return true;
    }
    
  }
}
