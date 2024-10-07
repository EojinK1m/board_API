package com.board_api.board.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.data.repository.CrudRepository
import java.util.*


@Entity
class Posting(
    @Id
    val id: String,
    var title: String,
    var content: String
) {}


interface PostingRepository: CrudRepository<Posting, String>
