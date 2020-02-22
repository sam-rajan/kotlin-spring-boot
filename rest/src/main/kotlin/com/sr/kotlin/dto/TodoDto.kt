package com.sr.kotlin.dto

import com.fasterxml.jackson.annotation.JsonInclude
import javax.validation.constraints.NotEmpty

@JsonInclude(JsonInclude.Include.NON_NULL)
class TodoDto {
    var id: Number? = null
    @NotEmpty(message = "Name cannot be null or empty")
    var name: String = ""
}