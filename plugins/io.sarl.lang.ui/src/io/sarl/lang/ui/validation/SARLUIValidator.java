/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2015 Sebastian RODRIGUEZ, Nicolas GAUD, Stéphane GALLAND.
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
package io.sarl.lang.ui.validation;

import static org.eclipse.xtext.util.Strings.isEmpty;
import static org.eclipse.xtext.util.Strings.notNull;
import io.sarl.lang.sarl.SarlPackage;

import java.text.MessageFormat;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.ide.validator.XtendUIValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/** Validator based on the Eclipse UI.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class SARLUIValidator extends XtendUIValidator {

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> packages = super.getEPackages();
		packages.add(SarlPackage.eINSTANCE);
		//packages.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/xtend")); //$NON-NLS-1$
	    packages.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/xtext/xbase/Xbase")); //$NON-NLS-1$
	    packages.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/xtext/common/JavaVMTypes")); //$NON-NLS-1$
	    packages.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/xtext/xbase/Xtype")); //$NON-NLS-1$
	    packages.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/Xtext/Xbase/XAnnotations")); //$NON-NLS-1$
		return packages;
	}

	@Check
	@Override
	public void checkFileNamingConventions(XtendFile xtendFile) {
		//
		// The wrong package is a warning in SARL (an error in Xtend).
		//
		String expectedPackage = getExpectedPackageName(xtendFile);
		String declaredPackage = xtendFile.getPackage();
		if(expectedPackage != null &&
			!((isEmpty(expectedPackage) && declaredPackage == null) || expectedPackage.equals(declaredPackage))) {
			warning(
					MessageFormat.format(
							Messages.SARLUIValidator_0,
							notNull(declaredPackage),
							notNull(expectedPackage)),
					XtendPackage.Literals.XTEND_FILE__PACKAGE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					IssueCodes.WRONG_PACKAGE,
					expectedPackage);
		}
	}

}