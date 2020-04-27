#!/usr/bin/env groovy



def call() {
    def pipelineName = "Returned value from SharedLibrary"
    echo "From the Shared library : ${env.JOB_NAME}" 
    echo "Defined var from outside of CALL() ${pipelineName}"
    sh "printenv"
}                                              