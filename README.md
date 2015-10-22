#A simple selenium testing example.

It will login to a web server. If login is successful, a rest service call to get information from the server.

The server app is in project https://github.com/michaelyin/jboss-resteasy-ag. The server app can be deployed to
JBoss wildfly 8.2.1.

The example uses ChromeDriver for its testing, and default driver is installed at /opt/webdriver/chromedriver. If your OS is Windows, the default driver should be installed at C:/opt/webdriver/chromedriver.
