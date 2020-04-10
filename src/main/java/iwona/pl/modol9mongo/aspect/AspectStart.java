package iwona.pl.modol9mongo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static java.lang.System.currentTimeMillis;

@Aspect
@Component
public class AspectStart {

   private double  startTime;

    @Before("@annotation(BeforeStart)")
    public void beforeStart() {
        startTime = currentTimeMillis();
        System.out.println("start read: ");
    }

    @After("@annotation(AfterStart)")
    public void afterStart() {
      double duration = (currentTimeMillis() - startTime);
        System.out.println("after read: " + duration);
    }

    @Around("@annotation(AroundStart)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        double start = currentTimeMillis();
        joinPoint.proceed();
        double end = currentTimeMillis();
        double duration = (end-start);
        System.out.println("Czas zapisu dla mogo Db: " +duration);
    }

}
