package coreplatform.reflection;

import java.util.Arrays;

public class ReflectionApp {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> example1 = BankReflection.class;
		Class<?> example2 = Class.forName("coreplatform.section9.reflection.BankReflection");
		Class<?> example3 = new BankReflection().getClass();

		showClassName(example1);
		showClassName(example2);
		showClassName(example3);
		System.out.println("<-------------------------------------------------->");
		showParentClassAndInterfaces(example1);
		showModifiers(example1);
	}

	private static void showClassName(Class<?> classType) {
		System.out.println(classType.getCanonicalName());
		System.out.println(classType.getSimpleName());
	}
	
	private static void showParentClassAndInterfaces(Class<?> classType) {
		System.out.println(classType.getSuperclass().getSimpleName());
		Arrays.asList(classType.getInterfaces()).forEach(System.out::println);
	}
	
	private static void showModifiers(Class<?> classType) {
		Arrays.asList(classType.getModifiers()).forEach(System.out::println);
	}
}
