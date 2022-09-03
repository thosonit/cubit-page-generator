package it.thoson.pagecubit.generator.components

import it.thoson.pagecubit.generator.CubitGenerator

class StuffGenerator(
    name: String, useEquatable: Boolean
) : CubitGenerator(name, useEquatable, templateName = "custom_widget") {
    override fun fileName() = "custom_widget.${fileExtension()}"
}