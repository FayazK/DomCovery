package salt.domcoverage.core.code2instrument;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import salt.domcoverage.core.utils.ConstantVars;

public class ElementData {

	public String getElementFile() {
		return elementFile;
	}



	public void setElementFile(String elementFile) {
		this.elementFile = elementFile;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getTestName() {
		return testName;
	}



	public void setTestName(String testName) {
		this.testName = testName;
	}



	public String getBy() {
		return by;
	}



	public void setBy(String by) {
		this.by = by;
	}



	public String getDomData() {
		return domData;
	}



	public void setDomData(String domData) {
		this.domData = domData;
	}



	public String getDomFileName() {
		return domFileName;
	}



	public void setDomFileName(String domFileName) {
		this.domFileName = domFileName;
	}



	public List<String> getElements() {
		return elements;
	}



	public void setElements(List<String> elements) {
		this.elements = elements;
	}



	private String elementFile;
	String time;
	String testName;
	String by;
	String domData;
	String domFileName;
	List<String> elements;

	
	
	public ElementData(String testName, String time, String by, String domfilename,String elementF) {
		super();
		this.time = time;
		this.testName = testName;
		this.by = by;
		this.elementFile= elementF;
		this.domFileName= domfilename;
		 try {
			 domData = FileUtils.readFileToString(new File(ConstantVars.COVERAGE_LOCATION+domfilename+".html"));
			 elements = FileUtils.readLines(new File(ConstantVars.COVERAGE_LOCATION+elementF+".txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}



	public String getdomfilename() {
		// TODO Auto-generated method stub
		return domFileName;
	}
	
	
}