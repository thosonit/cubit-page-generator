package it.thoson.pagecubit.generator.components

import it.thoson.pagecubit.generator.BlocGenerator

class BlocGenerator(
    name: String, useEquatable: Boolean
) : BlocGenerator(name, useEquatable, templateName = "bloc") {
    override fun fileName() = "${snakeCase()}_bloc.${fileExtension()}"
}