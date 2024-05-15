package com.quizcontext.service.serviceImp;

import com.quizcontext.entity.User;
import com.quizcontext.repository.UserRepository;
import com.quizcontext.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

  private final UserRepository userRepository;

  public UserServiceImp(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User create(User user) {
    return userRepository.save(user);
  }
}
