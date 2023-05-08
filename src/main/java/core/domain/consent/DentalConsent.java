package core.domain.consent;

import app.config.Configuration;
import core.domain.area.Area;
import core.domain.bus.command.Command;
import core.domain.process.Process;
import java.util.List;
import utilidades.Constantes;

public class DentalConsent extends ConsentInterface implements Command {

    private static final String TYPE = "ODONTOLOGIA";
    private static final String URL = "consentimiento_odontologico.xhtml?faces-redirect=true";

    private List<Area> areasList;


     private String FORMAT_DOCUMENT_WITHOUT_GUARDIAN = "<html>\n"
            + "            <head>\n"
            + "            <title>SBCPM-F-001.V3 Consentimiento Informado de Proc.</title>\n"
            + "            <meta charset=\"utf-8\">\n"
            + "            <link rel=\"stylesheet\" type=\"text/css\" href=\"" + PATH_CSS_APP + STYLES + "\" />\n"
            + "            </head>\n"
            + "            <body>\n"
            + "            <div class=\"container\" style=\"float: left;\">\n"
            + "            	<header >\n"
            + "            		<table class=\"with-border\" style=\"margin-right: auto; width: 100%\">\n"
            + "            	        <tbody  class=\"alineacion-center\">\n"
            + "            	                <tr >\n"
            + "            	                    <td  rowspan=\"3\" >\n"
            + "            	                        <img  src=\"" + PATH_IMAGES_APP + NAME_LOGO + "\"  width=\"40\" />\n"
            + "            	                    </td>\n"
            + "                                 <td >SISTEMA DE GESTION INTEGRADO</td>\n"
            + "                                 <td >FECHA:</td>\n"
            + "                                 <td >@Fecha@</td>\n"
            + "                             </tr>\n"
            + "                             <tr>\n"
            + "                                 <td  rowspan=\"2\" >CONSENTIMIENTO - DESENTIMIENTO INFORMADO TRATAMIENTO ODONTOLOGIO</td>\n"
            + "                                 <td  >VERSION:</td>\n"
            + "                                 <td >2</td>\n"
            + "                             </tr>\n"
            + "                             <tr>\n"
            + "                                 <td >CODIGO:</td>\n"
            + "                                 <td >SBCPM-F-001</td>\n"
            + "                             </tr>        \n"
            + "                     </tbody>\n"
            + "                 </table>\n"
            + "             </header>\n"
            + "            \n"
            + "             <div class=\"contenido\" style=\"padding-top: 15px;\">\n"
            + "                    <p>Fecha (DD/MM/AAAA):  <u><i>@Fecha@</i></u></p>\n"
            +
            "                    <p>Yo <u><i>@Paciente@</i></u> identificado con documento de identidad No. <u><i>@NroDocumento@</i></u>, actuando en nombre propio ( ), en representación del menor ( ) <u><i>____________________________</i></u> identificad@ con Documento de identidad número <u><i>_______________________</i></u></p>   \n"
            +
            "                    <p>Que el profesional en odontología de la Clínica Santa Clara, me ha explicado que es conveniente proceder en mi situación, al tratamiento odontológico en las siguientes areas:</p>\n"
            + "                    <table class=\"with-border\" style=\"margin-right: auto; width: 100%\">\n"
            + "                        <tbody  class=\"alineacion-left\">\n"
            + "                                @LstProcedimientos@\n"
            + "                        </tbody>\n"
            + "                    </table>\n"
            + "                    <p><strong>DESCRIPCION DEL PROCEDIMIENTO</strong>\n"
            +
            "                    <p><strong>HIGIENE ORAL:</strong>  Remoción de la placa bacteriana y cálculos de sarro formados alrededor de los dientes mediante ultrasonido, y curetas de periodoncia. También, se realizará la remoción de manchas dentales extrínsecas y pulido especializado con pasta abrasiva, o bien mediante un aeropulidor con el sistema a base de bicarbonato de sodio a presión. RIESGOS: Sangrado gingival, sensibilidad dentinal, caida de restauraciones cervicales.</p>\n"
            +
            "                    <p><strong>ANESTESIA DENTAL:</strong>  La anestesia local o regional, consiste en aplicar mediante una inyección una sustancia que provoca el bloqueo reversible de los impulsos nerviosos, Interrumpiendo de esta manera la función sensitiva, con el fin de realizar un tratamiento sin dolor: Riesgos: Laseración por movimientos involuntarios del paciente, ruptura de la aguja dentro de los tejidos blandos, fracaso anestésico,  sensacion de adormecimiento que puede producir automordeduras, ocasionando trauma en los tejidos blandos, hematoma en el sitio de punción, alergia al medicamento que puede ir desde una urticaria hasta un edema angioneurótico, anestesia intravascular que puede ir desde un mareo leve, taquicardias, desmayos, dolor de cabeza, aumentos de tensión arterial que podrían ocasionar tratamientos de urgencia médica.</p>\n"
            +
            "                    <p><strong>OPERATORIA:</strong>  La Restauración con Resina de Fotocurado consiste en la eliminación de tejido dental cariado, o restauraciones desadaptadas o dientes que han recibido fracturas y requieren reconstruir la forma y la función del diente. Para ello puede requerir la aplicación de anestesia local. Es importante aclarar que la caries puede ser expansiva al interior de la misma en forma de cono, lo que hace que en muchas ocasiones se observe la estructura dentaria conservada, pero al hacer apertura, el tejido dentario interno se encuentre reblandecido expandiéndose formando una cavidad extensa. RIESGOS: Exposición pulpar al retirar la caries, lo que llevará a la necesidad de requerir un tratamiento convencional de conductos, Incluso podría existir la posibilidad de tener una microexposición que no sea detectada y ocasione una pulpitis irreversible, que tambien requerirá un tratamiento convencional de conductos. Puntos de contacto prematuros, que ocasione dolor al masticar y requiera una cita de control para realizar el correspondiente ajuste oclusal. Al realizar la preparación dental pueden quedar paredes delgadas que con la fuerza masticatoria produzca una fractura dentaria, que dependiendo de la fractura requerirá una nueva obturación con resina o una restauración fija. Falla en la higiene oral del paciente que ocasione caries recurrente.</p>\n"
            +
            "                    <p><strong>ENDODONCIA:</strong>  La Endodoncia consiste en la eliminación de tejido pulpar enfermo, previa anestesia local, ensanchamiento de los conductos, y sellado del conducto con material termoplástico que impida el paso de bacterias y toxinas infecciosas. Para ello requiere la toma de radiografía inicial, toma de conductometría a través de localizador apical, o medida del tamaño de la raíz para su respectiva preparación, obturación del conducto y radiografía de control. RIESGO: Cambio de color del diente, Fractura del tejido soporte por no realizar tratamiento restaurador despues de terminado el tratamiento endodóntico, Fractura de instrumentos dentro del conducto, Perforación de la raiz, extravasación al periapice del desinfectante utilizado en la irrigación, el diente puede presentar síndrome del diente fisurado, que es una microfractura del diente y pese al tratamiento de conductos el dolor persiste, lo que ocasiona una fractura vertical del diente terminando en extracción.</p>\n"
            + "\n"
            +
            "                    <p><strong>EXODONCIA:</strong>  Una pieza dentaria se decide extraer por fines ortodónticos para evitar apiñamiento dental, o porque la pieza dentaria ha sufrido un deterioro en su estructura que compromete la integridad del diente y que es imposible rehabilitar por su poco tejido remanente, o por falta de recurso económico para el tratamiento planteado. RIESGOS: en el momento del procedimiento pueden exisitr complicaciones como fractura radicalar, que requeriá un procedimiento quirúrgico más amplio. También puede ocasionar lesión de dientes vecinos, fractura de la tabla osea, de la tuberosidad del maxilar, del maxilar inferior, comunicación oroantral en molares superiores, tragado de pieza dentaria, desgarro de tejidos blandos, lesión de nervios, hemorragia, alveolitis, infección, inflamación.</p>\n"
            +
            "                    <p><strong>ODONTOPEDIATRIA: </strong> Para el manejo del comportamiento del menor, existen técnicas comunicativas que en presencia de padres permisivos o autoritarios, requiere la separación de los padres.\n"
            +
            "                    Siempre existirá la comunicación verbal explicando el tratamiento al menor, mostrando, diciendo y haciendo, con la finalidad que el menor conozca el procedimiento. En ocasiones se requiere una técnica restrictiva, cuando el paciente no colabora y requiere el tratamiento con urgencia y no da tiempo al proceso de adaptación, por lo cual se requerirá la presencia del padre o acudiente para que ayude a inmovilizar al paciente. RIESGOS:  El niño en el forcejeo puede salir maltratado.</p>\n"
            +
            "                    <p>Certifico que leí y entendí las indicaciones, riesgos, ventajas y beneficios inherentes a cada tratamiento,que tuve la oportunidad de resolver mis inquietudes, también que conozco el autocuidado y control respectivo al plan de tratamiento,  por lo cual conciento que me practiquen los procedimientos programados en el tratamiento odontológico aquí propuesto.</p>\n"
            +
            "                    <p>De conformidad con la política de privacidad disponible en la pág. Web www.clinicasantaclara.com, Autorizo a la CLÍNICA SANTA CLARA el tratamiento de mis datos personales,  SI@datosPersonalesSI@, NO@datosPersonalesNO@</p>\n"
            +
            "                    <p>El titular de los datos tiene derecho de conocer, actualizar, rectificar, suprimir los datos y revocar la autorización salvo las excepciones legales.</p>\n"
            + "            \n"
            + "                    <table width=\"100%\" >\n"
            + "                        <tbody>\n"
            + "                            <tr>\n"
            + "                                <td width=\"50%\">\n"
            + "                                        <div style=\"float: left; margin-top: 32px\">\n"
            + "                                            <p>Firma del usuario o acudiente:</p>\n"
            + "                                            <p>Idetificación:<u><i>@TipoDoc@ @NroDocumento@</p>\n"
            + "                                        </div>\n"
            + "                                        <div>\n"
            + "                                            <span class=\"position-firma\">\n"
            + "                                                <img class=\"img-firma\" src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE +
            "-@docSignature@." + Constantes.IMAGE_FORMAT + "\" width=\"130\" />\n"
            +
            "                                                <div class=\"subrayado\">______________________________</div>                                 \n"
            + "                                            </span>\n"
            + "                                        </div>\n"
            + "                                                    \n"
            + "                                </td>\n"
            + "                                <td width=\"50%\"  style=\"\">\n"
            + "                                        <div style=\"float: left; margin-top: 32px\">\n"
            + "                                            <p>Firma odontólogo tratante:</p>\n"
            + "                                            <p>Registro No.<u><i>@NroRegistro@</i></u></p>\n"
            + "                                        </div>\n"
            + "                                        <div>\n"
            + "                                            <span class=\"position-firma\">\n"
            + "                                                <img class=\"img-firma\" src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE +
            "-@docSignatureProfessional@." + Constantes.IMAGE_FORMAT + "\" width=\"130\" />\n"
            + "                                                <div class=\"subrayado\">______________________________</div>\n"
            //            + "                                                <div class=\"subrayado3\"><u><i>@NroRegistro@</i></u></div>\n"
            + "                                            </span>\n"
            + "                                        </div>             \n"
            + "                                </td>\n"
            + "                            </tr>\n"
            + "                        </tbody>\n"
            + "                    </table><br/>"
            + "                    <table width=\"100%\" class=\"with-border\">\n"
            + "                        <tbody>\n"
            + "                            <tr>\n"
            + "                                <td colspan=\"2\">\n"
            + "                                    <p>DESENTIMIENTO DEL CONSENTIMIENTO INFORMADO</p>               \n"
            + "                                </td>\n"
            + "                            </tr>\n"
            + "                            <tr>\n"
            + "                                <td colspan=\"2\">\n"
            +
            "                                    <p>Por medio del presente documento y en pleno uso de mis facultades mentales, certifico que he recibido toda la información del tratamiento propuesto, sus indicaciones, riesgos, ventajas y beneficios por parte del Profesional en Odontología de la Clínica Santa Clara y aún así otorgo en forma libre y espontánea  mi disentimiento de los siguientes procedimientos</p>               \n"
            + "                                </td>\n"
            + "                            </tr>\n"
            + "                            <tr>\n"
            + "                                <td colspan=\"2\"><p>PROCEDIMIENTOS: @desentimientos@</p></td>\n"
            + "                            </tr>\n"
            + "                            <tr>\n"
            +
            "                                <td colspan=\"2\"><p>Entiendo que estos procedimientos hacen parte del tratamiento instaurado, me ha sido explicada las implicaciones y posibles complicaciones por su no realización. No obstante me niego al mismo, asumiendo los riesgos bajo mi propia responsabilidad.</p></td>\n"
            + "                            </tr>\n"
            + "                            <tr>\n"
            + "                                <td colspan=\"1\" width=\"50%\">\n"
            + "                                        <div style=\"float: left; margin-top: 32px\">\n"
            + "                                            <p>Firma del usuario o acudiente:</p>\n"
            +
            "                                            <p>Idetificación:<u style=\"display:@displayFirma@\"><i>@TipoDoc@ @NroDocumento@</p>\n"
            + "                                        </div>\n"
            + "                                        <div>\n"
            + "                                            <span class=\"position-firma\">\n"
            + "                                                <img style=\"display:@displayFirma@\" class=\"img-firma\" src=\"" +
            PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignature@." + Constantes.IMAGE_FORMAT + "\" width=\"130\" />\n"
            +
            "                                                <div class=\"subrayado\">______________________________</div>                                 \n"
            + "                                            </span>\n"
            + "                                        </div>\n"
            + "                                                    \n"
            + "                                </td>\n"
            + "                                <td colspan=\"1\" width=\"50%\">\n"
            + "                                        <div style=\"float: left; margin-top: 32px\">\n"
            + "                                            <p>Firma odontólogo tratante:</p>\n"
            +
            "                                            <p>Registro No.<u style=\"display:@displayFirma@\"><i>@NroRegistro@</i></u></p>\n"
            + "                                        </div>\n"
            + "                                        <div>\n"
            + "                                            <span class=\"position-firma\">\n"
            + "                                                <img style=\"display:@displayFirma@\" class=\"img-firma\" src=\"" +
            PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignatureProfessional@." + Constantes.IMAGE_FORMAT + "\" width=\"130\" />\n"
            + "                                                <div class=\"subrayado\">______________________________</div>\n"
            + "                                            </span>\n"
            + "                                        </div>             \n"
            + "                                </td>\n"
            + "                            </tr>\n"
            + "                        </tbody>\n"
            + "                    </table>\n"
            + "             </div>\n"
            + "            </div>\n"
            + "            </body>\n"
            + "            </html>";

