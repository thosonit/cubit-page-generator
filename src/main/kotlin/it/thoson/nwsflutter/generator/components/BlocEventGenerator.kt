package it.thoson.nwsflutter.generator.components

import it.thoson.nwsflutter.generator.BlocGenerator

class BlocEventGenerator(
    blocName: String, blocShouldUseEquatable: Boolean
) : BlocGenerator(blocName, blocShouldUseEquatable, templateName = "bloc_event") {

    override fun fileName() = "${snakeCase()}_event.${fileExtension()}"
}