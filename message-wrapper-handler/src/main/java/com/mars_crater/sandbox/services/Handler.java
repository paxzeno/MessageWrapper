package com.mars_crater.sandbox.services;

import com.mars_crater.messages.ObjectFactory;
import com.mars_crater.messages.TotalsRequest;
import com.mars_crater.messages.TotalsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Message handler, used for reading and writing messages.
 */
public class Handler {

    private static final Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    public TotalsRequest OpenMessage() throws JAXBException, FileNotFoundException {
        JAXBContext jc = JAXBContext.newInstance("com.mars_crater.messages");

        Unmarshaller u = jc.createUnmarshaller();
        return (TotalsRequest) ((JAXBElement) u.unmarshal(new FileInputStream("src/main/resources/messages-in/TotalsRequest.xml"))).getValue();
    }

//    TODO: do a more elegant thing
//    private List<JAXBElement> unmarshal(File file) {
//        if (file.isDirectory()) {
//            for (String filename : file.list()) {
//
//            }
//        }
//    }

    public void closeMessage(TotalsResponse totalsResponse) throws JAXBException, FileNotFoundException {
        JAXBContext jc = JAXBContext.newInstance("com.mars_crater.messages");

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<TotalsResponse> totalsResponseJAXBElement =  objectFactory.createTotalsResponse(totalsResponse);

        marshaller.marshal(totalsResponseJAXBElement, new FileOutputStream("src/main/resources/messages-out/TotalsResponse.xml"));
        marshaller.marshal(totalsResponseJAXBElement, System.out);
    }
}
