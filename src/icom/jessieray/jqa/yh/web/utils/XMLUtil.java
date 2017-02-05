package icom.jessieray.jqa.yh.web.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.thoughtworks.xstream.XStream;

/**
 * xml工具�?
 * @author miklchen
 *
 */
public class XMLUtil {

	/**
	 * 解析xml,返回第一级元素键值对。如果第�?级元素有子节点，则此节点的�?�是子节点的xml数据�?
	 * @param strxml
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static Map doXMLParse(String strxml) throws JDOMException, IOException {
		strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");

		if(null == strxml || "".equals(strxml)) {
			return null;
		}
		Map m = new HashMap();
		
		InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(in);
		Element root = doc.getRootElement();
		List list = root.getChildren();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Element e = (Element) it.next();
			String k = e.getName();
			String v = "";
			List children = e.getChildren();
			if(children.isEmpty()) {
				v = e.getTextNormalize();
			} else {
				v = XMLUtil.getChildrenText(children);
			}
			
			m.put(k, v);
		}
		
		//关闭�?
		in.close();
		
		return m;
	}
	
	/**
	 * 获取子结点的xml
	 * @param children
	 * @return String
	 */
	public static String getChildrenText(List children) {
		StringBuffer sb = new StringBuffer();
		if(!children.isEmpty()) {
			Iterator it = children.iterator();
			while(it.hasNext()) {
				Element e = (Element) it.next();
				String name = e.getName();
				String value = e.getTextNormalize();
				List list = e.getChildren();
				sb.append("<" + name + ">");
				if(!list.isEmpty()) {
					sb.append(XMLUtil.getChildrenText(list));
				}
				sb.append(value);
				sb.append("</" + name + ">");
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * 获取xml编码字符�?
	 * @param strxml
	 * @return
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public static String getXMLEncoding(String strxml) throws JDOMException, IOException {
		InputStream in = HttpClientUtil.String2Inputstream(strxml);
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(in);
		in.close();
		return (String)doc.getProperty("encoding");
	}
	
	
	/**
	 * 将xml转换为Map
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
		
		Map<String, String> resultMap = new HashMap<String, String>();
		
		InputStream ins = request.getInputStream();
		SAXReader reader = new SAXReader();
		org.dom4j.Document document = reader.read(ins);
		org.dom4j.Element rootElement = document.getRootElement();
		List<Element> elements = rootElement.elements();
		
		for (Element element : elements) {
			resultMap.put(element.getName(), element.getText());
		}
		ins.close();
		return resultMap;
	}
	
	/**
	 * 将对象转换为xml
	 * @param object
	 * @return
	 */
	public static String objToXml(Object object, String xmlRootElementAlias) {
		
		XStream xStream = new XStream();
		xStream.alias(xmlRootElementAlias, object.getClass());
		String xml = xStream.toXML(object);
		return xml;
	}
	
	/**
	 * 将对象转换为xml，支持设置xml的多个元素的别名
	 * @param object
	 * @return
	 */
	public static String objToXml(Object object, Map<String, Object> xmlElementAliasMap) {
		
		XStream xStream = new XStream();
		
		Set<String> aliasSet = xmlElementAliasMap.keySet();
		for (String alias : aliasSet) {
			xStream.alias(alias, xmlElementAliasMap.get(alias).getClass());
		}
		String xml = xStream.toXML(object);
		return xml;
}
	
}
