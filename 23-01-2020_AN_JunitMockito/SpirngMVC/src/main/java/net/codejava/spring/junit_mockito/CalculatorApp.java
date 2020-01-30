package net.codejava.spring.junit_mockito;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;  


@RunWith(MockitoJUnitRunner.class)
public class CalculatorApp {
	
   @InjectMocks 
   CalcPojo mathApplication = new CalcPojo();

   @Mock
   CalcInterface calcService;

   @Test
   public void testAdd(){

	  when(calcService.add(55,45)).thenReturn(100);
      when(calcService.subtract(20,20)).thenReturn(0);
      when(calcService.multiply(10,5)).thenReturn(50);
      when(calcService.divide(200,2)).thenReturn(100);
		
      Assert.assertEquals(calcService.add(55, 45),100,0);
      Assert.assertEquals(calcService.subtract(20, 20),0,0);
      Assert.assertEquals(calcService.multiply(10, 5),50,0);
      Assert.assertEquals(calcService.divide(200, 2),100,0);
       
      InOrder inOrder = inOrder(calcService);
      
      inOrder.verify(calcService).add(55,45);
      inOrder.verify(calcService).subtract(20,20);
      inOrder.verify(calcService).multiply(10,5);
      inOrder.verify(calcService).divide(200,2);

       verify(calcService).multiply(10, 5);
       verify(calcService).divide(200, 2);
   }
}