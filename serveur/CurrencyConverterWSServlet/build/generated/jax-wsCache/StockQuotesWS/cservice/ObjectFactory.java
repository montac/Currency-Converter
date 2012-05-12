
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

    private final static QName _GetStockQuotesResponse_QNAME = new QName("http://cservice/", "getStockQuotesResponse");
    private final static QName _GetLocalStockQuotes_QNAME = new QName("http://cservice/", "getLocalStockQuotes");
    private final static QName _GetLocalStockQuotesResponse_QNAME = new QName("http://cservice/", "getLocalStockQuotesResponse");
    private final static QName _GetStockQuotes_QNAME = new QName("http://cservice/", "getStockQuotes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLocalStockQuotesResponse }
     * 
     */
    public GetLocalStockQuotesResponse createGetLocalStockQuotesResponse() {
        return new GetLocalStockQuotesResponse();
    }

    /**
     * Create an instance of {@link GetStockQuotesResponse }
     * 
     */
    public GetStockQuotesResponse createGetStockQuotesResponse() {
        return new GetStockQuotesResponse();
    }

    /**
     * Create an instance of {@link GetLocalStockQuotes }
     * 
     */
    public GetLocalStockQuotes createGetLocalStockQuotes() {
        return new GetLocalStockQuotes();
    }

    /**
     * Create an instance of {@link GetStockQuotes }
     * 
     */
    public GetStockQuotes createGetStockQuotes() {
        return new GetStockQuotes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStockQuotesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cservice/", name = "getStockQuotesResponse")
    public JAXBElement<GetStockQuotesResponse> createGetStockQuotesResponse(GetStockQuotesResponse value) {
        return new JAXBElement<GetStockQuotesResponse>(_GetStockQuotesResponse_QNAME, GetStockQuotesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalStockQuotes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cservice/", name = "getLocalStockQuotes")
    public JAXBElement<GetLocalStockQuotes> createGetLocalStockQuotes(GetLocalStockQuotes value) {
        return new JAXBElement<GetLocalStockQuotes>(_GetLocalStockQuotes_QNAME, GetLocalStockQuotes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalStockQuotesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cservice/", name = "getLocalStockQuotesResponse")
    public JAXBElement<GetLocalStockQuotesResponse> createGetLocalStockQuotesResponse(GetLocalStockQuotesResponse value) {
        return new JAXBElement<GetLocalStockQuotesResponse>(_GetLocalStockQuotesResponse_QNAME, GetLocalStockQuotesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStockQuotes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cservice/", name = "getStockQuotes")
    public JAXBElement<GetStockQuotes> createGetStockQuotes(GetStockQuotes value) {
        return new JAXBElement<GetStockQuotes>(_GetStockQuotes_QNAME, GetStockQuotes.class, null, value);
    }

}
