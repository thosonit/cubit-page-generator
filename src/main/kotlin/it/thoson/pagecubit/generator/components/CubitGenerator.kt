package it.thoson.pagecubit.generator.components

import it.thoson.pagecubit.generator.CubitGenerator

class CubitGenerator(
    name: String, useEquatable: Boolean
) : CubitGenerator(name, useEquatable, templateName = "cubit") {
    override fun fileName() = "${snakeCase()}_cubit.${fileExtension()}"
}