package it.thoson.pagecubit.generator

import it.thoson.pagecubit.generator.components.BlocEventGenerator
import it.thoson.pagecubit.generator.components.BlocGenerator
import it.thoson.pagecubit.generator.components.BlocStateGenerator

object BlocGeneratorFactory {
    fun getBlocGenerators(name: String, useEquatable: Boolean): List<it.thoson.pagecubit.generator.BlocGenerator> {
        val bloc = BlocGenerator(name, useEquatable)
        val event = BlocEventGenerator(name, useEquatable)
        val state = BlocStateGenerator(name, useEquatable)
        return listOf(bloc, event, state)
    }
}