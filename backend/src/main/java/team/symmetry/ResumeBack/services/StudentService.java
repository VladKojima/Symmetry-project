package team.symmetry.ResumeBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.symmetry.ResumeBack.utils.EntityValidator;

@Service
public class StudentService {
    @Autowired
    EntityValidator validator;

}
