package com.lesson8.dao;

import com.lesson8.connection.ConnectionDB;
import com.lesson8.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultStudentDao implements StudentDao {

    private final String GET_STUDENTS = "SELECT id_student, name, surname, age FROM student";

    private final String GET_STUDENT_ID = "SELECT id_student, name, surname, age FROM student WHERE id_student = ?";

    private final String INSERT_STUDENT = "INSERT INTO student (id_student,name,surname,age) VALUES (?,?,?,?)";

    private final String UPDATE_STUDENT = " UPDATE student SET name =?, surname = ?, age=? WHERE id_student=?";

    private final String DELETE_STUDENT = "DELETE FROM student WHERE id_student=?";

    private final ConnectionDB connectionDB;

    public DefaultStudentDao(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_STUDENTS);
            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    @Override
    public Student get(long idStudent) {
        Student student = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(GET_STUDENT_ID);
            preparedStatement.setLong(1, idStudent);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    @Override
    public boolean save(Student student) {
        boolean check = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_STUDENT);
            preparedStatement.setLong(1, student.getIdStudent());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurname());
            preparedStatement.setLong(4, student.getAge());
            int numberOfLines = preparedStatement.executeUpdate();
            if (numberOfLines >= 1) {
                check = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return check;
    }


    @Override
    public boolean update(Student student) {
        boolean check = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setLong(3, student.getAge());
            preparedStatement.setLong(4, student.getIdStudent());
            int numberOfLines = preparedStatement.executeUpdate();
            if (numberOfLines >= 1) {
                check = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    @Override
    public void delete(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setLong(1, id);
            int numberOfLines = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