    public String FORMAT_DOCUMENT_WITH_GUARDIAN = "<html>\n"
            + "            <head>\n"
            + "            <title>SBCPM-F-001.V3 Consentimiento Informado de Proc.</title>\n"
            + "            <meta charset=\"utf-8\">\n"
            + "            <link rel=\"stylesheet\" type=\"text/css\" href=\"" + PATH_CSS_APP + STYLES + "\" />\n"
            + "            </head>\n"
            + "            <body>\n"
            + "            <div class=\"container\" style=\"float: left;\">\n"
            + "            	<header >\n"
            + "            		<table class=\"with-border\" style=\"margin-right: auto; width: 100%\">\n"
            + "            	        <tbody  class=\"alineacion-center\">\n"
            + "            	                <tr >\n"
            + "            	                    <td  rowspan=\"3\" >\n"
            + "            	                        <img  src=\"" + PATH_IMAGES_APP + NAME_LOGO + "\"  width=\"40\" />\n"
            + "            	                    </td>\n"
            + "                                 <td >SISTEMA DE GESTION INTEGRADO</td>\n"
            + "                                 <td >FECHA:</td>\n"
            + "                                 <td >@Fecha@</td>\n"
            + "                             </tr>\n"
            + "                             <tr>\n"
            + "                                 <td  rowspan=\"2\" >CONSENTIMIENTO - DESENTIMIENTO INFORMADO TRATAMIENTO ODONTOLOGIO</td>\n"
            + "                                 <td  >VERSION:</td>\n"
            + "                                 <td >2</td>\n"
            + "                             </tr>\n"
            + "                             <tr>\n"
            + "                                 <td >CODIGO:</td>\n"
            + "                                 <td >SBCPM-F-001</td>\n"
            + "                             </tr>        \n"
            + "                     </tbody>\n"
            + "                 </table>\n"
            + "             </header>\n"
            + "            \n"
            + "             <div class=\"contenido\" style=\"padding-top: 15px;\">\n"
            + "                    <p>Fecha (DD/MM/AAAA):  <u><i>@Fecha@</i></u></p>\n"
            +
            "                    <p>Yo <u><i>@Acudiente@</i></u> identificado con documento de identidad No. <u><i>@NroDocumento@</i></u>, actuando en nombre propio ( ), en representación del menor ( ) <u><i>@Paciente@</i></u> identificad@ con Documento de identidad número <u><i>@NroDocumento2@</i></u></p>   \n"
            +
            "                    <p>Que el profesional en odontología de la Clínica Santa Clara, me ha explicado que es conveniente proceder en mi situación, al tratamiento odontológico en las siguientes areas:</p>\n"
            + "                    <table class=\"with-border\" style=\"margin-right: auto; width: 100%\">\n"
            + "                        <tbody  class=\"alineacion-left\">\n"
            + "                                @LstProcedimientos@\n"
            + "                        </tbody>\n"
            + "                    </table>\n"
            + "                    <p><strong>DESCRIPCION DEL PROCEDIMIENTO</strong>\n"
            +
            "                    <p><strong>HIGIENE ORAL:</strong>  Remoción de la placa bacteriana y cálculos de sarro formados alrededor de los dientes mediante ultrasonido, y curetas de periodoncia. También, se realizará la remoción de manchas dentales extrínsecas y pulido especializado con pasta abrasiva, o bien mediante un aeropulidor con el sistema a base de bicarbonato de sodio a presión. RIESGOS: Sangrado gingival, sensibilidad dentinal, caida de restauraciones cervicales.</p>\n"
            +
            "                    <p><strong>ANESTESIA DENTAL:</strong>  La anestesia local o regional, consiste en aplicar mediante una inyección una sustancia que provoca el bloqueo reversible de los impulsos nerviosos, Interrumpiendo de esta manera la función sensitiva, con el fin de realizar un tratamiento sin dolor: Riesgos: Laseración por movimientos involuntarios del paciente, ruptura de la aguja dentro de los tejidos blandos, fracaso anestésico,  sensacion de adormecimiento que puede producir automordeduras, ocasionando trauma en los tejidos blandos, hematoma en el sitio de punción, alergia al medicamento que puede ir desde una urticaria hasta un edema angioneurótico, anestesia intravascular que puede ir desde un mareo leve, taquicardias, desmayos, dolor de cabeza, aumentos de tensión arterial que podrían ocasionar tratamientos de urgencia médica.</p>\n"
            +
            "                    <p><strong>OPERATORIA:</strong>  La Restauración con Resina de Fotocurado consiste en la eliminación de tejido dental cariado, o restauraciones desadaptadas o dientes que han recibido fracturas y requieren reconstruir la forma y la función del diente. Para ello puede requerir la aplicación de anestesia local. Es importante aclarar que la caries puede ser expansiva al interior de la misma en forma de cono, lo que hace que en muchas ocasiones se observe la estructura dentaria conservada, pero al hacer apertura, el tejido dentario interno se encuentre reblandecido expandiéndose formando una cavidad extensa. RIESGOS: Exposición pulpar al retirar la caries, lo que llevará a la necesidad de requerir un tratamiento convencional de conductos, Incluso podría existir la posibilidad de tener una microexposición que no sea detectada y ocasione una pulpitis irreversible, que tambien requerirá un tratamiento convencional de conductos. Puntos de contacto prematuros, que ocasione dolor al masticar y requiera una cita de control para realizar el correspondiente ajuste oclusal. Al realizar la preparación dental pueden quedar paredes delgadas que con la fuerza masticatoria produzca una fractura dentaria, que dependiendo de la fractura requerirá una nueva obturación con resina o una restauración fija. Falla en la higiene oral del paciente que ocasione caries recurrente.</p>\n"
            +
            "                    <p><strong>ENDODONCIA:</strong>  La Endodoncia consiste en la eliminación de tejido pulpar enfermo, previa anestesia local, ensanchamiento de los conductos, y sellado del conducto con material termoplástico que impida el paso de bacterias y toxinas infecciosas. Para ello requiere la toma de radiografía inicial, toma de conductometría a través de localizador apical, o medida del tamaño de la raíz para su respectiva preparación, obturación del conducto y radiografía de control. RIESGO: Cambio de color del diente, Fractura del tejido soporte por no realizar tratamiento restaurador despues de terminado el tratamiento endodóntico, Fractura de instrumentos dentro del conducto, Perforación de la raiz, extravasación al periapice del desinfectante utilizado en la irrigación, el diente puede presentar síndrome del diente fisurado, que es una microfractura del diente y pese al tratamiento de conductos el dolor persiste, lo que ocasiona una fractura vertical del diente terminando en extracción.</p>\n"
            + "\n"
            +
            "                    <p><strong>EXODONCIA:</strong>  Una pieza dentaria se decide extraer por fines ortodónticos para evitar apiñamiento dental, o porque la pieza dentaria ha sufrido un deterioro en su estructura que compromete la integridad del diente y que es imposible rehabilitar por su poco tejido remanente, o por falta de recurso económico para el tratamiento planteado. RIESGOS: en el momento del procedimiento pueden exisitr complicaciones como fractura radicalar, que requeriá un procedimiento quirúrgico más amplio. También puede ocasionar lesión de dientes vecinos, fractura de la tabla osea, de la tuberosidad del maxilar, del maxilar inferior, comunicación oroantral en molares superiores, tragado de pieza dentaria, desgarro de tejidos blandos, lesión de nervios, hemorragia, alveolitis, infección, inflamación.</p>\n"
            +
            "                    <p><strong>ODONTOPEDIATRIA: </strong> Para el manejo del comportamiento del menor, existen técnicas comunicativas que en presencia de padres permisivos o autoritarios, requiere la separación de los padres.\n"
            +
            "                    Siempre existirá la comunicación verbal explicando el tratamiento al menor, mostrando, diciendo y haciendo, con la finalidad que el menor conozca el procedimiento. En ocasiones se requiere una técnica restrictiva, cuando el paciente no colabora y requiere el tratamiento con urgencia y no da tiempo al proceso de adaptación, por lo cual se requerirá la presencia del padre o acudiente para que ayude a inmovilizar al paciente. RIESGOS:  El niño en el forcejeo puede salir maltratado.</p>\n"
            +
            "                    <p>Certifico que leí y entendí las indicaciones, riesgos, ventajas y beneficios inherentes a cada tratamiento,que tuve la oportunidad de resolver mis inquietudes, también que conozco el autocuidado y control respectivo al plan de tratamiento,  por lo cual conciento que me practiquen los procedimientos programados en el tratamiento odontológico aquí propuesto.</p>\n"
            +
            "                    <p>De conformidad con la política de privacidad disponible en la pág. Web www.clinicasantaclara.com, Autorizo a la CLÍNICA SANTA CLARA el tratamiento de mis datos personales,  SI@datosPersonalesSI@, NO@datosPersonalesNO@</p>\n"
            +
            "                    <p>El titular de los datos tiene derecho de conocer, actualizar, rectificar, suprimir los datos y revocar la autorización salvo las excepciones legales.</p>\n"
            + "            \n"
            + "                    <table width=\"100%\" >\n"
            + "                        <tbody>\n"
            + "                            <tr>\n"
            + "                                <td width=\"50%\">\n"
            + "                                        <div style=\"float: left; margin-top: 32px\">\n"
            + "                                            <p>Firma del usuario o acudiente:</p>\n"
            + "                                            <p>Idetificación:<u><i>@TipoDoc@ @NroDocumento@</p>\n"
            + "                                        </div>\n"
            + "                                        <div>\n"
            + "                                            <span class=\"position-firma\">\n"
            + "                                                <img class=\"img-firma\" src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE +
            "-@docSignature@." + Constantes.IMAGE_FORMAT + "\" width=\"130\" />\n"
            +
            "                                                <div class=\"subrayado\">______________________________</div>                                 \n"
            + "                                            </span>\n"
            + "                                        </div>\n"
            + "                                                    \n"
            + "                                </td>\n"
            + "                                <td width=\"50%\"  style=\"\">\n"
            + "                                        <div style=\"float: left; margin-top: 32px\">\n"
            + "                                            <p>Firma odontólogo tratante:</p>\n"
            + "                                            <p>Registro No.<u><i>@NroRegistro@</i></u></p>\n"
            + "                                        </div>\n"
            + "                                        <div>\n"
            + "                                            <span class=\"position-firma\">\n"
            + "                                                <img class=\"img-firma\" src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE +
            "-@docSignatureProfessional@." + Constantes.IMAGE_FORMAT + "\" width=\"130\" />\n"
            + "                                                <div class=\"subrayado\">______________________________</div>\n"
            //            + "                                                <div class=\"subrayado3\"><u><i>@NroRegistro@</i></u></div>\n"
            + "                                            </span>\n"
            + "                                        </div>             \n"
            + "                                </td>\n"
            + "                            </tr>\n"
            + "                        </tbody>\n"
            + "                    </table><br/>\n"
            + "                    <table width=\"100%\" class=\"with-border\">\n"
            + "                        <tbody>\n"
            + "                            <tr>\n"
            + "                                <td colspan=\"2\">\n"
            + "                                    <p>DESENTIMIENTO DEL CONSENTIMIENTO INFORMADO</p>               \n"
            + "                                </td>\n"
            + "                            </tr>\n"
            + "                            <tr>\n"
            + "                                <td colspan=\"2\">\n"
            +
            "                                    <p>Por medio del presente documento y en pleno uso de mis facultades mentales, certifico que he recibido toda la información del tratamiento propuesto, sus indicaciones, riesgos, ventajas y beneficios por parte del Profesional en Odontología de la Clínica Santa Clara y aún así otorgo en forma libre y espontánea  mi disentimiento de los siguientes procedimientos</p>               \n"
            + "                                </td>\n"
            + "                            </tr>\n"
            + "                            <tr>\n"
            + "                                <td colspan=\"2\"><p>PROCEDIMIENTOS: @desentimientos@</p></td>\n"
            + "                            </tr>\n"
            + "                            <tr>\n"
            +
            "                                <td colspan=\"2\"><p>Entiendo que estos procedimientos hacen parte del tratamiento instaurado, me ha sido explicada las implicaciones y posibles complicaciones por su no realización. No obstante me niego al mismo, asumiendo los riesgos bajo mi propia responsabilidad.</p></td>\n"
            + "                            </tr>\n"
            + "                            <tr>\n"
            + "                                <td colspan=\"1\" width=\"50%\">\n"
            + "                                        <div style=\"float: left; margin-top: 32px\">\n"
            + "                                            <p>Firma del usuario o acudiente:</p>\n"
            +
            "                                            <p>Idetificación:<u style=\"display:@displayFirma@\"><i>@TipoDoc@ @NroDocumento@</p>\n"
            + "                                        </div>\n"
            + "                                        <div>\n"
            + "                                            <span class=\"position-firma\">\n"
            + "                                                <img style=\"display:@displayFirma@\" class=\"img-firma\" src=\"" +
            PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignature@." + Constantes.IMAGE_FORMAT + "\" width=\"130\" />\n"
            +
            "                                                <div class=\"subrayado\">______________________________</div>                                 \n"
            + "                                            </span>\n"
            + "                                        </div>\n"
            + "                                                    \n"
            + "                                </td>\n"
            + "                                <td colspan=\"1\" width=\"50%\">\n"
            + "                                        <div style=\"float: left; margin-top: 32px\">\n"
            + "                                            <p>Firma odontólogo tratante:</p>\n"
            +
            "                                            <p>Registro No.<u style=\"display:@displayFirma@\"><i>@NroRegistro@</i></u></p>\n"
            + "                                        </div>\n"
            + "                                        <div>\n"
            + "                                            <span class=\"position-firma\">\n"
            + "                                                <img style=\"display:@displayFirma@\" class=\"img-firma\" src=\"" +
            PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignatureProfessional@." + Constantes.IMAGE_FORMAT + "\" width=\"130\" />\n"
            + "                                                <div class=\"subrayado\">______________________________</div>\n"
            + "                                            </span>\n"
            + "                                        </div>             \n"
            + "                                </td>\n"
            + "                            </tr>\n"
            + "                        </tbody>\n"
            + "                    </table>\n"
            + "             </div>\n"
            + "            </div>\n"
            + "            </body>\n"
            + "            </html>";

