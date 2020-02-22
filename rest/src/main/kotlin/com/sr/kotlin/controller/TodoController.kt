package com.sr.kotlin.controller

import com.sr.kotlin.dto.TodoDto
import com.sr.kotlin.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping( "/api/v1/todos")
class TodoController(val todoService: TodoService) {


    @PostMapping
    fun addTodo(@RequestBody @Valid todo: TodoDto): ResponseEntity<Void> {
        val todoDto = todoService.createList(todo)
        val location = ServletUriComponentsBuilder.fromCurrentRequest().path(
        "/{id}").buildAndExpand(todoDto.id).toUri()
        return ResponseEntity.created(location).build()
    }


    @GetMapping
    fun getTodo(): ResponseEntity<List<TodoDto>> {
        val todos = todoService.getAllTodo()
        return ResponseEntity.ok(todos)
    }
}