package com.rdydev.playground.data.api

import com.rdydev.playground.data.model.api.*

class StubBlogService : BlogService {

    override fun getUsers(): List<User> {
        return listOf(
            getUserWithId(1),
            getUserWithId(2)
        )
    }

    override fun getComments(): List<Comment> {
        return listOf(
            Comment(1, 1, "name 1", "email 1", "body 1"),
            Comment(1, 2, "name 1", "email 1", "body 2"),
            Comment(2, 3, "name 2", "email 2", "body 3")
        )
    }

    override fun getPosts(): List<Post> {
        return listOf(
            Post(1, 1, "title 1", "body 1"),
            Post(1, 2, "title 2", "body 2"),
            Post(2, 3, "title 3", "body 3"),
            Post(2, 4, "title 4", "body 4"),
            Post(2, 5, "title 5", "body 5")
        )
    }

    private fun getUserWithId(id: Int): User {
        val stubCompany = Company("company", "catchphrase", "bs")
        val stubLatLng = LatLong("0", "0")
        val stubAddress = Address(
            "street",
            "suite",
            "city",
            "zipcode",
            stubLatLng
        )

        return User(
            id,
            "Ben Pearson",
            "benpearson",
            "fake@email1.com",
            stubAddress.copy(street = "street $id"),
            "123 123 123",
            "http://fake.site",
            stubCompany.copy(name = "company $id")
        )
    }
}