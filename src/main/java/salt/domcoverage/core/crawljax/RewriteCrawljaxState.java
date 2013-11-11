package salt.domcoverage.core.crawljax;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import salt.domcoverage.core.metrics.ElementCoverageData;
import salt.domcoverage.core.utils.ConstantVars;
import salt.domcoverage.core.utils.Utils;

public class RewriteCrawljaxState {

	public void applyCoverageToStateFiles(List<ElementCoverageData> elementCovData, Map<String, String> crawljax2DomcoverySimilarDoms, Map<String, String> mapMergedDoms2number) {

		// getall state files
		Map<String, String> stateFiles = Utils.readFilesfromDirectory(ConstantVars.CRAWLJAXSTATES, "html");
		for (String filename : stateFiles.keySet()) {
			// filename=filename.replace(".html", "");
			// if state is already crawled with craawljax
			if (crawljax2DomcoverySimilarDoms.containsKey(filename)) {
				// means: this state is common between craljax and test suite
				String mergeddomfilename = crawljax2DomcoverySimilarDoms.get(filename);
				addCoverageData(filename, stateFiles.get(filename), elementCovData, mergeddomfilename);
				continue;
			}
			if (mapMergedDoms2number.containsValue(filename)) {
				// statefile is just generated by domcovery
				String mergeddomfilename = Utils.getKeyByValue(mapMergedDoms2number, filename);
				addCoverageData(filename, stateFiles.get(filename), elementCovData, mergeddomfilename);
				continue;
			}
			ElementCoverageData cov = new ElementCoverageData(null, "0", "0", "0", "0");
			insertCoverageData(stateFiles.get(filename), cov, filename);
		}

	}

	private void addCoverageData(String filename, String fileData, List<ElementCoverageData> covData, String mergeddomfilename) {
		for (ElementCoverageData elementCoverageData : covData) {
			if (elementCoverageData.getDomFileName().equals(mergeddomfilename)) {
				insertCoverageData(fileData, elementCoverageData, filename);
				return;
			}
		}

	}

	private String insertCoverageData(String fileData, ElementCoverageData elementCoverageData, String filename) {
		fileData = fileData.replace("${" + ConstantVars.DirectElementCoverage + "}", elementCoverageData.getDirectCoverage());
		fileData = fileData.replace("${" + ConstantVars.IndirectElementCoverage + "}", elementCoverageData.getIndirectCoverage());
		fileData = fileData.replace("${" + ConstantVars.AssertedElementCoverage + "}", elementCoverageData.getAssertedCoverage());
		fileData = fileData.replace("${" + ConstantVars.ClickableElementCoverage + "}", elementCoverageData.getClickableCoverage());
		Utils.writeStringToFile(ConstantVars.CRAWLJAXSTATES + filename, fileData);
		return fileData;
	}

	public void applyCoverageToIndexFile(Map<String, String> covs) {
		try {
			File file = new File(ConstantVars.CRAWLOVERVIEW + "index.html");
			String fileData = FileUtils.readFileToString(file);

			for (String s : covs.keySet()) {
				fileData = fileData.replace("${" + s + "}", covs.get(s));
			}
			FileUtils.writeStringToFile(file, fileData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
