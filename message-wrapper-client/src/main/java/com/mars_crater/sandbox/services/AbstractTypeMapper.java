package com.mars_crater.sandbox.services;

import com.mars_crater.sandbox.entities.vo.TotalsVO;

import java.util.List;

/**
 * Created by ateixeira on 09-11-2014.
 */
public abstract class AbstractTypeMapper<T> {

    public void setTotals(TotalsVO total, List<T> totalsList) {
        totalsList.add(this.mapTotals(total));
    }

    protected abstract T mapTotals(TotalsVO totalsVO);

}
