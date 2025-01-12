package org.crcketiplmatch.restapi.todo.Service;

import org.crcketiplmatch.restapi.todo.Entity.Task;
import org.crcketiplmatch.restapi.todo.Repositry.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            if (updatedTask != null) {
                if (updatedTask.getTitle() != null) {
                    task.setTitle(updatedTask.getTitle());
                }
                if (updatedTask.getDescription() != null) {
                    task.setDescription(updatedTask.getDescription());
                }
            }
            task.setCompleted(updatedTask.isCompleted());
            return taskRepository.save(task);
        }).orElse(null);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
