package it.thoson.nwsflutter.generator.components

import it.thoson.nwsflutter.generator.CubitGenerator

class CubitGenerator(
    name: String, useEquatable: Boolean
) : CubitGenerator(name, useEquatable, templateName = "cubit") {
    override fun fileName() = "${snakeCase()}_cubit.${fileExtension()}"
}