package core.domain.consent;

import app.config.Configuration;
import core.domain.area.Area;
import core.domain.bus.command.Command;
import core.domain.process.Process;
import java.util.List;

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
            + "                                 <td >29/11/2024</td>\n"
            + "                             </tr>\n"
            + "                             <tr>\n"
            + "                                 <td  rowspan=\"2\" >CONSENTIMIENTO - DESENTIMIENTO INFORMADO TRATAMIENTO ODONTOLOGIO</td>\n"
            + "                                 <td  >VERSION:</td>\n"
            + "                                 <td >2</td>\n"
            + "                             </tr>\n"
            + "                             <tr>\n"
            + "                                 <td >CODIGO:</td>\n"
            + "                                 <td >SBCCE-F-004</td>\n"
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
            "                    <p><strong>ODONTOPEDIATRIA: </strong> Para el manejo del comportamiento del menor, existen técnicas comunicativas que en presencia de padres permisivos o autoritarios, requiere la separación de los padres.Siempre existirá la comunicación verbal explicando el tratamiento al menor, mostrando, diciendo y haciendo, con la finalidad que el menor conozca el procedimiento. En ocasiones se requiere una técnica restrictiva, cuando el paciente no colabora y requiere el tratamiento con urgencia y no da tiempo al proceso de adaptación, por lo cual se requerirá la presencia del padre o acudiente para que ayude a inmovilizar al paciente. RIESGOS: El niño en el forcejeo puede salir maltratado.</p>\n"
            +
            "                    <p><strong>REHABILITACION ORAL,PROTESIS FIJAS (Coronas, Puentes, Carillas e Incrustaciones): </strong> Elijo realizar un puente fijo o implantar un reemplazo de los dientes perdidos en vez de un aparato removible. Entiendo que este puente fijo o implante y la corona pueden no estar incluidos dentro de la cobertura de mi tratamiento odontológico. Se me ha informado que es necesario tallar el esmalte del diente o de los dientes, como preparación para la restauración, entiendo que a veces no es posible duplicar el color de un diente natural en un diente artificial. Comprendo además que puedo tener que usar coronas temporarias (dientes provisionales), las cuales pueden desprenderse fácilmente, y que debo ser cuidadoso para garantizar que permanezcan fijas hasta que me entreguen las coronas permanentes. Sé que al momento previo a la cementación será la última oportunidad para realizar modificaciones en mi corona, puentes o carillas nuevos (incluye forma, adaptación, tamaño y color). Se me ha explicado que, en muy pocos casos, los procedimientos cosméticos pueden producir la necesidad de un futuro tratamiento de conducto radicular, el cual no siempre puede detectarse con anticipación o pronosticarse. Entiendo que los procedimientos cosméticos pueden afectar la superficie del diente y requerir modificaciones en los procesos de higiene diaria, y me comprometo adquirir los hábitos de higiene que me sean sugeridos de acuerdo a mi prótesis, ya que es parte fundamental en la duración del tratamiento. También es mi responsabilidad regresar al odontólogo para una cementación permanente dentro de los 20 días posteriores al alistamiento del diente. Demoras excesivas en la visita al odontólogo pueden causar caries, movimientos dentales, enfermedades de encía o problemas de mordida. Esto puede requerir una nueva corona, puente o carilla u otro tratamiento debido a la demora en realizar la cementación permanente.\n" +
            "El Dr. me ha explicado las diferentes alternativas de tratamiento, sus costos y promedios de duración con un adecuado mantenimiento. Entiendo que mi tratamiento odontológico, debe tener como mínimo un cuidado dental. Elijo seguir las recomendaciones del Odontólogo relacionadas con un tratamiento dental óptimo. Entiendo que la Odontología no es una ciencia exacta y que en consecuencia, aun los profesionales más respetados no pueden garantizar los resultados. Entiendo que cada odontólogo (a) es un profesional individual y que es individualmente responsable por la atención dental que me otorga. Reconozco haber recibido toda la información correspondiente a mi tratamiento por parte del Odontólogo (a) responsable de mi tratamiento dental.</p>\n\n"
            +
            "                    <p><strong>PROTESIS TOTAL O PARCIAL REMOVIBLE: </strong> Las Prótesis Total o parcial removible están fabricadas de acrílico, DEFLEX o valplast, metálicas o combinaciones entre estas y requieren de un trato adecuado y son sensibles a fracturarse cuando se dejan caer o ser aplastadas.\n" +
            "He recibido información detallada sobre los problemas de usar este tipo de prótesis removibles como: dificultades para masticar o hablar inicialmente mientras la musculatura se adapta, movilidad de los dientes de soporte (dolor posible fractura). Es posible que deba asistir a varias citas odontológicas para tratar de remediar estos problemas. \n" +
            "Entiendo que NO todas las personas tienen la capacidad de adaptarse a las prótesis totales y/o parciales removibles y esto no implica devolución de dinero. Es posible que requiera modificaciones en los procesos de higiene diario, y me comprometo a adquirir hábitos de higiene que me sean sugeridos de acuerdo a mi prótesis; ya que es parte fundamental en la adaptación de la prótesis removible y en la conservación de los dientes adyacentes y tejidos circundantes.\n" +
            "Comprendo que la cita odontológica para la prueba de dientes en cera  (enfilado) será la última oportunidad para realizar modificaciones en mi nueva prótesis parcial y/o total removible (incluye forma, adaptación, tamaño, colocación y color).\n" +
            "Entiendo que en algunos casos, las prótesis total y/o parcial removible necesitan ser rebasadas a los días, semanas o meses después de su colocación inicial, este es un procedimiento que permite ajustar la base de una prótesis a los tejidos que prestan asiento, mediante la interposición de un material que `pasa a formar parte de la base de la prótesis. El costo de este procedimiento no está incluido en el costo inicial de la protesis. \n" +
            "El Dr. me ha explicado las diferentes alternativas de tratamiento, sus costos y promedios de duración con un adecuado mantenimiento. Entiendo que la Odontología no es una ciencia exacta y que en consecuencia, aun los profesionales más respetados no pueden garantizar los resultados. Entiendo que cada odontólogo (a) es un profesional individual y que es individualmente responsable por la atención dental que me otorga. Reconozco haber recibido toda la información correspondiente a mi tratamiento por parte del Odontólogo (a) responsable de mi tratamiento dental.</p>\n\n"
            +
            "                    <p><strong>ACLARAMIENTO  EN CONSULTORIO ODONTOLOGICO: </strong> El aclaramiento dental está diseñado para aclarar el color de sus dientes, usando una mezcla de Peróxido de Hidrogeno. Este produce un máximo aclaramiento en el menor tiempo con la mínima sensibilidad. Durante el procedimiento, el gel aclarador será aplicado en sus dientes de 3 a 4 sesiones de 20 minutos cada una. Durante todo el procedimiento un retractor de mejillas será colocado en su boca para ayudarlo a mantenerla abierta, y sus encías serán cubiertas por una barrera protectora para asegurar el aislamiento del gel de Peróxido de Hidrogeno. Antes y Después del tratamiento, el color de sus dientes será registrado.\n" +
            "\n" +
            "Riesgos: \n" +
            "Sensibilidad Dental, algunos pacientes experimentan sensibilidad dental. Esto es normal y generalmente suaves si sus dientes normalmente no son sensibles. Si sus dientes son normalmente sensibles, por favor informar antes del tratamiento ya que con un suave analgésico será efectivo para eliminar la molestia. \n" +
            "Irritación de la Encía y/o tejidos: Se puede causar irritación de su encía, labios o comisuras labiales; esto es el resultado del contacto del gel con los tejidos. Materiales protectores será colocados en su boca para prevenir esto, pero a pesar de los mejores esfuerzos puede raramente ocurrir filtración del producto. Si la irritación ocurre, es generalmente de corta duración y suave.\n" +
            "Restauraciones Existentes: Obturaciones blancas, restauraciones de porcelana o resina, coronas, carillas no aclararan o no lo harán de manera pareja con sus dientes naturales. Si tiene alguna inquietud al respecto hable con su odontólogo antes de realizar el Aclaramiento Dental.\n" +
            "\n" +
            "Expectativas: Un Aclaramiento Dental significativo puede ser logrado en la mayoría de los casos, pero no hay ninguna forma de predecir que tan blancos sus dientes van a quedar. Por favor entienda que los dientes con múltiples colores como: bandas, manchas generadas por fluorosis o pigmentos en sus dientes no tendrán un cambio significativo durante el aclaramiento dental.\n" +
            "Importante: El Aclaramiento Dental en el consultorio no está recomendado para mujeres embarazadas ni lactando, niños menores de 14 años o cualquier persona que sea alérgico al Peróxido de Hidrogeno.\n" +
            "Tratamientos Alternativos: Aunque recomendamos el aclaramiento dental en consultorio odontológico, existen otras alternativas en el mercado disponibles para Uds, tales como Aclaramiento caseros. \n" +
            "Yo entiendo que el Aclaramiento Dental en el consultorio odontológico no puede ser garantizado y que este depende de los cuidados que yo tenga después de finalizado tales como abstenerme de consumir cualquier sustancia cromo génica, por ejemplo: salsas, bebidas oscuras, carotenos durante las siguientes 72 horas.\n" +
            "He comprendido las explicaciones que se me han facilitado en un lenguaje claro y sencillo, y el odontólogo (a) que me ha atendido me ha permitido realizar todas las observaciones y me ha aclarado todas las dudas que le he planteado. También comprendo que, en cualquier momento y sin necesidad de dar ninguna explicación, puedo revocar el consentimiento que ahora presto.\n</p>\n\n"
            +"                    <p><strong>ORTODONCIA FIJA / ORTOPEDIA MAXILAR: </strong> Los Beneficios y Ventajas que tenemos con el tratamiento son: Previene y corrige irregularidades dentales y faciales con el propósito de brindarle al paciente: 1.Una correcta oclusión (corregir dientes  apiñados, torcidos, salidos, etc.). 2. Mejorar la Estética facial y dental. (Aumentar la autoestima-mejora su imagen). 3. Mejorar la función masticatoria. 4. Facilitar la limpieza de los dientes, (Reduciendo la posibilidad de caries y problemas en las encías y huesos).\n" +
            "También, me han advertido de los posibles efectos colaterales de los aparatos de ortodoncia  fijos o removibles, que  pueden ocasionar la irritación o inflamación de la mucosa bucal (de 24 a 48 horas aproximadamente), si pasa de este tiempo se debe informar al ortodoncista, de igual manera  dolor y molestias al masticar en los primeros días después de colocar la aparatología. \n" +
            "Los riesgos previstos que se pueden presentar durante mi tratamiento de ortopedia y/o ortodoncia son:\n" +
            "Las bandas fijas pueden producir irritación, inflamación y ulceras y que es posible que con el tiempo se produzca una reabsorción de la raíz, retracción en la encia que debe de ser objeto de tratamiento posterior.\n" +
            "El procedimiento implica una serie de riesgos como caries, descalcificaciones, inflamación de las encías, disminución del tamaño de las raíces y del hueso, dolores en las articulaciones, dolor de cabeza u oídos, reactivación de lesiones preexistentes del nervio del diente, reabsorción radicular y micro fracturas del esmalte.\n" +
            "El tiempo total estimado para terminar el tratamiento puede ser mayor al que se ha planeado, debido al crecimiento excesivo o deficiente del hueso, la poca cooperación en el uso de los aparatos o colocación de elásticos durante las horas requeridas por día, la higiene bucal insuficiente, los aditamentos rotos  y el no acudir regularmente a las consultas afectan el tiempo de duración del tratamiento y la calidad de los resultados definitivos.\n" +
            "Además existen otros  riesgos y molestias del tratamiento muy poco frecuentes, pero que pueden ser graves e incluso fatales. Certifico que he formulado preguntas referentes a mi condición clínica y tratamiento a realizar, las cuales se me han contestado de manera comprensible para mi. \n" +
            "En caso de abandono del tratamiento se pueden presentar daños en el paciente, tales como los anteriormente mencionados.\n" +
            "El paciente se hace responsable de los perjuicios derivados del abandono del tratamiento y por ende del no seguimiento de las recomendaciones del ortodoncista tratante.\n" +
            "Entiendo que el costo de mi tratamiento solo cubre lo realizado por el ortodoncista, y no incluye procedimientos que requieran odontología general, extracciones, rayos x, u otros procedimientos quirúrgicos  a pesar de que se deban realizar consecuentemente con el tratamiento ortodoncico.\n" +
            "Acepto que se harán cargos adicionales en caso de pérdida de aparatología o daño  por mal uso o mal trato, aparatos adicionales que se requieran para el tratamiento, brackets perdidos y retenedores que se requieran al finalizar el tratamiento  de ortodoncia.\n\n"
            +"                    <p><strong>PLACA NEUROMIORELAJANTE/PLACA DE BRUXISMO: </strong> Se le ha recomendado el uso de una placa neuromiorelajante o de bruxismo. Este dispositivo está diseñado para proteger los dientes y las estructuras orales durante el descanso nocturno o diurno, reducir el desgaste dental, y aliviar la tensión muscular en la mandíbula asociada con el bruxismo (rechinar o apretar los dientes).\n" +
            "Objetivo del tratamiento: Proteger los dientes del desgaste excesivo. Aliviar los síntomas de dolor en la mandíbula, cuello o cabeza.Reducir la actividad muscular excesiva durante el sueño.Prevenir o minimizar el daño a los tejidos blandos y duros de la cavidad oral.\n" +
            "Riesgos y complicaciones posibles: Irritación o incomodidad inicial en la boca y encías. Aumento de la salivación. Cambios temporales en la mordida al retirar la placa. Dificultad para adaptarse al uso de la placa durante las primeras semanas. Riesgo de daño o fractura del dispositivo si no se manipula adecuadamente. En casos raros, puede ocurrir exacerbación del dolor o disfunción temporomandibular.\n" +
            "Alternativas al tratamiento: Técnicas de relajación o fisioterapia para aliviar el estrés mandibular. Medicamentos para el control del dolor o relajantes musculares. No realizar tratamiento, con el posible riesgo de progresión de los síntomas y daño dental.\n" +
            "Cuidados y recomendaciones: Usar la placa según las indicaciones proporcionadas por su odontólogo. Limpiar la placa diariamente con agua y jabón neutro, y almacenarla en un lugar adecuado. Asistir a las citas de seguimiento para ajustes o revisiones necesarias. Reportar cualquier incomodidad o problema relacionado con el uso de la placa.\n" +
            "He leído y comprendido la información proporcionada sobre el uso de la placa neuromiorelajante o de bruxismo. Se me han explicado los beneficios, riesgos y alternativas al tratamiento. Entiendo que puedo retirar mi consentimiento en cualquier momento, y que tengo derecho a hacer preguntas en cualquier etapa del tratamiento.\n\n\n"
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
            + "                                            <p>Identificación:<u><i>@TipoDoc@ @NroDocumento@</p>\n"
            + "                                        </div>\n"
            + "                                        <div>\n"
            + "                                            <span class=\"position-firma\">\n"
            + "                                                <img class=\"img-firma\" src=\"" + PATH_IMAGES_APP + NAME_SIGNATURE +
            "-@docSignature@." + IMAGE_FORMAT + "\" width=\"130\" />\n"
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
            "-@docSignatureProfessional@." + IMAGE_FORMAT + "\" width=\"130\" />\n"
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
            "                                            <p>Identificación:<u style=\"display:@displayFirma@\"><i>@TipoDoc@ @NroDocumento@</p>\n"
            + "                                        </div>\n"
            + "                                        <div>\n"
            + "                                            <span class=\"position-firma\">\n"
            + "                                                <img style=\"display:@displayFirma@\" class=\"img-firma\" src=\"" +
            PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignature@." + IMAGE_FORMAT + "\" width=\"130\" />\n"
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
            PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignatureProfessional@." + IMAGE_FORMAT + "\" width=\"130\" />\n"
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
            + "                                 <td >29/11/2024</td>\n"
            + "                             </tr>\n"
            + "                             <tr>\n"
            + "                                 <td  rowspan=\"2\" >CONSENTIMIENTO - DESENTIMIENTO INFORMADO TRATAMIENTO ODONTOLOGIO</td>\n"
            + "                                 <td  >VERSION:</td>\n"
            + "                                 <td >2</td>\n"
            + "                             </tr>\n"
            + "                             <tr>\n"
            + "                                 <td >CODIGO:</td>\n"
            + "                                 <td >SBCCE-F-004</td>\n"
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
            "                    <p><strong>ODONTOPEDIATRIA: </strong> Para el manejo del comportamiento del menor, existen técnicas comunicativas que en presencia de padres permisivos o autoritarios, requiere la separación de los padres.Siempre existirá la comunicación verbal explicando el tratamiento al menor, mostrando, diciendo y haciendo, con la finalidad que el menor conozca el procedimiento. En ocasiones se requiere una técnica restrictiva, cuando el paciente no colabora y requiere el tratamiento con urgencia y no da tiempo al proceso de adaptación, por lo cual se requerirá la presencia del padre o acudiente para que ayude a inmovilizar al paciente. RIESGOS: El niño en el forcejeo puede salir maltratado.</p>\n"
            +
            "                    <p><strong>REHABILITACION ORAL,PROTESIS FIJAS (Coronas, Puentes, Carillas e Incrustaciones): </strong> Elijo realizar un puente fijo o implantar un reemplazo de los dientes perdidos en vez de un aparato removible. Entiendo que este puente fijo o implante y la corona pueden no estar incluidos dentro de la cobertura de mi tratamiento odontológico. Se me ha informado que es necesario tallar el esmalte del diente o de los dientes, como preparación para la restauración, entiendo que a veces no es posible duplicar el color de un diente natural en un diente artificial. Comprendo además que puedo tener que usar coronas temporarias (dientes provisionales), las cuales pueden desprenderse fácilmente, y que debo ser cuidadoso para garantizar que permanezcan fijas hasta que me entreguen las coronas permanentes. Sé que al momento previo a la cementación será la última oportunidad para realizar modificaciones en mi corona, puentes o carillas nuevos (incluye forma, adaptación, tamaño y color). Se me ha explicado que, en muy pocos casos, los procedimientos cosméticos pueden producir la necesidad de un futuro tratamiento de conducto radicular, el cual no siempre puede detectarse con anticipación o pronosticarse. Entiendo que los procedimientos cosméticos pueden afectar la superficie del diente y requerir modificaciones en los procesos de higiene diaria, y me comprometo adquirir los hábitos de higiene que me sean sugeridos de acuerdo a mi prótesis, ya que es parte fundamental en la duración del tratamiento. También es mi responsabilidad regresar al odontólogo para una cementación permanente dentro de los 20 días posteriores al alistamiento del diente. Demoras excesivas en la visita al odontólogo pueden causar caries, movimientos dentales, enfermedades de encía o problemas de mordida. Esto puede requerir una nueva corona, puente o carilla u otro tratamiento debido a la demora en realizar la cementación permanente.\n" +
            "El Dr. me ha explicado las diferentes alternativas de tratamiento, sus costos y promedios de duración con un adecuado mantenimiento. Entiendo que mi tratamiento odontológico, debe tener como mínimo un cuidado dental. Elijo seguir las recomendaciones del Odontólogo relacionadas con un tratamiento dental óptimo. Entiendo que la Odontología no es una ciencia exacta y que en consecuencia, aun los profesionales más respetados no pueden garantizar los resultados. Entiendo que cada odontólogo (a) es un profesional individual y que es individualmente responsable por la atención dental que me otorga. Reconozco haber recibido toda la información correspondiente a mi tratamiento por parte del Odontólogo (a) responsable de mi tratamiento dental.</p>\n\n"
            +
            "                    <p><strong>PROTESIS TOTAL O PARCIAL REMOVIBLE: </strong> Las Prótesis Total o parcial removible están fabricadas de acrílico, DEFLEX o valplast, metálicas o combinaciones entre estas y requieren de un trato adecuado y son sensibles a fracturarse cuando se dejan caer o ser aplastadas.\n" +
            "He recibido información detallada sobre los problemas de usar este tipo de prótesis removibles como: dificultades para masticar o hablar inicialmente mientras la musculatura se adapta, movilidad de los dientes de soporte (dolor posible fractura). Es posible que deba asistir a varias citas odontológicas para tratar de remediar estos problemas. \n" +
            "Entiendo que NO todas las personas tienen la capacidad de adaptarse a las prótesis totales y/o parciales removibles y esto no implica devolución de dinero. Es posible que requiera modificaciones en los procesos de higiene diario, y me comprometo a adquirir hábitos de higiene que me sean sugeridos de acuerdo a mi prótesis; ya que es parte fundamental en la adaptación de la prótesis removible y en la conservación de los dientes adyacentes y tejidos circundantes.\n" +
            "Comprendo que la cita odontológica para la prueba de dientes en cera  (enfilado) será la última oportunidad para realizar modificaciones en mi nueva prótesis parcial y/o total removible (incluye forma, adaptación, tamaño, colocación y color).\n" +
            "Entiendo que en algunos casos, las prótesis total y/o parcial removible necesitan ser rebasadas a los días, semanas o meses después de su colocación inicial, este es un procedimiento que permite ajustar la base de una prótesis a los tejidos que prestan asiento, mediante la interposición de un material que `pasa a formar parte de la base de la prótesis. El costo de este procedimiento no está incluido en el costo inicial de la protesis. \n" +
            "El Dr. me ha explicado las diferentes alternativas de tratamiento, sus costos y promedios de duración con un adecuado mantenimiento. Entiendo que la Odontología no es una ciencia exacta y que en consecuencia, aun los profesionales más respetados no pueden garantizar los resultados. Entiendo que cada odontólogo (a) es un profesional individual y que es individualmente responsable por la atención dental que me otorga. Reconozco haber recibido toda la información correspondiente a mi tratamiento por parte del Odontólogo (a) responsable de mi tratamiento dental.</p>\n\n"
            +
            "                    <p><strong>ACLARAMIENTO  EN CONSULTORIO ODONTOLOGICO: </strong> El aclaramiento dental está diseñado para aclarar el color de sus dientes, usando una mezcla de Peróxido de Hidrogeno. Este produce un máximo aclaramiento en el menor tiempo con la mínima sensibilidad. Durante el procedimiento, el gel aclarador será aplicado en sus dientes de 3 a 4 sesiones de 20 minutos cada una. Durante todo el procedimiento un retractor de mejillas será colocado en su boca para ayudarlo a mantenerla abierta, y sus encías serán cubiertas por una barrera protectora para asegurar el aislamiento del gel de Peróxido de Hidrogeno. Antes y Después del tratamiento, el color de sus dientes será registrado.\n" +
            "\n" +
            "Riesgos: \n" +
            "Sensibilidad Dental, algunos pacientes experimentan sensibilidad dental. Esto es normal y generalmente suaves si sus dientes normalmente no son sensibles. Si sus dientes son normalmente sensibles, por favor informar antes del tratamiento ya que con un suave analgésico será efectivo para eliminar la molestia. \n" +
            "Irritación de la Encía y/o tejidos: Se puede causar irritación de su encía, labios o comisuras labiales; esto es el resultado del contacto del gel con los tejidos. Materiales protectores será colocados en su boca para prevenir esto, pero a pesar de los mejores esfuerzos puede raramente ocurrir filtración del producto. Si la irritación ocurre, es generalmente de corta duración y suave.\n" +
            "Restauraciones Existentes: Obturaciones blancas, restauraciones de porcelana o resina, coronas, carillas no aclararan o no lo harán de manera pareja con sus dientes naturales. Si tiene alguna inquietud al respecto hable con su odontólogo antes de realizar el Aclaramiento Dental.\n" +
            "\n" +
            "Expectativas: Un Aclaramiento Dental significativo puede ser logrado en la mayoría de los casos, pero no hay ninguna forma de predecir que tan blancos sus dientes van a quedar. Por favor entienda que los dientes con múltiples colores como: bandas, manchas generadas por fluorosis o pigmentos en sus dientes no tendrán un cambio significativo durante el aclaramiento dental.\n" +
            "Importante: El Aclaramiento Dental en el consultorio no está recomendado para mujeres embarazadas ni lactando, niños menores de 14 años o cualquier persona que sea alérgico al Peróxido de Hidrogeno.\n" +
            "Tratamientos Alternativos: Aunque recomendamos el aclaramiento dental en consultorio odontológico, existen otras alternativas en el mercado disponibles para Uds, tales como Aclaramiento caseros. \n" +
            "Yo entiendo que el Aclaramiento Dental en el consultorio odontológico no puede ser garantizado y que este depende de los cuidados que yo tenga después de finalizado tales como abstenerme de consumir cualquier sustancia cromo génica, por ejemplo: salsas, bebidas oscuras, carotenos durante las siguientes 72 horas.\n" +
            "He comprendido las explicaciones que se me han facilitado en un lenguaje claro y sencillo, y el odontólogo (a) que me ha atendido me ha permitido realizar todas las observaciones y me ha aclarado todas las dudas que le he planteado. También comprendo que, en cualquier momento y sin necesidad de dar ninguna explicación, puedo revocar el consentimiento que ahora presto.\n</p>\n\n"
            +"                    <p><strong>ORTODONCIA FIJA / ORTOPEDIA MAXILAR: </strong> Los Beneficios y Ventajas que tenemos con el tratamiento son: Previene y corrige irregularidades dentales y faciales con el propósito de brindarle al paciente: 1.Una correcta oclusión (corregir dientes  apiñados, torcidos, salidos, etc.). 2. Mejorar la Estética facial y dental. (Aumentar la autoestima-mejora su imagen). 3. Mejorar la función masticatoria. 4. Facilitar la limpieza de los dientes, (Reduciendo la posibilidad de caries y problemas en las encías y huesos).\n" +
            "También, me han advertido de los posibles efectos colaterales de los aparatos de ortodoncia  fijos o removibles, que  pueden ocasionar la irritación o inflamación de la mucosa bucal (de 24 a 48 horas aproximadamente), si pasa de este tiempo se debe informar al ortodoncista, de igual manera  dolor y molestias al masticar en los primeros días después de colocar la aparatología. \n" +
            "Los riesgos previstos que se pueden presentar durante mi tratamiento de ortopedia y/o ortodoncia son:\n" +
            "Las bandas fijas pueden producir irritación, inflamación y ulceras y que es posible que con el tiempo se produzca una reabsorción de la raíz, retracción en la encia que debe de ser objeto de tratamiento posterior.\n" +
            "El procedimiento implica una serie de riesgos como caries, descalcificaciones, inflamación de las encías, disminución del tamaño de las raíces y del hueso, dolores en las articulaciones, dolor de cabeza u oídos, reactivación de lesiones preexistentes del nervio del diente, reabsorción radicular y micro fracturas del esmalte.\n" +
            "El tiempo total estimado para terminar el tratamiento puede ser mayor al que se ha planeado, debido al crecimiento excesivo o deficiente del hueso, la poca cooperación en el uso de los aparatos o colocación de elásticos durante las horas requeridas por día, la higiene bucal insuficiente, los aditamentos rotos  y el no acudir regularmente a las consultas afectan el tiempo de duración del tratamiento y la calidad de los resultados definitivos.\n" +
            "Además existen otros  riesgos y molestias del tratamiento muy poco frecuentes, pero que pueden ser graves e incluso fatales. Certifico que he formulado preguntas referentes a mi condición clínica y tratamiento a realizar, las cuales se me han contestado de manera comprensible para mi. \n" +
            "En caso de abandono del tratamiento se pueden presentar daños en el paciente, tales como los anteriormente mencionados.\n" +
            "El paciente se hace responsable de los perjuicios derivados del abandono del tratamiento y por ende del no seguimiento de las recomendaciones del ortodoncista tratante.\n" +
            "Entiendo que el costo de mi tratamiento solo cubre lo realizado por el ortodoncista, y no incluye procedimientos que requieran odontología general, extracciones, rayos x, u otros procedimientos quirúrgicos  a pesar de que se deban realizar consecuentemente con el tratamiento ortodoncico.\n" +
            "Acepto que se harán cargos adicionales en caso de pérdida de aparatología o daño  por mal uso o mal trato, aparatos adicionales que se requieran para el tratamiento, brackets perdidos y retenedores que se requieran al finalizar el tratamiento  de ortodoncia.\n\n"
            +"                    <p><strong>PLACA NEUROMIORELAJANTE/PLACA DE BRUXISMO: </strong> Se le ha recomendado el uso de una placa neuromiorelajante o de bruxismo. Este dispositivo está diseñado para proteger los dientes y las estructuras orales durante el descanso nocturno o diurno, reducir el desgaste dental, y aliviar la tensión muscular en la mandíbula asociada con el bruxismo (rechinar o apretar los dientes).\n" +
            "Objetivo del tratamiento: Proteger los dientes del desgaste excesivo. Aliviar los síntomas de dolor en la mandíbula, cuello o cabeza.Reducir la actividad muscular excesiva durante el sueño.Prevenir o minimizar el daño a los tejidos blandos y duros de la cavidad oral.\n" +
            "Riesgos y complicaciones posibles: Irritación o incomodidad inicial en la boca y encías. Aumento de la salivación. Cambios temporales en la mordida al retirar la placa. Dificultad para adaptarse al uso de la placa durante las primeras semanas. Riesgo de daño o fractura del dispositivo si no se manipula adecuadamente. En casos raros, puede ocurrir exacerbación del dolor o disfunción temporomandibular.\n" +
            "Alternativas al tratamiento: Técnicas de relajación o fisioterapia para aliviar el estrés mandibular. Medicamentos para el control del dolor o relajantes musculares. No realizar tratamiento, con el posible riesgo de progresión de los síntomas y daño dental.\n" +
            "Cuidados y recomendaciones: Usar la placa según las indicaciones proporcionadas por su odontólogo. Limpiar la placa diariamente con agua y jabón neutro, y almacenarla en un lugar adecuado. Asistir a las citas de seguimiento para ajustes o revisiones necesarias. Reportar cualquier incomodidad o problema relacionado con el uso de la placa.\n" +
            "He leído y comprendido la información proporcionada sobre el uso de la placa neuromiorelajante o de bruxismo. Se me han explicado los beneficios, riesgos y alternativas al tratamiento. Entiendo que puedo retirar mi consentimiento en cualquier momento, y que tengo derecho a hacer preguntas en cualquier etapa del tratamiento.\n\n\n"
            +
            "                    Siempre existirá la comunicación verbal explicando el tratamiento al menor, mostrando, diciendo y haciendo, con la finalidad que el menor conozca el procedimiento. En ocasiones se requiere una técnica restrictiva, cuando el paciente no colabora y requiere el tratamiento con urgencia y no da tiempo al proceso de adaptación, por lo cual se requerirá la presencia del padre o acudiente para que ayude a inmovilizar al paciente. RIESGOS:  El niño en el forcejeo puede salir maltratado.</p>\n"
            +
            "                    <p>Certifico que leí y entendí las indicaciones, riesgos, ventajas y beneficios inherentes a cada tratamiento,que tuve la oportunidad de resolver mis inquietudes, también que conozco el autocuidado y control respectivo al plan de tratamiento,  por lo cual conciento que me practiquen los procedimientos programados en el tratamiento odontológico aquí propuesto.</p>\n"
            +
            "                    <p>De conformidad con la política de privacidad disponible en la pág. Web www.clinicasantaclara.com, Autorizo a la CLÍNICA SANTA CLARA el tratamiento de mis datos personales,  SI@datosPersonalesSI@, NO@datosPersonalesNO@</p>\n"
            +
            "                    <p>El titular de los datos tiene derecho de conocer, actualizar, rectificar, suprimir los datos y revocar la autorización salvo las excepciones legales.</p>\n"
            + "            \n<br/>"
            + "            \n<br/>"
            + "                    <table width=\"100%\" >\n"
            + "                        <tbody>\n"
            + "                            <tr>\n"
            + "                                <td width=\"50%\">\n"
            + "                                        <div style=\"float: left; margin-top: 32px\">\n"
            + "                                            <p>Firma del usuario o acudiente:</p>\n"
            +
            "                                            <p>Identificación:<u><i>@TipoDoc@ @NroDocumento@</p>\n"
            + "                                        </div>\n"
            + "                                        <div>\n"
            + "                                            <span class=\"position-firma\">\n"
            + "                                                <img class=\"img-firma\" src=\"" +
            PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignature@." + IMAGE_FORMAT + "\" width=\"130\" />\n"
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
            + "                                                <img class=\"img-firma\" src=\"" +
            PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignatureProfessional@." + IMAGE_FORMAT + "\" width=\"130\" />\n"
            + "                                                <div class=\"subrayado\">______________________________</div>\n"
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
            "                                            <p>Identificación:<u style=\"display:@displayFirma@\"><i>@TipoDoc@ @NroDocumento@</p>\n"
            + "                                        </div>\n"
            + "                                        <div>\n"
            + "                                            <span class=\"position-firma\">\n"
            + "                                                <img style=\"display:@displayFirma@\" class=\"img-firma\" src=\"" +
            PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignature@." + IMAGE_FORMAT + "\" width=\"130\" />\n"
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
            PATH_IMAGES_APP + NAME_SIGNATURE + "-@docSignatureProfessional@." + IMAGE_FORMAT + "\" width=\"130\" />\n"
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
                && !this.getPatient().getDocumentNumber().matches(REGEX_DOCUMENT)) {
            return "Ingrese un nro de documento válido para el paciente";

        }
        if (this.getPatient() != null
                && this.getPatient().getName() != null
                && this.getPatient().getName().equals("")
                && !this.getPatient().getName().matches(REGEX_NAME)) {
            return "Ingrese un nombre válido para el paciente";

        }
        if (isGuardian() && this.getPatient() != null
                && this.getPatient().getGuardian() != null
                && this.getPatient().getGuardian().getDocumentNumber() != null
                && this.getPatient().getGuardian().getDocumentNumber().equals("")
                && !this.getPatient().getGuardian().getDocumentNumber().matches(REGEX_DOCUMENT)) {
            return "Ingrese un nro de documento válido para el acudiente";

        }
        if (isGuardian()
                && this.getPatient().getGuardian() != null
                && this.getPatient().getGuardian().getName() != null
                && this.getPatient().getGuardian().getName().equals("")
                && !this.getPatient().getGuardian().getName().matches(REGEX_NAME)) {
            return "Ingrese un nombre válido para el acudiente";

        }

        if (this.getProfessional().getRegistryNumber() != null
                && !this.getProfessional().getRegistryNumber().toString().matches(REGEX_DIGIT)) {
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
        String areaTable = areasTableBuilder(1);
        if (this.isGuardian()) {
            html = FORMAT_DOCUMENT_WITH_GUARDIAN.replace("@docSignature@", this.getSignatureConsent());
            html = html.replace("@docSignatureProfessional@", this.getSignatureProfessional());
        } else {
            html = FORMAT_DOCUMENT_WITHOUT_GUARDIAN.replace("@docSignature@", this.getSignatureConsent());
            html = html.replace("@docSignatureProfessional@", this.getSignatureProfessional());
        }
        html = html.replace("@LstProcedimientos@", areaTable);
        html = html.replace("@Fecha@", this.getDate("dd/MM/yyyy"));
        html = html.replace("@Dia@", this.getDay() + " " + this.getDate("dd"));
        html = html.replace("@Mes@", this.getMonth());
        html = html.replace("@Anio@", this.getDate("yyyy"));
        html = html.replace("@TipoDoc@",
                (isGuardian() ? this.getGuardianData().getDocumentType().getInitials() :
                        this.getPatient().getDocumentType().getInitials()));
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
                        tableHtml.append(firstProcedure ? procedure.getDescription() : " - " + procedure.getDescription());
                        firstProcedure = false;
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
