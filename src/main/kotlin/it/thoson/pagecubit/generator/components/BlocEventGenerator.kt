package it.thoson.pagecubit.generator.components

import it.thoson.pagecubit.generator.BlocGenerator

class BlocEventGenerator(
    blocName: String, blocShouldUseEquatable: Boolean
) : BlocGenerator(blocName, blocShouldUseEquatable, templateName = "bloc_event") {

    override fun fileName() = "${snakeCase()}_event.${fileExtension()}"
}