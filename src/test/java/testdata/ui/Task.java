package testdata.ui;

public class Task {

    public static models.ui.Task getTask() {
        return new models.ui.Task(
                "Bin Task",
                "Bin Task In Progress",
                "Bin updated Task"
        );
    }
}