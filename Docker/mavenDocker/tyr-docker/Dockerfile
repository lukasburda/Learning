FROM jboss/wildfly
RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent
ADD target/tyr.war /opt/jboss/wildfly/standalone/deployments/
ADD format.yaml /opt/jboss/wildfly/standalone/configuration/
ADD config.properties /opt/jboss/wildfly/standalone/configuration/
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
