package it.thoson.nwsflutter.actions

import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFileFactory
import com.intellij.lang.java.JavaLanguage
import it.thoson.nwsflutter.dialog.GeneratePageDialog
import it.thoson.nwsflutter.generator.CubitGenerator
import it.thoson.nwsflutter.generator.CubitGeneratorFactory

open class GeneratePageAction : AnAction(), GeneratePageDialog.Listener {

    private lateinit var dataContext: DataContext

    override fun actionPerformed(e: AnActionEvent) {
        val dialog = GeneratePageDialog(this)
        dialog.show()
    }

    override fun onGeneratePageClicked(pageName: String?) {
        pageName?.let { name ->
            val generators = CubitGeneratorFactory.getCubitGenerators(name, true)
            generate(generators)
        }
    }

    override fun update(e: AnActionEvent) {
        e.dataContext.let {
            this.dataContext = it
            val presentation = e.presentation
            presentation.isEnabled = true
        }
    }

    private fun generate(mainSourceGenerators: List<CubitGenerator>) {
        val project = CommonDataKeys.PROJECT.getData(dataContext)
        val view = LangDataKeys.IDE_VIEW.getData(dataContext)
        val directory = view?.orChooseDirectory
        ApplicationManager.getApplication().runWriteAction {
            CommandProcessor.getInstance().executeCommand(
                project, {
                    mainSourceGenerators.forEach { createSourceFile(project!!, it, directory!!) }
                }, "Generate a new Page", null
            )
        }
    }

    private fun createSourceFile(project: Project, generator: CubitGenerator, directory: PsiDirectory) {
        val fileName = generator.fileName()
        val existingPsiFile = directory.findFile(fileName)
        if (existingPsiFile != null) {
            val document = PsiDocumentManager.getInstance(project).getDocument(existingPsiFile)
            document?.insertString(document.textLength, "\n" + generator.generate())
            return
        }
        val psiFile = PsiFileFactory.getInstance(project)
            .createFileFromText(fileName, JavaLanguage.INSTANCE, generator.generate())
        directory.add(psiFile)
    }
}