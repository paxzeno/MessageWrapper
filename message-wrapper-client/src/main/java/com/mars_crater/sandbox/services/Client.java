package com.mars_crater.sandbox.services;

import com.mars_crater.sandbox.entities.vo.TotalsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Client receiver of the message and reply.
 */
public class Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        final Mapper mapper = new Mapper();
        final List<TotalsVO> totalsVOList = mapper.createTotalsVOList();
        LOGGER.debug("========= Starting Client ==========");

        for (TotalsVO element : totalsVOList) {
            LOGGER.debug("========= Retrieving element ==========");
            LOGGER.debug("\n=======================================" + element + "\n=======================================");
        }

        mapper.createTotalsResponse(totalsVOList);

    }
}
