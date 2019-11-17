package com.sr.kotlin.repository

import com.sr.kotlin.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Int>