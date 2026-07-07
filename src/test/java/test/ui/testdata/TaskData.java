package test.ui.testdata;

import models.ui.Task;

public class TaskData {

    public static Task getTask() {
        return new Task(
                "Bin Task",
                "Bin Task In Progress",
                "NashTech"
        );
    }
}