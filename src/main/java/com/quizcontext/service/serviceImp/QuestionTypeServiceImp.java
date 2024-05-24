package com.quizcontext.service.serviceImp;

import com.quizcontext.constant.Constant;
import com.quizcontext.entity.QuestionType;
import com.quizcontext.enums.ResultCode;
import com.quizcontext.exception.QuizContextException;
import com.quizcontext.mapper.QuestionTypeMapper;
import com.quizcontext.repository.QuestionTypeRepository;
import com.quizcontext.service.QuestionTypeService;
import java.util.List;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class QuestionTypeServiceImp implements QuestionTypeService {

  private final QuestionTypeRepository questionTypeRepository;
  private final QuestionTypeMapper questionTypeMapper;
  private final MessageSource messageSource;

  public QuestionTypeServiceImp(
      QuestionTypeRepository questionTypeRepository,
      QuestionTypeMapper questionTypeMapper,
      MessageSource messageSource) {
    this.questionTypeRepository = questionTypeRepository;
    this.questionTypeMapper = questionTypeMapper;
    this.messageSource = messageSource;
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
    return questionTypeRepository
        .findById(id)
        .orElseThrow(
            () ->
                new QuizContextException(
                    ResultCode.DATA_NOT_FOUND.getCode(),
                    messageSource.getMessage(
                        "data.not.found",
                        new Object[] {Constant.QUESTION_TYPE},
                        Locale.getDefault())));
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
