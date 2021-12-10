package coreplatform.quickreview;


public class GenericsExamples{

	
	public static <T extends Number> double genericSum(T param1, T param2) {
		return param1.doubleValue() + param2.doubleValue();
	}
}
