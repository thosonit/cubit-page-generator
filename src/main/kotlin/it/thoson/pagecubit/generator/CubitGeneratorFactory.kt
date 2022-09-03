package it.thoson.pagecubit.generator

import it.thoson.pagecubit.generator.components.CubitGenerator
import it.thoson.pagecubit.generator.components.CubitStateGenerator
import it.thoson.pagecubit.generator.components.PageGenerator
import it.thoson.pagecubit.generator.components.StuffGenerator

object CubitGeneratorFactory {
    fun getCubitGenerators(name: String, useEquatable: Boolean): List<it.thoson.pagecubit.generator.CubitGenerator> {
        val cubit = CubitGenerator(name, useEquatable)
        val state = CubitStateGenerator(name, useEquatable)
        val page = PageGenerator(name, useEquatable)
        val stuff = StuffGenerator(name, useEquatable)
        return listOf(cubit, state, page, stuff)
    }
}