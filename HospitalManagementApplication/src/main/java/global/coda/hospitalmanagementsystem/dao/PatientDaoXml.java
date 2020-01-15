package global.coda.hospitalmanagementsystem.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import global.coda.hospitalmanagementsystem.model.Patient;

public class PatientDaoXml extends PatientDao {
  public PatientDaoXml() {
    super();
  }
  
  File patientXmlFile = new File(xmlFilePath);

  @Override
  public int readPatientFile(HashMap<Integer, Patient> patients,
      int patientCount) {
    try {

      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document patientDoc = dBuilder.parse(patientXmlFile);

      patientDoc.getDocumentElement().normalize();

      NodeList newList = patientDoc.getElementsByTagName("patient");

      for (int temp = 0; temp < newList.getLength(); temp++) {

        Node newNode = newList.item(temp);
        Patient patientObj = new Patient();
        if (newNode.getNodeType() == Node.ELEMENT_NODE) {

          Element patientElement = (Element) newNode;
          String[] patientRecord = new String[100];
          patientRecord[0] = (patientElement.getAttribute("Id"));
          patientRecord[1] = (patientElement.getElementsByTagName("Name")
              .item(0).getTextContent());
          patientRecord[2] = (patientElement.getElementsByTagName("Age").item(0)
              .getTextContent());
          patientRecord[3] = (patientElement.getElementsByTagName("BloodGroup")
              .item(0).getTextContent());
          patientRecord[4] = (patientElement.getElementsByTagName("Address1")
              .item(0).getTextContent());
          patientRecord[5] = (patientElement.getElementsByTagName("Address2")
              .item(0).getTextContent());
          patientRecord[6] = (patientElement.getElementsByTagName("Address3")
              .item(0).getTextContent());

          patientObj.setPatientId(Integer.parseInt(patientRecord[0]));
          patientObj.setpatientName(patientRecord[1]);
          patientObj.setpatientAge(Integer.parseInt(patientRecord[2]));
          patientObj.setpatientBloodGroup(patientRecord[3]);
          List<String> tempaddressList = new ArrayList<String>();
          tempaddressList.add(patientRecord[4]);
          tempaddressList.add(patientRecord[5]);
          tempaddressList.add(patientRecord[6]);
          patientObj.setPatientAddress(tempaddressList);
          patients.put(patientObj.getPatientId(), patientObj);

        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return patientCount;
  }

  @Override
  public void writePatientFile(HashMap<Integer, Patient> patientMap) {
    DocumentBuilderFactory documentFactory = DocumentBuilderFactory
        .newInstance();

    DocumentBuilder documentBuilder = null;
    try {
      documentBuilder = documentFactory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    Document document = documentBuilder.newDocument();
    Element root = document.createElement("Patients");
    document.appendChild(root);

    for (Map.Entry<Integer, Patient> entry : patientMap.entrySet()) {
      Patient patientObj = (Patient) entry.getValue();
      Element patient = document.createElement("Patient");
      root.appendChild(patient);

      Attr attr = document.createAttribute("Id");
      attr.setValue(String.valueOf(patientObj.getPatientId()));
      patient.setAttributeNode(attr);

      Element name = document.createElement("Name");
      name.appendChild(document.createTextNode(patientObj.getpatientName()));
      patient.appendChild(name);

      Element age = document.createElement("Age");
      age.appendChild(document
          .createTextNode(Integer.toString(patientObj.getpatientAge())));
      patient.appendChild(age);

      Element bloodgroup = document.createElement("BloodGroup");
      bloodgroup.appendChild(
          document.createTextNode(patientObj.getpatientBloodGroup()));
      patient.appendChild(bloodgroup);

      Element addressline1 = document.createElement("Address1");
      addressline1.appendChild(
          document.createTextNode(patientObj.getPatientAddress().get(0)));
      patient.appendChild(addressline1);

      Element addressline2 = document.createElement("Address2");
      addressline2.appendChild(
          document.createTextNode(patientObj.getPatientAddress().get(1)));
      patient.appendChild(addressline2);

      Element addressline3 = document.createElement("Address3");
      addressline3.appendChild(
          document.createTextNode(patientObj.getPatientAddress().get(2)));
      patient.appendChild(addressline3);
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = null;
      try {
        transformer = transformerFactory.newTransformer();
      } catch (TransformerConfigurationException e) {
        e.printStackTrace();
      }
      DOMSource domSource = new DOMSource(document);
      StreamResult streamResult = new StreamResult(patientXmlFile);
      try {
        transformer.transform(domSource, streamResult);
      } catch (TransformerException e) {
        e.printStackTrace();
      }
    }
  }
}
