package team.symmetry.ResumeBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.symmetry.ResumeBack.repos.ModeratorRepo;

@Service
public class ModeratorService {
    @Autowired
    ModeratorRepo moderatorRepo;
}
