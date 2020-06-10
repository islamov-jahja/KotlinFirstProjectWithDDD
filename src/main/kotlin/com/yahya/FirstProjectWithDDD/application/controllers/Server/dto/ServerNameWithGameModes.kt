package com.yahya.FirstProjectWithDDD.application.controllers.Server.dto

import com.yahya.FirstProjectWithDDD.application.controllers.IDTO

data class ServerNameWithGameModes(
        val name: String,
        val gameModes: MutableList<String>
):IDTO