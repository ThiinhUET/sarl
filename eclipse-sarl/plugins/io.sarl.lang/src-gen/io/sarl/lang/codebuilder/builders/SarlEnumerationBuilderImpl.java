/*
 * $Id$
 *
 * File is automatically generated by the Xtext language generator.
 * Do not change it.
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2017 the original authors or authors.
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
package io.sarl.lang.codebuilder.builders;

import io.sarl.lang.sarl.SarlEnumeration;
import io.sarl.lang.sarl.SarlFactory;
import io.sarl.lang.sarl.SarlScript;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Provider;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.xtend.XtendFactory;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.lib.Pure;

/** Builder of a Sarl SarlEnumeration.
 */
@SuppressWarnings("all")
public class SarlEnumerationBuilderImpl extends AbstractBuilder implements ISarlEnumerationBuilder {

	private SarlEnumeration sarlEnumeration;

	private EObject container;

	@Override
	@Pure
	public String toString() {
		return EmfFormatter.objToStr(getSarlEnumeration());
	}

	/** Initialize the Ecore element when inside a script.
	 */
	public void eInit(SarlScript script, String name, IJvmTypeProvider context) {
		setTypeResolutionContext(context);
		if (this.sarlEnumeration == null) {
			this.container = script;
			this.sarlEnumeration = SarlFactory.eINSTANCE.createSarlEnumeration();
			script.getXtendTypes().add(this.sarlEnumeration);
			this.sarlEnumeration.setAnnotationInfo(XtendFactory.eINSTANCE.createXtendTypeDeclaration());
			if (!Strings.isEmpty(name)) {
				this.sarlEnumeration.setName(name);
			}
		}
	}

	/** Initialize the Ecore element when inner type declaration.
	 */
	public void eInit(XtendTypeDeclaration container, String name, IJvmTypeProvider context) {
		if (this.sarlEnumeration == null) {
			this.container = container;
			this.sarlEnumeration = SarlFactory.eINSTANCE.createSarlEnumeration();
			container.getMembers().add(this.sarlEnumeration);
			if (!Strings.isEmpty(name)) {
				this.sarlEnumeration.setName(name);
			}
		}
	}

	/** Replies the generated SarlEnumeration.
	 */
	@Pure
	public SarlEnumeration getSarlEnumeration() {
		return this.sarlEnumeration;
	}

	/** Replies the resource to which the SarlEnumeration is attached.
	 */
	@Pure
	public Resource eResource() {
		return getSarlEnumeration().eResource();
	}

	/** Change the documentation of the element.
	 *
	 * <p>The documentation will be displayed just before the element.
	 *
	 * @param doc the documentation.
	 */
	public void setDocumentation(String doc) {
		if (Strings.isEmpty(doc)) {
			getSarlEnumeration().eAdapters().removeIf(new Predicate<Adapter>() {
				public boolean test(Adapter adapter) {
					return adapter.isAdapterForType(DocumentationAdapter.class);
				}
			});
		} else {
			DocumentationAdapter adapter = (DocumentationAdapter) EcoreUtil.getExistingAdapter(
					getSarlEnumeration(), DocumentationAdapter.class);
			if (adapter == null) {
				adapter = new DocumentationAdapter();
				getSarlEnumeration().eAdapters().add(adapter);
			}
			adapter.setDocumentation(doc);
		}
	}

	/** Add a modifier.
	 * @param modifier - the modifier to add.
	 */
	public void addModifier(String modifier) {
		if (!Strings.isEmpty(modifier)) {
			this.sarlEnumeration.getModifiers().add(modifier);
		}
	}

	@Inject
	private Provider<ISarlEnumLiteralBuilder> iSarlEnumLiteralBuilderProvider;

	/** Create a SarlEnumLiteral.
	 * @param name - the name of the SarlEnumLiteral.
	 * @return the builder.
	 */
	public ISarlEnumLiteralBuilder addSarlEnumLiteral(String name) {
		ISarlEnumLiteralBuilder builder = this.iSarlEnumLiteralBuilderProvider.get();
		builder.eInit(getSarlEnumeration(), name, getTypeResolutionContext());
		return builder;
	}

}

