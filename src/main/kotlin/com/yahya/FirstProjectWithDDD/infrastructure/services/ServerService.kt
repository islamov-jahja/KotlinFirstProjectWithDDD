package com.yahya.FirstProjectWithDDD.infrastructure.services

import com.yahya.FirstProjectWithDDD.application.controllers.Server.dto.ServerDataTransfer
import com.yahya.FirstProjectWithDDD.domain.core.entity.GameMode
import com.yahya.FirstProjectWithDDD.domain.core.entity.Server
import com.yahya.FirstProjectWithDDD.domain.core.repositories.ICustomizedServerRepository
import com.yahya.FirstProjectWithDDD.domain.core.services.IServerProcessing
import com.yahya.FirstProjectWithDDD.infrastructure.converters.EntityConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ServerService(@Autowired private val customizedServerRepository: ICustomizedServerRepository,
                    @Autowired private val entityConverter: EntityConverter) : IServerProcessing {

    override fun putInfoAboutServer(serverDataTransfer: ServerDataTransfer) {
        if (!serverExist(serverDataTransfer)) {
            saveServer(serverDataTransfer)
        } else {
            deleteServer(serverDataTransfer)
            saveServer(serverDataTransfer)
        }
    }

    override fun getInfoAboutServers(): MutableList<ServerDataTransfer> {
        val serverDataTransfers: MutableList<ServerDataTransfer> = mutableListOf()
        if (customizedServerRepository.count() == Integer.toUnsignedLong(0)){
            return serverDataTransfers
        }

        val servers = customizedServerRepository.findAll()
        for (server in servers){
            val serverDataTransfer = entityConverter.convert(server) as ServerDataTransfer
            serverDataTransfers.add(serverDataTransfer)
        }

        return serverDataTransfers
    }

    private fun saveServer(serverDataTransfer: ServerDataTransfer) {
        val server = Server(serverDataTransfer.endPoint, serverDataTransfer.info.name)

        for (mode in serverDataTransfer.info.gameModes) {
            val gameMode = GameMode(mode, serverDataTransfer.endPoint)

            server.addGameMode(gameMode)
        }

        customizedServerRepository.save(server)
    }

    private fun deleteServer(serverDataTransfer: ServerDataTransfer) {
        val server = customizedServerRepository.findByEndPoint(serverDataTransfer.endPoint)
        customizedServerRepository.delete(server)
    }

    private fun serverExist(serverDataTransfer: ServerDataTransfer): Boolean {
        return customizedServerRepository.existsByEndPoint(serverDataTransfer.endPoint)
    }
}