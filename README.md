#Fastest

Fastest es una herramienta para la generación automática de casos de prueba derivados de una especifiación Z.
La versión actual de Fastest acepta como entrada especificaciones escritas con un subconjunto significativo del lenguaje Z y genera como salida casos de prueba abstractos (en notación Z).

Fastest implementa el Test Template Framework (TTF) descripto en:
* P. Stocks and D. Carrington, "A framework for specification-based testing", IEEE Transactions on Software Engineering, vol. 22, no. 11, pp. 777--793, Nov. 1996.
* P. Stocks, "Applying formal methods to software testing", Ph.D. dissertation, Department of Computer Science, University of Queensland, 1993.
* H. M. Hörcher and J. Peleska, "Using formal specifications to support software testing", Software Quality Journal, vol. 4, pp. 309--327, 1995.

La herramienta utiliza el framework CZT (http://czt.sourceforge.net). El diseño sigue una arquitectura cliente/servidor y de invocación implícita lo cual brinda simplicidad para introducir cambios.
Fastest funciona tanto sobre Linux como sobre MS Windows y requiere sólo Java SE Runtime Environment 1.6 o superior.

Para instalar la herramienta solo debe descomprimir el archivo Fastest.tar.gz. La distribución incluye un pequeño manual en inglés.
