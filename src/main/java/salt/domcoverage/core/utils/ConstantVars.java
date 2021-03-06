package salt.domcoverage.core.utils;

public class ConstantVars {

	public static final String COVERAGE_LOCATION = "Coverage/";
	public static final String SEPARATOR = "~~";
	public static final String COVERAGE_COVERED_ELEMENTS_CSV = COVERAGE_LOCATION + "CoveredElements.csv";
	public static final String MERGEDLOCATION = "MergedState/";
	public static final String INSTRUMENTED_CODE_LOCATION = "instrumentedCode/";
	public static final String HTML_EXTENSION = ".html";

	public static final String STYLE = "<style  type=\"text/css\"> [coverage=\"true\"]{outline:10px solid green;}</style>";
	public static final int MINIMUM_LENGTH_OF_DOM = 50;
	public static final String DISTANCES_ARRAY = "Distances.csv";
	public static final String[] seleniumDomRelatedMethodCallList = new String[] { "findElement", "findElements" };
	public static final String[] allSeleniumMethodCalls = new String[] { "findElement", "id", "xpath", "tagName", "linkText",
			"cssSelector", "partialLinkText", "className", "findElements" };
	public static final String[] assertion_methods_list = new String[] { "assertEquals", "assertTrue", "assertNotNull", "assertNull" };
	public static final String[] ELEMENTS_NOT_COUNT = new String[] { "p", "form", "tbody", "tabular", "thead", "h1", "h2", "h3", "br",
			"hr", "code", "i", "kbd", "pre", "small", "strong", "abbr", "ul", "ol", "dl", "th", "select" };
	public static final String[] ELEMENTS_TO_COUNT = new String[] { "div", "input", "a", "li", "td", "tr", "table", "option", "img", "dt",
			"iframe", "textarea", "span" };
	public static final String INJECT_ELEMENT_ACCESS_JS = "elementaccessinject.js";
	public static final String INJECT_ELEMENT_ACCESS_CSS = "elementaccessinject.css";
	public static final String CLICKABLE_DETECTOR_JS = "clickable-detector-pre.js";
	public static final String CLICKABLE_DETECTOR_CSS = "clickable-detected.css";
	public static final String VISIBLE_ELEMENT_DETECTOR_JS = "visible-element-detect.js";
	public static final String VISIBLE_ELEMENT_DETECTOR_CSS = "visible-element-detect.css";
	public static final String CSS_CODE_INJECT = "cssCodeInject.css";
	public static final String JS_CODE_INJECT = "jsCodeInject.js";

	public static final String PROXY_IP = "127.0.0.1";
	public static int PROXY_PORT = 8884;
	public static final String[] SELENIUMDRIVER_METHODCALLS = new String[] { "FirefoxDriver", "ChromeDriver" };
	public static final String DomCoverageCriteria = "DomCoverageCriteriaReport.txt";
	public static double SIMILARITY_THRESHOLD = 17;// saltlab:17,organizer:5, photogalley:34, claroline:23
	public static final String ELEMENTS_SEPARATOR = "@@@@@@@@@";
	public static String CRAWLOVERVIEW = "out/";
	public static String CRAWLJAXDOMS = CRAWLOVERVIEW + "doms/";
	public static String CRAWLJAXSTATES = CRAWLOVERVIEW + "states/";
	public static String CRAWLJAX_IMAGES = CRAWLOVERVIEW + "screenshots/";
	public static final boolean ENFORCE_SIMILARITY_FROM_BEGINING = true;
	public static boolean JS_REWRITE_EXECUTED = false;
	public static boolean oracleAssertion = false;

	public static String ESTIMATIONFILE = "estimation.b";
	public static String EXPLORATIONFILE = "exploration.b";
	public static boolean indirectCoverageMode = false;
	public static boolean Clickable_mode = false;

	public static final String assertedCoverageAttribute = "assertedcoverage";
	public static final String directCoverageAttribute = "directcoverage";
	public static final String clickableCoverageAttribute = "clickablecoverage";
	public static final String indirectCoverageAttribute = "indirectcoverage";

	public static final String DomStateCoverage = "DomStateCoverage";
	public static final String DomTransitionCoverage = "DomTransitionCoverage";
	public static final String DirectElementCoverage = "DirectElementCoverage";
	public static final String IndirectElementCoverage = "IndirectElementCoverage";
	public static final String AssertedElementCoverage = "AssertedElementCoverage";
	public static final String ClickableElementCoverage = "ClickableElementCoverage";
	public static final String OutPutBuilderTemp = "outputbuildertemp/";
	public static final String EdgeData = COVERAGE_LOCATION + "edgeData.csv";
	public static boolean Clickable_element_collection = true;

}
