# shared-libraries
Shared Libraries for Jenkins Pipeline development. 
Folder structure explained: 
1) The resources directory can have non-groovy resources that get loaded via the libraryResource step. Think of this as a place to store supporting data files such as json files.
   Example: def input = libraryResource ‘org/foo/bar/input.json’
2) The src directory is the standard Java source directory layout. This area is added to the classpath when a Pipeline that includes this shared library is executed. Something like: org.foo.bar.groovy in folder structure. Use import to load in the Pipeline script.
3) The vars directory holds global variables that should be accessible from pipeline scripts. A corresponding .txt file can be included that defines documentation for objects here. If found, this will be pulled in as part of the documentation in the Jenkins application.