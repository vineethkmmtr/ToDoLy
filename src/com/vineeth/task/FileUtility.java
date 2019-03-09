package com.vineeth.task;

import com.vineeth.domain.Task;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileUtility {

    public void writeToFile(List<Task> taskList) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File("MyTasks.csv");
        if (!file.exists()) {
            sb.append("Title");
            sb.append(',');
            sb.append("DueDate");
            sb.append(',');
            sb.append("Status");
            sb.append(',');
            sb.append("Project");
        }
        for (Task task : taskList) {
            sb.append('\n');
            sb.append(task.getTitle());
            sb.append(',');
            sb.append(task.getDueDate());
            sb.append(',');
            sb.append(task.getStatus());
            sb.append(',');
            sb.append(task.getProject());
        }

        FileWriter fw = new FileWriter("MyTasks.csv", true);
        PrintWriter out = new PrintWriter(fw);
        out.println(sb.toString());
        out.close();
    }

    public String fetchTasks() throws IOException {
        String tasks = "";
        Scanner scanner = new Scanner(new File("MyTasks.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            tasks = tasks + "|" + scanner.next();
        }
        scanner.close();

        return tasks;
    }

}
