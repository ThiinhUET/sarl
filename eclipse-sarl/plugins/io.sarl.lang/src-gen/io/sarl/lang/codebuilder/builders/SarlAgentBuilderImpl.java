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

import io.sarl.lang.core.Agent;
import io.sarl.lang.sarl.SarlAgent;
import io.sarl.lang.sarl.SarlFactory;
import io.sarl.lang.sarl.SarlScript;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Provider;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.xtend.XtendFactory;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.lib.Pure;

/** Builder of a Sarl SarlAgent.
 */
@SuppressWarnings("all")
public class SarlAgentBuilderImpl extends AbstractBuilder implements ISarlAgentBuilder {

	private SarlAgent sarlAgent;

	@Override
	@Pure
	public String toString() {
		return EmfFormatter.objToStr(getSarlAgent());
	}

	/** Initialize the Ecore element when inside a script.
	 */
	public void eInit(SarlScript script, String name, IJvmTypeProvider context) {
		setTypeResolutionContext(context);
		if (this.sarlAgent == null) {
			this.sarlAgent = SarlFactory.eINSTANCE.createSarlAgent();
			script.getXtendTypes().add(this.sarlAgent);
			this.sarlAgent.setAnnotationInfo(XtendFactory.eINSTANCE.createXtendTypeDeclaration());
			if (!Strings.isEmpty(name)) {
				this.sarlAgent.setName(name);
			}
		}
	}

	/** Replies the generated SarlAgent.
	 */
	@Pure
	public SarlAgent getSarlAgent() {
		return this.sarlAgent;
	}

	/** Replies the resource to which the SarlAgent is attached.
	 */
	@Pure
	public Resource eResource() {
		return getSarlAgent().eResource();
	}

	/** Change the documentation of the element.
	 *
	 * <p>The documentation will be displayed just before the element.
	 *
	 * @param doc the documentation.
	 */
	public void setDocumentation(String doc) {
		if (Strings.isEmpty(doc)) {
			getSarlAgent().eAdapters().removeIf(new Predicate<Adapter>() {
				public boolean test(Adapter adapter) {
					return adapter.isAdapterForType(DocumentationAdapter.class);
				}
			});
		} else {
			DocumentationAdapter adapter = (DocumentationAdapter) EcoreUtil.getExistingAdapter(
					getSarlAgent(), DocumentationAdapter.class);
			if (adapter == null) {
				adapter = new DocumentationAdapter();
				getSarlAgent().eAdapters().add(adapter);
			}
			adapter.setDocumentation(doc);
		}
	}

	/** Change the super type.
	 * @param superType - the qualified name of the super type,
	 *     or <code>null</code> if the default type.
	 */
	public void setExtends(String superType) {
		if (!Strings.isEmpty(superType)
				&& !Agent.class.getName().equals(superType)) {
			JvmParameterizedTypeReference superTypeRef = newTypeRef(this.sarlAgent, superType);
			JvmTypeReference baseTypeRef = findType(this.sarlAgent, Agent.class.getCanonicalName());
			if (isSubTypeOf(this.sarlAgent, superTypeRef, baseTypeRef)) {
				this.sarlAgent.setExtends(superTypeRef);
				return;
			}
		}
		this.sarlAgent.setExtends(null);
	}

	/** Add a modifier.
	 * @param modifier - the modifier to add.
	 */
	public void addModifier(String modifier) {
		if (!Strings.isEmpty(modifier)) {
			this.sarlAgent.getModifiers().add(modifier);
		}
	}

	@Inject
	private Provider<ISarlConstructorBuilder> iSarlConstructorBuilderProvider;

	/** Create a SarlConstructor.
	 * @return the builder.
	 */
	public ISarlConstructorBuilder addSarlConstructor() {
		ISarlConstructorBuilder builder = this.iSarlConstructorBuilderProvider.get();
		builder.eInit(getSarlAgent(), getTypeResolutionContext());
		return builder;
	}

	@Inject
	private Provider<ISarlBehaviorUnitBuilder> iSarlBehaviorUnitBuilderProvider;

	/** Create a SarlBehaviorUnit.
	 * @param name - the typename of the SarlBehaviorUnit.
	 * @return the builder.
	 */
	public ISarlBehaviorUnitBuilder addSarlBehaviorUnit(String name) {
		ISarlBehaviorUnitBuilder builder = this.iSarlBehaviorUnitBuilderProvider.get();
		builder.eInit(getSarlAgent(), name, getTypeResolutionContext());
		return builder;
	}

