package coreplatform.quickreview;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class TestReviews {

	@Test
	public void givenObjectSerializedThenTrueReturned() {
		Person person = new Person("teban", "gomez", "28");
		ObjectToJsonConverter objectToJsonConverter = new ObjectToJsonConverter();
		String json = objectToJsonConverter.convertToJson(person);
		assertEquals("{\"firstName\":\"Teban\",\"lastName\":\"Gomez\",\"age\":\"28\"}", json);
	}
	
	@Test
	public void testThatExecuteGenericSums() {
		double example1 = GenericsExamples.genericSum(1.0, 1.5);
		int example2 = (int)GenericsExamples.genericSum(1, 1);
		assertEquals(2.5, example1, 0);
		assertEquals(2, example2);
	}
	
	@Test
	public void testThatExecuteComparisonOrSorts() {
		Person person1 = new Person("David", "Gomez", "28");
		Person person2 = new Person("Mateo", "Gomez", "8");
		Person person3 = new Person("Xilena", "Gutierrez", "27");
		Person person4 = new Person("Mateo", "Castrillon", "26");
		
		List<Person> persons = new ArrayList<>();
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		persons.add(person4);
		List<Person> persons2 = new ArrayList<>(persons);
		List<Person> persons3 = new ArrayList<>();
		persons3.addAll(persons);
		
		Collections.sort(persons);
		Collections.sort(persons2, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				int firstComparison = o1.getLastName().compareTo(o2.getLastName());
				return firstComparison == 0 ? o1.getFirstName().compareTo(o2.getFirstName()) : firstComparison;
			}
			
		});
		Collections.sort(persons3, (p1, p2) -> Integer.valueOf(p1.getAge()) - Integer.valueOf(p2.getAge()));
		
		assertEquals("Castrillon", persons.get(1).getLastName());
		assertEquals("Castrillon", persons2.get(0).getLastName());
		assertEquals("8", persons3.get(0).getAge());
		
		InterfaceExamples interfaceExamples = new TestingInterface();
	}
}
