package com.sr.kotlin.rest.repository

import com.sr.kotlin.rest.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Int>