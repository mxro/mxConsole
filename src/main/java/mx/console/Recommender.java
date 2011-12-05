/*******************************************************************************
 * Copyright 2011 Max Erik Rohde http://www.mxro.de
 * 
 * All rights reserved.
 ******************************************************************************/
package mx.console;

public interface Recommender<GRecommendation> {

	public interface RecommenderCallback<GRecommendation> {
		
		public void onNewRecommendation(GRecommendation recommendation,
				int relevance);

		public void onRemoveRecommendation(GRecommendation recommendation);

		public void onUpdateRelevance(GRecommendation recommendation,
				int newRelevance);
	}

	public void setBase(String base);

}
