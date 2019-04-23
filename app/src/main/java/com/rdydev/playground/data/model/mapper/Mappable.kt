package com.rdydev.playground.data.model.mapper

interface Mappable<Api, Domain> {
    fun map(api: Api): Domain
}