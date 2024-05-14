package team.symmetry.ResumeBack.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import team.symmetry.ResumeBack.models.Announcement;

public interface AnnouncementRepo extends JpaRepository<Announcement, Integer>{
    
}
