package com.yahya.FirstProjectWithDDD.domain.core.repositories

import com.yahya.FirstProjectWithDDD.domain.core.entity.GameMode
import org.springframework.data.repository.CrudRepository

interface ICustomizeGameModeRepository : CrudRepository<GameMode, Long> {
    fun deleteByServerEndPoint(serverEndPoint: String)
}