package com.simbest.ws.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.interceptor.Fault;

import java.io.InputStream;

/**
 * @author lishuyi
 */
@Slf4j
public class CustomLoggingInInterceptor extends LoggingInInterceptor {


    public CustomLoggingInInterceptor() {
        super(Phase.PRE_STREAM);
        this.setPrettyLogging(true);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        InputStream is = message.getContent(InputStream.class);
        CachedOutputStream os = new CachedOutputStream();
        try {
            IOUtils.copy(is, os);
            os.flush();
            message.setContent(InputStream.class, os.getInputStream());
            is.close();
            String soapXml = IOUtils.toString(os.getInputStream());
            log.debug(soapXml);
            super.handleMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
