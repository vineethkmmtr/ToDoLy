package com.vineeth;

import com.vineeth.task.TaskExecuter;

import java.io.IOException;
import java.util.Scanner;

public class TodoApp {

    private static TaskExecuter taskExecuter;

    public static void main(String[] args) throws IOException, InterruptedException {
        taskExecuter = new TaskExecuter();
        System.out.println("Welcome to ToDoLy");
        System.out.println("You have x tasks to do and Y tasks are done");

        while(true) {
            int selectedOption = displayDefaultUserInputOptions();

            switch (selectedOption) {
                case 1:
                    taskExecuter.showAllTasks();
                    break;
                case 2:
                    taskExecuter.addNewTask();
                    break;
                case 3:
                    // code block
                    break;
                case 4:
                    taskExecuter.saveAndQuit();
                    break;
                default:
                    System.out.println("Unknown input! Please provide correct value.");
            }
        }
    }

    private static int displayDefaultUserInputOptions() throws IOException {
        System.out.println("Pick an option");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        return option;
    }
}
