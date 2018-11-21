package pl.mazurmarcin.webcalculator.aop;

import java.text.ParseException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.mazurmarcin.webcalculator.services.CalculatorStatService;

@Aspect
@Component
public class CalculatorStatsAspect {

	private CalculatorStatService calculatorStatService;

	@Autowired
	public CalculatorStatsAspect(CalculatorStatService calculatorStatService) {
		this.calculatorStatService = calculatorStatService;
	}

	@Pointcut("execution(* pl.mazurmarcin.webcalculator.services.CalculatorsService.*(..))")
	private void calculatorServices() {
	}

	@Before("calculatorServices()")
	public void addCalculatorStats(JoinPoint theJoinPoint) throws ParseException {

		String methodName = theJoinPoint.getSignature().getName();
		calculatorStatService.saveCalculatorStat(methodName);

	}

}
