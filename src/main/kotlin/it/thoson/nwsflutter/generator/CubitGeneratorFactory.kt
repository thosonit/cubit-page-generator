package it.thoson.nwsflutter.generator

import it.thoson.nwsflutter.generator.components.CubitGenerator
import it.thoson.nwsflutter.generator.components.CubitStateGenerator

object CubitGeneratorFactory {
    fun getCubitGenerators(name: String, useEquatable: Boolean): List<it.thoson.nwsflutter.generator.CubitGenerator> {
        val cubit = CubitGenerator(name, useEquatable)
        val state = CubitStateGenerator(name, useEquatable)
        return listOf(cubit, state)
    }
}