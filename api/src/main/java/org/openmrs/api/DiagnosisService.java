/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.api;

import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.Diagnosis;
import org.openmrs.annotation.Authorized;
import org.openmrs.util.PrivilegeConstants;


import java.util.Date;
import java.util.List;

/**
 * <pre>
 * API methods for managing diagnoses
 * </pre>
 * 
 *  @since 2.2
 */
public interface DiagnosisService extends OpenmrsService {

	/**
	 * Saves a diagnosis
	 *
	 * @param diagnosis - the diagnosis to be saved
	 * @return the diagnosis
	 */
	@Authorized({ PrivilegeConstants.EDIT_DIAGNOSES })
	Diagnosis save(Diagnosis diagnosis);

	/**
	 * Voids a diagnosis
	 *
	 * @param diagnosis - the diagnosis to be voided
	 * @param voidReason - the reason for voiding the diagnosis
	 * @return the diagnosis that was voided
	 */
	@Authorized({ PrivilegeConstants.EDIT_DIAGNOSES })
	Diagnosis voidDiagnosis(Diagnosis diagnosis, String voidReason);

	/**
	 * Gets a diagnosis based on the uuid
	 *
	 * @param uuid - uuid of the diagnosis to be returned
	 * @return diagnosis matching the given uuid
	 */
	@Authorized({ PrivilegeConstants.GET_DIAGNOSES })
	Diagnosis getDiagnosisByUuid(String uuid);

	/**
	 * Gets diagnoses since date, sorted in reverse chronological order
	 *
	 * @param patient the patient whose diagnosis we are to get
	 * @param fromDate the date used to filter diagnosis which happened from this date and later
	 * @return the list of diagnoses for the given patient and starting from the given date
	 */
	@Authorized({ PrivilegeConstants.GET_DIAGNOSES })
	List<Diagnosis> getDiagnoses(Patient patient, Date fromDate);

	/**
	 * Finds the primary diagnoses for a given encounter
	 * 
	 * @param encounter the encounter whose diagnoses we are to get
	 * @return the list of diagnoses in the given encounter
	 */
	List<Diagnosis> getPrimaryDiagnoses(Encounter encounter);

	/**
	 * Determines whether or not an encounter contains a given diagnosis
	 * 
	 * @param encounter the encounter whose diagnoses we are to get
	 * @param diagnosis the diagnosis to check if it belongs to a given encounter
	 * @return true if the encounter has the given diagnosis, else false
	 */
	boolean hasDiagnosis(Encounter encounter, Diagnosis diagnosis);

	/**
	 * Gets unique diagnoses since date, sorted in reverse chronological order
	 *
	 * @param patient the patient whose diagnosis we are to get
	 * @param fromDate the date used to filter diagnosis which happened from this date and later
	 * @return the list of diagnoses
	 */
	List<Diagnosis> getUniqueDiagnoses(Patient patient, Date fromDate);
}

