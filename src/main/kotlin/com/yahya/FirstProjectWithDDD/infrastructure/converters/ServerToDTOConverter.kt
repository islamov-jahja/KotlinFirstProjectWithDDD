package com.yahya.FirstProjectWithDDD.infrastructure.converters

import com.yahya.FirstProjectWithDDD.application.controllers.IDTO
import com.yahya.FirstProjectWithDDD.application.controllers.Server.dto.ServerDataTransfer
import com.yahya.FirstProjectWithDDD.application.controllers.Server.dto.ServerNameWithGameModes
import com.yahya.FirstProjectWithDDD.domain.core.entity.IEntity
import com.yahya.FirstProjectWithDDD.domain.core.entity.Server
import com.yahya.FirstProjectWithDDD.domain.supporting.converter.IEntityToDTOConverter

class ServerToDTOConverter: IEntityToDTOConverter {
    override fun convert(entity: IEntity): IDTO {
        val server:Server = entity as Server
        val gameModesInStringFormat = getGameModesInStringFormat(server)
        return ServerDataTransfer(server.endPoint, ServerNameWithGameModes(server.name, gameModesInStringFormat))
    }

    private fun getGameModesInStringFormat(server: Server): MutableList<String> {
        val gameModesInString: MutableList<String> = mutableListOf()
        for (gameMode in server.getGameModes()){
            gameModesInString.add((gameMode.mode))
        }

        return gameModesInString
    }
}