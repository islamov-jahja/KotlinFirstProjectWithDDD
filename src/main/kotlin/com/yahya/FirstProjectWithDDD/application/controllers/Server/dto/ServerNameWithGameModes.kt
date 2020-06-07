package com.yahya.FirstProjectWithDDD.application.controllers.Server.dto

data class ServerNameWithGameModes (
        val name: String,
        val gameModes: MutableList<String>
)