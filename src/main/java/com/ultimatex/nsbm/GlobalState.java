package com.ultimatex.nsbm;

import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.model.Student;

public abstract class GlobalState {

    private static Course selectedCourse;
    private static Student selectedStudent;
    private static boolean fromInsertAction;

    public static Course getSelectedCourse() {
        return selectedCourse;
    }

    public static void setSelectedCourse(Course selectedCourse) {
        GlobalState.selectedCourse = selectedCourse;
    }

    public static Student getSelectedStudent() {
        return selectedStudent;
    }

    public static void setSelectedStudent(Student selectedStudent) {
        GlobalState.selectedStudent = selectedStudent;
    }

    public static boolean isFromInsertAction() {
        return fromInsertAction;
    }

    public static void setFromInsertAction(boolean fromInsertAction) {
        GlobalState.fromInsertAction = fromInsertAction;
    }
}
