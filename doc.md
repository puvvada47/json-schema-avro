**How to run the gradle **

Prerequisites
      
1.run the gradle project 
                 
    gradle build 


2.  gradle version will be taken from distributionUrl in gradle-wrapper.properties

        distributionUrl=https\://services.gradle.org/distributions/gradle-7.4-bin.zip

3.   important steps for build.gradle
        
           a)apply plugin
             Ex:apply(plugin: "java")
  
           b) mention repository
           Ex: repostories(){
            mavenCentral()
            }

           c)mention dependencies
            Ex:  dependencies {
               compile group:'org.hibernate',name:'hibernate-core',version:'3.6.7.Final'
              testCompile group:'junit',name:'junit',version:'4.+' 
           }

          
       

   