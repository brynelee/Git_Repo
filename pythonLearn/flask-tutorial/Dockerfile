FROM tiangolo/uwsgi-nginx-flask:python3.7-alpine3.8

ENV UWSGI_INI /app/uwsgi.ini

COPY ./uwsgi.ini /app/uwsgi.ini
COPY ./flaskr /app/flaskr
COPY ./instance /app/instance

# tiangolo/uwsgi-nginx-flask:python3.7-alpine3.8 pre-defined static resource directory
COPY ./flaskr/static /app/static

# in case there is sth to do before starting the application
COPY ./prestart.sh /app/prestart.sh

# in case the working directory is not /app
# WORKDIR /app

VOLUME [ "/app" ]