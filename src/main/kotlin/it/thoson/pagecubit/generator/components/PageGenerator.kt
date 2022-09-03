package it.thoson.pagecubit.generator.components

import it.thoson.pagecubit.generator.CubitGenerator

class PageGenerator(
    name: String, useEquatable: Boolean
) : CubitGenerator(name, useEquatable, templateName = "cubit_page") {
    override fun fileName() = "${snakeCase()}_page.${fileExtension()}"
}