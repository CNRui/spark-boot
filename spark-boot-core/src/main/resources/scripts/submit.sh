#!/bin/bash
nohup spark-submit \
--class com.glbg.ai.recommend_gb.UnbrandResult2HBase \
--master yarn \
--queue root.ai.offline \
--deploy-mode cluster \
--driver-java-options -XX:MaxPermSize=512m \
--executor-memory 8g \
--driver-memory 4g \
--driver-cores 2 \
--num-executors 60 \
--executor-cores 1 \
--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
--conf spark.storage.memoryFraction=0.05 \
--conf spark.shuffle.memoryFraction=0.75 \
--conf spark.sql.shuffle.partitions=1200 \
--conf spark.default.parallelism=1200 \
@artifactId@-@version@-jar-with-dependencies.jar > submit.log 2>&1 &