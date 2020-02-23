package com.sr.kotlin.rest.entity

import javax.persistence.*

@Entity
@Table(name = "todo")
data class Todo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,

    @Column(name = "name")
    var name: String
)