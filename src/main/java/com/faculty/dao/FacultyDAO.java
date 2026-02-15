package com.faculty.dao;

import java.util.List;
import com.faculty.model.Faculty;

public interface FacultyDAO {
    void addFaculty(Faculty faculty);
    List<Faculty> getAllFaculty();
    Faculty getFacultyById(int id);
    void updateFaculty(Faculty faculty);
    void deleteFaculty(int id);
}