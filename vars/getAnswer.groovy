#!/usr/bin/env groovy

def pipelineName = "Returned value from SharedLibrary"

def call() {
    echo "From the Shared library : ${env.JOB_NAME}"
    return pipelineName
}