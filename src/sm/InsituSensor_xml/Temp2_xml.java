package sm.InsituSensor_xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import sm.main.UploadFrame;


public class Temp2_xml {
//	private static String savePath = "src/instance/insituSensor.xml";
//	private static String xmlPath = "src/Resource/InsituSensor.xml";
	private static String savePath = "C:/Users/Chels/Desktop/instance/insituSensor.xml";
	
	public InputStream parsedoc() {
		InputStream file= this.getClass().getResourceAsStream("/InsituSensor.xml");
		return file;
	}
	
	public static void DOMcreate(){
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Temp2_xml temp2_xml = new Temp2_xml();
        	InputStream file = temp2_xml.parsedoc();
			Document doc = db.parse(file);
        	
        	//根节点<sml:physicalSystem>
        	Element root = (Element)doc.getFirstChild();
        	
        	//Page One 站点标识信息
        	Element description = (Element) doc.getElementsByTagName("gml:description").item(0);
        	description.getFirstChild().setNodeValue(InsituSensorFrame.getDescription());
        	System.out.println(description.getNodeName());	
        	
        	NodeList kwordList = doc.getElementsByTagName("sml:KeywordList");
        	NodeList keyword = doc.getElementsByTagName("sml:keyword");
        	Element keywordList = (Element) kwordList.item(0);
        	String[] keywords = InsituSensorFrame.getKeywords();
        	int keywordCount = keywords.length;
        	System.out.println("共有关键词个数："+keywordCount);
        	if (keywordCount<4||keywordCount==4) {
				for(int i=0;i<keywordCount;i++) {
					keyword.item(i).getFirstChild().setNodeValue(keywords[i]);
				}
				for(int i=keywordCount;i<4;i++) {
					keyword.item(i).getFirstChild().setNodeValue("");
				}
			}
        	else if (keywordCount>4) {
        		for(int i=0;i<4;i++) {
					keyword.item(i).getFirstChild().setNodeValue(keywords[i]);
				}
        		for (int j = 4; j < keywordCount; j++) {
					Element k = doc.createElement("sml:keyword");
					keywordList.appendChild(k);
					k.setTextContent(keywords[j]);
				}
			}
        	
        	Element identifierList = (Element) doc.getElementsByTagName("sml:IdentifierList").item(0);
        	System.out.println(identifierList.getNodeName());
        	NodeList identifiers = doc.getElementsByTagName("sml:identifier");
        	int parentSensorPlatformCount = InsituSensorFrame.getParentPlatformCount();
        	System.out.println("共有所属平台个数："+parentSensorPlatformCount);
        	for (int i = 0; i < identifiers.getLength(); i++) {
        		Element identifier = (Element) identifiers.item(i);
				Element term = (Element) identifier.getElementsByTagName("sml:Term").item(0);
				Element label = (Element) term.getElementsByTagName("sml:label").item(0);
				Element value = (Element) term.getElementsByTagName("sml:value").item(0);
				String lb = label.getFirstChild().getNodeValue();
				if (lb.equals("唯一标识码")) {
					value.getFirstChild().setNodeValue(InsituSensorFrame.getUID());
				}else if (lb.equals("传感器全称")) {
					value.getFirstChild().setNodeValue(InsituSensorFrame.getLongname());
				}else if (lb.equals("传感器简称")) {
					value.getFirstChild().setNodeValue(InsituSensorFrame.getShortname());
				}else if (lb.equals("所属平台名称")) {
					if (parentSensorPlatformCount>0) {
						value.getFirstChild().setNodeValue(InsituSensorFrame.getParentPlatformInfo(0, 0));
					}else {
						identifierList.removeChild(identifier);
					}
				}else if (lb.equals("所属平台标识符")) {
					if (parentSensorPlatformCount>0) {
						value.getFirstChild().setNodeValue(InsituSensorFrame.getParentPlatformInfo(0, 1));
					}else {
						identifierList.removeChild(identifier);
					}
				}
			}
        	if (parentSensorPlatformCount>1) {
				for (int i = 1; i < parentSensorPlatformCount; i++) {
					Element identifier1 = doc.createElement("sml:identifier");
					Element term = doc.createElement("sml:Term");
					Element label = doc.createElement("sml:label");
					Element value = doc.createElement("sml:value");
					String name = InsituSensorFrame.getParentPlatformInfo(i, 0);
					String id = InsituSensorFrame.getParentPlatformInfo(i, 1);
					term.setAttribute("definition", "urn:ogc:def:identifier:OGC:1.0:parentSensorPlatformName");
					label.setTextContent("所属平台名称");
					value.setTextContent(name);
					term.appendChild(label);
					term.appendChild(value);
					identifier1.appendChild(term);
					identifierList.appendChild(identifier1);
					
					Element identifier2 = doc.createElement("sml:identifier");
					Element term2 = doc.createElement("sml:Term");
					Element label2 = doc.createElement("sml:label");
					Element value2 = doc.createElement("sml:value");
					term2.setAttribute("definition", "urn:ogc:def:identifier:OGC:1.0:parentSensorPlatformUniqueID");
					label2.setTextContent("所属平台标识符");
					value2.setTextContent(id);
					term2.appendChild(label2);
					term2.appendChild(value2);
					identifier2.appendChild(term2);
					identifierList.appendChild(identifier2);			
				}
			}
        	if (InsituSensorFrame.checkOtherIdentifier()&&InsituSensorFrame.getOtherIdentifierCount()>0) {
				for (int i = 0; i < InsituSensorFrame.getOtherIdentifierCount(); i++) {
					Element identifier = doc.createElement("sml:identifier");
					Element term = doc.createElement("sml:Term");
					Element label = doc.createElement("sml:label");
					Element value = doc.createElement("sml:value");
					term.setAttribute("definition", "urn:ogc:def:identifier:OGC:1.0:otherIdentifier");
					label.setTextContent(InsituSensorFrame.getOtherIdentifierInfo(i, 0));
					value.setTextContent(InsituSensorFrame.getOtherIdentifierInfo(i, 1));
					term.appendChild(label);
					term.appendChild(value);
					identifier.appendChild(term);
					identifierList.appendChild(identifier);
				}
			}
        	
        	Element classifierList = (Element) doc.getElementsByTagName("sml:ClassifierList").item(0);
        	NodeList classifiers = doc.getElementsByTagName("sml:classifier");
        	String[] application = InsituSensorFrame.getApplication();
        	for (int i = 0; i < classifiers.getLength(); i++) {
        		Element classifier = (Element) classifiers.item(i);
    			Element term = (Element) classifier.getElementsByTagName("sml:Term").item(0);
    			Element label = (Element) term.getElementsByTagName("sml:label").item(0);
    			Element value = (Element) term.getElementsByTagName("sml:value").item(0);
    			String labelContent = label.getFirstChild().getNodeValue();
    			if (i==0&&labelContent.equals("传感器类型")) {
					value.getFirstChild().setNodeValue(InsituSensorFrame.getSensorType1());
				}else if (i==1&&labelContent.equals("传感器类型")) {
					value.getFirstChild().setNodeValue(InsituSensorFrame.getSensorType2());
				}else if (labelContent.equals("共享等级")) {
					value.getFirstChild().setNodeValue(InsituSensorFrame.getShareLevel());
				}else if (labelContent.equals("预期应用")&&application.length>0) {
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
        	
        	if (InsituSensorFrame.getOtherClassifierCount()>0&&InsituSensorFrame.checkOtherClassifier()) {
				for (int i = 0; i < InsituSensorFrame.getOtherClassifierCount(); i++) {
					Element classifier = doc.createElement("sml:classifier");
					Element term = doc.createElement("sml:Term");
					Element label = doc.createElement("sml:label");
					Element value = doc.createElement("sml:value");
					term.setAttribute("definition", "urn:ogc:def:classifier:OGC:1.0:otherClassifier");
					label.setTextContent(InsituSensorFrame.getOtherClassifierInfo(i, 0));
					value.setTextContent(InsituSensorFrame.getOtherClassifierInfo(i, 1));
					term.appendChild(label);
					term.appendChild(value);
					classifier.appendChild(term);
					classifierList.appendChild(classifier);
				}
			}
        			
        	//Page Two  约束条件（有效时间；法律约束；安全约束）
        	Element validTM = (Element) doc.getElementsByTagName("sml:validTime").item(0);
        	Element TMPeriod = (Element) validTM.getElementsByTagName("gml:TimePeriod").item(0);
        	Element beginTM = (Element) TMPeriod.getElementsByTagName("gml:beginPosition").item(0);
        	Element endTM = (Element) TMPeriod.getElementsByTagName("gml:endPosition").item(0);
        	if (InsituSensorFrame.getBeginTMStates().equals("不定时间点")) {
        		TMPeriod.removeChild(beginTM);
				Element unknown = doc.createElement("gml:beginPosition");
        		unknown.setAttribute("indeterminatePosition", "unknown");
        		TMPeriod.appendChild(unknown);
			}else if (InsituSensorFrame.getBeginTMStates().equals("确定时间点")&&(!InsituSensorFrame.getBeginTM().equals(""))) {
				beginTM.getFirstChild().setNodeValue(InsituSensorFrame.getBeginTM());
			}		
        	if (InsituSensorFrame.getEndTMStates().equals("不定时间点")) {
        		TMPeriod.removeChild(endTM);
				Element unknown = doc.createElement("gml:endPosition");
        		unknown.setAttribute("indeterminatePosition", "unknown");
        		TMPeriod.appendChild(unknown);
			}else if (InsituSensorFrame.getEndTMStates().equals("确定时间点")&&(!InsituSensorFrame.getEndTM().equals(""))) {
				endTM.getFirstChild().setNodeValue(InsituSensorFrame.getEndTM());
			}
        			
        	Element legalConstraint = (Element) doc.getElementsByTagName("sml:legalConstraints").item(0);
        	Element legalLimitation = (Element) doc.getElementsByTagName("gco:CharacterString").item(0);
        	if (InsituSensorFrame.checkLegalConstraint()&&(!InsituSensorFrame.getLegalConstraint().equals(""))) {
				legalLimitation.getFirstChild().setNodeValue(InsituSensorFrame.getLegalConstraint());
			}else if (!InsituSensorFrame.checkLegalConstraint()||InsituSensorFrame.getLegalConstraint().equals("")) {
				root.removeChild(legalConstraint);
			}
        	
        	Element securityConstraint = (Element) doc.getElementsByTagName("sml:securityConstraints").item(0);
        	Element securityNoticeText = (Element) doc.getElementsByTagName("ism:NoticeText").item(0);
        	if (InsituSensorFrame.checkSecurityConstraint()&&(!InsituSensorFrame.getSecurityConstraint().equals(""))) {
				securityNoticeText.getFirstChild().setNodeValue(InsituSensorFrame.getSecurityConstraint());
			}else if (!InsituSensorFrame.checkSecurityConstraint()||InsituSensorFrame.getSecurityConstraint().equals("")) {
				root.removeChild(securityConstraint);
			}
        	
        	//Page Three 站点特征、观测能力、位置信息
        	Element characteristicList = (Element) doc.getElementsByTagName("sml:CharacteristicList").item(0);
        	NodeList characteristic = characteristicList.getElementsByTagName("sml:characteristic");
        	Element chara1 = (Element) characteristic.item(0);
        	Element chara2 = (Element) characteristic.item(1);
        	Element chara3 = (Element) characteristic.item(2);
        	if (InsituSensorFrame.getSensorLength().equals("")&&InsituSensorFrame.getSensorWidth().equals("")
        			&&InsituSensorFrame.getSensorHeight().equals("")&&InsituSensorFrame.getSensorWeigh().equals("")) {
				characteristicList.removeChild(chara1);
			}else {
				Element field1 = (Element) chara1.getElementsByTagName("swe:field").item(0);
	        	Element dataRecord1 = (Element) field1.getElementsByTagName("swe:DataRecord").item(0);
	        	NodeList fields1 = field1.getElementsByTagName("swe:field");
	        	for (int i = 0; i < fields1.getLength(); i++) {
	        		Element field = (Element) fields1.item(i);
	        		Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					String name = field.getAttribute("name");
	        		if (name.equals("长度")) {
						if (InsituSensorFrame.getSensorLength().equals("")) {
							dataRecord1.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getSensorLength());
						}
					}
	        		else if (name.equals("宽度")) {
						if (InsituSensorFrame.getSensorWidth().equals("")) {
							dataRecord1.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getSensorWidth());
						}
					}
	        		else if (name.equals("高度")) {
						if (InsituSensorFrame.getSensorHeight().equals("")) {
							dataRecord1.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getSensorHeight());
						}
					}
	        		else if (name.equals("质量")) {
						if (InsituSensorFrame.getSensorWeigh().equals("")) {
							dataRecord1.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getSensorWeigh());
						}
					}
	        		System.out.println("传感器物理特征："+name+">>>"+value.getFirstChild().getNodeValue()+"\n");
				}	
			}
        	
        	if ((!InsituSensorFrame.checkCurrentType())&&InsituSensorFrame.getMinCurrent().equals("")&&InsituSensorFrame.getMaxCurrent().equals("")
        			&&InsituSensorFrame.getMinVoltage().equals("")&&InsituSensorFrame.getMaxVoltage().equals("")
        			&&InsituSensorFrame.getPower().equals("")&&InsituSensorFrame.getOutputPower().equals("")) {
				characteristicList.removeChild(chara2);
			}else {
				Element dataRecord2 = (Element) chara2.getElementsByTagName("swe:DataRecord").item(0);
	        	NodeList fields2 = chara2.getElementsByTagName("swe:field");
	        	for (int i = 0; i < fields2.getLength(); i++) {
	        		Element field = (Element) fields2.item(i);
	        		Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					String name = field.getAttribute("name");
					if (name.equals("电源类型")) {
						if (InsituSensorFrame.checkCurrentType()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getCurrentType());
						}else {
							dataRecord2.removeChild(field);
						}
					}else if (name.equals("电流")) {
						if (InsituSensorFrame.checkCurrent()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getMinCurrent()+" "+InsituSensorFrame.getMaxCurrent());
						}else {
							dataRecord2.removeChild(field);
						}
					}else if (name.equals("电压")) {
						if (InsituSensorFrame.checkVoltage()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getMinVoltage()+" "+InsituSensorFrame.getMaxVoltage());
						}else {
							dataRecord2.removeChild(field);
						}
					}else if (name.equals("功率")) {
						if (InsituSensorFrame.checkPower()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getPower());
						}else {
							dataRecord2.removeChild(field);
						}
					}else if (name.equals("输出功率")) {
						if (InsituSensorFrame.checkOutputPower()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getOutputPower());
						}else {
							dataRecord2.removeChild(field);
						}
					}
					System.out.println("传感器供电通信特征："+name+">>>"+value.getFirstChild().getNodeValue()+"\n");
				}	
			}
        	
        	if (!InsituSensorFrame.checkLife()&&!InsituSensorFrame.checkHumidity()&&!InsituSensorFrame.checkTemperature()
        			&&!InsituSensorFrame.checkProtectGrade()&&!InsituSensorFrame.checkMTBF()&&!InsituSensorFrame.checkIsOperable()) {
        		characteristicList.removeChild(chara3);
			}else {
				Element dataRecord3 = (Element) chara3.getElementsByTagName("swe:DataRecord").item(0);
	        	NodeList fields3 = dataRecord3.getElementsByTagName("swe:field");
	        	for (int i = 0; i < fields3.getLength(); i++) {
	        		Element field = (Element) fields3.item(i);
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					String name = field.getAttribute("name");
					if (name.equals("设计寿命")) {
						if (InsituSensorFrame.checkLife()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getLife());
						}else {
							dataRecord3.removeChild(field);
						}
					}else if (name.equals("工作湿度范围")) {
						if (InsituSensorFrame.checkHumidity()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getMinHumidity()+" "+InsituSensorFrame.getMaxHumidity());
						}else {
							dataRecord3.removeChild(field);
						}
					}else if (name.equals("工作温度范围")) {
						if (InsituSensorFrame.checkTemperature()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getMinTemperature()+" "+InsituSensorFrame.getMaxTemperature());
						}else {
							dataRecord3.removeChild(field);
						}
					}else if (name.equals("防护等级")) {
						if (InsituSensorFrame.checkProtectGrade()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getProtectionGrade());
						}else {
							dataRecord3.removeChild(field);
						}
					}else if (name.equals("无故障时间")) {
						if (InsituSensorFrame.checkMTBF()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getMTBF());
						}else {
							dataRecord3.removeChild(field);
						}
					}else if (name.equals("是否可控")) {
						if (InsituSensorFrame.checkIsOperable()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getIsOperable());
						}else {
							dataRecord3.removeChild(field);
						}
					}
					System.out.println("传感器工作环境特征："+name+">>>"+value.getFirstChild().getNodeValue()+"\n");
				}
			}
        	
        	if (InsituSensorFrame.getOtherCharacterCount()>0||InsituSensorFrame.checkOtherCharacter()) {
        		Element chara = doc.createElement("sml:characteristic");
				Element dataRecord = doc.createElement("swe:DataRecord");
				for (int i = 0; i < InsituSensorFrame.getOtherCharacterCount(); i++) {
					Element field = doc.createElement("sml:field");
					Element quantity = doc.createElement("sml:Quantity");
					Element value = doc.createElement("sml:value");
					field.setAttribute("name", InsituSensorFrame.getOtherCharacterInfo(i, 0));
					quantity.setAttribute("definition", "urn:ogc:def:property:OGC:1.0:otherCharacteristic");
					value.setTextContent(InsituSensorFrame.getOtherCharacterInfo(i, 1));
					quantity.appendChild(value);
					field.appendChild(quantity);
					dataRecord.appendChild(field);	
				}
				chara.appendChild(dataRecord);
				characteristicList.appendChild(chara);
			}

        	Element CapabilityList = (Element) doc.getElementsByTagName("sml:CapabilityList").item(0);
        	NodeList Capability = CapabilityList.getElementsByTagName("sml:capability");
        	Element Capability1 = (Element) Capability.item(0);
        	Element Capability2 = (Element) Capability.item(1);
        	Element Capability3 = (Element) Capability.item(2);
        	Element Capability4 = (Element) Capability.item(3);
        	Element Capability5 = (Element) Capability.item(4);
        	if (InsituSensorFrame.getDetectType().equals("")&&!InsituSensorFrame.checkDetectPrinciple()&&!InsituSensorFrame.checkOverload()
        			&&!InsituSensorFrame.checkMeasurementRange()&&!InsituSensorFrame.checkFrequency()) {
				CapabilityList.removeChild(Capability1);
			}else {
				Element dataRecord = (Element) Capability1.getElementsByTagName("swe:DataRecord").item(0);
				NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("原位探测类型")) {
						if (InsituSensorFrame.getDetectType().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getDetectType());
						}
					}else if (name.equals("探测原理")) {
						if (InsituSensorFrame.checkDetectPrinciple()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getDetectPrinciple());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("极限过载")) {
						if (InsituSensorFrame.checkOverload()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getMinOverload()+" "+InsituSensorFrame.getMaxOverload());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("量程范围")) {
						if (InsituSensorFrame.checkMeasurementRange()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getMinMeasurementRange()+" "+InsituSensorFrame.getMaxMeasurementRange());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("波段频率范围")) {
						if (InsituSensorFrame.checkFrequency()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getMinFrequency()+" "+InsituSensorFrame.getMaxFrequency());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("observedBBox")) {
						if (InsituSensorFrame.getLowerY().equals("")&&InsituSensorFrame.getLowerX().equals("")
								&&InsituSensorFrame.getUpperY().equals("")&&InsituSensorFrame.getUpperX().equals("")) {
							dataRecord.removeChild(field);
						}else {
							Element v1 = (Element) field.getElementsByTagName("swe:value").item(1);
							Element v2 = (Element) field.getElementsByTagName("swe:value").item(2);
							Element v3 = (Element) field.getElementsByTagName("swe:value").item(3);
							value.getFirstChild().setNodeValue(InsituSensorFrame.getLowerY());
							v1.getFirstChild().setNodeValue(InsituSensorFrame.getLowerX());
							v2.getFirstChild().setNodeValue(InsituSensorFrame.getUpperY());
							v3.getFirstChild().setNodeValue(InsituSensorFrame.getUpperX());
						}
					}
					System.out.println("观测能力广度:"+name+">>"+value.getFirstChild().getNodeValue()+"\n");
				}
			}
        	
        	if (!InsituSensorFrame.checkObserveResolution()&&!InsituSensorFrame.checkRadius()&&!InsituSensorFrame.checkSensitivity()) {
				CapabilityList.removeChild(Capability2);
			}else {
				Element dataRecord = (Element) Capability2.getElementsByTagName("swe:DataRecord").item(0);
				NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("观测分辨率")) {
						if (InsituSensorFrame.checkObserveResolution()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getObserveResolution());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("观测半径")) {
						if (InsituSensorFrame.checkRadius()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getRadius());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("灵敏度")) {
						if (InsituSensorFrame.checkSensitivity()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getSensitivity());
						}else {
							dataRecord.removeChild(field);
						}
					}
					System.out.println("观测能力深度:"+name+">>"+value.getFirstChild().getNodeValue()+"\n");
				}
			}
        	
        	if (!InsituSensorFrame.checkInterval()&&!InsituSensorFrame.checkDuration()&&!InsituSensorFrame.checkRespondTM()) {
				CapabilityList.removeChild(Capability3);
			}else {
				Element dataRecord = (Element) Capability3.getElementsByTagName("swe:DataRecord").item(0);
				NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("采样周期")) {
						if (InsituSensorFrame.checkInterval()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getInterval());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("采样持续时间")) {
						if (InsituSensorFrame.checkDuration()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getDuration());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("响应时间")) {
						if (InsituSensorFrame.checkRespondTM()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getRespondTM());
						}else {
							dataRecord.removeChild(field);
						}
					}
					System.out.println("观测能力频度:"+name+">>"+value.getFirstChild().getNodeValue()+"\n");
				}
				
			}
        	
        	if (!InsituSensorFrame.checkSensitivityTolerance()&&!InsituSensorFrame.checkDetectAccuracy()&&!InsituSensorFrame.checkRepeatability()
        			&&!InsituSensorFrame.checkLag()&&!InsituSensorFrame.checkNonlinearity()) {
				CapabilityList.removeChild(Capability4);
			}else {
				Element dataRecord = (Element) Capability4.getElementsByTagName("swe:DataRecord").item(0);
				NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("灵敏度允差")) {
						if (InsituSensorFrame.checkSensitivityTolerance()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getSensitivityTolerance());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("探测精度")) {
						if (InsituSensorFrame.checkDetectAccuracy()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getDetectAccuracy());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("重复性误差")) {
						if (InsituSensorFrame.checkRepeatability()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getRepeatability());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("滞后允差")) {
						if (InsituSensorFrame.checkLag()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getLag());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("非线性误差")) {
						if (InsituSensorFrame.checkNonlinearity()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getNonlinearity());
						}else {
							dataRecord.removeChild(field);
						}
					}
					System.out.println("观测能力质量:"+name+">>"+value.getFirstChild().getNodeValue()+"\n");
				}
			}
        	
        	if (!InsituSensorFrame.checkDataAccessLevel()&&!InsituSensorFrame.checkDataAccessQuality()&&!InsituSensorFrame.checkDataFormat()) {
				CapabilityList.removeChild(Capability5);
			}else {
				Element dataRecord = (Element) Capability5.getElementsByTagName("swe:DataRecord").item(0);
				NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("数据获取等级")) {
						if (InsituSensorFrame.checkDataAccessLevel()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getDataAccessLevel());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("数据格式")) {
						if (InsituSensorFrame.checkDataFormat()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getDataFormat());
						}else {
							dataRecord.removeChild(field);
						}
					}else if (name.equals("数据质量等级")) {
						if (InsituSensorFrame.checkDataAccessQuality()) {
							value.getFirstChild().setNodeValue(InsituSensorFrame.getDataAccessQuality());
						}else {
							dataRecord.removeChild(field);
						}
					}
					System.out.println("观测能力数据:"+name+">>"+value.getFirstChild().getNodeValue()+"\n");
				}
			}
        	
        	if (InsituSensorFrame.getOtherCapabilityCount()>0||InsituSensorFrame.checkOtherCapability()) {
				Element capability = doc.createElement("sml:capability");
				Element dataRecord = doc.createElement("swe:DataRecord");
				for (int i = 0; i < InsituSensorFrame.getOtherCapabilityCount(); i++) {
					Element field = doc.createElement("sml:field");
					Element quantity = doc.createElement("sml:Quantity");
					Element value = doc.createElement("sml:value");
					field.setAttribute("name", InsituSensorFrame.getOtherCapabilityInfo(i, 0));
					quantity.setAttribute("definition", "urn:ogc:def:property:OGC:1.0:otherCapability");
					value.setTextContent(InsituSensorFrame.getOtherCapabilityInfo(i, 1));
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
        	int positionChoice = InsituSensorFrame.checkPositionChoice();
        	switch (positionChoice) {
			case 0:
				root.removeChild(textPosition);
				root.removeChild(pointPosition);
				root.removeChild(vectorPosotion);break;
			case 1:
				root.removeChild(pointPosition);
				root.removeChild(vectorPosotion);
				Element positionText = (Element) textPosition.getElementsByTagName("swe:value").item(0);
				positionText.getFirstChild().setNodeValue(InsituSensorFrame.getTextPosition());break;
			case 2:
				root.removeChild(textPosition);
				root.removeChild(vectorPosotion);
				Element coordinates = (Element) pointPosition.getElementsByTagName("gml:coordinates").item(0);
				pointPosition.setAttribute("srsName", InsituSensorFrame.getPointSRS());
				coordinates.getFirstChild().setNodeValue(InsituSensorFrame.getPointY()+" "+InsituSensorFrame.getPointX());
				break;
			case 3:
				root.removeChild(textPosition);
				root.removeChild(pointPosition);
				NodeList locationValue = vectorPosotion.getElementsByTagName("swe:value");
				vectorPosotion.setAttribute("referenceFrame", InsituSensorFrame.getLocationSRS());
				locationValue.item(0).getFirstChild().setNodeValue(InsituSensorFrame.getLatitude());
				locationValue.item(1).getFirstChild().setNodeValue(InsituSensorFrame.getLongitude());
				locationValue.item(2).getFirstChild().setNodeValue(InsituSensorFrame.getAltitude());
				break;
			default:
				break;
			}
        	
        	//Page Four 联系单位、服务历史、接口信息
        	Element contacts = (Element) doc.getElementsByTagName("sml:contacts").item(0);
        	Element contactList = (Element) contacts.getElementsByTagName("sml:ContactList").item(0);
        	Element contact = (Element) contactList.getElementsByTagName("sml:contact").item(0);
        	String role = "";
        	if (InsituSensorFrame.getRole().equals("制造商")) {
				role = "manufacturer";
			}else if (InsituSensorFrame.getRole().equals("管理者")) {
				role = "management";
			}else if (InsituSensorFrame.getRole().equals("使用者")) {
				role = "operator";
			}
        	contact.setAttribute("xlink:arcrole", "urn:ogc:def:role:OGC:1.0:"+role);
        	NodeList CharacterString = contact.getElementsByTagName("gco:CharacterString");
        	CharacterString.item(0).getFirstChild().setNodeValue(InsituSensorFrame.getOrganizationName());
        	CharacterString.item(1).getFirstChild().setNodeValue(InsituSensorFrame.getIndividualName());
        	Element voice = (Element) contact.getElementsByTagName("gmd:voice").item(0);
			Element deliveryPoint = (Element) contact.getElementsByTagName("gmd:deliveryPoint").item(0);
			Element city = (Element) contact.getElementsByTagName("gmd:city").item(0);
			Element administrativeArea = (Element) contact.getElementsByTagName("gmd:administrativeArea").item(0);
			Element country = (Element) contact.getElementsByTagName("gmd:country").item(0);
			Element email = (Element) contact.getElementsByTagName("gmd:electronicMailAddress").item(0);
			Element code = (Element) contact.getElementsByTagName("gmd:postalCode").item(0);
        	voice.getFirstChild().setNodeValue(InsituSensorFrame.getTelephone());
			deliveryPoint.getFirstChild().setNodeValue(InsituSensorFrame.getDeliveryPoint());
			city.getFirstChild().setNodeValue(InsituSensorFrame.getCity());
			administrativeArea.getFirstChild().setNodeValue(InsituSensorFrame.getAdministration());
			country.getFirstChild().setNodeValue(InsituSensorFrame.getCountry());
			email.getFirstChild().setNodeValue(InsituSensorFrame.getEmail());
			code.getFirstChild().setNodeValue(InsituSensorFrame.getPostcode());
			
        	
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
        	Element eventList = (Element) doc.getElementsByTagName("sml:EventList").item(0);
        	Element event = (Element) eventList.getElementsByTagName("sml:event").item(0);
        	Element time = (Element) event.getElementsByTagName("sml:time").item(0);
        	if (InsituSensorFrame.getEventNum()==0) {
				root.removeChild(history);
			}
        	if (InsituSensorFrame.checkEventID()||InsituSensorFrame.checkEventDescription()||
					InsituSensorFrame.checkEventInstance()||InsituSensorFrame.checkEventPeriod()) {
				Element eLabel = (Element) event.getElementsByTagName("swe:label").item(0);
				Element eDescription = (Element) event.getElementsByTagName("swe:description").item(0);
				Element timePeriod = (Element) event.getElementsByTagName("gml:TimePeriod").item(0);
				eLabel.getFirstChild().setNodeValue(InsituSensorFrame.getEventLabel());
				eDescription.getFirstChild().setNodeValue(InsituSensorFrame.getEventDescription());
				int eventTMChoice = InsituSensorFrame.getEventTMChoice();
				if (eventTMChoice==1) {
					timePeriod.setAttribute("gml:id", InsituSensorFrame.getEventID());
					Element eventBeginTM = (Element) timePeriod.getElementsByTagName("gml:beginPosition").item(0);
					Element eventEndTM = (Element) timePeriod.getElementsByTagName("gml:endPosition").item(0);
					eventBeginTM.getFirstChild().setNodeValue(InsituSensorFrame.getEventBeginTM());
					eventEndTM.getFirstChild().setNodeValue(InsituSensorFrame.getEventEndTM());
				}else if (eventTMChoice==2) {
					time.removeChild(timePeriod);
					Element timeInstant = doc.createElement("gml:TimeInstant");
					Element timePosition = doc.createElement("gml:timePosition");
					timeInstant.setAttribute("gml:id", InsituSensorFrame.getEventID());
					timePosition.setTextContent(InsituSensorFrame.getEventInstance());
					timeInstant.appendChild(timePosition);
					time.appendChild(timeInstant);
				}else {
					event.removeChild(time);
				}
				if (InsituSensorFrame.getEventNum()>1) {
					for (int i = 1; i < InsituSensorFrame.getEventNum(); i++) {
						Element Event = doc.createElement("sml:Event");
						Element eLb = doc.createElement("swe:label");
						eLb.setTextContent(InsituSensorFrame.getEventInfo(i, 1));
						Event.appendChild(eLb);
						event.appendChild(Event);
					}
				}
			}
        	
        	
        	Element interfaces = (Element) doc.getElementsByTagName("sml:interfaces").item(0);
        	Element interfaceList = (Element) doc.getElementsByTagName("sml:InterfaceList").item(0);
        	Element intface = (Element) interfaceList.getElementsByTagName("sml:interface").item(0);
        	if (InsituSensorFrame.getInterfaceNum()==0) {
				root.removeChild(interfaces);
			}else if (InsituSensorFrame.getInterfaceNum()==1) {
				intface.setAttribute("name",InsituSensorFrame.getInterfaceInfo(0, 0));
				NodeList interfaceValue = intface.getElementsByTagName("swe:value");
				interfaceValue.item(0).getFirstChild().setNodeValue(InsituSensorFrame.getInterfaceInfo(0, 1));
				interfaceValue.item(1).getFirstChild().setNodeValue(InsituSensorFrame.getInterfaceInfo(0, 2));
				interfaceValue.item(2).getFirstChild().setNodeValue(InsituSensorFrame.getInterfaceInfo(0, 3));
			}else if (InsituSensorFrame.getInterfaceNum()>1) {
				intface.setAttribute("name",InsituSensorFrame.getInterfaceInfo(0, 0));
				NodeList interfaceValue = intface.getElementsByTagName("swe:value");
				interfaceValue.item(0).getFirstChild().setNodeValue(InsituSensorFrame.getInterfaceInfo(0, 1));
				interfaceValue.item(1).getFirstChild().setNodeValue(InsituSensorFrame.getInterfaceInfo(0, 2));
				interfaceValue.item(2).getFirstChild().setNodeValue(InsituSensorFrame.getInterfaceInfo(0, 3));
				for (int i = 1; i < InsituSensorFrame.getInterfaceNum(); i++) {
					Element inter = (Element) intface.cloneNode(true);
					NodeList interValue = inter.getElementsByTagName("swe:value");
					inter.setAttribute("name",InsituSensorFrame.getInterfaceInfo(i, 0));
					interValue.item(0).getFirstChild().setNodeValue(InsituSensorFrame.getInterfaceInfo(i, 1));
					interValue.item(1).getFirstChild().setNodeValue(InsituSensorFrame.getInterfaceInfo(i, 2));
					interValue.item(2).getFirstChild().setNodeValue(InsituSensorFrame.getInterfaceInfo(i, 3));
					interfaceList.appendChild(inter);
				}
			}
        	
        	
        	
        	//Page Five 输入、输出、参数、组件、关系信息
        	Element inputs = (Element) doc.getElementsByTagName("sml:inputs").item(0);
        	Element inputList = (Element) doc.getElementsByTagName("sml:InputList").item(0);
        	Element input = (Element) inputList.getElementsByTagName("sml:input").item(0);
        	Element property = (Element) input.getElementsByTagName("swe:ObservableProperty").item(0);
        	if (InsituSensorFrame.getInputNum()==0) {
				root.removeChild(inputs);
			}else if (InsituSensorFrame.getInputNum()==1) {
				input.setAttribute("name", InsituSensorFrame.getInputInfo(0, 0));
				property.setAttribute("definition", InsituSensorFrame.getInputInfo(0, 1));
			}else if (InsituSensorFrame.getInputNum()>1) {
				input.setAttribute("name", InsituSensorFrame.getInputInfo(0, 0));
				property.setAttribute("definition", InsituSensorFrame.getInputInfo(0, 1));
				for (int i = 1; i < InsituSensorFrame.getInputNum(); i++) {
					Element in = doc.createElement("sml:input");
					Element observable = doc.createElement("swe:ObservableProperty");
					in.setAttribute("name", InsituSensorFrame.getInputInfo(i, 0));
					observable.setAttribute("definition", InsituSensorFrame.getInputInfo(i, 1));
					in.appendChild(observable);
					observable.setNodeValue("");
					inputList.appendChild(in);
				}
			}
        	
        	Element outputs = (Element) doc.getElementsByTagName("sml:outputs").item(0);
        	Element outputList = (Element) doc.getElementsByTagName("sml:OutputList").item(0);
        	Element output = (Element) outputList.getElementsByTagName("sml:output").item(0);
        	Element outdef = (Element) output.getElementsByTagName("swe:Quantity").item(0);
        	Element outUom = (Element) output.getElementsByTagName("swe:uom").item(0);
        	if (InsituSensorFrame.getOutputNum()==0) {
				root.removeChild(outputs);
			}else if (InsituSensorFrame.getOutputNum()==1) {
				output.setAttribute("name", InsituSensorFrame.getOutputInfo(0, 0));
				outdef.setAttribute("definition", InsituSensorFrame.getOutputInfo(0, 1));
				outUom.setAttribute("code", InsituSensorFrame.getOutputInfo(0, 2));
			}else if (InsituSensorFrame.getOutputNum()>1) {
				output.setAttribute("name", InsituSensorFrame.getOutputInfo(0, 0));
				outdef.setAttribute("definition", InsituSensorFrame.getOutputInfo(0, 1));
				outUom.setAttribute("code", InsituSensorFrame.getOutputInfo(0, 2));
				for (int i = 1; i < InsituSensorFrame.getOutputNum(); i++) {
					Element out = doc.createElement("sml:output");
					Element quantity = doc.createElement("swe:Quantity");
					Element outputUom = doc.createElement("swe:uom");
					out.setAttribute("name", InsituSensorFrame.getOutputInfo(i, 0));
					quantity.setAttribute("definition", InsituSensorFrame.getOutputInfo(i, 1));
					outUom.setAttribute("code", InsituSensorFrame.getOutputInfo(i, 2));
					quantity.appendChild(outputUom);
					out.appendChild(quantity);
					outputList.appendChild(out);
				}
			}
        	
        	Element parameters = (Element) doc.getElementsByTagName("sml:parameters").item(0);
        	Element parameterRecord = (Element) documentation.getElementsByTagName("swe:DataRecord").item(0);
        	Element parameter = (Element) parameters.getElementsByTagName("sml:parameter").item(0);
        	if (InsituSensorFrame.getParameterNum()==0) {
				root.removeChild(parameters);
			}else if (InsituSensorFrame.getParameterNum()>1) {
				NodeList paraLabel = parameter.getElementsByTagName("swe:label"); //2
				Element paraDescription = (Element) parameter.getElementsByTagName("swe:description").item(0);
				Element paraCount = (Element) parameter.getElementsByTagName("swe:value").item(0);
				Element paraValue = (Element) parameter.getElementsByTagName("swe:values").item(0);
				Element paraUom = (Element) parameter.getElementsByTagName("swe:uom").item(0);
				Element paraField = (Element) parameter.getElementsByTagName("swe:field").item(0);
				String[] paravalues = InsituSensorFrame.getParameterValue().split(" ");
				int paraNum = paravalues.length;
				parameter.setAttribute("name", InsituSensorFrame.getParameterName());
				paraLabel.item(0).getFirstChild().setNodeValue(InsituSensorFrame.getParameterName());
				paraDescription.getFirstChild().setNodeValue(InsituSensorFrame.getParameterDescription());
				paraCount.getFirstChild().setNodeValue(""+paraNum);
				paraValue.getFirstChild().setNodeValue(InsituSensorFrame.getParameterValue());
				if (InsituSensorFrame.getParameterNum()==1) {
					paraLabel.item(1).getFirstChild().setNodeValue(InsituSensorFrame.getParameterItem(0, 0));
					paraUom.setAttribute("code", InsituSensorFrame.getParameterItem(0, 1));
				}else if (InsituSensorFrame.getParameterNum()>1) {
					paraLabel.item(1).getFirstChild().setNodeValue(InsituSensorFrame.getParameterItem(0, 0));
					paraUom.setAttribute("code", InsituSensorFrame.getParameterItem(0, 1));
					for (int i = 1; i < InsituSensorFrame.getParameterNum(); i++) {
						Element f = (Element) paraField.cloneNode(true);
						Element l = (Element) f.getElementsByTagName("swe:label").item(0);
						Element u = (Element) f.getElementsByTagName("swe:uom").item(0);
						l.getFirstChild().setNodeValue(InsituSensorFrame.getParameterItem(i, 0));
						u.setAttribute("code", InsituSensorFrame.getParameterItem(i, 1));
						f.appendChild(l);
						f.appendChild(u);
						parameterRecord.appendChild(f);
					}
				}
			}
        	
        	Element components = (Element) doc.getElementsByTagName("sml:components").item(0);
        	Element componentList = (Element) doc.getElementsByTagName("sml:ComponentList").item(0);
        	Element component = (Element) componentList.getElementsByTagName("sml:component").item(0);
        	if (InsituSensorFrame.getComponentNum()==0) {
				root.removeChild(components);
			}else if (InsituSensorFrame.getComponentNum()==1) {
				component.setAttribute("name", InsituSensorFrame.getComponentInfo(0, 0));
				component.setAttribute("xlink:Title", InsituSensorFrame.getComponentInfo(0, 1));
				component.setAttribute("xlink:href", InsituSensorFrame.getComponentInfo(0, 2));
			}else if (InsituSensorFrame.getComponentNum()>1) {
				component.setAttribute("name", InsituSensorFrame.getComponentInfo(0, 0));
				component.setAttribute("xlink:Title", InsituSensorFrame.getComponentInfo(0, 1));
				component.setAttribute("xlink:href", InsituSensorFrame.getComponentInfo(0, 2));
				for (int i = 1; i < InsituSensorFrame.getComponentNum(); i++) {
					Element compon = (Element) component.cloneNode(true);
					compon.setAttribute("name", InsituSensorFrame.getComponentInfo(i, 0));
					compon.setAttribute("xlink:Title", InsituSensorFrame.getComponentInfo(i, 1));
					compon.setAttribute("xlink:href", InsituSensorFrame.getComponentInfo(i, 2));
					componentList.appendChild(compon);
				}
			}
        	
        	Element connections = (Element) doc.getElementsByTagName("sml:connections").item(0);
        	Element connectionList = (Element) doc.getElementsByTagName("sml:ConnectionList").item(0);
        	Element link = (Element) connectionList.getElementsByTagName("sml:Link").item(0);
        	Element source = (Element) link.getElementsByTagName("sml:source").item(0);
        	Element destination = (Element) link.getElementsByTagName("sml:destination").item(0);
        	if (InsituSensorFrame.getConnectionNum()==0) {
				root.removeChild(connections);
			}else if (InsituSensorFrame.getConnectionNum()==1) {
				source.setAttribute("ref", InsituSensorFrame.getConnectionInfo(0, 0));
				destination.setAttribute("ref", InsituSensorFrame.getConnectionInfo(0, 1));
			}else if (InsituSensorFrame.getConnectionNum()>1) {
				source.setAttribute("ref", InsituSensorFrame.getConnectionInfo(0, 0));
				destination.setAttribute("ref", InsituSensorFrame.getConnectionInfo(0, 1));
				for (int i = 1; i < InsituSensorFrame.getConnectionNum(); i++) {
					Element lk = (Element) link.cloneNode(true);
					Element s = (Element) lk.getElementsByTagName("sml:source").item(0);
		        	Element d = (Element) lk.getElementsByTagName("sml:destination").item(0);
		        	s.setAttribute("ref", InsituSensorFrame.getConnectionInfo(i, 0));
		        	d.setAttribute("ref", InsituSensorFrame.getConnectionInfo(i, 1));
		        	lk.appendChild(s);
		        	lk.appendChild(d);
		        	connectionList.appendChild(lk);
				}
			}
        	
        	//继承、配置信息
        	//感兴趣特征FOI
        	Element FOI = (Element) doc.getElementsByTagName("sml:featuresOfInterest").item(0);
			Element FOIList = (Element) FOI.getElementsByTagName("sml:FeatureList").item(0);
			Element FOILink = (Element) FOIList.getElementsByTagName("sml:feature").item(0);
			int FOInum = InsituSensorFrame.getFOINum();
        	if (InsituSensorFrame.checkFOI()==true&&FOInum>0) {
				if (FOInum>1) {
					for (int i = 1; i < FOInum; i++) {
						Element foi = (Element) FOILink.cloneNode(true);
						foi.setAttribute("name", InsituSensorFrame.getFOIInfo(i, 0));
						foi.setAttribute("xlink:href", InsituSensorFrame.getFOIInfo(i, 1));
						FOIList.appendChild(foi);
					}
				}
				FOILink.setAttribute("name", InsituSensorFrame.getFOIInfo(0, 0));
				FOILink.setAttribute("xlink:href", InsituSensorFrame.getFOIInfo(0, 1));
			}else {
				root.removeChild(FOI);
			}

			
        	//继承基类link to base
        	Element configuration = (Element) doc.getElementsByTagName("sml:configuration").item(0);
        	Element setting = (Element) configuration.getElementsByTagName("sml:Setting").item(0);
        	Element setValue = (Element) setting.getElementsByTagName("sml:setValue").item(0);
        	Element setMode = (Element) setting.getElementsByTagName("sml:setMode").item(0);
        	if (InsituSensorFrame.checkInheritance()||InsituSensorFrame.checkConfiguration()) {
				//模式选择
        		if (InsituSensorFrame.getModeChoice().equals("")&&InsituSensorFrame.getModeType().equals("")) {
					setting.removeChild(setMode);
				}else {
					setMode.setAttribute("ref", "modes/"+InsituSensorFrame.getModeType());
					setMode.getFirstChild().setNodeValue(InsituSensorFrame.getModeChoice());
				}
        		//配置参数
        		if (InsituSensorFrame.getSetValueNum()>0) {
					setValue.setAttribute("ref", "parameters/"+InsituSensorFrame.getSetValueInfo(0, 0));
					setValue.getFirstChild().setNodeValue(InsituSensorFrame.getSetValueInfo(0, 1));
					if (InsituSensorFrame.getSetValueNum()>1) {
						for (int i = 1; i < InsituSensorFrame.getSetValueNum(); i++) {
							Element e = doc.createElement("sml:setValue");
							e.setAttribute("ref", "parameters/"+InsituSensorFrame.getSetValueInfo(i, 0));
							e.setTextContent(InsituSensorFrame.getSetValueInfo(i, 1));
							setting.appendChild(e);
						}
					}
				}else {
					root.removeChild(setValue);
				}		
			}else {
				root.removeChild(configuration);
			}
        	
        	
        	TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			DOMSource xmlSource = new DOMSource(doc);
			StreamResult outputFile = new StreamResult(new File(savePath));
			tf.transform(xmlSource, outputFile);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
        
	}
	
	public static void saveXML() {
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
