package com.quizcontext.service.serviceImp;

import com.quizcontext.entity.Collection;
import com.quizcontext.repository.CollectionRepository;
import com.quizcontext.service.CollectionService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImp implements CollectionService {

  private final CollectionRepository collectionRepository;

  public CollectionServiceImp(CollectionRepository collectionRepository) {
    this.collectionRepository = collectionRepository;
  }

  @Override
  public Collection create(Collection collection) {
    return collectionRepository.save(collection);
  }

  @Override
  public Collection getById(Long id) {
    return collectionRepository.getById(id);
  }

  @Override
  public List<Collection> getAll() {
    return collectionRepository.findAll();
  }
}
