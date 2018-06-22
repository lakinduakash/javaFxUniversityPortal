package com.ultimatex.nsbm;

import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.model.Student;

import java.util.Date;

/**
 * This class hold global application states.
 * Ex: current course which student is registered, which student is being registered,which action triggered now
 * It is better to set all the field when changing the state. If not previous states may give unexpected results
 * If you don't want to save state of any field make sure those are set null
 */

public abstract class GlobalState {

    private static Course selectedCourse;
    private static Student selectedStudent;
    private static boolean fromInsertAction;
    private static boolean fromEditAction;

    private static Date simulatedDate = new Date();

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

    public static boolean isFromEditAction() {
        return fromEditAction;
    }

    public static void setFromEditAction(boolean fromEditAction) {
        GlobalState.fromEditAction = fromEditAction;
    }

    public static Date getSimulatedDate() {
        return simulatedDate;
    }

    public static void setSimulatedDate(Date simulatedDate) {
        GlobalState.simulatedDate = simulatedDate;
    }
}
