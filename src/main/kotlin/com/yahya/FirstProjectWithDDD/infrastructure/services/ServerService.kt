package com.yahya.FirstProjectWithDDD.infrastructure.services

import com.yahya.FirstProjectWithDDD.application.controllers.Server.dto.ServerDataTransfer
import com.yahya.FirstProjectWithDDD.domain.core.entity.GameMode
import com.yahya.FirstProjectWithDDD.domain.core.entity.Server
import com.yahya.FirstProjectWithDDD.domain.core.repositories.ICustomizeGameModeRepository
import com.yahya.FirstProjectWithDDD.domain.core.repositories.ICustomizedServerRepository
import com.yahya.FirstProjectWithDDD.domain.core.services.IServerProcessing
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ServerService(@Autowired private val customizedServerRepository: ICustomizedServerRepository,
                    @Autowired private val customizeGameModeRepository: ICustomizeGameModeRepository) : IServerProcessing {

    override fun putInfoAboutServer(serverDataTransfer: ServerDataTransfer){
        if (!serverExist(serverDataTransfer)){
            saveServer(serverDataTransfer)
        }else{
            deleteServer(serverDataTransfer)
            saveServer(serverDataTransfer)
        }
    }

    private fun saveServer(serverDataTransfer: ServerDataTransfer){
        val server = Server(serverDataTransfer.endPoint, serverDataTransfer.serverNameWithGameModes.name)

        for (mode in serverDataTransfer.serverNameWithGameModes.gameModes){
            val gameMode = GameMode(mode, serverDataTransfer.endPoint)

            server.addGameMode(gameMode)
        }

        customizedServerRepository.save(server)
    }

    private fun deleteServer(serverDataTransfer: ServerDataTransfer){
        val server = customizedServerRepository.findByEndPoint(serverDataTransfer.endPoint)
        customizedServerRepository.delete(server)
    }

    private fun serverExist(serverDataTransfer: ServerDataTransfer): Boolean{
        return customizedServerRepository.existsByEndPoint(serverDataTransfer.endPoint)
    }

    override fun getInfoAboutServers(): ServerDataTransfer {
        TODO("Not yet implemented")
    }
}