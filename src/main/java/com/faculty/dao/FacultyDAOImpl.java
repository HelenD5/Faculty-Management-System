package com.faculty.dao;

import java.sql.*;
import java.util.*;
import com.faculty.model.Faculty;
import com.faculty.util.DBConnection;

public class FacultyDAOImpl implements FacultyDAO {

    @Override
    public void addFaculty(Faculty faculty) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO faculty(name, department, email, designation) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, faculty.getName());
            ps.setString(2, faculty.getDepartment());
            ps.setString(3, faculty.getEmail());
            ps.setString(4, faculty.getDesignation());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public List<Faculty> getAllFaculty() {
        List<Faculty> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM faculty";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Faculty f = new Faculty();
                f.setId(rs.getInt("id"));
                f.setName(rs.getString("name"));
                f.setDepartment(rs.getString("department"));
                f.setEmail(rs.getString("email"));
                f.setDesignation(rs.getString("designation"));
                list.add(f);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public Faculty getFacultyById(int id) {
        Faculty f = null;
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM faculty WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                f = new Faculty();
                f.setId(rs.getInt("id"));
                f.setName(rs.getString("name"));
                f.setDepartment(rs.getString("department"));
                f.setEmail(rs.getString("email"));
                f.setDesignation(rs.getString("designation"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return f;
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE faculty SET name=?, department=?, email=?, designation=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, faculty.getName());
            ps.setString(2, faculty.getDepartment());
            ps.setString(3, faculty.getEmail());
            ps.setString(4, faculty.getDesignation());
            ps.setInt(5, faculty.getId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void deleteFaculty(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM faculty WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}