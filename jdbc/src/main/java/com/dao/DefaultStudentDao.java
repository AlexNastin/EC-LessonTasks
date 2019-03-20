package com.dao;

import com.connection.ConnectionDB;
import com.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultStudentDao implements StudentDao {

    private final String GET_STUDENTS = "SELECT id_student, name, surname, age FROM student";

    private final String GET_STUDENT_ID = "SELECT id_student, name, surname, age FROM student WHERE id_student = ?";

    private final String INSERT_STUDENT = "INSERT INTO student (id_student,name,surname,age) VALUES (?,?,?,?)";

    private final String UPDATE_STUDENT = " UPDATE student SET name =?, surname = ?, age=? WHERE id_student=?";

    private final String DELETE_STUDENT = "DELETE FROM student WHERE id_student=?";

    private ConnectionDB connectionDB = ConnectionDB.getInstance();

    private DefaultStudentDao() {
    }

    @Override
    public List<Student> getStudents() {
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
    public Student getStudentById(long id) {
        Student student = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(GET_STUDENT_ID);
            preparedStatement.setLong(1, id);
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
    public void saveStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_STUDENT);
            preparedStatement.setLong(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurname());
            preparedStatement.setLong(4, student.getAge());
            preparedStatement.executeUpdate();
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

    @Override
    public void update(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setLong(3, student.getAge());
            preparedStatement.setLong(4, student.getId());
            preparedStatement.executeUpdate();
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

    @Override
    public void delete(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
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

    /**
     * The inner class for implementation singleton.
     */
    private static class Holder {
        private final static DefaultStudentDao INSTANCE = new DefaultStudentDao();
    }

    /**
     * The method gives DefaultStudentDao singleton instance.
     */
    public static DefaultStudentDao getInstance() {
        return Holder.INSTANCE;
    }
}
