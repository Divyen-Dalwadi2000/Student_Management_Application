package Interfaces;

import model.Student;

public interface StudentDetailsInterface {
    public boolean insertStudent(Student s);

    public boolean delete(int rollNo);

    public boolean update(int rollNo, String update, int ch, Student s);

    public void showAllStudent();

    public boolean showStudentById(int rollNo);

}