    public DentalConsent(Configuration configuration, List<Area> areasList) {
        super(configuration);
        setTypeConsent(TYPE);
        setAreasList(areasList);
    }

    @Override
    public String dataValidation() {
        if (this.getPatient() != null
                && this.getPatient().getDocumentNumber() != null
                && this.getPatient().getDocumentNumber().equals("")
                && !this.getPatient().getDocumentNumber().matches(Constantes.REGEX_DOCUMENTO)) {
            return "Ingrese un nro de documento válido para el paciente";

        }
        if (this.getPatient() != null
                && this.getPatient().getName() != null
                && this.getPatient().getName().equals("")
                && !this.getPatient().getName().matches(Constantes.REGEX_NOMBRE)) {
            return "Ingrese un nombre válido para el paciente";

        }
        if (isGuardian() && this.getPatient() != null
                && this.getPatient().getGuardian() != null
                && this.getPatient().getGuardian().getDocumentNumber() != null
                && this.getPatient().getGuardian().getDocumentNumber().equals("")
                && !this.getPatient().getGuardian().getDocumentNumber().matches(Constantes.REGEX_DOCUMENTO)) {
            return "Ingrese un nro de documento válido para el acudiente";

        }
        if (isGuardian()
                && this.getPatient().getGuardian() != null
                && this.getPatient().getGuardian().getName() != null
                && this.getPatient().getGuardian().getName().equals("")
                && !this.getPatient().getGuardian().getName().matches(Constantes.REGEX_NOMBRE)) {
            return "Ingrese un nombre válido para el acudiente";

        }

        if (this.getProfessional().getRegistryNumber() != null
                && !this.getProfessional().getRegistryNumber().toString().matches(Constantes.REGEX_DIGITO)) {
            return "Ingrese un valor válido para la Nro de registro";

        }
        if (this.getSignature() == null || this.getSignature().equals("")) {
            return "Ingrese la firma";

        }
        return null;
    }

