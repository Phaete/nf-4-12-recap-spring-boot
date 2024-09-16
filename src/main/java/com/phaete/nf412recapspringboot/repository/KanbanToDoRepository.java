package com.phaete.nf412recapspringboot.repository;

import com.phaete.nf412recapspringboot.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KanbanToDoRepository extends MongoRepository<Todo, String> {
}
