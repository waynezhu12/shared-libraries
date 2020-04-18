# shared-libraries
Shared Libraries for Jenkins Pipeline development 
The resources directory can have non-groovy resources that get loaded via the libraryResource step. Think of this as a place to store supporting data files such as json files.
The src directory uses a structure similar to the standard Java src layout. This area is added to the classpath when a Pipeline that includes this shared library is executed. Something like: org.foo.bar.groovy in folder structure.
The vars directory holds global variables that should be accessible from pipeline scripts. A corresponding .txt file can be included that defines documentation for objects here. If found, this will be pulled in as part of the documentation in the Jenkins application.