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
  master : j-001
  slaves : j-[002,003]
  We have to update the configuration files in a necessary way. If the file location is shared 
  by all the nodes, configuring one node would do it. But if it is not in a shared location, you might have
  to configure the nodes one by one at a time. Assuming the shared location of files:
  The flink source contains a file called slaves in the conf folder. Go to that file and add the nodes one by 
  one separately in a new line. 
    Ex: j-002
        j-003
