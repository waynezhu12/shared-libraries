#!/usr/bin/env groovy



def call() {
    def pipelineName = "Returned value from SharedLibrary"

    echo "From the Shared library : ${env.JOB_NAME}" 
    echo "Defined var from outside of CALL() ${pipelineName}"
    //sh "printenv"
    def scannerHome = tool 'SonarQube-Scanner (3.0.3.778)'
    echo "Sonar Qube Scanner Path: ${scannerHome}" 
    echo "${currentBuild.currentResult}"
    //def azureRegistry ="azure.groupeconnect.io"
    //def hash = sh(script: "git rev-parse HEAD",returnStdout: true).trim()
    //echo "Whatever this is ${hash}"
    //return this
} 

def AEM(String supressionList = "Two"){
    echo "This call takes a SupressionList value: ${supressionList}"
}