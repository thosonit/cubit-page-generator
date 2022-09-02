package it.thoson.nwsflutter.generator

import it.thoson.nwsflutter.generator.components.BlocEventGenerator
import it.thoson.nwsflutter.generator.components.BlocGenerator
import it.thoson.nwsflutter.generator.components.BlocStateGenerator

object BlocGeneratorFactory {
    fun getBlocGenerators(name: String, useEquatable: Boolean): List<it.thoson.nwsflutter.generator.BlocGenerator> {
        val bloc = BlocGenerator(name, useEquatable)
        val event = BlocEventGenerator(name, useEquatable)
        val state = BlocStateGenerator(name, useEquatable)
        return listOf(bloc, event, state)
    }
}