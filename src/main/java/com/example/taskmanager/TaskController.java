package com.example.taskmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public TaskController() {
        tasks.add(new Task(nextId.getAndIncrement(), "Learn Maven", false));
        tasks.add(new Task(nextId.getAndIncrement(), "Create a Jenkins pipeline", false));
        tasks.add(new Task(nextId.getAndIncrement(), "Push the project to GitHub", true));
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @PostMapping("/tasks")
    public String addTask(@RequestParam String title) {
        if (title != null && !title.isBlank()) {
            tasks.add(new Task(nextId.getAndIncrement(), title.trim(), false));
        }
        return "redirect:/";
    }

    @PostMapping("/tasks/{id}/complete")
    public String completeTask(@PathVariable long id) {
        tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .ifPresent(task -> task.setCompleted(!task.isCompleted()));
        return "redirect:/";
    }

    @PostMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable long id) {
        tasks.removeIf(task -> task.getId() == id);
        return "redirect:/";
    }

    public static class Task {
        private final long id;
        private final String title;
        private boolean completed;

        public Task(long id, String title, boolean completed) {
            this.id = id;
            this.title = title;
            this.completed = completed;
        }

        public long getId() { return id; }
        public String getTitle() { return title; }
        public boolean isCompleted() { return completed; }
        public void setCompleted(boolean completed) { this.completed = completed; }
    }
}
