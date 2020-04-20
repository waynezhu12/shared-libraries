#!/usr/bin/env groovy

/**
 * Send notifications based on build status string
 */
def call(String buildStatus = 'STARTED', String appName = 'Unknown', String branch = 'Unknow branch') {
  // build status of null means successful
  buildStatus = buildStatus ?: 'SUCCESS'
  // appName of null means Pipeline didn't pass it
  appName = appName ?: 'Unknown'
  //branch of null means Pipeline didn't pass it
  branch = branch ?: 'Unknown Branch'

  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
  def summary = "${subject} (${env.BUILD_URL})"
  def details = """<html><h1> Automated Pipeline Notification </h1>
                    <p>We're in early days testing out this functionality, but stay tuned for more rich notifications!</p>
                    <p>In the meantime, you can view the build, <a href="${BUILD_URL}">here</a>.</html>"""
  def teamsWebhook = "https://outlook.office.com/webhook/cc5b27ce-f773-4cd2-9b36-3fbccebd787e@d52c9ea1-7c21-47b1-82a3-33a74b1f74b8/JenkinsCI/a29e133934a0465eb3415bed3a22a0d2/4f0de5ed-8f4b-4d48-aa5b-333661fde525" 

  // Override default values based on build status
  if (buildStatus == 'STARTED') {
    color = 'YELLOW'
    colorCode = '#FFFF00'
  } else if (buildStatus == 'SUCCESS') {
    color = 'GREEN'
    colorCode = '#00FF00'
  } else {
    color = 'RED'
    colorCode = '#FF0000'
  }

  // Send build notification to Teams channel
  // We can send to different Teams channel based on the ${appName} 
  office365ConnectorSend (
                    status: "New CI Pipeline Run for ${appName} (#${BUILD_NUMBER}) initiated from ${branch} branch",
                    webhookUrl: "${teamsWebhook}",
                    color: '6699dd',
                    message: details
                )

  
    
}