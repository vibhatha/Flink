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
  i. master : j-001
  ii. slaves : j-[002,003]
  
  The flink source contains a file called slaves in the conf folder. 
