package com.quizcontext.repository;

import com.quizcontext.entity.QuizType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Jpa Repository contains the APIs for basic CRUD operations, the APIS for pagination, and the APIs for sorting.
 */

@Repository
public interface QuizTypeRepository extends JpaRepository<QuizType, Long> {}
