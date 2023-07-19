package it.thoson.pagecubit.generator.components

import it.thoson.pagecubit.generator.CubitGenerator

class NavigatorGenerator(
    name: String, useEquatable: Boolean
) : CubitGenerator(name, useEquatable, templateName = "navigator") {
    override fun fileName() = "${snakeCase()}_navigator.${fileExtension()}"
}