    @Override
    public String getFormat() {
        String html;
        String areaTable=areasTableBuilder(1);
        if (this.isGuardian()) {
            html = FORMAT_DOCUMENT_WITH_GUARDIAN.replace("@docSignature@", this.getSignatureConsent());
        } else {
            html = FORMAT_DOCUMENT_WITHOUT_GUARDIAN.replace("@docSignature@", this.getSignatureConsent());
        }
        html = html.replace("@LstProcedimientos@", areaTable);
        html = html.replace("@Fecha@", this.getDate("dd/MM/yyyy"));
        html = html.replace("@Dia@", this.getDay() + " " + this.getDate("dd"));
        html = html.replace("@Mes@", this.getMonth());
        html = html.replace("@Anio@", this.getDate("yyyy"));
        html = html.replace("@TipoDoc@",
                (isGuardian() ? this.getGuardianData().getDocumentType().getInitials() : this.getPatient().getDocumentType().getInitials()));
        html = html.replace("@NroDocumento@",
                (isGuardian() ? this.getGuardianData().getDocumentNumber() : this.getPatient().getDocumentNumber()));
        html = html.replace("@NroDocumento2@", (isGuardian() ? this.getPatient().getDocumentNumber() : ""));
        html = html.replace("@Acudiente@", (isGuardian() ? this.getGuardianData().getName() : ""));
        html = html.replace("@Paciente@", this.getPatient().getName());
        html = html.replace("@datosPersonalesSI@", this.getDataTreatment() ? "<u><i>X</i></u>" : "_");
        html = html.replace("@datosPersonalesNO@", this.getDataTreatment() ? "_" : "<u><i>X</i></u>");
        html = html.replace("@NroRegistro@", this.getProfessional().getRegistryNumber().toString());


        if (this.getArea() != null) {
            html = html.replace("@area" + this.getArea().getId() + "@", "<div align=\"center\">X</div>");
            html = html.replaceAll("@area\\d+@", "");
        }

        if (this.getDisagree()) {
            String dissentsHtml = "";
            for (Process dissent : this.getDissents()) {
                dissentsHtml = dissentsHtml + (dissentsHtml.equals("") ? dissent.getDescription() : ", " + dissent.getDescription());
            }
            html = html.replace("@desentimientos@", dissentsHtml);
            html = html.replace("@displayFirma@", "block");
        } else {
            html = html.replace("@displayFirma@", "none");
            html = html.replace("@desentimientos@", "");
        }
        return html;
    }

