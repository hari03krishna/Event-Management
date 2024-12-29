package com.eventmanagement.dao;

import java.util.List;

import com.eventmanagement.models.Task;

public interface TaskDAO {
	
	    List<Task> getTasksByEventId(int eventId);
	    Task getTaskById(int taskId);
	    void updateTask(Task task);
}
