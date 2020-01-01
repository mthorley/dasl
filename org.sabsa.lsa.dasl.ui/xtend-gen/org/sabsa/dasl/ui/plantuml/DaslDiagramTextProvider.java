package org.sabsa.dasl.ui.plantuml;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.sabsa.dasl.dasl.SecurityModel;
import org.sabsa.dasl.ui.plantuml.AbstractDiagramTextProvider;
import org.sabsa.dasl.ui.plantuml.DaslPlantUMLPrinter;

@SuppressWarnings("all")
public class DaslDiagramTextProvider extends AbstractDiagramTextProvider {
  public void DomainmodelDiagramTextProvider() {
    this.setFileExtensions("dasl");
    this.setEditorType(XtextEditor.class);
  }
  
  protected String getDiagramTextInternal(final IEditorPart editorPart, final ISelection selection) {
    String _xifexpression = null;
    if ((editorPart instanceof XtextEditor)) {
      String _xblockexpression = null;
      {
        final XtextEditor editor = ((XtextEditor) editorPart);
        final IXtextDocument document = editor.getDocument();
        final IUnitOfWork<SecurityModel, XtextResource> _function = new IUnitOfWork<SecurityModel, XtextResource>() {
          public SecurityModel exec(final XtextResource it) throws Exception {
            EObject _head = IterableExtensions.<EObject>head(it.getContents());
            return ((SecurityModel) _head);
          }
        };
        final SecurityModel model = document.<SecurityModel>readOnly(_function);
        final String buf = DaslPlantUMLPrinter.print(model);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(buf);
        _builder.newLineIfNotEmpty();
        _xblockexpression = _builder.toString();
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
}
