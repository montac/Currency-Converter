/*
 * Servlet qui fait à la classe du WebService pour récupérer la cours des actions
 */


import cservice.StockQuotes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author hp
 */
public class StockQuotesServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/StockQuotes/StockQuotesWS.wsdl")
    private StockQuotes service;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/StockQuotes/StockQuotesWS.wsdl")


    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");       
        PrintWriter out = response.getWriter();
        
        boolean scriptTag = false;
        
        String cb = request.getParameter("callback");
        if (cb != null) {
            scriptTag = true;
            response.setContentType("text/javascript");
        } else {
            response.setContentType("application/json");
        }
        if (scriptTag) {
            out.write(cb + "(");
        }
       
         out.print(getLocalStockQuotes());
        
        if (scriptTag) {
            out.write(");");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String getStockQuotes() {
        cservice.StockQuotesWS port = service.getStockQuotesWSPort();
        return port.getStockQuotes();
    }

    private String getLocalStockQuotes() {
        cservice.StockQuotesWS port = service.getStockQuotesWSPort();
        return port.getLocalStockQuotes();
    }


    
    
    
}
