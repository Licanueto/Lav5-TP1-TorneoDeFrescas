<H2> TorneoDeFrescas: Primer Trabajo Práctico de Laboratorio 5 de TSSI</H2>


<H3>Maven</H3>
<H5>Maven es una herramienta de automatización de compilación de software utilizada principalmente en Java pero también disponible para C#, Scala y Ruby entre otros.
Maven nos permite descargar librerías (por ej. MySQL Connector/J) y plugins de repositorios de forma dinámica. A estos y a sus dependencias las describe mediante un archivo XML.</H5>

<H3>POM</H3>
<H5>POM significa Project Object Model y es un archivo en formato XML que nos sirve para comunicarnos con Maven.
Nos provee la configuración para un determinado proyecto incluyendo su nombre, dueño y dependencias de otros proyectos.
Mediante el POM también pueden ser configurados los plugins y cómo el proyecto reacciona a estos.
Los proyectos grandes suelen ser subdivididos y en este caso cada sub-proyecto tendrá su POM.</H5>

<H3>Archetype && ArtifactId</H3>
<H5>Archetype es una herramienta que nos permite generar plantillas de proyectos Maven.
Un Archetype adecuado permite al programador ahorrarse el tiempo de armar el proyecto y setear las cosas básicas pudiendo así enfocarse en lo que le compete.
También haciendo que distintas personas/proyectos partan del mismo Archetype se puede lograr una estandarización del formato de los proyectos en una organización.
ArtifactId poco tiene que ver con Archetype. Este es simplemente el nombre del archivo jar sin versión.
Este comienza con letras minúsculas.

<H3>Goals? de Maven</H3>
<H4>clean 
<H5>No es un Goal sino que es uno de los tres Lifecycles (ciclos de vida) de Maven junto con "default" y "site".
        Este consiste en limpiar el proyecto y remover los archivos generados por el build anterior. 
<H4>package 
<H5>Es una fase del Lifecycle default. En esta se toma el código compilado y se lo "empaqueta" en un formato distribuible como un jar.
<H4>install 
<H5>Es otra fase del Lifecycle default que consiste en agregar y configurar el paquete en un repositorio local para ser usado como una dependencia en otros proyectos de forma local.
<H4>compile
<H5>Es una fase del Lifecycle default que simplemente consiste en la compilación del código fuente del proyecto.</H5>

<H3>Scopes de Maven</H3>
<H4>Compile
 <H5>Las dependencias con este scope son transitivas y están disponibles en la ruta del proyecto.
        Estas son automáticamente propagadas a los otros proyectos que dependan de este.
<H4>Provided
<H5>Este scope se utiliza para demarcar que las dependencias que se encuentran dentro de este deberían ser provistas en tiempo de ejecución por el JDK o por un container.    
        Estas al ser provistas por el JDK en tiempo de ejecución obviamente no son transitivas.
<H4>Runtime
<H5>Las dependencias dentro de este scope son requeridas en tiempo de ejecución pero no son necesarias en tiempo de compilación del código fuente del proyecto.
        Debido a esto las dependencias en este scope estarán presentes en tiempo de compilación (y en Test) pero no en la ruta de las clases compiladas.
<H4>Test
<H5>Este scope se utiliza para indicar que la dependencia no es requerida para el uso normal de la aplicación (ni para la compilación de esa versión) sino que son dependencias utilizadas por las clases dentro de la ruta Test.
<H4>System
<H5>Es un scope similar al Provided pero de diferencia de este en que el sistema requiere que nosotros lo apuntemos a un jar especifico dentro del sistema.
        Es importante recordar que la compilación puede fallar en otra computadora si los jar no están donde se espera que estén.</H5>