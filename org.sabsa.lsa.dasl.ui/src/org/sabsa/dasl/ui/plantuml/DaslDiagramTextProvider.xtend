package org.sabsa.dasl.ui.plantuml

import org.eclipse.ui.IEditorPart
import org.eclipse.jface.viewers.ISelection
import org.eclipse.xtext.ui.editor.XtextEditor
import org.sabsa.dasl.dasl.SecurityModel

class DaslDiagramTextProvider extends AbstractDiagramTextProvider {
	
    def DomainmodelDiagramTextProvider() {
        fileExtensions = "dasl"
        editorType = typeof(XtextEditor)
    }
         
	override protected getDiagramTextInternal(IEditorPart editorPart, ISelection selection) {

    	if (editorPart instanceof XtextEditor) {
	    
	        // Retrieve the "semantic" EMF from XtextEditor
	        val XtextEditor editor = (editorPart as XtextEditor);
	        val document = editor.document
	        val SecurityModel model = document.readOnly[
	            return contents.head as SecurityModel
	        ]
	
		    //System.out.println(DaslMxGraphPrinter.print(model));
	        val buf = DaslPlantUMLPrinter.print(model)
	        
	        '''
	          «buf»
	        '''
	    }
    } 
}