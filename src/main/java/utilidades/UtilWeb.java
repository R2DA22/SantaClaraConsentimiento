/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import app.config.Properties;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Julian D Osorio G
 */
public class UtilWeb {

    public static void redirect(String Url) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect(Url);
    }

    public static void addWarningMsg(final String titulo, final String detalle) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, detalle);
        context.showMessageInDialog(message);
    }

    public static void addSuccessMsg(final String titulo, final String detalle) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, detalle);
        context.showMessageInDialog(message);
    }

    public String obtenerRutaURL() {
        String contextPath = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURL().toString();
        String part[] = contextPath.split("/SantaClaraConsentimiento");
        return part[0];
    }

    public String getRealPath() {
        String realPath = "";
        try {
            URI u = getClass().getResource(PdfFile.class.getSimpleName() + ".class").toURI();
            realPath = u.getPath().substring(0, u.getPath().indexOf("classes"));
            try {
                String OS = System.getProperty("os.name").toLowerCase();
                if (OS.contains("win")) {
                    realPath = realPath.substring(1, realPath.length());
                    realPath = realPath.replaceAll("\\/", "\\\\");
                }

            } catch (Exception e) {
            }
        } catch (URISyntaxException e) {
        }
        String part[] = realPath.split("WEB-INF");
        return part[0];
    }
}
