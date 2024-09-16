package com.phaete.nf412recapspringboot.service;

import com.phaete.nf412recapspringboot.model.Todo;
import com.phaete.nf412recapspringboot.model.TodoDTO;
import com.phaete.nf412recapspringboot.repository.KanbanToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class KanbanToDoService {

    private final KanbanToDoRepository kanbanToDoRepository;
    private final IdService idService;

    public KanbanToDoService(KanbanToDoRepository kanbanToDoRepository, IdService idService) {
        this.kanbanToDoRepository = kanbanToDoRepository;
        this.idService = idService;
    }

    public List<Todo> findAll() {
        return kanbanToDoRepository.findAll();
    }

    public Todo findById(String id) {
        return kanbanToDoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Can not find todo with the id: " + id));
    }

    public Todo save(TodoDTO todoDTO) {
        return kanbanToDoRepository.save(new Todo(idService.generateId(), todoDTO.description(), todoDTO.status()));
    }

    public Todo update(String id, Todo todo) {
        Todo todoToUpdate = kanbanToDoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Can not find todo with the id: " + id));
        return kanbanToDoRepository.save(new Todo(todoToUpdate.id(), todo.description(), todo.status()));
    }

    public String deleteById(String id) {
        kanbanToDoRepository.deleteById(id);
        return "Deleted todo with id: " + id;
    }
}
