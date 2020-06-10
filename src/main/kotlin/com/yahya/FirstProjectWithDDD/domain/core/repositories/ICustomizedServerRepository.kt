package com.yahya.FirstProjectWithDDD.domain.core.repositories

import com.yahya.FirstProjectWithDDD.domain.core.entity.Server
import org.springframework.data.repository.CrudRepository

interface ICustomizedServerRepository : CrudRepository<Server, Long> {
    fun findByEndPoint(endPoint: String): Server
    fun existsByEndPoint(endPoint: String): Boolean
}