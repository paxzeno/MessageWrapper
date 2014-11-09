package com.mars_crater.sandbox.services;

import com.mars_crater.messages.CatTypeTotals;
import com.mars_crater.messages.IndexTypeTotals;
import com.mars_crater.messages.NonTypeTotals;
import com.mars_crater.messages.Totals;
import com.mars_crater.messages.TotalsRequest;
import com.mars_crater.messages.TotalsResponse;
import com.mars_crater.sandbox.entities.vo.TotalsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ateixeira on 08-11-2014.
 */
public class Mapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    public List<TotalsVO> createTotalsVOList() {
        try {
            final Handler handler = new Handler();
            final TotalsRequest totalsRequest = handler.OpenMessage();

            List<TotalsVO> totalsVOList = new ArrayList<TotalsVO>();

            //index totals mapping
            final List<IndexTypeTotals> indexTypeTotals = totalsRequest.getTotals().getIndexTypeTotals();
            for (IndexTypeTotals indexTypeTotal : indexTypeTotals) {
                TotalsVO indexTotal = new TotalsVO();
                indexTotal.setIndex(indexTypeTotal.getIndex());
                indexTotal.setType(indexTypeTotal.getType());
                indexTotal.setLoadedQuantity(indexTypeTotal.getLoadQtt());
                indexTotal.setLoadedAmount(indexTypeTotal.getLoadAmnt());
                indexTotal.setDistributedQuantity(indexTypeTotal.getDistributedQtt());
                indexTotal.setRecycledQuantity(indexTypeTotal.getRecycledQtt());
                totalsVOList.add(indexTotal);
            }

            //category totals mapping
            final List<CatTypeTotals> catTypeTotals = totalsRequest.getTotals().getCatTypeTotals();
            for (CatTypeTotals catTypeTotal : catTypeTotals) {
                TotalsVO catTotal = new TotalsVO();
                catTotal.setType(catTypeTotal.getType());
                catTotal.setRecycledQuantity(catTypeTotal.getRecycledQtt());
                catTotal.setRecycledAmount(catTypeTotal.getRecycledAmnt());
                catTotal.setNonRecycledQuantity(catTypeTotal.getNonRecycledQtt());
                catTotal.setNonRecycledAmount(catTypeTotal.getNonRecycledAmnt());
                totalsVOList.add(catTotal);
            }

            //other totals mapping
            final List<NonTypeTotals> nonTypeTotals = totalsRequest.getTotals().getNonTypeTotals();
            for (NonTypeTotals nonTypeTotal : nonTypeTotals) {
                TotalsVO nonTotal = new TotalsVO();
                nonTotal.setType(nonTypeTotal.getType());
                nonTotal.setLoadedQuantity(nonTypeTotal.getLoadQtt());
                totalsVOList.add(nonTotal);
            }

            return totalsVOList;

        } catch (JAXBException e) {
            LOGGER.debug("Error trying to parse the message, " + e.getMessage());
            return new ArrayList<TotalsVO>();
        } catch (FileNotFoundException e) {
            LOGGER.debug("Error trying to access the message file." + e.getMessage());
            return new ArrayList<TotalsVO>();
        }
    }

    public void createTotalsResponse(List<TotalsVO> totalsVOList) {
        try {
            final TotalsProducer totalsProducer = new TotalsProducer();

            final TotalsResponse totalsResponse = new TotalsResponse();
            totalsResponse.setTotals(totalsProducer.getTotals(totalsVOList));

            final Handler handler = new Handler();
            handler.closeMessage(totalsResponse);

        } catch (JAXBException e) {
            LOGGER.debug("Error trying to marshall the message." + e);
        } catch (FileNotFoundException e) {
            LOGGER.debug("Error trying to write the message file." + e.getMessage());
        }

    }
}
