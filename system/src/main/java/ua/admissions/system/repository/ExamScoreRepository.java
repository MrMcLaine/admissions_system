package ua.admissions.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.admissions.system.entity.ExamScore;

public interface ExamScoreRepository extends JpaRepository<ExamScore, Long> {
}
