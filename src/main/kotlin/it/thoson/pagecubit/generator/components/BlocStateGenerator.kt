package it.thoson.pagecubit.generator.components

import it.thoson.pagecubit.generator.BlocGenerator

class BlocStateGenerator(
    name: String, useEquatable: Boolean
) : BlocGenerator(name, useEquatable, templateName = "bloc_state") {
    override fun fileName() = "${snakeCase()}_state.${fileExtension()}"
}