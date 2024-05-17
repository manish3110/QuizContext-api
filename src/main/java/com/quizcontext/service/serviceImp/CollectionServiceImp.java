package com.quizcontext.service.serviceImp;

import com.quizcontext.entity.Collection;
import com.quizcontext.mapper.CollectionMapper;
import com.quizcontext.repository.CollectionRepository;
import com.quizcontext.service.CollectionService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImp implements CollectionService {

  private final CollectionRepository collectionRepository;
  private final CollectionMapper collectionMapper;

  public CollectionServiceImp(
      CollectionRepository collectionRepository, CollectionMapper collectionMapper) {
    this.collectionRepository = collectionRepository;
    this.collectionMapper = collectionMapper;
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

  @Override
  public Collection update(Collection collection) {
    Collection existingCollection = getById(collection.getId());
    Collection updatedCollection = collectionMapper.toDbEntity(collection, existingCollection);
    return collectionRepository.save(updatedCollection);
  }

  @Override
  public void delete(Long id) {
    collectionRepository.deleteById(id);
  }
}
