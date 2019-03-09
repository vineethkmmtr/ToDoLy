package com.vineeth.task;

import com.vineeth.domain.Task;
import com.vineeth.domain.TaskStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskExecuter {

    private List<Task> unsavedTaskList;
    private FileUtility fileUtility;
    private BufferedReader bufferedReader;

    public TaskExecuter() {
        unsavedTaskList = new ArrayList<>();
        fileUtility = new FileUtility();
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void showAllTasks() throws IOException {
        promptForUnsavedTasks();
        //show tasks
        /*System.out.println("Please select an option");
        System.out.println("(1) Tasks by project");
        System.out.println("(2) Tasks by date");

        String option = bufferedReader.readLine();*/

        String myTasks = fileUtility.fetchTasks();
        System.out.println(myTasks);
    }

    public void addNewTask() throws IOException, InterruptedException {
        System.out.print("Enter Task Title: ");
        String title = bufferedReader.readLine();

        System.out.print("Enter Task Due Date: ");
        String dueDate = bufferedReader.readLine();

        System.out.print("Enter Project Name: ");
        String project = bufferedReader.readLine();

        Task task = new Task(title, dueDate, "To Do", project);
        unsavedTaskList.add(task);

        System.out.println("**********Task added to Todo list***********");
        System.out.println();
        Thread.sleep(1000);
    }

    public void editTask() {

    }

    public void saveAndQuit() throws IOException, InterruptedException {
        save();
        quit();
    }

    private void promptForUnsavedTasks() throws IOException {
        if (unsavedTaskList != null && unsavedTaskList.size() > 0) {
            System.out.println("There are unsaved tasks. Do you want to save them and continue? Y/N");
            String input;
            do {
                input = bufferedReader.readLine();
                switch (input.toUpperCase()) {
                    case "Y":
                        save();
                        break;
                    case "N":
                        break;
                    default:
                        System.out.println("Unknown input! Please provide correct value.");
                }
            } while (!(input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")));
        }
    }

    private void save() throws IOException {
        fileUtility.writeToFile(unsavedTaskList);
        System.out.println("***********Task list saved successfully*************");
        unsavedTaskList.clear();
    }

    private void quit() throws InterruptedException {
        System.out.println("Exiting the application. Have a nice day!");
        Thread.sleep(2000);
        System.exit(0);
    }

}
