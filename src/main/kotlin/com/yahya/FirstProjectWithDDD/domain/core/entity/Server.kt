package com.yahya.FirstProjectWithDDD.domain.core.entity

import javax.persistence.*

@Entity(name = "server")
class Server(_endPoint: String, _name: String): IEntity {
    @Id
    @Column(name = "endpoint")
    val endPoint: String = _endPoint

    @Column(name = "name", length = 50)
    val name: String = _name

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "server_end_point")
    private var gameModes: MutableList<GameMode> = mutableListOf()

    fun addGameMode(gameMode: GameMode){
        gameModes.add(gameMode)
    }

    fun getGameModes(): MutableList<GameMode>{
        return gameModes
    }
}
