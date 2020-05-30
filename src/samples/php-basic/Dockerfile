FROM ubuntu:latest

# Install apache, PHP, and supplimentary programs. openssh-server, curl, and lynx-cur are for debugging the container.
RUN apt-get update && apt-get -y upgrade && DEBIAN_FRONTEND=noninteractive apt-get -y install \
    locales apache2 php php-mysql libapache2-mod-php php-pear php-fpm php-dev php-zip php-curl php-xmlrpc php-gd php-mbstring php-xml curl git 

RUN locale-gen en_US.UTF-8
RUN update-locale LANG=en_US.UTF8
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

# Enable apache mods.
RUN a2enmod rewrite
RUN a2enmod actions
RUN a2enmod cgi
RUN a2enmod expires
RUN a2enmod headers
RUN a2enmod include
RUN a2enmod info
RUN a2enmod proxy
RUN a2enmod proxy_http
RUN a2enmod unique_id
RUN a2enmod userdir
RUN a2enmod vhost_alias

# Update the PHP.ini file, enable <? ?> tags
RUN sed -i "s/short_open_tag = Off/short_open_tag = On/" /etc/php/7.2/apache2/php.ini

# Manually set up the apache environment variables
ENV APACHE_RUN_USER www-data
ENV APACHE_RUN_GROUP www-data
ENV APACHE_LOG_DIR /var/log/apache2
ENV APACHE_LOCK_DIR /var/lock/apache2
ENV APACHE_PID_FILE /var/run/apache2.pid

# Expose apache.
EXPOSE 80

RUN mkdir /var/www/site
RUN chown -R www-data:www-data /var/www
RUN chmod -R u=rX,g=rX,o=r /var/www/*

# Update the default apache site with the config we created.
ADD config/apache-config.conf /etc/apache2/sites-enabled/000-default.conf
ADD src /var/www/site

ENTRYPOINT /usr/sbin/apache2ctl -D FOREGROUND