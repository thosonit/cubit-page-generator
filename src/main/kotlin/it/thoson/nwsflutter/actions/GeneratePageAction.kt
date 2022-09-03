package it.thoson.nwsflutter.actions

import com.fleshgrinder.extensions.kotlin.toLowerSnakeCase
import com.intellij.lang.java.JavaLanguage
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.impl.file.PsiDirectoryFactory
import it.thoson.nwsflutter.dialog.GeneratePageDialog
import it.thoson.nwsflutter.generator.CubitGenerator
import it.thoson.nwsflutter.generator.CubitGeneratorFactory
import it.thoson.nwsflutter.generator.components.StuffGenerator

open class GeneratePageAction : AnAction(), GeneratePageDialog.Listener {

    private lateinit var dataContext: DataContext

    override fun actionPerformed(e: AnActionEvent) {
        val dialog = GeneratePageDialog(this)
        dialog.show()
    }

    override fun onGeneratePageClicked(pageName: String?) {
        pageName?.let { name ->
            val generators = CubitGeneratorFactory.getCubitGenerators(name, true)
            generate(pageName.toLowerSnakeCase(), generators)
        }
    }

    override fun update(e: AnActionEvent) {
        e.dataContext.let {
            this.dataContext = it
            val presentation = e.presentation
            presentation.isEnabled = true
        }
    }

    private fun generate(pageName: String, mainSourceGenerators: List<CubitGenerator>) {
        val project = CommonDataKeys.PROJECT.getData(dataContext)
        val view = LangDataKeys.IDE_VIEW.getData(dataContext)
        val directory = view?.orChooseDirectory

        val newDirectory = directory?.createSubdirectory(pageName)

        ApplicationManager.getApplication().runWriteAction {
            CommandProcessor.getInstance().executeCommand(
                project, {
                    mainSourceGenerators.forEach { createSourceFile(project!!, it, newDirectory!!) }
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
        if (generator is StuffGenerator) {
            //Todo: fix tạm :(
            val newDirectory = directory.createSubdirectory("widgets")
            newDirectory.add(psiFile);
        } else {
            directory.add(psiFile)
        }
    }
}