package sm.remoteSensorPlatform_xml;

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

import sm.InsituSensor_xml.Temp2_xml;
import sm.main.UploadFrame;


public class CreateRemoteSensorPlatformXML {
//	private static String savePath = "src/instance/instance_RemoteSensorPlatform.xml";
//	private static String xmlPath = "src/Resource/RemoteSensorPlatform.xml";
	
	private static String savePath = "C:/Users/Chels/Desktop/instance/RemoteSensorPlatform.xml";
	
	public InputStream parsedoc() {
		InputStream file= this.getClass().getResourceAsStream("/RemoteSensorPlatform.xml");
		return file;
	}
	
	public static void DomCreate() {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(true);
        try {
        	DocumentBuilder db = dbf.newDocumentBuilder();
        	CreateRemoteSensorPlatformXML r = new CreateRemoteSensorPlatformXML();
        	InputStream file = r.parsedoc();
        	Document doc = db.parse(file);
        	
        	//根节点<sml:physicalSystem>
        	Element root = (Element)doc.getFirstChild();
        	
        	//Page One 卫星平台标识信息
        	Element description = (Element) doc.getElementsByTagName("gml:description").item(0);
        	System.out.println(description.getNodeName());
        	description.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getDescription());
        	
        	Element keywords = (Element) doc.getElementsByTagName("sml:keywords").item(0);
        	System.out.println(keywords.getNodeName());
        	Element keywordList = (Element) keywords.getElementsByTagName("sml:KeywordList").item(0);
        	NodeList keyword = keywordList.getElementsByTagName("sml:keyword");
        	String[] kword = RemoteSensorPlatformFrame.getKeywords();
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
					keywordList.appendChild(k);
					k.setTextContent(kword[j]);
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
				if (lb.equals("唯一标识符")) {
					value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getUID());
				}else if (lb.equals("卫星平台全称")) {
					value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getLongname());
				}else if (lb.equals("卫星平台简称")) {
					value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getShortname());
				}else if (lb.equals("搭载传感器名称")&&RemoteSensorPlatformFrame.getAssociatedSensorCount()>0) {
					value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getAssociatedSensorInfo(0, 0));
				}else if (lb.equals("搭载传感器标识符")&&RemoteSensorPlatformFrame.getAssociatedSensorCount()>0) {
					value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getAssociatedSensorInfo(0, 1));
				}
			}
        	if (RemoteSensorPlatformFrame.getAssociatedSensorCount()>1) {
				for (int i = 1; i < RemoteSensorPlatformFrame.getAssociatedSensorCount(); i++) {
					Element identifierName = doc.createElement("sml:identifier");
					Element t1 = doc.createElement("sml:Term");
					t1.setAttribute("definition", "urn:ogc:def:identifier:OGC:1.0:associatedSensorName");
					Element l1 = doc.createElement("sml:label");
					Element v1 = doc.createElement("sml:value");
					l1.setTextContent("搭载传感器名称");
					v1.setTextContent(RemoteSensorPlatformFrame.getAssociatedSensorInfo(i, 0));
					t1.appendChild(l1);
					t1.appendChild(v1);
					identifierName.appendChild(t1);
					identifierList.appendChild(identifierName);
					
					Element identifierID = doc.createElement("sml:identifier");
					Element t = doc.createElement("sml:Term");
					t.setAttribute("definition", "urn:ogc:def:identifier:OGC:1.0:associatedSensorUniqueID");
					Element l = doc.createElement("sml:label");
					l.setTextContent("搭载传感器标识符");
					Element v = doc.createElement("sml:value");
					v.setTextContent(RemoteSensorPlatformFrame.getAssociatedSensorInfo(i, 1));
					t.appendChild(l);
					t.appendChild(v);
					identifierID.appendChild(t);
					identifierList.appendChild(identifierID);
				}
			}
        	//其他标识符
        	if (RemoteSensorPlatformFrame.checkOtherIdentifier()&&RemoteSensorPlatformFrame.getOtherIdentifierCount()>0) {
				for (int i = 0; i < RemoteSensorPlatformFrame.getOtherIdentifierCount(); i++) {
					Element identifier = doc.createElement("sml:identifier");
					Element term = doc.createElement("sml:Term");
					Element label = doc.createElement("sml:label");
					Element value = doc.createElement("sml:value");
					term.setAttribute("definition", "urn:ogc:def:identifier:OGC:1.0:otherIdentifier");
					label.setTextContent(RemoteSensorPlatformFrame.getOtherIdentifierInfo(i, 0));
					value.setTextContent(RemoteSensorPlatformFrame.getOtherIdentifierInfo(i, 1));
					term.appendChild(label);
					term.appendChild(value);
					identifier.appendChild(term);
					identifierList.appendChild(identifier);
				}
			}
        	
        	Element classifierList = (Element) doc.getElementsByTagName("sml:ClassifierList").item(0);
        	System.out.println(classifierList.getNodeName());
        	NodeList classifiers = classifierList.getElementsByTagName("sml:classifier");
        	String[] application = RemoteSensorPlatformFrame.getApplication();
        	for (int i = 0; i < classifiers.getLength(); i++) {
				Element classifier = (Element) classifiers.item(0);
				Element term = (Element) classifier.getElementsByTagName("sml:Term").item(0);
    			Element label = (Element) term.getElementsByTagName("sml:label").item(0);
    			Element value = (Element) term.getElementsByTagName("sml:value").item(0);
    			String lb = label.getFirstChild().getNodeValue();
				if (lb.equals("平台类型")) {
					value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getPlatformType());
				}else if (lb.equals("卫星类型")) {
					value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getSensorType());
				}else if (lb.equals("轨道类型")) {
					value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getOrbitType());
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
        	if (RemoteSensorPlatformFrame.checkOtherClassifier()&&RemoteSensorPlatformFrame.getOtherClassifierCount()>0) {
        		for (int i = 0; i < RemoteSensorPlatformFrame.getOtherClassifierCount(); i++) {
        			Element classifier = doc.createElement("sml:classifier");
    				Element term = doc.createElement("sml:Term");
    				Element label = doc.createElement("sml:label");
    				Element value = doc.createElement("sml:value");
    				term.setAttribute("definition", "urn:ogc:def:classifier:OGC:1.0:otherClassifier");
    				label.setTextContent(RemoteSensorPlatformFrame.getOtherClassifierInfo(i, 0));
    				value.setTextContent(RemoteSensorPlatformFrame.getOtherClassifierInfo(i, 1));
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
        	if (RemoteSensorPlatformFrame.getBeginTMStates().equals("不定时间点")) {
        		TMPeriod.removeChild(beginTM);
				Element unknown = doc.createElement("gml:beginPosition");
        		unknown.setAttribute("indeterminatePosition", "unknown");
        		TMPeriod.appendChild(unknown);
			}else if (RemoteSensorPlatformFrame.getBeginTMStates().equals("确定时间点")) {
				beginTM.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getBeginTM());
			}
        	if (RemoteSensorPlatformFrame.getEndTMStates().equals("不定时间点")) {
        		TMPeriod.removeChild(endTM);
				Element unknown = doc.createElement("gml:endPosition");
        		unknown.setAttribute("indeterminatePosition", "unknown");
        		TMPeriod.appendChild(unknown);
			}else if (RemoteSensorPlatformFrame.getEndTMStates().equals("确定时间点")) {
				endTM.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getEndTM());
			}
        	
        	Element legalConstraint = (Element) doc.getElementsByTagName("sml:legalConstraints").item(0);
        	System.out.println(legalConstraint.getNodeName());
        	Element legalLimitation = (Element) legalConstraint.getElementsByTagName("gco:CharacterString").item(0);
        	if (RemoteSensorPlatformFrame.checkLegalConstraint()&&!RemoteSensorPlatformFrame.getLegalConstraint().equals("")) {
				legalLimitation.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getLegalConstraint());
			}else if (RemoteSensorPlatformFrame.getLegalConstraint().equals("")) {
				root.removeChild(legalConstraint);
			}
        	
        	Element securityConstraint = (Element) doc.getElementsByTagName("sml:securityConstraints").item(0);
        	System.out.println(securityConstraint.getNodeName());
        	Element securityNoticeText = (Element) securityConstraint.getElementsByTagName("ism:NoticeText").item(0);
        	if (RemoteSensorPlatformFrame.checkSecurityConstraint()&&!RemoteSensorPlatformFrame.getSecurityConstraint().equals("")) {
				securityNoticeText.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getSecurityConstraint());
			}else if (RemoteSensorPlatformFrame.getSecurityConstraint().equals("")) {
				root.removeChild(securityConstraint);
			}
        	
        	//Page Three 站点特征、观测能力、位置信息
        	Element characteristics = (Element) doc.getElementsByTagName("sml:characteristics").item(0);
        	System.out.println(characteristics.getNodeName());
        	Element characteristicList = (Element) characteristics.getElementsByTagName("sml:CharacteristicList").item(0);
        	NodeList characteristic = characteristicList.getElementsByTagName("sml:characteristic");
        	Element chara1 = (Element) characteristic.item(0);
        	Element chara2 = (Element) characteristic.item(1);
        	Element chara3 = (Element) characteristic.item(2);
        	if (RemoteSensorPlatformFrame.getSensorLength().equals("")&&RemoteSensorPlatformFrame.getSensorWidth().equals("")
        			&&RemoteSensorPlatformFrame.getSensorHeight().equals("")&&RemoteSensorPlatformFrame.getSensorWeigh().equals("")) {
        		characteristicList.removeChild(chara1);
			}else {
	        	Element dataRecord = (Element) chara1.getElementsByTagName("swe:DataRecord").item(0);
	        	NodeList fields = dataRecord.getElementsByTagName("swe:field");
	        	for (int i = 0; i < fields.getLength(); i++) {
	        		Element field = (Element) fields.item(i); 
	        		String fieldName = field.getAttribute("name");
	        		Element value = (Element) field.getElementsByTagName("swe:value").item(0);
	        		if (fieldName.equals("长度")) {
						if (RemoteSensorPlatformFrame.getSensorLength().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getSensorLength());
						}
					}
	        		else if (fieldName.equals("宽度")) {
						if (RemoteSensorPlatformFrame.getSensorWidth().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getSensorWidth());
						}
					}
	        		else if (fieldName.equals("高度")) {
						if (RemoteSensorPlatformFrame.getSensorHeight().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getSensorHeight());
						}
					}
	        		else if (fieldName.equals("质量")) {
						if (RemoteSensorPlatformFrame.getSensorWeigh().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getSensorWeigh());
						}
					}
				} 	
			}
        	
        	if (!RemoteSensorPlatformFrame.checkCurrent()&&!RemoteSensorPlatformFrame.checkVoltage()
        			&&RemoteSensorPlatformFrame.getPower().equals("")&&RemoteSensorPlatformFrame.getOutputPower().equals("")) {
        		characteristicList.removeChild(chara2);
			}else {
				Element dataRecord = (Element) chara2.getElementsByTagName("swe:DataRecord").item(0);
	        	NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i); 
	        		String fieldName = field.getAttribute("name");
	        		Element value = (Element) field.getElementsByTagName("swe:value").item(0);
	        		if (fieldName.equals("电流")) {
						if (RemoteSensorPlatformFrame.checkCurrent()) {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getCurrent());
						}else {
							dataRecord.removeChild(field);
						}
					}
	        		else if (fieldName.equals("电压")) {
	        			if (RemoteSensorPlatformFrame.checkVoltage()) {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getVoltage());
						}else {
							dataRecord.removeChild(field);
						}
					}
	        		else if (fieldName.equals("功率")) {
						if (RemoteSensorPlatformFrame.getPower().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getPower());
						}
					}
	        		else if (fieldName.equals("输出功率")) {
						if (RemoteSensorPlatformFrame.getOutputPower().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getOutputPower());
						}
					}
				}
			}
        	
        	if (RemoteSensorPlatformFrame.getLife().equals("")&&RemoteSensorPlatformFrame.getOverload().equals("")) {
				characteristicList.removeChild(chara3);
			}else {
				Element dataRecord = (Element) chara3.getElementsByTagName("swe:DataRecord").item(0);
	        	NodeList fields = dataRecord.getElementsByTagName("swe:field");
	        	for (int i = 0; i < fields.getLength(); i++) {
	        		Element field = (Element) fields.item(i); 
	        		String fieldName = field.getAttribute("name");
	        		Element value = (Element) field.getElementsByTagName("swe:value").item(0);
	        		if (fieldName.equals("设计寿命")) {
						if (RemoteSensorPlatformFrame.getLife().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getLife());
						}
					}
	        		else if (fieldName.equals("有效载荷")) {
						if (RemoteSensorPlatformFrame.getOverload().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getOverload());
						}
					}
				}
			}
        	//其他平台特征
        	if (RemoteSensorPlatformFrame.getOtherCharacterCount()>0&&RemoteSensorPlatformFrame.checkOtherCharacter()) {
        		Element chara = doc.createElement("sml:characteristic");
				Element dataRecord = doc.createElement("swe:DataRecord");
				Element otherCharaLabel = doc.createElement("swe:label");
				otherCharaLabel.setTextContent("其他特征");
				for (int i = 0; i < RemoteSensorPlatformFrame.getOtherCharacterCount(); i++) {
					Element field = doc.createElement("swe:field");
					Element quantity = doc.createElement("swe:Quantity");
					Element value = doc.createElement("swe:value");
					field.setAttribute("name", RemoteSensorPlatformFrame.getOtherCharacterInfo(i, 0));
					value.setTextContent(RemoteSensorPlatformFrame.getOtherCharacterInfo(i, 1));
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
        	if (RemoteSensorPlatformFrame.getEpochTM().equals("")&&RemoteSensorPlatformFrame.getOrbitHeight().equals("")&&
        			RemoteSensorPlatformFrame.getOrbitCycle().equals("")&&RemoteSensorPlatformFrame.getRevisiteTM().equals("")&&
        			RemoteSensorPlatformFrame.getOrbitInclination().equals("")&&RemoteSensorPlatformFrame.getLocaTimeOfDescendingNode().equals("")
        			&&RemoteSensorPlatformFrame.getOrbitRightAscension().equals("")&&RemoteSensorPlatformFrame.getOrbitEccentricity().equals("")
        			&&RemoteSensorPlatformFrame.getOrbitArgumentOfPerigee().equals("")&&RemoteSensorPlatformFrame.getOrbitMeanMotion().equals("")
        			&&RemoteSensorPlatformFrame.getOrbitMeanAnomaly().equals("")&&RemoteSensorPlatformFrame.getOrbitDecayRate().equals("")
        			&&RemoteSensorPlatformFrame.getLowerX().equals("")&&RemoteSensorPlatformFrame.getLowerY().equals("")
        			&&RemoteSensorPlatformFrame.getUpperX().equals("")&&RemoteSensorPlatformFrame.getUpperY().equals("")) {
				CapabilityList.removeChild(Capability1);
			}else {
				Element dataRecord = (Element) Capability1.getElementsByTagName("swe:DataRecord").item(0);
				NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("发射时间")) {
						if (RemoteSensorPlatformFrame.getEpochTM().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getEpochTM());
						}
					}
					else if (name.equals("轨道高度")) {
						if (RemoteSensorPlatformFrame.getOrbitHeight().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getOrbitHeight());
						}
					}
					else if (name.equals("轨道周期")) {
						if (RemoteSensorPlatformFrame.getOrbitCycle().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getOrbitCycle());
						}
					}
					else if (name.equals("重访周期")) {
						if (RemoteSensorPlatformFrame.getRevisiteTM().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getRevisiteTM());
						}
					}
					else if (name.equals("轨道倾角")) {
						if (RemoteSensorPlatformFrame.getOrbitInclination().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getOrbitInclination());
						}
					}
					else if (name.equals("降交点地方时")) {
						if (RemoteSensorPlatformFrame.getLocaTimeOfDescendingNode().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getLocaTimeOfDescendingNode());
						}
					}
					else if (name.equals("升交点赤经")) {
						if (RemoteSensorPlatformFrame.getOrbitRightAscension().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getOrbitRightAscension());
						}
					}
					else if (name.equals("偏心率")) {
						if (RemoteSensorPlatformFrame.getOrbitEccentricity().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getOrbitEccentricity());
						}
					}
					else if (name.equals("近地点幅角")) {
						if (RemoteSensorPlatformFrame.getOrbitArgumentOfPerigee().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getOrbitArgumentOfPerigee());
						}
					}
					else if (name.equals("平近点角")) {
						if (RemoteSensorPlatformFrame.getOrbitMeanAnomaly().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getOrbitMeanAnomaly());
						}
					}
					else if (name.equals("平运动角")) {
						if (RemoteSensorPlatformFrame.getOrbitMeanMotion().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getOrbitMeanMotion());
						}
					}
					else if (name.equals("衰减率")) {
						if (RemoteSensorPlatformFrame.getOrbitDecayRate().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getOrbitDecayRate());
						}
					}
					else if (name.equals("observedBBox")) {
						Element v1 = (Element) field.getElementsByTagName("swe:value").item(1);
						Element v2 = (Element) field.getElementsByTagName("swe:value").item(2);
						Element v3 = (Element) field.getElementsByTagName("swe:value").item(3);
						value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getLowerY());
						v1.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getLowerX());
						v2.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getUpperY());
						v3.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getUpperX());
					}
				}
			}
        	
        	if (RemoteSensorPlatformFrame.getTLESatID().equals("")&&RemoteSensorPlatformFrame.getTLE1().equals("")
        			&&RemoteSensorPlatformFrame.getTLE2().equals("")) {
        		CapabilityList.removeChild(Capability2);
			}else {
				Element dataRecord = (Element) Capability2.getElementsByTagName("swe:DataRecord").item(0);
				NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("TLE卫星标识码")) {
						if (RemoteSensorPlatformFrame.getTLESatID().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getTLESatID());
						}
					}
					else if (name.equals("TLE轨道参数1")) {
						if (RemoteSensorPlatformFrame.getTLE1().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getTLE1());
						}
					}
					else if (name.equals("TLE轨道参数2")) {
						if (RemoteSensorPlatformFrame.getTLE2().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getTLE2());
						}
					}
				}
			}
        	
        	if (RemoteSensorPlatformFrame.getStorage().equals("")&&RemoteSensorPlatformFrame.getDataRate().equals("")) {
        		CapabilityList.removeChild(Capability3);
			}else {
				Element dataRecord = (Element) Capability3.getElementsByTagName("swe:DataRecord").item(0);
				NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("存储容量")) {
						if (RemoteSensorPlatformFrame.getStorage().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getStorage());
						}
					}
					else if (name.equals("数据速率")) {
						if (RemoteSensorPlatformFrame.getDataRate().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getDataRate());
						}
					}
				}
			}
        	
        	if (RemoteSensorPlatformFrame.getTransmissionMode().equals("")&&RemoteSensorPlatformFrame.getDownloadLinkWaveBand().equals("")
        			&&RemoteSensorPlatformFrame.getDownloadLinkRate().equals("")&&RemoteSensorPlatformFrame.getControlWaveBand().equals("")
        			&&RemoteSensorPlatformFrame.getCommunicationInterface().equals("")) {
        		CapabilityList.removeChild(Capability4);
			}else {
				Element dataRecord = (Element) Capability4.getElementsByTagName("swe:DataRecord").item(0);
				NodeList fields = dataRecord.getElementsByTagName("swe:field");
				for (int i = 0; i < fields.getLength(); i++) {
					Element field = (Element) fields.item(i);
					String name = field.getAttribute("name");
					Element value = (Element) field.getElementsByTagName("swe:value").item(0);
					if (name.equals("数传方式")) {
						if (RemoteSensorPlatformFrame.getTransmissionMode().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getTransmissionMode());
						}
					}
					else if (name.equals("遥测波段")) {
						if (RemoteSensorPlatformFrame.getControlWaveBand().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getControlWaveBand());
						}
					}
					else if (name.equals("数据下行波段")) {
						if (RemoteSensorPlatformFrame.getDownloadLinkWaveBand().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getDownloadLinkWaveBand());
						}
					}
					else if (name.equals("数据下行速率")) {
						if (RemoteSensorPlatformFrame.getDownloadLinkRate().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getDownloadLinkRate());
						}
					}
					else if (name.equals("通信接口")) {
						if (RemoteSensorPlatformFrame.getCommunicationInterface().equals("")) {
							dataRecord.removeChild(field);
						}else {
							value.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getCommunicationInterface());
						}
					}
				}
			}
        	//其他观测能力
        	if (RemoteSensorPlatformFrame.getOtherCapabilityCount()>0||RemoteSensorPlatformFrame.checkOtherCapability()) {
        		Element capability = doc.createElement("sml:capability");
				Element dataRecord = doc.createElement("swe:DataRecord");
				for (int i = 0; i < RemoteSensorPlatformFrame.getOtherCapabilityCount(); i++) {
					Element field = doc.createElement("swe:field");
					Element quantity = doc.createElement("swe:Quantity");
					Element value = doc.createElement("swe:value");
					field.setAttribute("name", RemoteSensorPlatformFrame.getOtherCapabilityInfo(i, 0));
					value.setTextContent(RemoteSensorPlatformFrame.getOtherCapabilityInfo(i, 1));
					quantity.appendChild(value);
					field.appendChild(quantity);
					dataRecord.appendChild(field);
				}
				capability.appendChild(dataRecord);
				CapabilityList.appendChild(capability);
			}
        	
        	
        	Element position = (Element) doc.getElementsByTagName("sml:position").item(0);
        	System.out.println(position.getNodeName());
        	NodeList positionValue = position.getElementsByTagName("swe:value");
        	String[] positions = RemoteSensorPlatformFrame.getPosition();
        	positionValue.item(0).getFirstChild().setNodeValue(positions[0]);
        	positionValue.item(1).getFirstChild().setNodeValue(positions[1]);
        	positionValue.item(2).getFirstChild().setNodeValue(positions[2]);
        	
        	Element spatialFrame = (Element) doc.getElementsByTagName("sml:SpatialFrame").item(0);
        	System.out.println(spatialFrame.getNodeName());
        	String[] spatialFrameInfo = RemoteSensorPlatformFrame.getSpatialFrame();
        	Element spatialOrigin = (Element) spatialFrame.getElementsByTagName("sml:origin").item(0);
        	NodeList spatialAxis = spatialFrame.getElementsByTagName("sml:axis");
        	spatialFrame.setAttribute("id", spatialFrameInfo[0]);
        	spatialOrigin.getFirstChild().setNodeValue(spatialFrameInfo[1]);
        	spatialAxis.item(0).getFirstChild().setNodeValue(spatialFrameInfo[2]);
        	spatialAxis.item(1).getFirstChild().setNodeValue(spatialFrameInfo[3]);
        	spatialAxis.item(2).getFirstChild().setNodeValue(spatialFrameInfo[4]);
        	
        	Element temporalFrame = (Element) doc.getElementsByTagName("sml:TemporalFrame").item(0);
        	System.out.println(temporalFrame.getNodeName());
        	Element temporalOrigin = (Element) temporalFrame.getElementsByTagName("sml:origin").item(0);
        	String[] temporalFrameInfo = RemoteSensorPlatformFrame.getTemporalFrame();
        	temporalFrame.setAttribute("id", temporalFrameInfo[0]);
        	temporalOrigin.getFirstChild().setNodeValue(temporalFrameInfo[1]);
        	
        	//Page Four 联系单位、服务历史、接口信息
        	Element contacts = (Element) doc.getElementsByTagName("sml:contacts").item(0);
        	System.out.println(contacts.getNodeName());
        	Element contactList = (Element) contacts.getElementsByTagName("sml:ContactList").item(0);
        	Element contact = (Element) contactList.getElementsByTagName("sml:contact").item(0);
        	String role = "";
        	if (RemoteSensorPlatformFrame.getRole().equals("制造商")) {
				role = "manufacturer";
				}else if (RemoteSensorPlatformFrame.getRole().equals("管理者")) {
				role = "management";
				}else if (RemoteSensorPlatformFrame.getRole().equals("使用者")) {
				role = "operater";
			}
        	contact.setAttribute("xlink:arcrole", "urn:ogc:def:role:OGC:1.0:"+role);
        	NodeList CharacterString = contact.getElementsByTagName("gco:CharacterString");
        	CharacterString.item(0).getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getOrganizationName());
        	CharacterString.item(1).getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getIndividualName());
        	Element voice = (Element) contact.getElementsByTagName("gmd:voice").item(0);
			Element deliveryPoint = (Element) contact.getElementsByTagName("gmd:deliveryPoint").item(0);
			Element city = (Element) contact.getElementsByTagName("gmd:city").item(0);
			Element administrativeArea = (Element) contact.getElementsByTagName("gmd:administrativeArea").item(0);
			Element country = (Element) contact.getElementsByTagName("gmd:country").item(0);
			Element email = (Element) contact.getElementsByTagName("gmd:electronicMailAddress").item(0);
			Element code = (Element) contact.getElementsByTagName("gmd:postalCode").item(0);
        	voice.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getTelephone());
			deliveryPoint.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getDeliveryPoint());
			city.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getCity());
			administrativeArea.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getAdministration());
			country.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getCountry());
			email.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getEmail());
			code.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getPostcode());
        	
			
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
			if (RemoteSensorPlatformFrame.getEventNum()==0) {
				root.removeChild(history);
			}else if (RemoteSensorPlatformFrame.getEventNum()>1) {
				Element eLabel = (Element) event.getElementsByTagName("swe:label").item(0);
				Element eDescription = (Element) event.getElementsByTagName("swe:description").item(0);
				Element time = (Element) event.getElementsByTagName("sml:time").item(0);
	        	Element eTMPeriod = (Element) time.getElementsByTagName("gml:TimePeriod").item(0);
				eLabel.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getEventLabel());
				eDescription.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getEventDescription());
				int eTMChoice = RemoteSensorPlatformFrame.getEventTMChoice();
				System.out.println(eTMChoice);
				if (eTMChoice==1) {
					eTMPeriod.setAttribute("gml:id", RemoteSensorPlatformFrame.getEventID());
					Element eventBeginTM = (Element) eTMPeriod.getElementsByTagName("gml:beginPosition").item(0);
					Element eventEndTM = (Element) eTMPeriod.getElementsByTagName("gml:endPosition").item(0);
					eventBeginTM.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getEventBeginTM());
					eventEndTM.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getEventEndTM());
				}else if (eTMChoice==2) {
					time.removeChild(eTMPeriod);
					Element timeInstant = doc.createElement("gml:TimeInstant");
					Element timePosition = doc.createElement("gml:timePosition");
					timeInstant.setAttribute("gml:id", RemoteSensorPlatformFrame.getEventID());
					timePosition.setTextContent(RemoteSensorPlatformFrame.getEventInstance());
					timeInstant.appendChild(timePosition);
					time.appendChild(timeInstant);
				}else if(eTMChoice==0){
					event.removeChild(time);
				}
				for (int i = 1; i < RemoteSensorPlatformFrame.getEventNum(); i++) {
					Element e = doc.createElement("sml:Event");
					Element eLb = doc.createElement("swe:label");
					eLb.getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getEventInfo(i, 1));
					e.appendChild(eLb);
					event.appendChild(e);
				}
			}
			
			
			Element interfaces = (Element) doc.getElementsByTagName("sml:interfaces").item(0);
			System.out.println(interfaces.getNodeName());
        	Element interfaceList = (Element) interfaces.getElementsByTagName("sml:InterfaceList").item(0);
        	Element intface = (Element) interfaceList.getElementsByTagName("sml:interface").item(0);
			if (RemoteSensorPlatformFrame.getInterfaceNum()==0) {
				root.removeChild(interfaces);
			}else if (RemoteSensorPlatformFrame.getInterfaceNum()==1) {
				NodeList interfaceValue = intface.getElementsByTagName("swe:value");
				intface.setAttribute("name", RemoteSensorPlatformFrame.getInterfaceInfo(0, 0));
				interfaceValue.item(0).getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getInterfaceInfo(0, 1));
				interfaceValue.item(1).getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getInterfaceInfo(0, 2));
				interfaceValue.item(2).getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getInterfaceInfo(0, 3));
			}else if (RemoteSensorPlatformFrame.getInterfaceNum()>1) {
				NodeList interfaceValue = intface.getElementsByTagName("swe:value");
				intface.setAttribute("name", RemoteSensorPlatformFrame.getInterfaceInfo(0, 0));
				interfaceValue.item(0).getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getInterfaceInfo(0, 1));
				interfaceValue.item(1).getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getInterfaceInfo(0, 2));
				interfaceValue.item(2).getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getInterfaceInfo(0, 3));
				for (int i = 1; i < RemoteSensorPlatformFrame.getInterfaceNum(); i++) {
					Element inter = (Element) intface.cloneNode(true);
					NodeList interValue = inter.getElementsByTagName("swe:value");
					intface.setAttribute("name", RemoteSensorPlatformFrame.getInterfaceInfo(i, 0));
					interValue.item(0).getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getInterfaceInfo(i, 1));
					interValue.item(1).getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getInterfaceInfo(i, 2));
					interValue.item(2).getFirstChild().setNodeValue(RemoteSensorPlatformFrame.getInterfaceInfo(i, 3));
					interfaceList.appendChild(inter);
				}
			}
        	
			
			//Page Five 输入、输出、参数、组件、关系信息
			Element inputs = (Element) doc.getElementsByTagName("sml:inputs").item(0);
			System.out.println(inputs.getNodeName());
        	Element inputList = (Element) inputs.getElementsByTagName("sml:InputList").item(0);
        	Element input = (Element) inputList.getElementsByTagName("sml:input").item(0);
        	Element property = (Element) input.getElementsByTagName("swe:ObservableProperty").item(0);
			if (RemoteSensorPlatformFrame.getInputNum()==0) {
				root.removeChild(inputs);
			}else if (RemoteSensorPlatformFrame.getInputNum()>0) {
				input.setAttribute("name", RemoteSensorPlatformFrame.getInputInfo(0, 0));
				property.setAttribute("definition", RemoteSensorPlatformFrame.getInputInfo(0, 1));
				for (int i = 1; i < RemoteSensorPlatformFrame.getInputNum(); i++) {
					Element in = (Element) input.cloneNode(true);
					Element inProperty = (Element) in.getElementsByTagName("swe:ObservableProperty").item(0);
					in.setAttribute("name", RemoteSensorPlatformFrame.getInputInfo(i, 0));
					inProperty.setAttribute("definition", RemoteSensorPlatformFrame.getInputInfo(i, 1));
					inputList.appendChild(in);
				}
			}
			
			Element outputs = (Element) doc.getElementsByTagName("sml:outputs").item(0);
			System.out.println(outputs.getNodeName());
        	Element outputList = (Element) doc.getElementsByTagName("sml:OutputList").item(0);
        	Element output = (Element) outputList.getElementsByTagName("sml:output").item(0);
        	Element outdef = (Element) output.getElementsByTagName("swe:Quantity").item(0);
        	Element outUom = (Element) output.getElementsByTagName("swe:uom").item(0);
			if (RemoteSensorPlatformFrame.getOutputNum()==0) {
				root.removeChild(outputs);
			}else if (RemoteSensorPlatformFrame.getOutputNum()>0) {
				output.setAttribute("name", RemoteSensorPlatformFrame.getOutputInfo(0, 0));
				outdef.setAttribute("definition", RemoteSensorPlatformFrame.getOutputInfo(0, 1));
				outUom.setAttribute("code", RemoteSensorPlatformFrame.getOutputInfo(0, 2));
				for (int i = 1; i < RemoteSensorPlatformFrame.getOutputNum(); i++) {
					Element out = (Element) output.cloneNode(true);
					Element def = (Element) out.getElementsByTagName("swe:Quantity").item(0);
					Element uom = (Element) out.getElementsByTagName("swe:uom").item(0);
					out.setAttribute("name", RemoteSensorPlatformFrame.getOutputInfo(i, 0));
					def.setAttribute("definition", RemoteSensorPlatformFrame.getOutputInfo(i, 1));
					uom.setAttribute("code", RemoteSensorPlatformFrame.getOutputInfo(i, 2));
					outputList.appendChild(out);
				}
			}
			
			Element components = (Element) doc.getElementsByTagName("sml:components").item(0);
			System.out.println(components.getNodeName());
        	Element componentList = (Element) components.getElementsByTagName("sml:ComponentList").item(0);
        	Element component = (Element) componentList.getElementsByTagName("sml:component").item(0);
			if (RemoteSensorPlatformFrame.getComponentNum()==0) {
				root.removeChild(components);
			}else if (RemoteSensorPlatformFrame.getComponentNum()>0) {
				component.setAttribute("name", RemoteSensorPlatformFrame.getComponentInfo(0, 0));
				component.setAttribute("xlink:title", RemoteSensorPlatformFrame.getComponentInfo(0, 1));
				component.setAttribute("xlink:href", RemoteSensorPlatformFrame.getComponentInfo(0, 2));
				for (int i = 1; i < RemoteSensorPlatformFrame.getComponentNum(); i++) {
					Element comp = (Element) component.cloneNode(true);
					comp.setAttribute("name", RemoteSensorPlatformFrame.getComponentInfo(i, 0));
					comp.setAttribute("xlink:title", RemoteSensorPlatformFrame.getComponentInfo(i, 1));
					comp.setAttribute("xlink:href", RemoteSensorPlatformFrame.getComponentInfo(i, 2));
				}
			}
			
			//组件关系connections
			if (RemoteSensorPlatformFrame.getConnectionNum()>0) {
				Element connections = doc.createElement("sml:connections");
				Element connectionList = doc.createElement("sml:ConnectionList");
				for (int i = 0; i < RemoteSensorPlatformFrame.getConnectionNum(); i++) {
					Element link = doc.createElement("sml:Link");
					Element source = doc.createElement("sml:source");
					Element destination = doc.createElement("sml:destination");
					source.setAttribute("ref", RemoteSensorPlatformFrame.getConnectionInfo(i, 0));
					destination.setAttribute("ref", RemoteSensorPlatformFrame.getConnectionInfo(i, 1));
					link.appendChild(source);
					link.appendChild(destination);
					connectionList.appendChild(link);
				}
				connections.appendChild(connectionList);
				root.appendChild(connections);
			}
			
        	
        	TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			DOMSource xmlSource = new DOMSource(doc);
			StreamResult outputFile = new StreamResult(new File(savePath));
			tf.transform(xmlSource, outputFile);
		} catch (Exception e) {
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
