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
package io.sarl.lang.codebuilder.appenders;

import io.sarl.lang.codebuilder.builders.IExpressionBuilder;
import io.sarl.lang.codebuilder.builders.ISarlFieldBuilder;
import io.sarl.lang.sarl.SarlField;
import java.io.IOException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.Pure;

/** Source appender of a Sarl SarlField.
 */
@SuppressWarnings("all")
public class SarlFieldSourceAppender extends AbstractSourceAppender implements ISarlFieldBuilder {

	private final ISarlFieldBuilder builder;

	public SarlFieldSourceAppender(ISarlFieldBuilder builder) {
		this.builder = builder;
	}

	public void build(ISourceAppender appender) throws IOException {
		build(this.builder.getSarlField(), appender);
	}

	/** Dispose the resource.
	 */
	public void dispose() {
		this.builder.dispose();
	}

	public IJvmTypeProvider getTypeResolutionContext() {
		return this.builder.getTypeResolutionContext();
	}

	/** Initialize the Ecore element.
	 * @param container - the container of the SarlField.
	 * @param name - the name of the SarlField.
	 */
	public void eInit(XtendTypeDeclaration container, String name, String modifier, IJvmTypeProvider context) {
		this.builder.eInit(container, name, modifier, context);
	}

	/** Replies the generated element.
	 */
	@Pure
	public SarlField getSarlField() {
		return this.builder.getSarlField();
	}

	/** Replies the resource.
	 */
	@Pure
	public Resource eResource() {
		return getSarlField().eResource();
	}

	/** Change the documentation of the element.
	 *
	 * <p>The documentation will be displayed just before the element.
	 *
	 * @param doc the documentation.
	 */
	public void setDocumentation(String doc) {
		this.builder.setDocumentation(doc);
	}

	/** Change the type.
	 * @param type the type of the member.
	 */
	public void setType(String type) {
		this.builder.setType(type);
	}

	/** Change the initialValue.
	 * @param value - the value of the initialValue. It may be <code>null</code>.
	 */
	@Pure
	public IExpressionBuilder getInitialValue() {
		return this.builder.getInitialValue();
	}

	/** Add a modifier.
	 * @param modifier - the modifier to add.
	 */
	public void addModifier(String modifier) {
		this.builder.addModifier(modifier);
	}

	@Override
	@Pure
	public String toString() {
		return this.builder.toString();
	}

}

