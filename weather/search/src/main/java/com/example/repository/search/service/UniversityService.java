package com.example.repository.search.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UniversityService {
    Map<Integer, Map[]> fetchAllStudentByAge(List<Integer> ages);

    Map<Integer, Map[]> fetchAllTeacherByAge(List<Integer> ages);

    Map<Integer, Map[]> fetchAllTSByID(List<Integer> ids);
}