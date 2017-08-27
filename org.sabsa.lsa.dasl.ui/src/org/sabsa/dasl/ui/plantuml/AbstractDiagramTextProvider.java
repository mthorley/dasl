package org.sabsa.dasl.ui.plantuml;

import java.util.StringTokenizer;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPathEditorInput;

import net.sourceforge.plantuml.eclipse.utils.DiagramTextProvider;

public abstract class AbstractDiagramTextProvider implements DiagramTextProvider {

	private String fileExtensions = null;
	private Class<?> editorType = null;

	public AbstractDiagramTextProvider() {
		
	}
	public AbstractDiagramTextProvider(String fileExtensions, Class<?> editorType) {
		this();
		setFileExtensions(fileExtensions);
		setEditorType(editorType);
	}

	public void setFileExtensions(String fileExtensions) {
		this.fileExtensions = fileExtensions;
	}

	public void setEditorType(Class<?> editorType) {
		this.editorType = editorType;
	}
	
	@Override
	public boolean supportsSelection(ISelection arg0) {
		return true;
	}

	public boolean supportsEditor(IEditorPart editorPart) {
		if (editorType != null && (! (editorType.isInstance(editorPart)))) {
			return false;
		}
		if (fileExtensions != null) {
			String fileExtension = null;
			if (fileExtension == null && editorPart.getEditorInput() instanceof IPathEditorInput) {
				fileExtension = ((IPathEditorInput) editorPart.getEditorInput()).getPath().getFileExtension();
			}
			boolean supportsFileExtension = false;
			StringTokenizer tokens = new StringTokenizer(fileExtensions, ",");
			while ((! supportsFileExtension) && tokens.hasMoreTokens()) {
				String ext = tokens.nextToken();
				if ("*".equals(ext) || ext.equals(fileExtension)) {
					supportsFileExtension = true;
				}
			}
			if (! supportsFileExtension) {
				return false;
			}
		}
		return true;
	}
	
	private String startuml = "@startuml";
	private String enduml = "@enduml";
	
	public String getDiagramText(IEditorPart editorPart) {
		if (supportsEditor(editorPart)) {
			String diagramText = ""; //getDiagramText(editorPart, editorPart.getEditorInput());
			if (diagramText != null) {
				diagramText = diagramText.trim();
				if (! diagramText.startsWith(startuml)) {
					diagramText = startuml + "\n" + diagramText;
				}
				if (! diagramText.endsWith(enduml)) {
					diagramText = diagramText + "\n" + enduml;
				}
			}
			return diagramText;
		}
		return null;
	}

	@Override
	public String getDiagramText(IEditorPart editorPart, ISelection selection) {
		if (supportsEditor(editorPart)) {
			String diagramText = getDiagramTextInternal(editorPart, selection);
			if (diagramText != null) {
				diagramText = diagramText.trim();
				if (! diagramText.startsWith(startuml)) {
					diagramText = startuml + "\n" + 
							"scale 0.75" + "\n" + 
							diagramText;
				}
				if (! diagramText.endsWith(enduml)) {
					diagramText = diagramText + "\n" + enduml;
				}
			}
			return diagramText;
		}
		return null;
	}
	
	protected abstract String getDiagramTextInternal(IEditorPart editorPart, ISelection selection);	
}
