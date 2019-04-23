package com.rdydev.playground.data.model.mapper

import com.rdydev.playground.data.model.domain.User

object UserMapper : Mappable<com.rdydev.playground.data.model.api.User, User> {

    override fun map(api: com.rdydev.playground.data.model.api.User): User {
        return User(
            id = api.id,
            name = api.name,
            username = api.username,
            email = api.email
        )
    }

}