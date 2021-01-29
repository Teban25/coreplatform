package coreplatform.section4.stringformatting;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainStringFormatting {

	public static void main(String[] args) {
		System.out.println("-------------------StringJoiner examples------------------------");
		stringJoinerExample();
		System.out.println("-------------------pattern examples------------------------");
		patternExamples();
		
		System.out.println("-------------------Formating examples------------------------");
		formatExamples();
	}
	
	private static void formatExamples() {
		String s1 = String.format("W:%d X:%d", 5,235);
		String s2 = String.format("W:%4d X:%4d", 5,235);
		String s3 = String.format("W:%04d X:%04d", 5,235);
		String s4 = String.format("W:%-4d X:%-4d", 5,235);
		String s5 = String.format("%,d", 1234567);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
	}
	
	private static void patternExamples() {
		String log = "210 250 sign";
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(log);
		
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
		System.out.println("---------------");
				
		List<String> elements = Arrays.asList(log.split("\\s"));
		elements.forEach(System.out::println);
	}

	private static void stringJoinerExample() {
		// StringJoiner examples

		StringJoiner sj = new StringJoiner(","); // separated by comma
		sj.setEmptyValue("EMPTY");
		StringJoiner soccerTeams = new StringJoiner("],[", "[", "]");

		sj.add("Mateo");
		sj.add("Karla");
		sj.add("Rose");
		System.out.println(sj.toString());

		soccerTeams.add("DIM");
		soccerTeams.add("ANAL");
		soccerTeams.add("Junior");

		System.out.println(soccerTeams.toString());
	}
}
