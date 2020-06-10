package com.yahya.FirstProjectWithDDD.domain.supporting.converter

import com.yahya.FirstProjectWithDDD.application.controllers.IDTO
import com.yahya.FirstProjectWithDDD.domain.core.entity.IEntity

interface IEntityToDTOConverter {
    fun convert(entity: IEntity): IDTO
}