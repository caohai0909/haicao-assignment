package models;

import java.util.Map;

public class SearchProductModel {
    public String Keyword;
    public String Results;

    public void setKeyword(String keyword) {
        Keyword = keyword;
    }

    public void setResults(String results) {
        Results = results;
    }

    public static SearchProductModel searchProductByKeyword(Map<String, String> entry){
        SearchProductModel searchProductModel = new SearchProductModel();
        searchProductModel.setKeyword(entry.get("Keyword"));
        searchProductModel.setResults(entry.get("Results"));
        return searchProductModel;
    }
}
