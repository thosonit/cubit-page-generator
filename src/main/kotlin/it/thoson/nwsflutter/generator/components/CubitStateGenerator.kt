package it.thoson.nwsflutter.generator.components

import it.thoson.nwsflutter.generator.CubitGenerator

class CubitStateGenerator(
    name: String, useEquatable: Boolean
) : CubitGenerator(name, useEquatable, templateName = "cubit_state") {
    override fun fileName() = "${snakeCase()}_state.${fileExtension()}"
}