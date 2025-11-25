package example.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect//Mark this class as an aspect specific class
public class AudienceWithAround {
	
	//Defining  pointCut Method
	@Pointcut("execution(* example.spring.aop.*.perform(..))")
	
	private void myPointCut() {}
	
	private void takeSeats()
	{
		System.out.println("Please take seats...[around]");
	}
	
	private void taurnOffMobile()
	{
		System.out.println("Please turn off mobile...[around]");
	}
	
	private void clap()
	{
		System.out.println("CLAP CLAP CLAP[around]");
	}
	
	private void demandForRefund()
	{
		System.out.println("Please give my money back[around]");
	}
	
	private void leave()
	{
		System.out.println("BYE, Leaving now...[around]");
	}
	@Around("myPointCut()")
	public void monitorPerformance(ProceedingJoinPoint joinPoint) {
		try{
			takeSeats();
		    taurnOffMobile();
	        joinPoint.proceed();
		    clap();
		}catch(Throwable e) {
			demandForRefund();
		}
		leave();
	
	}
}
