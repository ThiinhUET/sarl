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
package io.sarl.eclipse.properties;

import io.sarl.eclipse.runtime.ISREInstall;
import io.sarl.eclipse.runtime.SARLRuntime;
import io.sarl.eclipse.runtime.SREConfigurationBlock;
import io.sarl.eclipse.util.PluginUtil;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jdt.internal.ui.preferences.PropertyAndPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

/** Property page for selecting the SARL runtime environment
 * associated to this page.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class RuntimeEnvironmentPropertyPage extends PropertyAndPreferencePage {

	/** Identifier of the property page.
	 */
	public static final String PROPERTY_PAGE_ID = "io.sarl.eclipse.properties.SRE"; //$NON-NLS-1$

	/** Identifier of the preference page.
	 */
	public static final String PREFERENCE_PAGE_ID = "io.sarl.eclipse.preferences.SREsPreferencePage"; //$NON-NLS-1$

	/** Identifier of the context of the properties managed by this page.
	 */
	public static final String PROPERTY_QUALIFIER = "io.sarl.eclipse.launch.SRE"; //$NON-NLS-1$

	/** Name of the property that contains the SRE install id.
	 */
	public static final String PROPERTY_NAME_SRE_INSTALL_ID = "SRE_INSTALL_ID"; //$NON-NLS-1$

	/** Name of the property that indicates if the system-wide SRE should be used..
	 */
	public static final String PROPERTY_NAME_USE_SYSTEM_WIDE_SRE = "USE_SYSTEM_WIDE_SRE"; //$NON-NLS-1$

	/** Name of the property that indicates if the project has specific options.
	 */
	public static final String PROPERTY_NAME_HAS_PROJECT_SPECIFIC = "HAS_PROJECT_SPECIFIC"; //$NON-NLS-1$

	private SREConfigurationBlock sreBlock;

	/**
	 * Constructor for RuntimeEnvironmentPropertyPage.
	 */
	public RuntimeEnvironmentPropertyPage() {
		super();
	}

	/** Create a qualified name with the given name.
	 *
	 * @param name - the name.
	 * @return the qualified name.
	 */
	public static QualifiedName qualify(String name) {
		return new QualifiedName(PROPERTY_QUALIFIER, name);
	}

	@Override
	protected String getPreferencePageID() {
		return PREFERENCE_PAGE_ID;
	}

	@Override
	protected String getPropertyPageID() {
		return PROPERTY_PAGE_ID;
	}

	@Override
	protected Control createPreferenceContent(Composite composite) {
		this.sreBlock = new SREConfigurationBlock(true, null);
		Control ctrl = this.sreBlock.createControl(composite);
		this.sreBlock.initialize();
		try {
			String useSystemWide = getProject().getPersistentProperty(
					qualify(PROPERTY_NAME_USE_SYSTEM_WIDE_SRE));
			String sreInstallId = getProject().getPersistentProperty(
					qualify(PROPERTY_NAME_SRE_INSTALL_ID));
			ISREInstall sre = SARLRuntime.getSREFromId(Strings.emptyToNull(sreInstallId));
			boolean notify = this.sreBlock.getNotify();
			try {
				this.sreBlock.setNotify(false);
				this.sreBlock.selectSpecificSRE(sre);
				if (Boolean.parseBoolean(Objects.firstNonNull(
						Strings.emptyToNull(useSystemWide), Boolean.TRUE.toString()))) {
					this.sreBlock.selectSystemWideSRE();
				} else {
					this.sreBlock.selectSpecificSRE();
				}
			} finally {
				this.sreBlock.setNotify(notify);
			}
		} catch (CoreException e) {
			PluginUtil.log(e);
		}
		return ctrl;
	}

	@Override
	protected boolean hasProjectSpecificOptions(IProject project) {
		try {
			String value = project.getPersistentProperty(
					qualify(PROPERTY_NAME_HAS_PROJECT_SPECIFIC));
			return Boolean.parseBoolean(value);
		} catch (CoreException e) {
			PluginUtil.log(e);
		}
		return false;
	}

	/** Save the flag that indicates if the specific project options must be
	 * used.
	 *
	 * @param project - the project.
	 * @param useSpecificOptions - indicates if the specifi options must be used.
	 * @return <code>true</code> if the property was saved successfully.
	 */
	@SuppressWarnings("static-method")
	protected boolean saveProjectSpecificOptions(IProject project, boolean useSpecificOptions) {
		if (project != null) {
			try {
				project.setPersistentProperty(
						qualify(PROPERTY_NAME_HAS_PROJECT_SPECIFIC),
						Boolean.toString(useSpecificOptions));
				return true;
			} catch (CoreException e) {
				PluginUtil.log(e);
			}
		}
		return false;
	}

	@Override
	protected void performDefaults() {
		this.sreBlock.selectSRE(null);
		super.performDefaults();
	}

	@Override
	public boolean performOk() {
		IProject prj = getProject();
		if (prj == null || !super.performOk()
			|| !saveProjectSpecificOptions(getProject(), useProjectSettings())) {
			return false;
		}
		ISREInstall projectSRE = this.sreBlock.getSelectedSRE();
		boolean isSystemWide = this.sreBlock.isSystemWideDefaultSRE();
		String id = (projectSRE == null) ? null : projectSRE.getId();
		try {
			prj.setPersistentProperty(
					qualify(PROPERTY_NAME_USE_SYSTEM_WIDE_SRE),
					Boolean.toString(isSystemWide));
			prj.setPersistentProperty(
					qualify(PROPERTY_NAME_SRE_INSTALL_ID),
					id);
			return true;
		} catch (CoreException e) {
			PluginUtil.log(e);
		}
		return false;
	}

}