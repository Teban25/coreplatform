package coreplatform.quickreview;

public interface InterfaceExamples {

	void method1(String str);

	default void log(String str) {
		System.out.println("Logging: " + str);
	}
	
	default void log2(String str) {
		System.out.println("Logging: " + str);
	}

	static void print(String str) {
		System.out.println("Printing: " + str);
	}

}
