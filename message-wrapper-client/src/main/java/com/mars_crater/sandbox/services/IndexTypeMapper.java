package com.mars_crater.sandbox.services;

import com.mars_crater.messages.IndexTypeTotals;
import com.mars_crater.sandbox.entities.vo.TotalsVO;

/**
 * Created by ateixeira on 09-11-2014.
 */
public class IndexTypeMapper extends AbstractTypeMapper<IndexTypeTotals> {

    @Override
    protected IndexTypeTotals mapTotals(TotalsVO totalsVO) {
        final IndexTypeTotals indexTypeTotal = new IndexTypeTotals();
        indexTypeTotal.setIndex(totalsVO.getIndex());
        indexTypeTotal.setType(totalsVO.getType());
        indexTypeTotal.setLoadQtt(totalsVO.getLoadedQuantity());
        indexTypeTotal.setLoadAmnt(totalsVO.getLoadedAmount());
        indexTypeTotal.setDistributedQtt(totalsVO.getDistributedQuantity());
        indexTypeTotal.setRecycledQtt(totalsVO.getRecycledQuantity());
        return indexTypeTotal;
    }
}
