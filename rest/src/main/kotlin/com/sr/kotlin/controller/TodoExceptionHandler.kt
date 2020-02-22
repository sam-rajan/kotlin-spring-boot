package com.sr.kotlin.controller

import com.sr.kotlin.dto.ErrorDto
import com.sr.kotlin.utils.ErrorStatus
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindingResult
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class TodoExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleHttpMessageNotReadableException(ex: HttpMessageNotReadableException): ErrorDto {
        val errorDto = ErrorDto()
        errorDto.errorCode = ErrorStatus.INPUT_ERROR
        errorDto.errorMessage = "Invalid input"

        return errorDto
    }


    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ErrorDto {
        val errorDto = ErrorDto()
        errorDto.errorCode = ErrorStatus.INPUT_ERROR
        errorDto.errorMessage = getCustomMessage(ex.bindingResult)

        return errorDto
    }


    private fun getCustomMessage(result: BindingResult): String{
        val validErrors = mutableListOf<String>()
        for (objectError in result.allErrors) {
            validErrors.add(objectError.defaultMessage!!)
        }

        return validErrors.toString()
    }
}