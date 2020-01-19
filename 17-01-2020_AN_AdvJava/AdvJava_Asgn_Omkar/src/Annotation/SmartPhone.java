package Annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;


@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.METHOD, ElementType.TYPE}) 
public @interface SmartPhone {
		   String os() default "nokia";
		   int version() default 6;
}

class Android{  
@SmartPhone(os="Pie",version=9)  
public void displayAndroid(){System.out.println("Android Annotation Method");}  
}

@SmartPhone(os="iOS",version=8)  
class Apple{  
public void displayApple(){System.out.println("Apple Annotation Method");}  
} 