    @Override
    public String getUrl() {
        return URL;
    }

    public String areasTableBuilder(int columna) {
        int index;
        StringBuilder tableHtml = new StringBuilder();
        double shells = Math.ceil((double) areasList.size() / (double) columna) * columna;

        tableHtml.append("<tr>\n");
        tableHtml.append("<td width=\"20\"></td>\n");
        tableHtml.append("<td width=\"30\"><center>Área</center></td>\n");
        tableHtml.append("<td width=\"50\"><center>Detalle del procedimiento</center></td>\n");
        tableHtml.append("</tr>\n");

        for (int i = 1; i <= shells; i++) {
            index = i - 1;
            if (i % columna == 1) {
                tableHtml.append("<tr>\n");
            }
            if (areasList.size() > index) {
                tableHtml.append("<td width=\"20\">@area").append(areasList.get(index).getId()).append("@</td>\n");
                tableHtml.append("<td>").append(areasList.get(index).getName()).append("</td>\n");
                tableHtml.append("<td>");
                if (areasList.get(index).equals(this.getArea())) {
                    boolean firstProcedure = true;
                    for (Process procedure : this.getProcesses()) {
                        if (procedure.getIdProcess() != Integer.parseInt(Constantes.ID_OTRO_PROCEDIMIENTO)) {
                            tableHtml.append(firstProcedure ? procedure.getDescription() : " - " + procedure.getDescription());
                            firstProcedure = false;
                        }
                    }
                }
                tableHtml.append("</td>\n");

            } else {
                tableHtml.append("<td width=\"20\"></td>\n");
                tableHtml.append("<td></td>\n");
            }
            if (i % columna == 0) {
                tableHtml.append("</tr>\n");
            }
        }
        return tableHtml.toString();
    }

    public List<Area> getAreasList() {
        return areasList;
    }

    public void setAreasList(List<Area> areasList) {
        this.areasList = areasList;
    }
}
