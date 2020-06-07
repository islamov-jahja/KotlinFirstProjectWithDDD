package com.yahya.FirstProjectWithDDD.domain.core.entity

import javax.persistence.*


@Entity(name = "game_mode")
class GameMode (_mode: String, _serverEndPoint: String){

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    val id: Int = 0

    @Column(name = "server_end_point")
    val serverEndPoint: String =_serverEndPoint

    @Column(name = "mode")
    val mode: String = _mode

    @ManyToOne(fetch = FetchType.LAZY)
    private val server: Server? = null
}