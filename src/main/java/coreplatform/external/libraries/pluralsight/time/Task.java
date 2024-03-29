package coreplatform.external.libraries.pluralsight.time;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Task {

	private final Duration duration;
	private final String description;
	private final List<TaskPart> taskParts;

	public Task(Duration duration, String description) {
		this.duration = duration;
		this.description = description;
		taskParts = new ArrayList<>();
	}

	public Task(int hours, int minutes, String description) {
		this(Duration.ofHours(hours).plus(Duration.ofMinutes(minutes)), description);
	}

	public Task(int minutes, String description) {
		this(Duration.ofMinutes(minutes), description);
	}

	public Duration getDuration() {
		return duration;
	}

	String getDescription() {
		return description;
	}

	TaskPart createTaskPart(Duration d) {
		TaskPart t = new TaskPart(this, d, taskParts.size() + 1);
		taskParts.add(t);
		return t;
	}

	int getTaskPartCount() {
		return taskParts.size();
	}
}
