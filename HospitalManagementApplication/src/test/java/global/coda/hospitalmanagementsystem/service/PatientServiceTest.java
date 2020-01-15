package global.coda.hospitalmanagementsystem.service;

import global.coda.hospitalmanagementsystem.constant.TestConstant;
import global.coda.hospitalmanagementsystem.deligate.PatientFileService;
import global.coda.hospitalmanagementsystem.exception.InvalidPatientAgeException;
import global.coda.hospitalmanagementsystem.exception.InvalidPatientIdException;
import global.coda.hospitalmanagementsystem.exception.PatientObjectArrayEmptyException;
import global.coda.hospitalmanagementsystem.exception.PatientObjectArrayOverflowException;
import global.coda.hospitalmanagementsystem.exception.PatientRecordNotFoundException;
import global.coda.hospitalmanagementsystem.model.Patient;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PatientServiceTest {

	private PatientFileService patientService;
	HashMap<Integer, Patient> inputPatientMap;
	private static final ResourceBundle TEST_BUNDLE = ResourceBundle.getBundle(TestConstant.TEST_INPUT);

	@BeforeMethod
	public void setUp() {

		inputPatientMap = new HashMap<Integer, Patient>();
		patientService = new PatientFileService();

	}

	@Test
	public void createPatientTestValid() throws PatientObjectArrayOverflowException, InvalidPatientAgeException {
		String inputName = TEST_BUNDLE.getString(TestConstant.NAME);
		int inputAge = Integer.parseInt(TEST_BUNDLE.getString(TestConstant.AGE));
		String inputBloodGroup = TEST_BUNDLE.getString(TestConstant.BLOOD_GROUP);
		List<String> inputAddress = new LinkedList<String>();
		inputAddress.add(TEST_BUNDLE.getString(TestConstant.ADDRESS1));
		inputAddress.add(TEST_BUNDLE.getString(TestConstant.ADDRESS2));
		inputAddress.add(TEST_BUNDLE.getString(TestConstant.ADDRESS3));
		int countOfPatients = patientService.createPatient(inputPatientMap,
				Integer.parseInt(TEST_BUNDLE.getString(TestConstant.COUNT_OF_PATIENTS_VALID)), inputName, inputAge,
				inputBloodGroup, inputAddress);

		assertTrue(
				countOfPatients == Integer.parseInt(TEST_BUNDLE.getString(TestConstant.COUNT_OF_PATIENTS_VALID)) + 1);
	}

	@Test
	public void createPatientTestInValid() throws PatientObjectArrayOverflowException, InvalidPatientAgeException {
		String inputName = TEST_BUNDLE.getString(TestConstant.NAME);
		int inputAge = Integer.parseInt(TEST_BUNDLE.getString(TestConstant.AGE));
		String inputBloodGroup = TEST_BUNDLE.getString(TestConstant.BLOOD_GROUP);
		List<String> inputAddress = new LinkedList<String>();
		inputAddress.add(TEST_BUNDLE.getString(TestConstant.ADDRESS1));
		inputAddress.add(TEST_BUNDLE.getString(TestConstant.ADDRESS2));
		inputAddress.add(TEST_BUNDLE.getString(TestConstant.ADDRESS3));
		try {
			patientService.createPatient(inputPatientMap,
					Integer.parseInt(TEST_BUNDLE.getString(TestConstant.COUNT_OF_PATIENTS_INVALID)), inputName,
					inputAge, inputBloodGroup, inputAddress);
		} catch (Exception exception) {

			String exceptionName = exception.getClass().getSimpleName();
			assertEquals(exceptionName, "PatientObjectArrayOverflowException");
		}
	}

	@Test
	public void deletePatientTestValid() throws PatientObjectArrayEmptyException, InvalidPatientIdException,
			PatientObjectArrayOverflowException, InvalidPatientAgeException, PatientRecordNotFoundException {
		String inputName = TEST_BUNDLE.getString(TestConstant.NAME);
		int inputAge = Integer.parseInt(TEST_BUNDLE.getString(TestConstant.AGE));
		String inputBloodGroup = TEST_BUNDLE.getString(TestConstant.BLOOD_GROUP);
		List<String> inputAddress = new LinkedList<String>();
		inputAddress.add(TEST_BUNDLE.getString(TestConstant.ADDRESS1));
		inputAddress.add(TEST_BUNDLE.getString(TestConstant.ADDRESS2));
		inputAddress.add(TEST_BUNDLE.getString(TestConstant.ADDRESS3));
		int countOfPatients = patientService.createPatient(inputPatientMap, 0, inputName, inputAge, inputBloodGroup,
				inputAddress);
		int patientCount = patientService.deletePatient(inputPatientMap, countOfPatients, 1);

		assertTrue(patientCount == countOfPatients - 1);
	}

	@Test
	public void deletePatientTestInvalid() {

		try {
			patientService.deletePatient(inputPatientMap, 1, 2);
		} catch (Exception exception) {

			String exceptionName = exception.getClass().getSimpleName();
			System.out.println(exceptionName);
			assertEquals(exceptionName, "InvalidPatientIdException");
		}
	}

	@Test
	public void readPatientTestInvalidEmpty() {

		try {
			patientService.readAllPatients(inputPatientMap, -1);
		} catch (Exception exception) {

			String exceptionName = exception.getClass().getSimpleName();
			assertEquals(exceptionName, "PatientObjectArrayEmptyException");
		}

	}

	@Test
	public void readPatientTestInvalidOverflow() {

		try {
			patientService.readAllPatients(inputPatientMap, 101);
		} catch (Exception exception) {

			String exceptionName = exception.getClass().getSimpleName();
			assertEquals(exceptionName, "PatientObjectArrayOverflowException");
		}

	}

	@Test
	public void updatePatientTestValid() throws PatientObjectArrayOverflowException, InvalidPatientAgeException,
			InvalidPatientIdException, PatientRecordNotFoundException {
		String inputName = TEST_BUNDLE.getString(TestConstant.NAME);
		int inputAge = Integer.parseInt(TEST_BUNDLE.getString(TestConstant.AGE));
		String inputBloodGroup = TEST_BUNDLE.getString(TestConstant.BLOOD_GROUP);
		List<String> inputAddress = new LinkedList<String>();
		inputAddress.add(TEST_BUNDLE.getString(TestConstant.ADDRESS1));
		inputAddress.add(TEST_BUNDLE.getString(TestConstant.ADDRESS2));
		inputAddress.add(TEST_BUNDLE.getString(TestConstant.ADDRESS3));
		int countOfPatients = patientService.createPatient(inputPatientMap, 0, inputName, inputAge, inputBloodGroup,
				inputAddress);
		patientService.updatePatientAge(inputPatientMap, countOfPatients, countOfPatients, 48);
		assertEquals(inputPatientMap.get(countOfPatients).getpatientAge(), 48);

	}

}
