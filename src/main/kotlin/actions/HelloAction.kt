package actions

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.actions.MarkRootActionBase
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileVisitor

class HelloAction : MarkRootActionBase(
        "Mark Root Action Demo",
        null,
        AllIcons.Modules.Annotation
) {

    override fun isEnabled(selection: RootsSelection, module: Module): Boolean {
        println("> isEnabled selection=$selection, module=$module")
        return true
    }

    override fun modifyRoots(file: VirtualFile?, entry: ContentEntry?) {
        println("> modifyRoots: $file, $entry")
        VfsUtilCore.visitChildrenRecursively(file!!, object : VirtualFileVisitor<Any>() {
            override fun visitFile(file: VirtualFile): Boolean {
                println("file: $file")
                return true
            }
        })
    }

}