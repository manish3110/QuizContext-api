package com.quizcontext.service.serviceImp;

import com.quizcontext.entity.QuestionType;
import com.quizcontext.repository.QuestionTypeRepository;
import com.quizcontext.service.QuestionTypeService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class QuestionTypeImp implements QuestionTypeService {

  private final QuestionTypeRepository questionTypeRepository;

  public QuestionTypeImp(QuestionTypeRepository questionTypeRepository) {
    this.questionTypeRepository = questionTypeRepository;
  }

  @Override
  public QuestionType create(QuestionType questionType) {
    return questionTypeRepository.save(questionType);
  }

  @Override
  public List<QuestionType> getAll() {
    return questionTypeRepository.findAll();
  }

  @Override
  public QuestionType getById(Long id) {
    return questionTypeRepository.getById(id);
  }
}
