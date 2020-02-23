package com.sr.kotlin.service

import org.springframework.stereotype.Service
import com.sr.kotlin.dto.TodoDto
import com.sr.kotlin.entity.Todo
import com.sr.kotlin.repository.TodoRepository

@Service
class TodoService(val todoRepository: TodoRepository) {

    fun createList(todo: TodoDto): TodoDto {
        val todoEntity = Todo(null, todo.name)
        todoRepository.save(todoEntity)
        todo.id = todoEntity.id

        return todo
    }

    fun getAllTodo(): List<TodoDto> {
        val todos = todoRepository.findAll()
        return todos.map { todo ->
            val todoDto = TodoDto()
            todoDto.name = todo.name
            todoDto.id = todo.id

            todoDto
        }
    }

}