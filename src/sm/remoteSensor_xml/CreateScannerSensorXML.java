package sm.remoteSensor_xml;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import sm.main.UploadFrame;

public class CreateScannerSensorXML {
	
//	private static String savePath = "src/instance/instance_ScannerSensor.xml";
//	private static String xmlPath = "src/Resource/ScannerSensor.xml";
	
	private static String savePath = "C:/Users/Chels/Desktop/instance/ScannerSensor.xml";
	
	public InputStream parsedoc() {
		InputStream file= this.getClass().getResourceAsStream("/ScannerSensor.xml");
		return file;
	}
	
	public static void DomCreate() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
        try {
        	DocumentBuilder db = dbf.newDocumentBuilder();
        	CreateScannerSensorXML  createScannerSensorXML = new CreateScannerSensorXML();
        	InputStream file = createScannerSensorXML.parsedoc();
        	Document doc = db.parse(file);
        	
        	//根节点<sml:physicalSystem>
        	Element root = (Element)doc.getFirstChild();
        	
        	//Page One 卫星平台标识信息
        	Element description = (Element) doc.getElementsByTagName("gml:description").item(0);
        	System.out.println(description.getNodeName());
        	description.getFirstChild().setNodeValue(ScannerSensorFrame.getDescripition());
        	
        	Element keywords = (Element) doc.getElementsByTagName("sml:keywords").item(0);
        	System.out.println(keywords.getNodeName());
        	Element keywordList = (Element) keywords.getElementsByTagName("sml:KeywordList").item(0);
        	NodeList keyword = keywordList.getElementsByTagName("sml:keyword");
        	String[] kword = ScannerSensorFrame.getKeywords();
        	if (kword.length==0) {
				root.removeChild(keywords);
			}else if (kword.length<4||kword.length==4) {
				for (int i = 0; i < kword.length; i++) {
					keyword.item(i).getFirstChild().setNodeValue(kword[i]);
				}
				for (int j = kword.length; j < 4; j++) {
					keyword.item(j).getFirstChild().setNodeValue("");
				}
			}else if (kword.length>4) {
				for (int i = 0; i < 4; i++) {
					keyword.item(i).getFirstChild().setNodeValue(kword[i]);
				}
				for (int j = 4; j < kword.length; j++) {
					Element k = doc.createElement("sml:keyword");
					k.setTextContent(kword[j]);
					keywordList.appendChild(k);
				}
			}
        	
        	Element identifierList = (Element) doc.getElementsByTagName("sml:IdentifierList").item(0);
        	System.out.println(identifierList.getNodeName());
        	NodeList identifiers = identifierList.getElementsByTagName("sml:identifier");
        	for (int i = 0; i < identifiers.getLength(); i++) {
        		Element identifier = (Element) identifiers.item(i);
				Element term = (Element) identifier.getElementsByTagName("sml:Term").item(0);
				Element label = (Element) term.getElementsByTagName("sml:label").item(0);
				Element value = (Element) term.getElementsByTagName("sml:value").item(0);
				String lb = label.getFirstChild().getNodeValue();
				if (lb.equals("唯一标识码")) {
					value.getFirstChild().setNodeValue(ScannerSensorFrame.getUID());
				}else if (lb.equals("传感器全称")) {
					value.getFirstChild().setNodeValue(ScannerSensorFrame.getLongname());
				}else if (lb.equals("传感器简称")) {
					value.getFirstChild().setNodeValue(ScannerSensorFrame.getShortname());
				}else if (lb.equals("所属平台名称")&&ScannerSensorFrame.getParentPlatformCount()>0) {
					value.getFirstChild().setNodeValue(ScannerSensorFrame.getParentPlatformInfo(0, 0));
				}else if (lb.equals("所属平台标识符")&&ScannerSensorFrame.getParentPlatformCount()>0) {
					value.getFirstChild().setNodeValue(ScannerSensorFrame.getParentPlatformInfo(0, 1));
				}
				System.out.println("标识符:"+lb);
        	}
        	
        	if (ScannerSensorFrame.getParentPlatformCount()>1) {
				for (int i = 1; i < ScannerSensorFrame.getParentPlatformCount(); i++) {
					Element identifierName = doc.createElement("sml:identifier");
					Element t1 = doc.createElement("sml:Term");
					t1.setAttribute("definition", "urn:ogc:def:identifier:OGC:1.0:parentSensorPlatformName");
					Element l1 = doc.createElement("sml:label");
					Element v1 = doc.createElement("sml:value");
					l1.setTextContent("所属平台名称");
					v1.setTextContent(ScannerSensorFrame.getParentPlatformInfo(i, 0));
					t1.appendChild(l1);
					t1.appendChild(v1);
					identifierName.appendChild(t1);
					identifierList.appendChild(identifierName);
					
					Element identifierID = doc.createElement("sml:identifier");
					Element t = doc.createElement("sml:Term");
					t.setAttribute("definition", "urn:ogc:def:identifier:OGC:1.0:parentSensorPlatformUniqueID");
					Element l = doc.createElement("sml:label");
					l.setTextContent("所属平台标识符");
					Element v = doc.createElement("sml:value");
					v.setTextContent(ScannerSensorFrame.getParentPlatformInfo(i, 1));
					t.appendChild(l);
					t.appendChild(v);
					identifierID.appendChild(t);
					identifierList.appendChild(identifierID);
				}
			}
        	//其他标识符
        	if (ScannerSensorFrame.getOtherIdentifierCount()>0) {
				for (int i = 0; i < ScannerSensorFrame.getOtherIdentifierCount(); i++) {
					Element identifier = doc.createElement("sml:identifier");
					Element term = doc.createElement("sml:Term");
					Element label = doc.createElement("sml:label");
					Element value = doc.createElement("sml:value");
					term.setAttribute("definition", "urn:ogc:def:identifier:OGC:1.0:otherIdentifier");
					label.setTextContent(ScannerSensorFrame.getParentPlatformInfo(i, 0));
					value.setTextContent(ScannerSensorFrame.getParentPlatformInfo(i, 1));
					term.appendChild(label);
					term.appendChild(value);
					identifier.appendChild(term);
					identifierList.appendChild(identifier);
				}
			}
        	
        	Element classifierList = (Element) doc.getElementsByTagName("sml:ClassifierList").item(0);
        	System.out.println(classifierList.getNodeName());
        	NodeList classifiers = classifierList.getElementsByTagName("sml:classifier");
        	String[] application = ScannerSensorFrame.getApplication();
        	for (int i = 0; i < classifiers.getLength(); i++) {
        		Element classifier = (Element) classifiers.item(0);
				Element term = (Element) classifier.getElementsByTagName("sml:Term").item(0);
    			Element label = (Element) term.getElementsByTagName("sml:label").item(0);
    			Element value = (Element) term.getElementsByTagName("sml:value").item(0);
    			String lb = label.getFirstChild().getNodeValue();
    			if (lb.equals("传感器类型")) {
					value.getFirstChild().setNodeValue(ScannerSensorFrame.getSensorType());
				}else if (lb.equals("扫描类型")) {
					value.getFirstChild().setNodeValue(ScannerSensorFrame.getScannerType());
				}else if (lb.equals("预期应用")&&application.length>0) {
					value.getFirstChild().setNodeValue(application[0]);
				}
        	}
        	if (application.length>1) {
				for (int i = 1; i < application.length; i++) {
					Element classifier = doc.createElement("sml:classifier");
					Element term = doc.createElement("sml:Term");
					Element label = doc.createElement("sml:label");
					Element value = doc.createElement("sml:value");
					term.setAttribute("definition", "urn:ogc:def:classifier:OGC:1.0:intendedApplication");
					label.setTextContent("预期应用");
					value.setTextContent(application[i]);
					term.appendChild(label);
					term.appendChild(value);
					classifier.appendChild(term);
					classifierList.appendChild(classifier);
				}
			}
        	//其他分类符
        	if (ScannerSensorFrame.checkOtherClassifier()&&ScannerSensorFrame.getOtherClassiifierCount()>0) {
				for (int i = 0; i < ScannerSensorFrame.getOtherClassiifierCount(); i++) {
					Element classifier = doc.createElement("sml:classifier");
    				Element term = doc.createElement("sml:Term");
    				Element label = doc.createElement("sml:label");
    				Element value = doc.createElement("sml:value");
    				term.setAttribute("definition", "urn:ogc:def:classifier:OGC:1.0:otherClassifier");
    				label.setTextContent(ScannerSensorFrame.getOtherClassifierInfo(i, 0));
    				value.setTextContent(ScannerSensorFrame.getOtherClassifierInfo(i, 1));
    				term.appendChild(label);
    				term.appendChild(value);
    				classifier.appendChild(term);
    				classifierList.appendChild(classifier);
				}
			}
        	
        	//Page Two  约束条件（有效时间；法律约束；安全约束）
        	Element validTM = (Element) doc.getElementsByTagName("sml:validTime").item(0);
        	System.out.println(validTM.getNodeName());
        	Element TMPeriod = (Element) validTM.getElementsByTagName("gml:TimePeriod").item(0);
        	Element beginTM = (Element) TMPeriod.getElementsByTagName("gml:beginPosition").item(0);
        	Element endTM = (Element) TMPeriod.getElementsByTagName("gml:endPosition").item(0);
        	if (ScannerSensorFrame.getBeginTMStates().equals("不定时间点")) {
        		TMPeriod.removeChild(beginTM);
				Element unknown = doc.createElement("gml:beginPosition");
        		unknown.setAttribute("indeterminatePosition", "unknown");
			}else {
				beginTM.getFirstChild().setNodeValue(ScannerSensorFrame.getBeginTM());
			}
        	if (ScannerSensorFrame.getEndTMStates().equals("不定时间点")) {
        		TMPeriod.removeChild(endTM);
				Element unknown = doc.createElement("gml:endPosition");
        		unknown.setAttribute("indeterminatePosition", "unknown");
        		TMPeriod.appendChild(unknown);
			}else {
				endTM.getFirstChild().setNodeValue(ScannerSensorFrame.getEndTM());
			}
        	
        	Element legalConstraint = (Element) doc.getElementsByTagName("sml:legalConstraints").item(0);
        	System.out.println(legalConstraint.getNodeName());
        	Element legalLimitation = (Element) legalConstraint.getElementsByTagName("gco:CharacterString").item(0);
        	if (ScannerSensorFrame.getLegalConstraint().equals("")) {
				root.removeChild(legalConstraint);
			}else {
				legalLimitation.getFirstChild().setNodeValue(ScannerSensorFrame.getLegalConstraint());
			}
        	
        	Element securityConstraint = (Element) doc.getElementsByTagName("sml:securityConstraints").item(0);
        	System.out.println(securityConstraint.getNodeName());
        	Element securityNoticeText = (Element) securityConstraint.getElementsByTagName("ism:NoticeText").item(0);
        	if (ScannerSensorFrame.getSecurityConstraint().equals("")) {
				root.removeChild(securityConstraint);
			}else {
				securityNoticeText.getFirstChild().setNodeValue(ScannerSensorFrame.getSecurityConstraint());
			}
        	
        	//Page Three 站点特征、观测能力、位置信息
        	Element characteristics = (Element) doc.getElementsByTagName("sml:characteristics").item(0);
        	System.out.println(characteristics.getNodeName());
        	Element characteristicList = (Element) characteristics.getElementsByTagName("sml:CharacteristicList").item(0);
        	NodeList characteristic = characteristicList.getElementsByTagName("sml:characteristic");
        	Element chara1 = (Element) characteristic.item(0);
        	Element chara2 = (Element) characteristic.item(1);
        	Element chara3 = (Element) characteristic.item(2);
        	if (ScannerSensorFrame.getSensorLength().equals("")&&ScannerSensorFrame.getSensorWidth().equals("")
        			&&ScannerSensorFrame.getSensorWeigh().equals("")&&ScannerSensorFrame.getSensorHeight().equals("")) {
        		characteristicList.removeChild(chara1);
			}else {
				Element dataRecord = (Element) chara1.getElementsByTagName("swe:DataRecord").item(0);
	        	NodeList fields = dataRecord.getElementsByTagName("swe:field");
	        	for (int i = 0; i < fields.getLength(); i++) {
	        		Element field = (Element) fields.item(i); 
	        		String fieldName = field.getAttribute("name");
	        		Element value = (Element) field.getElementsByTagName("swe:value").item(0);
	        		if (fieldName.equals("长度")) {
						if (ScannerSensorFrame.getSensorLength().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getSensorLength());
						}
					}
	        		else if (fieldName.equals("宽度")) {
						if (ScannerSensorFrame.getSensorWidth().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getSensorWidth());
						}
					}
	        		else if (fieldName.equals("高度")) {
						if (ScannerSensorFrame.getSensorHeight().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getSensorHeight());
						}
					}
	        		else if (fieldName.equals("质量")) {
						if (ScannerSensorFrame.getSensorWeigh().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getSensorWeigh());
						}
					}
	        	}
			}
        	
        	if (!ScannerSensorFrame.checkCurrent()&&!ScannerSensorFrame.checkVoltage()
        			&&ScannerSensorFrame.getPower().equals("")&&ScannerSensorFrame.getOutputPower().equals("")) {
        		characteristicList.removeChild(chara2);
			}else {
				Element dataRecord = (Element) chara2.getElementsByTagName("swe:DataRecord").item(0);
	        	NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i); 
	        		String fieldName = field.getAttribute("name");
	        		Element value = (Element) field.getElementsByTagName("swe:value").item(0);
	        		if (fieldName.equals("电流")) {
						if (ScannerSensorFrame.checkCurrent()) {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getCurrent());
						}else {
							dataRecord.removeChild(field);
						}
					}
	        		else if (fieldName.equals("电压")) {
	        			if (ScannerSensorFrame.checkVoltage()) {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getVoltage());
						}else {
							dataRecord.removeChild(field);
						}
					}
	        		else if (fieldName.equals("功率")) {
						if (ScannerSensorFrame.getPower().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getPower());
						}
					}
	        		else if (fieldName.equals("输出功率")) {
						if (ScannerSensorFrame.getOutputPower().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getOutputPower());
						}
					}
				}
			}
        	
        	if (ScannerSensorFrame.getLife().equals("")) {
				characteristicList.removeChild(chara3);
			}else {
				Element dataRecord = (Element) chara3.getElementsByTagName("swe:DataRecord").item(0);
	        	NodeList fields = dataRecord.getElementsByTagName("swe:field");
	        	for (int i = 0; i < fields.getLength(); i++) {
	        		Element field = (Element) fields.item(i); 
	        		String fieldName = field.getAttribute("name");
	        		Element value = (Element) field.getElementsByTagName("swe:value").item(0);
	        		if (fieldName.equals("设计寿命")) {
						if (ScannerSensorFrame.getLife().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getLife());
						}
					}
				}
			}
        	//其他平台特征
        	if (ScannerSensorFrame.getOtherCharacterCount()>0&&ScannerSensorFrame.checkOtherCharacter()) {
        		Element chara = doc.createElement("sml:characteristic");
				Element dataRecord = doc.createElement("swe:DataRecord");
				Element otherCharaLabel = doc.createElement("swe:label");
				otherCharaLabel.setTextContent("其他特征");
				for (int i = 0; i < ScannerSensorFrame.getOtherCharacterCount(); i++) {
					Element field = doc.createElement("swe:field");
					Element quantity = doc.createElement("swe:Quantity");
					Element value = doc.createElement("swe:value");
					field.setAttribute("name", ScannerSensorFrame.getOtherCharacterInfo(i, 0));
					value.setTextContent(ScannerSensorFrame.getOtherCharacterInfo(i, 1));
					quantity.appendChild(value);
					field.appendChild(quantity);
					dataRecord.appendChild(field);
				}
				chara.appendChild(dataRecord);
				characteristicList.appendChild(chara);
			}
        	
        	Element Capabilities = (Element) doc.getElementsByTagName("sml:capabilities").item(0);
        	System.out.println(Capabilities.getNodeName());
        	Element CapabilityList = (Element) Capabilities.getElementsByTagName("sml:CapabilityList").item(0);
        	NodeList Capability = CapabilityList.getElementsByTagName("sml:capability");
        	Element Capability1 = (Element) Capability.item(0);
        	Element Capability2 = (Element) Capability.item(1);
        	Element Capability3 = (Element) Capability.item(2);
        	Element Capability4 = (Element) Capability.item(3);
        	Element Capability5 = (Element) Capability.item(4);
        	if (ScannerSensorFrame.getBandsCategory().equals("")&&ScannerSensorFrame.checkBandsRange()&&
        			ScannerSensorFrame.getBandsNumber().equals("")&&!ScannerSensorFrame.checkSwath()
        			&&ScannerSensorFrame.getFOV().equals("")&&!ScannerSensorFrame.checkGroungResolution()
        			&&ScannerSensorFrame.getSideSwingAngle().equals("")&&ScannerSensorFrame.getLowerY().equals("")
        			&&ScannerSensorFrame.getLowerX().equals("")&&ScannerSensorFrame.getUpperX().equals("")
        			&&ScannerSensorFrame.getUpperY().equals("")) {
				CapabilityList.removeChild(Capability1);
			}else {
				Element dataRecord = (Element) Capability1.getElementsByTagName("swe:DataRecord").item(0);
				NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("波段类别")) {
						if (ScannerSensorFrame.getBandsCategory().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getBandsCategory());
						}
					}
					else if (name.equals("波段范围")) {
						if (ScannerSensorFrame.checkBandsRange()) {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getBandsCategory());
						}else {
							dataRecord.removeChild(field);
						}
					}
					else if (name.equals("波段数")) {
						if (ScannerSensorFrame.checkBandsNumber()) {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getBandsNumber());
						}else {
							dataRecord.removeChild(field);
						}
					}
					else if (name.equals("成像宽度范围")) {
						if (ScannerSensorFrame.checkSwath()) {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getSwath());
						}else {
							dataRecord.removeChild(field);
						}
					}
					else if (name.equals("视场角")) {
						if (ScannerSensorFrame.checkFOV()) {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getFOV());
						}else {
							dataRecord.removeChild(field);
						}
					}
					else if (name.equals("地面分辨率范围")) {
						if (ScannerSensorFrame.checkGroungResolution()) {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getGroundResolutionRange());
						}else {
							dataRecord.removeChild(field);
						}
					}
					else if (name.equals("侧摆角")) {
						if (ScannerSensorFrame.checkSideSwingAngle()) {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getSideSwingAngle());
						}else {
							dataRecord.removeChild(field);
						}
					}
					else if (name.equals("observedBBox")) {
						Element v1 = (Element) field.getElementsByTagName("swe:value").item(1);
						Element v2 = (Element) field.getElementsByTagName("swe:value").item(2);
						Element v3 = (Element) field.getElementsByTagName("swe:value").item(3);
						value.getFirstChild().setNodeValue(ScannerSensorFrame.getLowerY());
						v1.getFirstChild().setNodeValue(ScannerSensorFrame.getLowerX());
						v2.getFirstChild().setNodeValue(ScannerSensorFrame.getUpperY());
						v3.getFirstChild().setNodeValue(ScannerSensorFrame.getUpperX());
					}
				}
			}
        	
        	if (ScannerSensorFrame.getOpticalBandCharacterCount()==0&&ScannerSensorFrame.getIFOV().equals("")
        			&&ScannerSensorFrame.getQuantizationLevel().equals("")&&ScannerSensorFrame.getNadirResolution().equals("")) {
				CapabilityList.removeChild(Capability2);
			}else {
				Element dataRecord = (Element) Capability2.getElementsByTagName("swe:DataRecord").item(0);
				NodeList fields = dataRecord.getElementsByTagName("swe:field");
				System.out.println(fields.getLength());
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					String[] opValue1 = ScannerSensorFrame.getOpticalBandCharacterInfo(0);
					if (name.equals("瞬时视场角")) {
						if (ScannerSensorFrame.getIFOV().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getIFOV());
						}
					}
					else if (name.equals("量化等级")) {
						if (ScannerSensorFrame.getQuantizationLevel().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getQuantizationLevel());
						}
					}
					else if (name.equals("星下点分辨率")) {
						if (ScannerSensorFrame.getNadirResolution().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getNadirResolution());
						}
					}
					else if (name.equals("RED波段名称(示例)")&&ScannerSensorFrame.getOpticalBandCharacterCount()>0) {
						field.setAttribute("name", opValue1[0]);
					}
					else if (name.equals("波段宽度范围")&&ScannerSensorFrame.getOpticalBandCharacterCount()>0) {
						value.getFirstChild().setNodeValue(opValue1[1]);
					}
					else if (name.equals("光谱分辨率")&&ScannerSensorFrame.getOpticalBandCharacterCount()>0) {
						value.getFirstChild().setNodeValue(opValue1[2]);
					}
					else if (name.equals("辐射分辨率")&&ScannerSensorFrame.getOpticalBandCharacterCount()>0) {
						value.getFirstChild().setNodeValue(opValue1[3]);
					}
					else if (name.equals("波段应用")&&ScannerSensorFrame.getOpticalBandCharacterCount()>0) {
						value.getFirstChild().setNodeValue(opValue1[4]);
					}
					else {
						value.getFirstChild().setNodeValue("");
					}
				}
			}
        	
        	if (ScannerSensorFrame.getRevisitingPeriod().equals("")) {
				CapabilityList.removeChild(Capability3);
			}else {
				Element dataRecord = (Element) Capability3.getElementsByTagName("swe:DataRecord").item(0);
				Element value = (Element) dataRecord.getElementsByTagName("swe:value").item(0);
				value.getFirstChild().setNodeValue(ScannerSensorFrame.getRevisitingPeriod());
			}
        	
        	if (ScannerSensorFrame.getGeolocationAccuracy().equals("")&&ScannerSensorFrame.getAngleAccuracy().equals("")
        			&&ScannerSensorFrame.getDistanceAccuracy().equals("")&&ScannerSensorFrame.getRadiationAccuracy().equals("")) {
				CapabilityList.removeChild(Capability4);
			}else {
				Element dataRecord = (Element) Capability4.getElementsByTagName("swe:DataRecord").item(0);
				NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("地理定位精度")) {
						if (ScannerSensorFrame.getGeolocationAccuracy().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getGeolocationAccuracy());
						}
					}
					else if (name.equals("角度精度")) {
						if (ScannerSensorFrame.getAngleAccuracy().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getAngleAccuracy());
						}
					}
					else if (name.equals("距离精度")) {
						if (ScannerSensorFrame.getDistanceAccuracy().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getDistanceAccuracy());
						}
					}
					else if (name.equals("辐射精度")) {
						if (ScannerSensorFrame.getRadiationAccuracy().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getRadiationAccuracy());
						}
					}
				}
			}
        	
        	if (!ScannerSensorFrame.checkDataAccessLevel()&&ScannerSensorFrame.getDataAccessQuality().equals("")&&
        			ScannerSensorFrame.getDataFormat().equals("")) {
				CapabilityList.removeChild(Capability5);
			}else {
				Element dataRecord = (Element) Capability5.getElementsByTagName("swe:DataRecord").item(0);
				NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("数据获取等级")) {
						if (ScannerSensorFrame.checkDataAccessLevel()) {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getDataAccessLevel());		
						}else {
							dataRecord.removeChild(field);
						}
					}
					else if (name.equals("数据格式")) {
						if (ScannerSensorFrame.getDataFormat().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getDataFormat());
						}
					}
					else if (name.equals("数据质量等级")) {
						if (ScannerSensorFrame.getDataAccessQuality().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(ScannerSensorFrame.getDataAccessQuality());
						}
					}
				}
			}
        	//其他观测能力
        	if (ScannerSensorFrame.getOtherCapabilityCount()>0&&!ScannerSensorFrame.checkOtherCapability()) {
        		Element capability = doc.createElement("sml:capability");
				Element dataRecord = doc.createElement("swe:DataRecord");
				for (int i = 0; i < ScannerSensorFrame.getOtherCapabilityCount(); i++) {
					Element field = doc.createElement("swe:field");
					Element quantity = doc.createElement("swe:Quantity");
					Element value = doc.createElement("swe:value");
					field.setAttribute("name", ScannerSensorFrame.getOtherCapabilityInfo(i, 0));
					value.setTextContent(ScannerSensorFrame.getOtherCapabilityInfo(i, 1));
					quantity.appendChild(value);
					field.appendChild(quantity);
					dataRecord.appendChild(field);
				}
				capability.appendChild(dataRecord);
				CapabilityList.appendChild(capability);
			}
        	
        	NodeList position = doc.getElementsByTagName("sml:position");
        	Element textPosition = (Element) position.item(0);
        	Element pointPosition = (Element) position.item(1);
        	Element vectorPosotion = (Element) position.item(2);
        	int positionChoice = ScannerSensorFrame.getPositionChoice();
        	System.out.println(positionChoice);
        	switch (positionChoice) {
			case 0:
				root.removeChild(textPosition);
				root.removeChild(pointPosition);
				root.removeChild(vectorPosotion);
				break;
			case 1:
				root.removeChild(pointPosition);
				root.removeChild(vectorPosotion);
				Element positionText = (Element) textPosition.getElementsByTagName("swe:value").item(0);
				positionText.getFirstChild().setNodeValue(ScannerSensorFrame.getTextPosition());
				break;
			case 2:
				root.removeChild(textPosition);
				root.removeChild(vectorPosotion);
				String[] pointInfo = ScannerSensorFrame.get2Dposition();
				Element coordinates = (Element) pointPosition.getElementsByTagName("gml:coordinates").item(0);
				pointPosition.setAttribute("srsName", pointInfo[0]);
				coordinates.getFirstChild().setNodeValue(pointInfo[1]+" "+pointInfo[2]);
				break;
			case 3:
				root.removeChild(textPosition);
				root.removeChild(pointPosition);
				String[] location = ScannerSensorFrame.get3DPosition();
				Element vector = (Element) vectorPosotion.getElementsByTagName("swe:Vector").item(0);
				NodeList vectorValue = vector.getElementsByTagName("swe:value");
				vector.setAttribute("referenceFrame", location[0]);
				vectorValue.item(0).getFirstChild().setNodeValue(location[1]);
				vectorValue.item(1).getFirstChild().setNodeValue(location[2]);
				vectorValue.item(2).getFirstChild().setNodeValue(location[3]);
				break;
			default:
				break;
			}
        	
        	//Page Four 联系单位、服务历史、接口信息
        	Element contacts = (Element) doc.getElementsByTagName("sml:contacts").item(0);
        	System.out.println(contacts.getNodeName());
        	Element contactList = (Element) contacts.getElementsByTagName("sml:ContactList").item(0);
        	Element contact = (Element) contactList.getElementsByTagName("sml:contact").item(0);
        	String role = "";
        	if (ScannerSensorFrame.getRole().equals("制造商")) {
				role = "manufacturer";
				}else if (ScannerSensorFrame.getRole().equals("管理者")) {
				role = "management";
				}else if (ScannerSensorFrame.getRole().equals("使用者")) {
				role = "operater";
			}
        	contact.setAttribute("xlink:arcrole", "urn:ogc:def:role:OGC:1.0:"+role);
        	NodeList CharacterString = contact.getElementsByTagName("gco:CharacterString");
        	CharacterString.item(0).getFirstChild().setNodeValue(ScannerSensorFrame.getOrganizationName());
        	CharacterString.item(1).getFirstChild().setNodeValue(ScannerSensorFrame.getIndividualName());
        	Element voice = (Element) contact.getElementsByTagName("gmd:voice").item(0);
			Element deliveryPoint = (Element) contact.getElementsByTagName("gmd:deliveryPoint").item(0);
			Element city = (Element) contact.getElementsByTagName("gmd:city").item(0);
			Element administrativeArea = (Element) contact.getElementsByTagName("gmd:administrativeArea").item(0);
			Element country = (Element) contact.getElementsByTagName("gmd:country").item(0);
			Element email = (Element) contact.getElementsByTagName("gmd:electronicMailAddress").item(0);
			Element code = (Element) contact.getElementsByTagName("gmd:postalCode").item(0);
        	voice.getFirstChild().setNodeValue(ScannerSensorFrame.getTelephone());
			deliveryPoint.getFirstChild().setNodeValue(ScannerSensorFrame.getDeliveryPoint());
			city.getFirstChild().setNodeValue(ScannerSensorFrame.getCity());
			administrativeArea.getFirstChild().setNodeValue(ScannerSensorFrame.getAdministration());
			country.getFirstChild().setNodeValue(ScannerSensorFrame.getCountry());
			email.getFirstChild().setNodeValue(ScannerSensorFrame.getEmail());
			code.getFirstChild().setNodeValue(ScannerSensorFrame.getPostcode());
        	
			
			Element documentation = (Element) doc.getElementsByTagName("sml:documentation").item(0);
        	if (UploadFrame.getIsDone()==true) {
        		Element documentList = (Element) documentation.getElementsByTagName("sml:DocumentList").item(0);
            	Element document = (Element) documentList.getElementsByTagName("sml:document").item(0);
            	String[] photoInfo = UploadFrame.getPhotoInfo();
            	ArrayList<String[]> annexs = UploadFrame.getAnnex();
            	int annexNum = annexs.size();
            	for (int i = 0; i < annexNum; i++) {
					Element document_i = (Element) document.cloneNode(true);
					String[] annex = annexs.get(i);
					Element url_i = (Element) document_i.getElementsByTagName("gmd:URL").item(0);
					Element nameString_i = (Element) document_i.getElementsByTagName("gco:CharacterString").item(0);
					Element descriptionString_i = (Element) document_i.getElementsByTagName("gco:CharacterString").item(1);
					url_i.getFirstChild().setNodeValue(annex[0]);
					nameString_i.getFirstChild().setNodeValue(annex[1]);
					descriptionString_i.getFirstChild().setNodeValue(annex[2]);		
					documentList.appendChild(document_i);
				}
            	if (UploadFrame.checkPhotoInfo()==true) {
            		Element url = (Element) document.getElementsByTagName("gmd:URL").item(0);
					Element nameString = (Element) document.getElementsByTagName("gco:CharacterString").item(0);
					Element descriptionString = (Element) document.getElementsByTagName("gco:CharacterString").item(1);
					url.getFirstChild().setNodeValue(photoInfo[0]);
					nameString.getFirstChild().setNodeValue(photoInfo[1]);
					descriptionString.getFirstChild().setNodeValue(photoInfo[2]);				
				}          	
			}else {
				root.removeChild(documentation);
			}
        	
			
			Element history = (Element) doc.getElementsByTagName("sml:history").item(0);
			System.out.println(history.getNodeName());
        	Element eventList = (Element) history.getElementsByTagName("sml:EventList").item(0);
        	Element event = (Element) eventList.getElementsByTagName("sml:event").item(0);
			//判断历史事件表格事件（行）数目
        	if (ScannerSensorFrame.getEventNum()==0) {
				root.removeChild(history);
			}else if (ScannerSensorFrame.getEventNum()>1) {
				Element eLabel = (Element) event.getElementsByTagName("swe:label").item(0);
				Element eDescription = (Element) event.getElementsByTagName("swe:description").item(0);
				Element time = (Element) event.getElementsByTagName("sml:time").item(0);
	        	Element eTMPeriod = (Element) time.getElementsByTagName("gml:TimePeriod").item(0);
				eLabel.getFirstChild().setNodeValue(ScannerSensorFrame.getEventLabel());
				eDescription.getFirstChild().setNodeValue(ScannerSensorFrame.getEventDescription());
				int eTMChoice = ScannerSensorFrame.getEventTMChoice();
				System.out.println(eTMChoice);
				if (eTMChoice==1) {
					eTMPeriod.setAttribute("gml:id", ScannerSensorFrame.getEventID());
					Element eventBeginTM = (Element) eTMPeriod.getElementsByTagName("gml:beginPosition").item(0);
					Element eventEndTM = (Element) eTMPeriod.getElementsByTagName("gml:endPosition").item(0);
					eventBeginTM.getFirstChild().setNodeValue(ScannerSensorFrame.getEventBeginTM());
					eventEndTM.getFirstChild().setNodeValue(ScannerSensorFrame.getEventEndTM());
				}else if (eTMChoice==2) {
					time.removeChild(eTMPeriod);
					Element timeInstant = doc.createElement("gml:TimeInstant");
					Element timePosition = doc.createElement("gml:timePosition");
					timeInstant.setAttribute("gml:id", ScannerSensorFrame.getEventID());
					timePosition.setTextContent(ScannerSensorFrame.getEventInstance());
					timeInstant.appendChild(timePosition);
					time.appendChild(timeInstant);
				}else if(eTMChoice==0){
					event.removeChild(time);
				}
				for (int i = 1; i < ScannerSensorFrame.getEventNum(); i++) {
					Element e = doc.createElement("sml:Event");
					Element eLb = doc.createElement("swe:label");
					eLb.getFirstChild().setNodeValue(ScannerSensorFrame.getEventInfo(i, 1));
					e.appendChild(eLb);
					event.appendChild(e);
				}
			}
			
			
			Element interfaces = (Element) doc.getElementsByTagName("sml:interfaces").item(0);
			System.out.println(interfaces.getNodeName());
        	Element interfaceList = (Element) interfaces.getElementsByTagName("sml:InterfaceList").item(0);
        	Element intface = (Element) interfaceList.getElementsByTagName("sml:interface").item(0);
			if (ScannerSensorFrame.getInterfaceNum()==0) {
				root.removeChild(interfaces);
			}else if (ScannerSensorFrame.getInterfaceNum()==1) {
				NodeList interfaceValue = intface.getElementsByTagName("swe:value");
				intface.setAttribute("name", ScannerSensorFrame.getInterfaceInfo(0, 0));
				interfaceValue.item(0).getFirstChild().setNodeValue(ScannerSensorFrame.getInterfaceInfo(0, 1));
				interfaceValue.item(1).getFirstChild().setNodeValue(ScannerSensorFrame.getInterfaceInfo(0, 2));
				interfaceValue.item(2).getFirstChild().setNodeValue(ScannerSensorFrame.getInterfaceInfo(0, 3));
			}else if (ScannerSensorFrame.getInterfaceNum()>1) {
				NodeList interfaceValue = intface.getElementsByTagName("swe:value");
				intface.setAttribute("name", ScannerSensorFrame.getInterfaceInfo(0, 0));
				interfaceValue.item(0).getFirstChild().setNodeValue(ScannerSensorFrame.getInterfaceInfo(0, 1));
				interfaceValue.item(1).getFirstChild().setNodeValue(ScannerSensorFrame.getInterfaceInfo(0, 2));
				interfaceValue.item(2).getFirstChild().setNodeValue(ScannerSensorFrame.getInterfaceInfo(0, 3));
				for (int i = 1; i < ScannerSensorFrame.getInterfaceNum(); i++) {
					Element inter = (Element) intface.cloneNode(true);
					NodeList interValue = inter.getElementsByTagName("swe:value");
					intface.setAttribute("name", ScannerSensorFrame.getInterfaceInfo(i, 0));
					interValue.item(0).getFirstChild().setNodeValue(ScannerSensorFrame.getInterfaceInfo(i, 1));
					interValue.item(1).getFirstChild().setNodeValue(ScannerSensorFrame.getInterfaceInfo(i, 2));
					interValue.item(2).getFirstChild().setNodeValue(ScannerSensorFrame.getInterfaceInfo(i, 3));
					interfaceList.appendChild(inter);
				}
			}
        	
			//Page Five 输入、输出、FOI信息
			Element inputs = (Element) doc.getElementsByTagName("sml:inputs").item(0);
			System.out.println(inputs.getNodeName());
        	Element inputList = (Element) inputs.getElementsByTagName("sml:InputList").item(0);
        	Element input = (Element) inputList.getElementsByTagName("sml:input").item(0);
        	Element property = (Element) input.getElementsByTagName("swe:ObservableProperty").item(0);
			if (ScannerSensorFrame.getInputNum()==0) {
				root.removeChild(inputs);
			}else if (ScannerSensorFrame.getInputNum()>0) {
				input.setAttribute("name", ScannerSensorFrame.getInputInfo(0, 0));
				property.setAttribute("definition", ScannerSensorFrame.getInputInfo(0, 1));
				for (int i = 1; i < ScannerSensorFrame.getInputNum(); i++) {
					Element in = (Element) input.cloneNode(true);
					Element inProperty = (Element) in.getElementsByTagName("swe:ObservableProperty").item(0);
					in.setAttribute("name", ScannerSensorFrame.getInputInfo(i, 0));
					inProperty.setAttribute("definition", ScannerSensorFrame.getInputInfo(i, 1));
					inputList.appendChild(in);
				}
			}
			
			Element outputs = (Element) doc.getElementsByTagName("sml:outputs").item(0);
			System.out.println(outputs.getNodeName());
        	Element outputList = (Element) doc.getElementsByTagName("sml:OutputList").item(0);
        	Element output = (Element) outputList.getElementsByTagName("sml:output").item(0);
        	Element outdef = (Element) output.getElementsByTagName("swe:Quantity").item(0);
        	Element outUom = (Element) output.getElementsByTagName("swe:uom").item(0);
			if (ScannerSensorFrame.getOutputNum()==0) {
				root.removeChild(outputs);
			}else if (ScannerSensorFrame.getOutputNum()>0) {
				output.setAttribute("name", ScannerSensorFrame.getOutputInfo(0, 0));
				outdef.setAttribute("definition", ScannerSensorFrame.getOutputInfo(0, 1));
				outUom.setAttribute("code", ScannerSensorFrame.getOutputInfo(0, 2));
				for (int i = 1; i < ScannerSensorFrame.getOutputNum(); i++) {
					Element out = (Element) output.cloneNode(true);
					Element def = (Element) out.getElementsByTagName("swe:Quantity").item(0);
					Element uom = (Element) out.getElementsByTagName("swe:uom").item(0);
					out.setAttribute("name", ScannerSensorFrame.getOutputInfo(i, 0));
					def.setAttribute("definition", ScannerSensorFrame.getOutputInfo(i, 1));
					uom.setAttribute("code", ScannerSensorFrame.getOutputInfo(i, 2));
					outputList.appendChild(out);
				}
			}
        	   
			Element FOI = (Element) doc.getElementsByTagName("sml:featuresOfInterest").item(0);
			Element FOIList = (Element) FOI.getElementsByTagName("sml:FeatureList").item(0);
			Element FOILink = (Element) FOIList.getElementsByTagName("sml:feature").item(0);
			int FOInum = ScannerSensorFrame.getFOINum();
        	if (ScannerSensorFrame.checkFOI()==true&&FOInum>0) {
				if (FOInum>1) {
					for (int i = 1; i < FOInum; i++) {
						Element foi = (Element) FOILink.cloneNode(true);
						foi.setAttribute("name", ScannerSensorFrame.getFOIInfo(i, 0));
						foi.setAttribute("xlink:href", ScannerSensorFrame.getFOIInfo(i, 1));
						FOIList.appendChild(foi);
					}
				}
				FOILink.setAttribute("name", ScannerSensorFrame.getFOIInfo(0, 0));
				FOILink.setAttribute("xlink:href", ScannerSensorFrame.getFOIInfo(0, 1));
			}else {
				root.removeChild(FOI);
			}
        	
        	TransformerFactory tff = TransformerFactory.newInstance();
    		Transformer tf = tff.newTransformer();
    		DOMSource xmlSource = new DOMSource(doc);
    		StreamResult outputFile = new StreamResult(new File(savePath));
    		tf.transform(xmlSource, outputFile);
        }catch (Exception e) {
			// TODO: handle exception
		}	
	} 
	
	public static void SaveXML() {
		JFileChooser jfc = new JFileChooser("C:/");
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.setFileFilter(new FileNameExtensionFilter("xml格式模型文件（*.xml）","xml"));
		jfc.showSaveDialog(null);
		File f = jfc.getSelectedFile();
		String fname = f.getAbsolutePath();
		DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db= dbf.newDocumentBuilder();
			Document xmlDoc = db.parse(savePath);
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf= tff.newTransformer();	
			DOMSource source = new DOMSource(xmlDoc);
			StreamResult out = new StreamResult(new File(fname+".xml"));
			tf.transform(source, out);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
