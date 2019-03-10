package sm.readExcel;

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



public class Excel2XML {
//	private static String savePath = "src/instance/instance_Excel2xml.xml";
	private static String savePath = "C:/Users/Chels/Desktop/instance/instance_Excel2xml.xml";
	private static String xmlPath = "src/Resource/template_Excel2xml.xml";
	//new
	public InputStream parsedoc() {
		InputStream file= this.getClass().getResourceAsStream("/template_Excel2xml.xml");
		return file;
	}
	//new
	public static void DomCreate() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
        try {
        	DocumentBuilder db = dbf.newDocumentBuilder();
        	//new
        	Excel2XML excel2xml = new Excel2XML();
        	InputStream file = excel2xml.parsedoc();
        	Document doc = db.parse(file);
//        	Document doc = db.parse(xmlPath);

        	
        	//主题节点
        	Element category = (Element) doc.getElementsByTagName("category").item(0);
        	System.out.println(category.getNodeName());
        	category.setAttribute("name", Excel2XmlFrame.getTheme());
        	
        	Element subCategory = (Element) category.getElementsByTagName("SubCategory").item(0);
        	System.out.println(subCategory.getNodeName());
        	subCategory.setAttribute("name", Excel2XmlFrame.getTheme()+" report");

        	ArrayList<Object[][]> content = Excel2XmlFrame.getKeywordContent();
        	int keyNum = content.size(); //关键词个数
        	Element keywordList = (Element) doc.getElementsByTagName("KeywordList").item(0);
        	Element keyword = (Element) keywordList.getElementsByTagName("keyword").item(0);
        	Element user = (Element) keyword.getElementsByTagName("User").item(0);
        	Element userName = (Element) user.getElementsByTagName("name").item(0);
        	Element positionText = (Element) user.getElementsByTagName("text").item(0);
        	Element positionCoordinate = (Element) user.getElementsByTagName("coordinate").item(0);
        	Element userTime = (Element) user.getElementsByTagName("time").item(0);
        	Element userContent = (Element) user.getElementsByTagName("text").item(1);
        	if (keyNum>0) {
        		Object[][] key1 = content.get(0); //第一个关键词包含用户信息
            	Object[] key11 =  key1[0];  //
//            	for (int i = 0; i < key1.length; i++) {
//            		System.out.println("第"+i+"个用户信息为：");
//					for (int j = 0; j < key11.length; j++) {
//						System.out.println(key1[i][j]+" ");
//					}
//				}
            	keyword.setAttribute("name", Excel2XmlFrame.getKeyword(0)[0]);
            	user.setAttribute("id", key11[0].toString());
            	userName.getFirstChild().setNodeValue(key11[1].toString());
            	positionText.getFirstChild().setNodeValue(key11[3].toString());
            	userTime.getFirstChild().setNodeValue(key11[2].toString());
            	userContent.getFirstChild().setNodeValue(key11[4].toString());
            	for (int i = 1; i < key1.length; i++) {
					Element user_i = doc.createElement("User");
					Element Description_i = doc.createElement("description");
		        	Element userName_i = doc.createElement("name");
		        	Element position_i = doc.createElement("position");
		        	Element positionText_i = doc.createElement("text");
		        	Element Point_i = doc.createElement("point");
		        	Element coordinate_i = doc.createElement("coordinate");
		        	Element userTime_i = doc.createElement("time");
		        	Element userContent_i = doc.createElement("content"); 
		        	Element contentText_i = doc.createElement("text");
		        	Object[] key1_i = key1[i];
		        	user_i.setAttribute("id", key1_i[0].toString());
		        	Description_i.setTextContent("用户详细信息");
		        	userName_i.setTextContent(key1_i[1].toString());
		        	positionText_i.setTextContent(key1_i[3].toString());
		        	userTime_i.setTextContent(key1_i[2].toString());
		        	contentText_i.setTextContent(key1_i[4].toString());
		        	Point_i.appendChild(coordinate_i);
		        	userContent_i.appendChild(contentText_i);
		        	position_i.appendChild(positionText_i);
		        	position_i.appendChild(Point_i);
		        	user_i.appendChild(Description_i);
		        	user_i.appendChild(userName_i);
		        	user_i.appendChild(position_i);
		        	user_i.appendChild(userTime_i);
		        	user_i.appendChild(userContent_i);
		        	keyword.appendChild(user_i);
				}
            	
            	//关键词大于1时
            	if (keyNum>1) {
            		for (int i = 1; i < keyNum; i++) {
            			Object[][] keyi = content.get(i); //第i个关键词
//        				for (int a = 0; a < keyi.length; a++) {
//                    		System.out.println("第"+a+"个用户信息为：");
//        					for (int b = 0; b < key11.length; b++) {
//        						System.out.println(keyi[a][b]+" ");
//        					}
//        				}
        				Element keyword_i = doc.createElement("keyword");
        				keyword_i.setAttribute("name", Excel2XmlFrame.getKeyword(i)[0]);
            			for (int j = 0; j < keyi.length; j++) {
            				Object keyi_j[] = keyi[j];
            				Element useri_j = doc.createElement("User");
        					Element Descriptioni_j = doc.createElement("description");
        		        	Element userNamei_j = doc.createElement("name");
        		        	Element positioni_j = doc.createElement("position");
        		        	Element positionTexti_j = doc.createElement("text");
        		        	Element Pointi_j = doc.createElement("point");
        		        	Element coordinatei_j = doc.createElement("coordinate");
        		        	Element userTimei_j = doc.createElement("time");
        		        	Element userContenti_j = doc.createElement("content"); 
        		        	Element contentTexti_j = doc.createElement("text");
        		        	useri_j.setAttribute("id", keyi_j[0].toString());
        		        	Descriptioni_j.setTextContent("用户详细信息");
        		        	userNamei_j.setTextContent(keyi_j[1].toString());
        		        	positionTexti_j.setTextContent(keyi_j[3].toString());
        		        	userTimei_j.setTextContent(keyi_j[2].toString());
        		        	contentTexti_j.setTextContent(keyi_j[4].toString());
        		        	Pointi_j.appendChild(coordinatei_j);
        		        	userContenti_j.appendChild(contentTexti_j);
        		        	positioni_j.appendChild(positionTexti_j);
        		        	positioni_j.appendChild(Pointi_j);
        		        	useri_j.appendChild(Descriptioni_j);
        		        	useri_j.appendChild(userNamei_j);
        		        	useri_j.appendChild(positioni_j);
        		        	useri_j.appendChild(userTimei_j);
        		        	useri_j.appendChild(userContenti_j);
        		        	keyword_i.appendChild(useri_j);
						}
            			keywordList.appendChild(keyword_i);
					}
				}
			}     	    	
        	
        	TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			DOMSource xmlSource = new DOMSource(doc);
			StreamResult outputFile = new StreamResult(new File(savePath));
			tf.transform(xmlSource, outputFile);
        }catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void SaveXml() {
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
