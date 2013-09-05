package salt.domcoverage.core.dom.clustering;

public class DataClustererWithRelativeSimilarity extends DataClusterer {

	boolean domsSimilar(int i, int j, double[][] distances) {

		double disij = distances[i][j];
		// double disji = distances[j][i];

		boolean similar = similarDomBasedonDiff(disij);
		System.out.println("similar?: " + similar);
		return similar;
	}

	public boolean similarDomBasedonDiff(double diff) {
		boolean similar = diff <= 16;
		return similar;
	}

}
