package it.thoson.nwsflutter.generator.components

import it.thoson.nwsflutter.generator.CubitGenerator

class PageGenerator(
    name: String, useEquatable: Boolean
) : CubitGenerator(name, useEquatable, templateName = "cubit_page") {
    override fun fileName() = "${snakeCase()}_page.${fileExtension()}"
}