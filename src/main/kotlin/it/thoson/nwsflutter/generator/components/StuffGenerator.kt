package it.thoson.nwsflutter.generator.components

import it.thoson.nwsflutter.generator.CubitGenerator

class StuffGenerator(
    name: String, useEquatable: Boolean
) : CubitGenerator(name, useEquatable, templateName = "custom_widget") {
    override fun fileName() = "custom_widget.${fileExtension()}"
}