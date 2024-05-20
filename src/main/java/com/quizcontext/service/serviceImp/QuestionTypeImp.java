package com.quizcontext.service.serviceImp;

import com.quizcontext.entity.QuestionType;
import com.quizcontext.mapper.QuestionTypeMapper;
import com.quizcontext.repository.QuestionTypeRepository;
import com.quizcontext.service.QuestionTypeService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class QuestionTypeImp implements QuestionTypeService {

  private final QuestionTypeRepository questionTypeRepository;
  private final QuestionTypeMapper questionTypeMapper;

  public QuestionTypeImp(
      QuestionTypeRepository questionTypeRepository, QuestionTypeMapper questionTypeMapper) {
    this.questionTypeRepository = questionTypeRepository;
    this.questionTypeMapper = questionTypeMapper;
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

  @Override
  public QuestionType update(QuestionType questionType) {
    QuestionType existQuestionType = getById(questionType.getId());
    QuestionType updatedQuestionType =
        questionTypeMapper.toDbEntity(questionType, existQuestionType);
    return questionTypeRepository.save(updatedQuestionType);
  }

  @Override
  public void delete(Long id) {
    questionTypeRepository.deleteById(id);
  }
}
