package com.yahya.FirstProjectWithDDD.infrastructure.converters

import com.yahya.FirstProjectWithDDD.application.controllers.IDTO
import com.yahya.FirstProjectWithDDD.domain.core.entity.IEntity
import com.yahya.FirstProjectWithDDD.domain.core.entity.Server
import com.yahya.FirstProjectWithDDD.domain.supporting.converter.ConverterNotFoundException
import javassist.NotFoundException
import org.springframework.stereotype.Component

@Component
class EntityConverter {
    fun convert(entity: IEntity):IDTO{
        if (entity is Server){
            return ServerToDTOConverter().convert(entity)
        }

        throw ConverterNotFoundException()
    }
}