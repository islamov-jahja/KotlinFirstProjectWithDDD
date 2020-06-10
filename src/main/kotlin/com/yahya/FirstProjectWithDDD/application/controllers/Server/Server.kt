package com.yahya.FirstProjectWithDDD.application.controllers.Server

import com.yahya.FirstProjectWithDDD.application.controllers.Server.dto.ServerDataTransfer
import com.yahya.FirstProjectWithDDD.application.controllers.Server.dto.ServerNameWithGameModes
import com.yahya.FirstProjectWithDDD.domain.core.services.IServerProcessing
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody
import java.awt.PageAttributes
import javax.ws.rs.*
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.core.Response

@Path("servers")
@Component
class Server(@Autowired val serverProcessing: IServerProcessing) {
    @Path("/{endpoint}/info")
    @PUT
    @Produces(APPLICATION_JSON)
    fun putServer(@PathParam("endpoint") endpoint: String, @RequestBody serverNameWithGameModes: ServerNameWithGameModes): Response{
        val serverDataTransfer = ServerDataTransfer(endpoint, serverNameWithGameModes)
        serverProcessing.putInfoAboutServer(serverDataTransfer)
        return Response.ok().build()
    }
    @Path("/info")
    @GET
    @Produces(APPLICATION_JSON)
    fun getServers(): Response{
        val infoAboutServers = serverProcessing.getInfoAboutServers()
        return when(val isEmpty = infoAboutServers.isEmpty()) {
            true -> Response.status(Response.Status.NOT_FOUND).build()
            else -> Response.ok(infoAboutServers).build()
        }
    }
}