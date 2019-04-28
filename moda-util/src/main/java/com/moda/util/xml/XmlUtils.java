package com.moda.util.xml;

import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.*;
import java.util.Map.Entry;

/**
 * @author lyh
 * @description XML操作工具
 * @date 2015-08-27
 *
 */
public class XmlUtils {

	/**
	 * 将请求参数转换为xml格式的string
	 *
	 * @param parameters
	 * @return
	 */
	public static String getRequestXml(SortedMap<String, String> parameters) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		Set<Entry<String, String>> es = parameters.entrySet();
		Iterator<Entry<String, String>> it = es.iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			if (entry.getKey() == null || entry.getValue() == null) {
				continue;
			}
			String k = entry.getKey().toString();
			String v = entry.getValue().toString();
			if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
				sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
			} else {
				sb.append("<" + k + ">" + v + "</" + k + ">");
			}
		}
		sb.append("</xml>");
		return sb.toString();
	}

	/**
	 * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
	 *
	 * @param strxml
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static SortedMap<String, Object> doXMLParse(String strxml) throws JDOMException, IOException {
		strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");

		if (null == strxml || "".equals(strxml)) {
			return null;
		}

		SortedMap<String, Object> m = new TreeMap<String, Object>();

		InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(in);
		Element root = doc.getRootElement();
		List<Element> list = root.getChildren();
		Iterator<Element> it = list.iterator();
		while (it.hasNext()) {
			Element e = (Element) it.next();
			String k = e.getName();
			String v = "";
			List<Element> children = e.getChildren();
			if (children.isEmpty()) {
				v = e.getTextNormalize();
			} else {
				v = getChildrenText(children);
			}
			m.put(k, v);
		}

		// 关闭流
		in.close();

		return m;
	}

	/**
	 * 获取子结点的xml
	 *
	 * @param children
	 * @return String
	 */
	public static String getChildrenText(List<Element> children) {
		StringBuffer sb = new StringBuffer();
		if (!children.isEmpty()) {
			Iterator<Element> it = children.iterator();
			while (it.hasNext()) {
				Element e = (Element) it.next();
				String name = e.getName();
				String value = e.getTextNormalize();
				List<Element> list = e.getChildren();
				sb.append("<" + name + ">");
				if (!list.isEmpty()) {
					sb.append(getChildrenText(list));
				}
				sb.append(value);
				sb.append("</" + name + ">");
			}
		}

		return sb.toString();
	}

	/**
	 * 获取返回XML
	 *
	 * @param return_code
	 * @param return_msg
	 * @return
	 */
	public static String getReturnXml(String return_code, String return_msg) {
		SortedMap<String, String> sm = new TreeMap<String, String>();
		sm.put("return_code", return_code);
		sm.put("return_msg", return_msg);
		return XmlUtils.getRequestXml(sm);
	}

	/**
	 * 格式化输出XML
	 *
	 * @param xml
	 * @return
	 */
	public static String formatXml(String xml) {
		org.dom4j.Document document;
		try {
			document = DocumentHelper.parseText(xml);
			StringWriter stringWriter = new StringWriter();
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter xmlWriter = new XMLWriter(stringWriter, format);
			xmlWriter.write(document);
			xmlWriter.close();
			return stringWriter.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xml;
	}
}
