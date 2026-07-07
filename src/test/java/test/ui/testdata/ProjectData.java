package test.ui.testdata;

import models.ui.Project;

public class ProjectData {

    public static Project getProject() {
        return new Project(
                "Bin Project",
                "Bin Customer",
                "Bin Project - Bin Customer",
                "Project Progress 50%"
        );
    }
}