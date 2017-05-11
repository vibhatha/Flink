# Flink
Research on Flink

## Configuration

There are two types of configurations that has to be done. 
1. Single Node Configuration
2. Multiple Node or Cluster Configuration

### Single Node Configuration

There are plenty of tutorials that can be found in the web to do this configuration.

### Multiple Node or Cluster Configuration

1. Identify the master and slaves.
  For instance if there is a single master and multiple slaves in the following format.
  ##### master : j-001
  ##### slaves : j-[002,003]
  We have to update the configuration files in a necessary way. If the file location is shared 
  by all the nodes, configuring one node would do it. But if it is not in a shared location, you might have
  to configure the nodes one by one at a time. Assuming the shared location of files:
  The flink source contains a file called slaves in the conf folder. Go to that file and add the nodes one by 
  one separately in a new line. 
  
2. Then the next task is to configure the master node properly. Edit the flink-conf.yaml in the conf folder. Replace the
   following parameter:
    ##### jobmanager.rpc.address: t-051
   And make sure that all the flink-conf.yaml files are updated in each node, if and only if they are not in a shared             location.

3. Add some more configurations 

    ##### jobmanager.heap.mb: 4096
    ##### taskmanager.heap.mb: 98304
    ##### taskmanager.numberOfTaskSlots: 64
    ##### taskmanager.network.numberOfBuffers: 196608
    ##### taskmanager.tmp.dirs: /scratch/vibhatha/flink/tmp
    ##### fs.hdfs.hadoopconf: /N/u/vibhatha/deploy/hadoop-2.7.3/etc/hadoop
  Use hdfs file location if and only if you are using hdfs file system for data loading. 
  
4. When you add the tmp directory for taskmanager, make sure you go and create this directory in each node and provide necessary read/write access. To do so, just follow the guidelines mentioned below.

  ###### chmod 777 /scratch/vibhatha/*
Basic configurations are done, if you have completed these steps. 


    
    

    
