package me.findthepeach.myood.filesearch.search;

import me.findthepeach.myood.filesearch.entry.File;

import java.util.ArrayList;
import java.util.List;

public class CompositeSearch implements SearchCriteria{

    public final List<SearchCriteria> criteriaList;
    public final LogicalOperator logicalOperator;

    public CompositeSearch(LogicalOperator logicalOperator) {
        this.criteriaList = new ArrayList<>();
        this.logicalOperator = logicalOperator;
    }

    public void addCriteria(SearchCriteria criteria) {
        criteriaList.add(criteria);
    }

    @Override
    public boolean matches(File file){
        if(logicalOperator == LogicalOperator.OR){
            for(SearchCriteria criteria : criteriaList){
                if(criteria.matches(file)){
                    return true;
                }
            }
            return false;
        }else if(logicalOperator == LogicalOperator.AND){
            for(SearchCriteria criteria : criteriaList){
                if(!criteria.matches(file)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
