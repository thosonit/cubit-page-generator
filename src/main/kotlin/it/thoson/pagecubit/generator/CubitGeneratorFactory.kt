package it.thoson.pagecubit.generator

import it.thoson.pagecubit.generator.components.*
import it.thoson.pagecubit.generator.components.CubitGenerator

object CubitGeneratorFactory {
    fun getCubitGenerators(name: String, useEquatable: Boolean): List<it.thoson.pagecubit.generator.CubitGenerator> {
        val cubit = CubitGenerator(name, useEquatable)
        val state = CubitStateGenerator(name, useEquatable)
        val page = PageGenerator(name, useEquatable)
        val navigator = NavigatorGenerator(name, useEquatable)
        val stuff = StuffGenerator(name, useEquatable)
        return listOf(cubit, state, page, navigator, stuff)
    }
}