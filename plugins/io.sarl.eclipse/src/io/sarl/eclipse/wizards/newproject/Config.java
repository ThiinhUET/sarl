/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014 Sebastian RODRIGUEZ, Nicolas GAUD, Stéphane GALLAND.
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
package io.sarl.eclipse.wizards.newproject;

import java.io.File;

/**
 * Provides the constants for the wizard "New SARL project".
 * <p>
 * These constants are externalized for helping Jnario to
 * check the documentation without instanciating Eclipse RCP.
 *
 * @author $Author: ngaud$
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public final class Config {

	/** Name of the folder that contains the sources.
	 */
	public static final String SOURCE_FOLDER_NAME = "src"; //$NON-NLS-1$

	/** Name of the folder that contains the "main" sources.
	 */
	public static final String MAIN_FOLDER_NAME = "main"; //$NON-NLS-1$

	/** Name of the folder that contains the "java" sources.
	 */
	public static final String JAVA_FOLDER_NAME = "java"; //$NON-NLS-1$

	/** Name of the folder that contains the "sarl" sources.
	 */
	public static final String SARL_FOLDER_NAME = "sarl"; //$NON-NLS-1$

	/** Name of the folder that contains the generated sources.
	 */
	public static final String GENERATED_SOURCE_FOLDER_NAME = "generated-sources"; //$NON-NLS-1$

	/** Name of the folder that contains the java sources generated from xtend.
	 */
	public static final String XTEND_FOLDER_NAME = "xtend"; //$NON-NLS-1$

	/** Folder where the Java files are generated by default by the Xtend compiler.
	 */
	public static final String DEFAULT_GENERATED_SOURCE_FOLDER = SOURCE_FOLDER_NAME + File.separator + MAIN_FOLDER_NAME
			+ File.separator + GENERATED_SOURCE_FOLDER_NAME + File.separator + XTEND_FOLDER_NAME;

	/**
	 * The different directories composing a SARL project.
	 */
	public static final String[] PROJECT_STRUCTURE_PATH = {
		// src/main
		SOURCE_FOLDER_NAME, SOURCE_FOLDER_NAME + File.separator + MAIN_FOLDER_NAME,
		// src/main/java
		SOURCE_FOLDER_NAME + File.separator + MAIN_FOLDER_NAME + File.separator + JAVA_FOLDER_NAME,
		// src/main/sarl
		SOURCE_FOLDER_NAME + File.separator + MAIN_FOLDER_NAME + File.separator + SARL_FOLDER_NAME,
		// src/main/generated-sources
		SOURCE_FOLDER_NAME + File.separator + MAIN_FOLDER_NAME + File.separator + GENERATED_SOURCE_FOLDER_NAME,
		// src/main/generated-sources/xtend
		DEFAULT_GENERATED_SOURCE_FOLDER,
	};

	/** Names of the reference libraries that are required to compile the SARL
	 * code and the generated Java code.
	 */
	public static final String[] SARL_REFERENCE_LIBRARIES = {
		"com.google.guava", //$NON-NLS-1$
		"org.eclipse.xtext.xbase.lib", //$NON-NLS-1$
		"io.sarl.lang.core", //$NON-NLS-1$
		"io.sarl.util", //$NON-NLS-1$
		"io.sarl.core", //$NON-NLS-1$
	};

	/**
	 * ID of the project nature defined by XText.
	 */
	public static final String XTEXT_NATURE_ID = "org.eclipse.xtext.ui.shared.xtextNature"; //$NON-NLS-1$

	private Config() {
		//
	}

}
