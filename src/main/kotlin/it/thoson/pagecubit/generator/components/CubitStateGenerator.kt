package it.thoson.pagecubit.generator.components

import it.thoson.pagecubit.generator.CubitGenerator

class CubitStateGenerator(
    name: String, useEquatable: Boolean
) : CubitGenerator(name, useEquatable, templateName = "cubit_state") {
    override fun fileName() = "${snakeCase()}_state.${fileExtension()}"
}