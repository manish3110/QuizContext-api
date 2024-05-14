package com.quizcontext.repository;

import com.quizcontext.entity.QuizType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * extends the JpaRepository interface so that we'll benefit from all the standard behavior of JpaRepository.
 */

@Repository
public interface QuizTypeRepository extends JpaRepository<QuizType, Long> {}
