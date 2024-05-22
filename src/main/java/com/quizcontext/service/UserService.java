package com.quizcontext.service;

import com.quizcontext.entity.User;
import java.util.List;

public interface UserService {
  User create(User user);

  User getById(Long id);

  List<User> getAll();

  User update(User user);

  void delete(Long id);
}
