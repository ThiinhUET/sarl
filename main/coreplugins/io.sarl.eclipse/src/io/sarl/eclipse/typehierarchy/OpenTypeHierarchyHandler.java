/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2018 the original authors or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.sarl.eclipse.typehierarchy;

import javax.inject.Inject;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.util.OpenTypeHierarchyUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;

import io.sarl.eclipse.util.AbstractSarlScriptInteractiveSelector.ElementDescription;
import io.sarl.lang.jvmmodel.SarlJvmModelAssociations;

/**
 * Handler for opening the type hierarchy from a SARL script.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 * @since 0.7
 */
public class OpenTypeHierarchyHandler extends AbstractHandler {

	@Inject
	private SarlScriptTypeSelector typeSelector;

	@Inject
	private IJavaElementFinder javaElementFinder;

	@Inject
	private SarlJvmModelAssociations sarlAssociations;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ISelection activeSelection = HandlerUtil.getActiveMenuSelection(event);
		if (activeSelection instanceof IStructuredSelection) {
			final ElementDescription selectedElement = this.typeSelector.searchAndSelect(((IStructuredSelection) activeSelection).toArray());
			if (selectedElement != null) {
				IJavaElement realJavaElement = null;
				if (selectedElement.element instanceof IJavaElement) {
					realJavaElement = (IJavaElement) selectedElement.element;
				} else if (selectedElement.element instanceof XtendTypeDeclaration) {
					final EObject jvmElement = this.sarlAssociations.getPrimaryJvmElement((XtendTypeDeclaration) selectedElement.element);
					if (jvmElement instanceof JvmIdentifiableElement) {
						realJavaElement = this.javaElementFinder.findElementFor((JvmIdentifiableElement) jvmElement);
					}
				}
				if (realJavaElement != null) {
					OpenTypeHierarchyUtil.open(realJavaElement, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
				}
			}
		}
		return null;
	}

}