	@Inject
	private Provider<ISarlFieldBuilder> iSarlFieldBuilderProvider;

	/** Create a SarlField.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	public ISarlFieldBuilder addVarSarlField(String name) {
		ISarlFieldBuilder builder = this.iSarlFieldBuilderProvider.get();
		builder.eInit(getSarlAgent(), name, "var", getTypeResolutionContext());
		return builder;
	}

	/** Create a SarlField.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	public ISarlFieldBuilder addValSarlField(String name) {
		ISarlFieldBuilder builder = this.iSarlFieldBuilderProvider.get();
		builder.eInit(getSarlAgent(), name, "val", getTypeResolutionContext());
		return builder;
	}

	/** Create a SarlField.	 *
	 * <p>This function is equivalent to {@link #addVarSarlField}.
	 * @param name - the name of the SarlField.
	 * @return the builder.
	 */
	public ISarlFieldBuilder addSarlField(String name) {
		return this.addVarSarlField(name);
	}

	@Inject
	private Provider<ISarlActionBuilder> iSarlActionBuilderProvider;

	/** Create a SarlAction.
	 * @param name - the name of the SarlAction.
	 * @return the builder.
	 */
	public ISarlActionBuilder addDefSarlAction(String name) {
		ISarlActionBuilder builder = this.iSarlActionBuilderProvider.get();
		builder.eInit(getSarlAgent(), name, "def", getTypeResolutionContext());
		return builder;
	}

	/** Create a SarlAction.
	 * @param name - the name of the SarlAction.
	 * @return the builder.
	 */
	public ISarlActionBuilder addOverrideSarlAction(String name) {
		ISarlActionBuilder builder = this.iSarlActionBuilderProvider.get();
		builder.eInit(getSarlAgent(), name, "override", getTypeResolutionContext());
		return builder;
	}

	/** Create a SarlAction.	 *
	 * <p>This function is equivalent to {@link #addDefSarlAction}.
	 * @param name - the name of the SarlAction.
	 * @return the builder.
	 */
	public ISarlActionBuilder addSarlAction(String name) {
		return this.addDefSarlAction(name);
	}

	@Inject
	private Provider<ISarlClassBuilder> iSarlClassBuilderProvider;

	/** Create a SarlClass.
	 * @param name - the name of the SarlClass.
	 * @return the builder.
	 */
	public ISarlClassBuilder addSarlClass(String name) {
		ISarlClassBuilder builder = this.iSarlClassBuilderProvider.get();
		builder.eInit(getSarlAgent(), name, getTypeResolutionContext());
		return builder;
	}

	@Inject
	private Provider<ISarlInterfaceBuilder> iSarlInterfaceBuilderProvider;

	/** Create a SarlInterface.
	 * @param name - the name of the SarlInterface.
	 * @return the builder.
	 */
	public ISarlInterfaceBuilder addSarlInterface(String name) {
		ISarlInterfaceBuilder builder = this.iSarlInterfaceBuilderProvider.get();
		builder.eInit(getSarlAgent(), name, getTypeResolutionContext());
		return builder;
	}

	@Inject
	private Provider<ISarlEnumerationBuilder> iSarlEnumerationBuilderProvider;

	/** Create a SarlEnumeration.
	 * @param name - the name of the SarlEnumeration.
	 * @return the builder.
	 */
	public ISarlEnumerationBuilder addSarlEnumeration(String name) {
		ISarlEnumerationBuilder builder = this.iSarlEnumerationBuilderProvider.get();
		builder.eInit(getSarlAgent(), name, getTypeResolutionContext());
		return builder;
	}

	@Inject
	private Provider<ISarlAnnotationTypeBuilder> iSarlAnnotationTypeBuilderProvider;

	/** Create a SarlAnnotationType.
	 * @param name - the name of the SarlAnnotationType.
	 * @return the builder.
	 */
	public ISarlAnnotationTypeBuilder addSarlAnnotationType(String name) {
		ISarlAnnotationTypeBuilder builder = this.iSarlAnnotationTypeBuilderProvider.get();
		builder.eInit(getSarlAgent(), name, getTypeResolutionContext());
		return builder;
	}

}

