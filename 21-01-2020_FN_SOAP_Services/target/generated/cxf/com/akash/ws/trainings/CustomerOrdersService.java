package com.akash.ws.trainings;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2020-01-26T09:45:51.271+05:30
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "CustomerOrdersService",
                  wsdlLocation = "classpath:CustomerOrders.wsdl",
                  targetNamespace = "http://trainings.ws.akash.com/")
public class CustomerOrdersService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://trainings.ws.akash.com/", "CustomerOrdersService");
    public final static QName CustomerOrdersPort = new QName("http://trainings.ws.akash.com/", "CustomerOrdersPort");
    static {
        URL url = CustomerOrdersService.class.getClassLoader().getResource("CustomerOrders.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(CustomerOrdersService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "classpath:CustomerOrders.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CustomerOrdersService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerOrdersService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerOrdersService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public CustomerOrdersService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CustomerOrdersService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CustomerOrdersService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns CustomerOrdersPortType
     */
    @WebEndpoint(name = "CustomerOrdersPort")
    public CustomerOrdersPortType getCustomerOrdersPort() {
        return super.getPort(CustomerOrdersPort, CustomerOrdersPortType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerOrdersPortType
     */
    @WebEndpoint(name = "CustomerOrdersPort")
    public CustomerOrdersPortType getCustomerOrdersPort(WebServiceFeature... features) {
        return super.getPort(CustomerOrdersPort, CustomerOrdersPortType.class, features);
    }

}
