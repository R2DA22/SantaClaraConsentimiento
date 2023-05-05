/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vista.ConsentimientoBean;

/**
 *
 * @author diego.ramirez
 */
public class FilterConsentimiento implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = (HttpSession) req.getSession();
        ConsentimientoBean bean = (ConsentimientoBean) session.getAttribute("consentimientoBean");
        if (bean != null && bean.getTipoFormulario()!= null && !bean.getTipoFormulario().equals("")) {
            chain.doFilter(req, res); // Logged-in user found, so just continue request.
        } else {
            res.sendRedirect(req.getContextPath() +"/"); // No logged-in user found, so redirect to login page.
        }
    }

    @Override
    public void destroy() {
    }

}
