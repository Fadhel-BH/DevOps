package tn.esprit.spring.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {
	



	@Around("execution(int tn.esprit.spring.services.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
            long start = System.currentTimeMillis();
            Object out=pjp.proceed();
            long elapsedTime = System.currentTimeMillis() - start;
            if (elapsedTime!=0) {
                throw new IllegalStateException("Method execution time: " + elapsedTime + " milliseconds.");
            }
            return out;
    }

}
