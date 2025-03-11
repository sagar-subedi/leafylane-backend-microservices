FROM grafana/grafana:latest

# Create necessary directories for provisioning
#USER root
RUN mkdir -p /etc/grafana/provisioning/datasources \
    /etc/grafana/provisioning/dashboards \
    /var/lib/grafana/dashboards

# Copy configuration files
COPY datasource.yml /etc/grafana/provisioning/datasources/datasource.yml
COPY dashboard.yml /etc/grafana/provisioning/dashboards/dashboard.yml

# Copy dashboard JSON files
COPY services-dashboard.json /var/lib/grafana/dashboards/services-dashboard.json
COPY docker-container-dashboard.json /var/lib/grafana/dashboards/docker-container-dashboard.json
COPY docker-all-dashboard.json /var/lib/grafana/dashboards/docker-all-dashboard.json

# Ensure proper ownership and permissions
#RUN #chown -R grafana:grafana /etc/grafana /var/lib/grafana

# Switch back to Grafana user
USER grafana
