package ua.admissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.admissions.system.entity.ExamScore;

@Repository
public interface ExamScoreRepository extends JpaRepository<ExamScore, Long> {
}
