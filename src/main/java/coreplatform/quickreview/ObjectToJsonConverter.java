package coreplatform.quickreview;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectToJsonConverter {

	public String convertToJson(Object object) throws JsonSerializationException {
		try {
			checkIfSerializable(object);
			initializeObject(object);
			return getJsonString(object);
		} catch (Exception e) {
			throw new JsonSerializationException(e.getMessage(), e);
		}
	}

	private String getJsonString(Object object) 
			throws IllegalArgumentException, IllegalAccessException {
		Class<?> classType = object.getClass();
		Map<String, String> jsonElementsMap = new HashMap<>();
		for (Field field : classType.getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(JsonElement.class)) {
				jsonElementsMap.put(field.getName(), (String) field.get(object));
			}
		}
		
		String jsonString = jsonElementsMap
				.entrySet()
				.stream()
				.map(entry -> "\"" + entry.getKey() + "\":\""
						+ entry.getValue() + "\"")
				.collect(Collectors.joining(","));
		return "{" + jsonString + "}";
	}

	private void initializeObject(Object object) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> classType = object.getClass();
		for (Method method : classType.getDeclaredMethods()) {
			if (method.isAnnotationPresent(Init.class)) {
				method.setAccessible(true);
				method.invoke(object);
			}
		}
	}

	private void checkIfSerializable(Object object) {
		if (Objects.isNull(object)) {
			throw new JsonSerializationException("The object to serialize is null");
		}
		
		Class<?> classType = object.getClass();
		if(!classType.isAnnotationPresent(JsonSerializable.class)) {
			throw new JsonSerializationException("The class " + classType.getSimpleName() + 
					" is not annotated with JsonSerializable");
		}
	}
}
