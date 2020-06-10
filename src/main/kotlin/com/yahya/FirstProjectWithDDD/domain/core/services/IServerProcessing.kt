package com.yahya.FirstProjectWithDDD.domain.core.services

import com.yahya.FirstProjectWithDDD.application.controllers.Server.dto.ServerDataTransfer
import com.yahya.FirstProjectWithDDD.domain.core.entity.Server

interface IServerProcessing {
    fun putInfoAboutServer(serverDataTransfer: ServerDataTransfer)
    fun getInfoAboutServers(): MutableList<ServerDataTransfer>
}