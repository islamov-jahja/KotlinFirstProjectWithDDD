package com.yahya.FirstProjectWithDDD.application.controllers.Server.dto

data class ServerDataTransfer(
  val endPoint: String,
  val serverNameWithGameModes: ServerNameWithGameModes
)