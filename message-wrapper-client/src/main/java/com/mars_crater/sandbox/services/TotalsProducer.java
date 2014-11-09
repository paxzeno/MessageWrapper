package com.mars_crater.sandbox.services;

import com.mars_crater.messages.CatTypeTotals;
import com.mars_crater.messages.IndexTypeTotals;
import com.mars_crater.messages.NonTypeTotals;
import com.mars_crater.messages.Totals;
import com.mars_crater.messages.Type;
import com.mars_crater.sandbox.entities.vo.TotalsVO;

import java.util.List;

/**
 * Created by ateixeira on 09-11-2014.
 */
public class TotalsProducer {

    public Totals getTotals(List<TotalsVO> totalsVOList) {
        final Totals totals = new Totals();
        for (TotalsVO totalsVO : totalsVOList) {
            switch (totalsVO.getType()) {
                case INDEX:
                    this.setIndexTotalsType(totalsVO, totals.getIndexTypeTotals());
                    break;
                case CATEGORY:
                    this.setCatTotalsType(totalsVO, totals.getCatTypeTotals());
                    break;
                case OTHER:
                    this.setNonTypeTotals(totalsVO, totals.getNonTypeTotals());
                    break;
            }
        }

        return totals;
    }

    private void setIndexTotalsType(TotalsVO total, List<IndexTypeTotals> indexTypeTotals) {
        final IndexTypeMapper indexTypeMapper = new IndexTypeMapper();
        indexTypeMapper.setTotals(total, indexTypeTotals);
    }

    private void setCatTotalsType(TotalsVO total, List<CatTypeTotals> catTypeTotals) {
        final CatTypeTotals catTypeTotal = new CatTypeTotals();
        catTypeTotal.setType(total.getType());
        catTypeTotal.setRecycledQtt(total.getRecycledQuantity());
        catTypeTotal.setRecycledAmnt(total.getRecycledAmount());
        catTypeTotal.setNonRecycledQtt(total.getNonRecycledQuantity());
        catTypeTotal.setNonRecycledAmnt(total.getNonRecycledAmount());
        catTypeTotals.add(catTypeTotal);
    }

    private void setNonTypeTotals(TotalsVO total, List<NonTypeTotals> nonTypeTotals) {
        final NonTypeTotals nonTypeTotal = new NonTypeTotals();
        nonTypeTotal.setType(total.getType());
        nonTypeTotal.setLoadQtt(total.getLoadedQuantity());
        nonTypeTotals.add(nonTypeTotal);
    }
}
