package com.yahya.FirstProjectWithDDD.domain.core.entity

import javax.persistence.*

@Entity(name = "server")
class Server(_endPoint: String, _name: String) {
    @Id
    @Column(name = "endpoint")
    val endPoint: String = _endPoint

    @Column(name = "name", length = 50)
    val name: String = _name

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "server_end_point")
    private var gameModes: MutableList<GameMode>? = null

    fun addGameMode(gameMode: GameMode){
        when(this.gameModes){
            null -> gameModes = mutableListOf(gameMode)
            else -> gameModes!!.add(gameMode)
        }
    }
}
