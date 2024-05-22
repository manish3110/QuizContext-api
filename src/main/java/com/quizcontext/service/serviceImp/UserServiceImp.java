package com.quizcontext.service.serviceImp;

import com.quizcontext.entity.User;
import com.quizcontext.mapper.UserMapper;
import com.quizcontext.repository.UserRepository;
import com.quizcontext.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserServiceImp(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public User create(User user) {
    return userRepository.save(user);
  }

  @Override
  public User getById(Long id) {
    return userRepository.getById(id);
  }

  @Override
  public List<User> getAll() {
    return userRepository.findAll();
  }

  @Override
  public User update(User user) {
    User existUser = getById(user.getId());
    User updatedUser = userMapper.toDbEntity(user, existUser);
    return userRepository.save(updatedUser);
  }

  @Override
  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}
