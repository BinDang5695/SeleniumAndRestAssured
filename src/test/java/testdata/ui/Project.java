package testdata.ui;

public class Project {

    public static models.ui.Project getProject() {
        return new models.ui.Project(
                "Bin Project",
                "Bin Customer",
                "Bin Project - Bin Customer",
                "Project Progress 50%"
        );
    }
}