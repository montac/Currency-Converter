
package cservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetConversionRatesV2_QNAME = new QName("http://cservice/", "getConversionRatesV2");
    private final static QName _GetLocalConversionRatesResponse_QNAME = new QName("http://cservice/", "getLocalConversionRatesResponse");
    private final static QName _GetConversionRatesV2Response_QNAME = new QName("http://cservice/", "getConversionRatesV2Response");
    private final static QName _GetConversionRatesResponse_QNAME = new QName("http://cservice/", "getConversionRatesResponse");
    private final static QName _GetConversionRates_QNAME = new QName("http://cservice/", "getConversionRates");
    private final static QName _GetLocalConversionRates_QNAME = new QName("http://cservice/", "getLocalConversionRates");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetConversionRatesV2 }
     * 
     */
    public GetConversionRatesV2 createGetConversionRatesV2() {
        return new GetConversionRatesV2();
    }

    /**
     * Create an instance of {@link GetLocalConversionRatesResponse }
     * 
     */
    public GetLocalConversionRatesResponse createGetLocalConversionRatesResponse() {
        return new GetLocalConversionRatesResponse();
    }

    /**
     * Create an instance of {@link GetLocalConversionRates }
     * 
     */
    public GetLocalConversionRates createGetLocalConversionRates() {
        return new GetLocalConversionRates();
    }

    /**
     * Create an instance of {@link GetConversionRatesV2Response }
     * 
     */
    public GetConversionRatesV2Response createGetConversionRatesV2Response() {
        return new GetConversionRatesV2Response();
    }

    /**
     * Create an instance of {@link GetConversionRates }
     * 
     */
    public GetConversionRates createGetConversionRates() {
        return new GetConversionRates();
    }

    /**
     * Create an instance of {@link GetConversionRatesResponse }
     * 
     */
    public GetConversionRatesResponse createGetConversionRatesResponse() {
        return new GetConversionRatesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConversionRatesV2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cservice/", name = "getConversionRatesV2")
    public JAXBElement<GetConversionRatesV2> createGetConversionRatesV2(GetConversionRatesV2 value) {
        return new JAXBElement<GetConversionRatesV2>(_GetConversionRatesV2_QNAME, GetConversionRatesV2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalConversionRatesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cservice/", name = "getLocalConversionRatesResponse")
    public JAXBElement<GetLocalConversionRatesResponse> createGetLocalConversionRatesResponse(GetLocalConversionRatesResponse value) {
        return new JAXBElement<GetLocalConversionRatesResponse>(_GetLocalConversionRatesResponse_QNAME, GetLocalConversionRatesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConversionRatesV2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cservice/", name = "getConversionRatesV2Response")
    public JAXBElement<GetConversionRatesV2Response> createGetConversionRatesV2Response(GetConversionRatesV2Response value) {
        return new JAXBElement<GetConversionRatesV2Response>(_GetConversionRatesV2Response_QNAME, GetConversionRatesV2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConversionRatesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cservice/", name = "getConversionRatesResponse")
    public JAXBElement<GetConversionRatesResponse> createGetConversionRatesResponse(GetConversionRatesResponse value) {
        return new JAXBElement<GetConversionRatesResponse>(_GetConversionRatesResponse_QNAME, GetConversionRatesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConversionRates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cservice/", name = "getConversionRates")
    public JAXBElement<GetConversionRates> createGetConversionRates(GetConversionRates value) {
        return new JAXBElement<GetConversionRates>(_GetConversionRates_QNAME, GetConversionRates.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalConversionRates }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cservice/", name = "getLocalConversionRates")
    public JAXBElement<GetLocalConversionRates> createGetLocalConversionRates(GetLocalConversionRates value) {
        return new JAXBElement<GetLocalConversionRates>(_GetLocalConversionRates_QNAME, GetLocalConversionRates.class, null, value);
    }

}
