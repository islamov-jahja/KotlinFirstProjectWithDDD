package com.yahya.FirstProjectWithDDD.application.controllers.Server.dto

import com.yahya.FirstProjectWithDDD.application.controllers.IDTO

data class ServerDataTransfer(
  val endPoint: String,
  val info: ServerNameWithGameModes
):IDTO