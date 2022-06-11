pipelineJob("nodejs-pipeline"){
    activeChoiceReactiveParam('REGISTERY') {
    description('Please Select Registery')
    filterable()
    choiceType('SINGLE_SELECT')
    groovyScript {
                script('["DockerHub", "GitlabRegistery"]')
                fallbackScript('"fallback choice"')
        }
    }

    definition {
        cpsScm {
            lightweight(true)
            scm {
                gitSCM {
                    branches {
                        branchSpec {
                            name('*/main')
                        }
                    }
                    userRemoteConfigs {
                        userRemoteConfig {
                            url('git@github.com:yikiksistemci/node-example.git')
                            credentialsId('github-ssh-private-key')
                            name('origin')
                            refspec('')
                        }
                    }
                    doGenerateSubmoduleConfigurations(false)
                    browser {
                    }
                    gitTool('')
                }
            }
            scriptPath('./Jenkinsfile')
        }
    }



}