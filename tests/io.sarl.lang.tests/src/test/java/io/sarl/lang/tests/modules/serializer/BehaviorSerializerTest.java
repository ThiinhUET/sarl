/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2020 the original authors or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.sarl.lang.tests.modules.serializer;

import static io.sarl.tests.api.tools.TestEObjects.behavior;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author $Author: sgalland$
 * @version $Name$ $Revision$ $Date$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
@DisplayName("serialization: behavior")
public class BehaviorSerializerTest extends AbstractSerializerTest {

	@Test
	public void empty_noSuper() throws Exception {
		String s = "behavior Foo { }";
		this.object = behavior(getParseHelper(), getValidationHelper(), s);
		assertSerialize(s);
	}

	@Test
	public void empty_super() throws Exception {
		String s = "behavior Foo extends foo.ecore.SubBehavior { }";
		this.object = behavior(getParseHelper(), getValidationHelper(), s);
		assertSerialize(s);
	}

}
