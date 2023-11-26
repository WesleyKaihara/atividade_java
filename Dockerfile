FROM mysql:8.0.16

ENV MYSQL_ROOT_PASSWORD atividade_java
COPY ./database.sql /docker-entrypoint-initdb.d/database.sql
