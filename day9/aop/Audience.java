package example.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect//Mark this class as an aspect specific class
public class Audience {
	
	//Defining  pointCut Method
	@Pointcut("execution(* example.spring.aop.*.perform(..))")
	//@Pointcut("execution(* example.spring.aop.Musician.perform(..))")
	//@Pointcut("execution(* example.spring.aop.Singer.perform(..))")
	//@Pointcut("execution(* example.spring.aop.S*.perform(..))")
	//@Pointcut("execution(* example.spring.aop.*i*.perform(..))")
	private void myPointCut() {}
	@Before("myPointCut()")//pointCut Expression
	public void takeSeats()
	{
		System.out.println("Please take seats...");
	}
	@Before("myPointCut()")
	public void taurnOffMobile()
	{
		System.out.println("Please turn off mobile...");
	}
	@AfterReturning("myPointCut()")
	public void clap()
	{
		System.out.println("CLAP CLAP CLAP");
	}
	@AfterThrowing("myPointCut()")
	public void demandForRefund()
	{
		System.out.println("Please give my money back");
	}
	@After("myPointCut()")
	public void leave()
	{
		System.out.println("BYE, Leaving now...");
	}
}
