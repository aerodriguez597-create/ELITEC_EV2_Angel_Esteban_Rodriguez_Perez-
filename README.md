# **🩺 Sistema de Registro de Recetas Médicas**

**Proyecto Java Desktop GUI** desarrollado como parte de la **Evaluación T2** del curso **Lenguaje de Programación / Desarrollo de Sistemas de Información**. Implementa el patrón de arquitectura **MVC (Modelo-Vista-Controlador)** con **Java Swing**, persiste los datos mediante **JDBC / MySQL** y aplica validaciones estrictas basadas en **Expresiones Regulares (Regex)**.

## **🛠️ Tecnologías Utilizadas**

| Tecnología | Descripción / Uso |
| :---- | :---- |
| **Java SE 25** | Lenguaje de programación principal |
| **Java Swing / AWT** | Desarrollo de la interfaz gráfica de usuario (GUI) |
| **MySQL** | Gestor de base de datos relacional (RDBMS) |
| **JDBC** | Driver de conectividad y ejecución de sentencias SQL |
| **Apache Maven** | Gestión de dependencias y ciclo de vida del proyecto |
| **Project Lombok** | Reducción de código repetitivo (Getters, Setters, Constructor) |
| **Eclipse IDE** | Entorno de desarrollo integrado |

## **📂 Estructura del Proyecto**

EV2\_Angel\_Rodriguez  
│  
├── src  
│   ├── entity  
│   │   ├── Receta.java  
│   │   └── TipoReceta.java  
│   │  
│   ├── model  
│   │   ├── RecetaModel.java  
│   │   └── TipoRecetaModel.java  
│   │  
│   ├── util  
│   │   ├── MySqlDBConexion.java  
│   │   ├── TeoriaExpresionesRegulares.java  
│   │   └── ValidateUtil.java  
│   │  
│   └── vista  
│       └── FrmRegistraReceta.java  
│  
├── bin  
├── target  
├── pom.xml  
├── SQL\_EV2\_Angel\_Rodriguez.sql  
└── README.md

### **🧩 Descripción de los paquetes:**

* 📦 **entity**: Contiene los POJOs/JavaBeans (Receta, TipoReceta) que mappen la estructura de la base de datos.  
* 📦 **model**: Implementa la lógica de acceso a datos (DAO) utilizando sentencias SQL preparadas (PreparedStatement) mediante JDBC.  
* 📦 **util**: Incluye la conexión a MySQL (MySqlDBConexion), las utilidades de validación de campos con Regex (ValidateUtil) y guías conceptuales (TeoriaExpresionesRegulares).  
* 📦 **vista**: Interfaz de usuario gráfica desarrollada con Java Swing (FrmRegistraReceta).

## **🗄️ Base de Datos y Modelo Relacional**

El proyecto utiliza una relación de **uno a muchos (1:N)** entre la tabla de categorías/tipos y la tabla principal:

┌─────────────────┐       1:N       ┌──────────────────────┐  
│   tiporeceta    │\<───────────────┤        receta        │  
├─────────────────┤                 ├──────────────────────┤  
│ PK idTipoReceta │                 │ PK idReceta          │  
│    descripcion  │                 │    nombrePaciente    │  
└─────────────────┘                 │    nombreMedicamento │  
                                    │    dosis             │  
                                    │    frecuencia        │  
                                    │    duracion          │  
                                    │    fechaEmision      │  
                                    │    indicaciones      │  
                                    │ FK idTipoReceta      │  
                                    └──────────────────────┘

## **✨ Funcionalidades Destacadas**

* 🔄 **Carga Dinámica de ComboBox (JComboBox)**: Los tipos de receta disponibles (*Analgésico, Antibiótico, Antiinflamatorio, Antialérgico, Vitaminas*, etc.) se obtienen dinámicamente desde MySQL al iniciar el formulario.  
* 🎯 **Validación en Tiempo Real con Regex**: Comprobación del formato de fechas (YYYY-MM-DD), cadenas de texto válidas, campos numéricos y campos obligatorios utilizando ValidateUtil.  
* 💾 **Persistencia Segura**: Inserción de registros mediante consultas preparadas en JDBC para evitar inyección SQL.  
* 💬 **Retroalimentación Gráfica**: Mensajes emergentes de alerta, confirmación y error vía JOptionPane.  
* 🧹 **Limpieza Automática**: Restablecimiento automático del formulario tras un registro exitoso.

## **⚙️ Configuración e Instalación**

### **Requisitos previos:**

> 1. **JDK 25** instalado y configurado en las variables de entorno.  
> 2. Servidor **MySQL** activo.  
> 3. IDE (Eclipse recomendada) con soporte para **Maven** y plugin de **Lombok**.

### **Pasos de ejecución:**

> 1. **Clonar o descargar el repositorio**:  
>    Bash  
>    git clone \<URL\_DEL\_REPOSITORIO\>

> 2. **Importar y preparar la Base de Datos**:  
   * Ejecuta el script SQL\_EV2\_Angel\_Rodriguez.sql en MySQL Workbench o phpMyAdmin para crear la base de datos receta, las tablas y los registros iniciales.  
> 3. **Configurar las credenciales de conexión**:  
   * Revisa la clase src/util/MySqlDBConexion.java y ajusta el usuario, contraseña y puerto de MySQL según tu entorno local:  
     Java  
     String url \= "jdbc:mysql://localhost:3306/receta?serverTimezone=America/Lima";

> 4. **Instalar dependencias y Compilar**:  
>    Bash  
>    mvn clean install

> 5. **Iniciar la aplicación**:  
   * Ejecuta la clase src/vista/FrmRegistraReceta.java como una **Java Application**.

## **👤 Autor**

* **Estudiante**: Angel Esteban Rodriguez Perez  
* **Asignación**: Tabla **RECETA**

* **Evaluación**: Evaluación T2  
* **Curso**: Lenguaje de Programación / Desarrollo de Sistemas de Información