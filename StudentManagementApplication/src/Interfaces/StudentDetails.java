package Interfaces;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Student;

public class StudentDetails implements StudentDetailsInterface {

    @Override
    public boolean insertStudent(Student s) {
        boolean flag = false;
        try {

            Connection conn = DBConnection.createConnection();
            String query = "insert into student(name,clgName,city,percentage) values (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, s.getName());
            statement.setString(2, s.getClgName());
            statement.setString(3, s.getCity());
            statement.setDouble(4, s.getPercentage());
            statement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public void showAllStudent() {
        boolean flag = false;
        try {
            Connection conn = DBConnection.createConnection();
            String query = "select * from student";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                System.out.println("\nRollNo : " + rs.getInt(1) + "\nName : " + rs.getString(2) + "\nCollege Name : "
                        + rs.getString(3) + "\nCity : " + rs.getString(4) + "\nPercentage : " + rs.getDouble(5));
                System.out.println("🌟===============================🌟");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(int rollNo) {
        boolean flag = false;
        try {
            Connection conn = DBConnection.createConnection();
            String query = "delete from student where rollNo = " + rollNo;
            PreparedStatement statement = conn.prepareStatement(query);
            statement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean showStudentById(int rollNo) {
        boolean flag = false;
        try {
            Connection conn = DBConnection.createConnection();
            String query = "select * from student where rollNo = " + rollNo;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println("\nRollNo : " + rs.getInt(1) + "\nName : " + rs.getString(2) + "\nCollege Name : "
                        + rs.getString(3) + "\nCity : " + rs.getString(4) + "\nPercentage : " + rs.getDouble(5));
                System.out.println("🌟===============================🌟");

                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(int rollNo, String update, int ch, Student s) {
        boolean flag = false;
        try {
            Connection conn = DBConnection.createConnection();
            String query = "update student set clgName = ?  where rollNo = ? ";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, update);
            statement.setInt(2, rollNo);
            statement.executeUpdate();
            flag = true ;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    // update student set clgName="DCS" where rollNo = 4;
}
