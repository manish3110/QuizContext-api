package com.quizcontext.service;

import com.quizcontext.entity.Collection;
import java.util.List;

public interface CollectionService {

  Collection create(Collection collection);

  Collection getById(Long id);

  List<Collection> getAll();

  Collection update(Collection collection);
}
