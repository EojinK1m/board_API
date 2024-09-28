package com.board_api.board.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/postings")
class PostingController {
    @GetMapping
    fun getPostings(): String{
        return "hello world"
    }
}