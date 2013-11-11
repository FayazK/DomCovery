package salt.domcoverage.core.dom;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import salt.domcoverage.core.utils.ConstantVars;

import com.crawljax.util.DomUtils;

public class DocumentObjectModel {

	private String DOM;

	public DocumentObjectModel(String dom) {
		DOM = dom;
	}

	public DocumentObjectModel(File file) {
		try {
			DOM = FileUtils.readFileToString(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getNumberofAllClickables() {

		Document document = getW3cDocument();
		NodeList elemA = document.getElementsByTagName("a");
		NodeList elemI = document.getElementsByTagName("input");
		NodeList elemB = document.getElementsByTagName("button");
		NodeList elemIm = document.getElementsByTagName("img");

		return elemA.getLength() + elemB.getLength() + elemI.getLength() + elemIm.getLength();
	}

	public int getAllElements() {
		int all = 0;
		Document w3cdoc = getW3cDocument();
		// NodeList body = w3cdoc.getElementsByTagName("body");
		// if (body == null)
		// body = w3cdoc.getElementsByTagName("BODY");

		all = w3cdoc.getElementsByTagName("*").getLength();

		NodeList elements = w3cdoc.getElementsByTagName("*");

		int bodyelementorder = 0;
		for (int i = 0; i < elements.getLength(); i++) {
			Node item = elements.item(i);
			if (item.getNodeName().toLowerCase().contains("body")) {
				bodyelementorder = i + 1;
				break;
			}
			// System.out.println("elem: " + item);

		}
		// System.out.println(" body element order numbercounting: " +
		// bodyelementorder);
		int numberofCountingItems = 0;
		for (int i = bodyelementorder - 1; i < elements.getLength(); i++) {
			Node item = elements.item(i);
			if (item.getFirstChild() != null && !containsText(item.getFirstChild().getNodeValue()))
				continue;
			if (countingItem(item.getNodeName())) {
				numberofCountingItems++;
			}
		}
		return numberofCountingItems;
	}

	private boolean containsText(String nodeValue) {
		if (nodeValue == null)
			return false;
		String s = new String(nodeValue);
		s = s.replace(" ", "");
		s = s.replaceAll("\\r\\n|\\r|\\n", " ");
		return s.equals("");
	}

	private boolean countingItem(String nodeName) {
		for (String s : ConstantVars.ELEMENTS_TO_COUNT) {
			if (nodeName.trim().toLowerCase().equals(s))
				return true;
		}
		return false;
	}

	private Document getW3cDocument() {
		Document asDocument = null;
		try {
			asDocument = DomUtils.asDocument(DOM);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return asDocument;
	}

	public int getElementAccessedInDOMThroughAttribute(String attribute) {
		org.jsoup.nodes.Document doc = Jsoup.parse(DOM);
		Elements elements = doc.select("[" + attribute + "]");
		return elements.size();

	}
}
