# moda-resources
moda-resources

1. Nacos
    ```
    nacos\bin\startup.cmd
    ```
2. Zookeeper
   ```
   kafka\bin\windows\zookeeper-server-start.bat kafka\config\zookeeper.properties
   ```
3. Kafka
    ```
    kafka\bin\windows\kafka-server-start.bat kafka\config\server.properties
    ```
4. Elasticsearch
    ```
    elasticsearch\bin\elasticsearch.bat
    ```
5. Logstash
    ```
    logstash\bin\logstash.bat -f logstash\config\logstash.conf
    ```
6. Kibana
    ```
    kibana\bin\kibana.bat
    ```
7. Sentinel
    ```
    java -Dserver.port=1902 -Dcsp.sentinel.dashboard.server=localhost:1902 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar
    ```
    ```