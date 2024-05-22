package com.quizcontext.service.serviceImp;

import com.quizcontext.entity.QuizType;
import com.quizcontext.mapper.QuizTypeMapper;
import com.quizcontext.repository.QuizTypeRepository;
import com.quizcontext.service.QuizTypeService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class QuizTypeServiceImp implements QuizTypeService {

  private final QuizTypeRepository quizTypeRepository;
  private final QuizTypeMapper quizTypeMapper;

  public QuizTypeServiceImp(QuizTypeRepository quizTypeRepository, QuizTypeMapper quizTypeMapper) {
    this.quizTypeRepository = quizTypeRepository;
    this.quizTypeMapper = quizTypeMapper;
  }

  @Override
  public QuizType create(QuizType quizType) {
    return quizTypeRepository.save(quizType);
  }

  @Override
  public QuizType getById(Long id) {
    return quizTypeRepository.getById(id);
  }

  @Override
  public List<QuizType> getAll() {
    return quizTypeRepository.findAll();
  }

  @Override
  public QuizType update(QuizType quizType) {
    QuizType existQuizType = getById(quizType.getId());
    QuizType updatedQuizType = quizTypeMapper.toDbEntity(quizType, existQuizType);
    return quizTypeRepository.save(updatedQuizType);
  }

  @Override
  public void delete(Long id) {
    quizTypeRepository.deleteById(id);
  }
}
