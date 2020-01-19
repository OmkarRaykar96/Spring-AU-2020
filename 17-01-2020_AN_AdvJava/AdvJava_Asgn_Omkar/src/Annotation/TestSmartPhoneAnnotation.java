package Annotation;

import java.lang.reflect.Method;

public class TestSmartPhoneAnnotation {

	public static void main(String args[])throws Exception{  
		  
		Android obj_and=new Android();  
		Method m=obj_and.getClass().getMethod("displayAndroid");  
		  
		SmartPhone smp=m.getAnnotation(SmartPhone.class); 
		System.out.println("Annotation on Method - Android");
		System.out.println("Operating System: "+smp.os());  
		System.out.println("Versions: "+smp.version());
		
		Class<Apple> appleClass = Apple.class;
		SmartPhone annotation = appleClass.getAnnotation(SmartPhone.class);
		System.out.println("\nAnnotation on Class - Apple");
		System.out.println("Operating System: "+annotation.os());  
		System.out.println("Versions: "+annotation.version());
	}
}
