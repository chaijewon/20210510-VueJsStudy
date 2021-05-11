package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// ���� => �ڵ�ȣ�� 
/*
 *   ������ (�ڵ� ȣ��)
 *   �ٽɱ�� (������ => �ٽ� ���븸 �ڵ�)
 *   
 *   �ڵ� ȣ�� 
 *   1) � �޼ҵ� ���� : PointCut 
 *   2) ȣ�Ⱑ ��ġ ������� : JoinPoint
 *      = Before
 *      public void display()
 *      {
 *          @Before : getConnection()
 *          try
 *          {
 *               @Around => setAutoCommit(false)
 *                 SQL
 *                 SQL
 *               @Around => commit()
 *                => Ʈ����� , �ð�(����) , �α����� 
 *          }catch(Exception e)
 *          {
 *             @After-Throwing
 *          }
 *          finally
 *          {
 *              @After : disConnection()
 *          }
 *          
 *          ���� : return @After-Returning
 *      }
 *      = After
 *      = After-Returning
 *      = After-Throwing
 *      = Around
 *      
 *      ===========================> PointCut+JoinPoint=Advice (Advice������ => Aspect)
 */
import java.util.*;
import java.text.*;
@Component  // �޸� �Ҵ�
@Aspect
public class MyAspect {
   @Around("execution(* com.sist.web.*Controller.*(..))")
   public Object around(ProceedingJoinPoint jp) throws Throwable
   {
	   Object obj=null;
	   long start=System.currentTimeMillis();
	   obj=jp.proceed(); // ȣ��� �޼ҵ带 ������ �´� 
	   long end=System.currentTimeMillis();
	   String today=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	   System.out.println("ȣ�� �ð�:"+today);
	   System.out.println("����� ��û �޼ҵ�:"+jp.getSignature().getName());
	   System.out.println("����ð�:"+(end-start));
	   System.out.println("===============================");
	   return obj;
   }
}















