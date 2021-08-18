# solid-couscous
Grupo2 LabTBD 2

Instrucciones de instalación:
1) Descargar o clonar repositorio:

       git clone https://github.com/Mod4rchive/solid-couscous

2) Ejecutar scripts SQL:

      a) Abrir terminal

      b) Ejectuar comando en terminal:

       sudo su - postgres

       psql -f [rutadelarchivo]/tables_db_emergencies.sql

       psql -f [rutadelarchivo]/data_db_emergencies.sql

      c) Cerrar terminal

3) Abrir terminal en carpeta demo, ejecutar:

       ./gradlew bootRun

4) Abrir terminal en carpeta front, ejecutar:

       npm install @nuxtjs/axios

       npm run dev

5) Abrir en navegador la direccion web indicada:

       http://localhost:3000/
