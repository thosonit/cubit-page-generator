package it.thoson.nwsflutter.generator.components

import it.thoson.nwsflutter.generator.BlocGenerator

class BlocGenerator(
    name: String, useEquatable: Boolean
) : BlocGenerator(name, useEquatable, templateName = "bloc") {
    override fun fileName() = "${snakeCase()}_bloc.${fileExtension()}"
}