folder('Production') {
    displayName('Bootcamp Pipelines')
    description('Add all jobs to here for Bootcamp')
    views {
        listView('NodeJS'){
            description('NodeJS Pipelines')
            filterBuildQueue()
            filterExecutors()
            recurse()
            jobs {
                name(nodejs-pipeline)
            }
            columns {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
                lastDuration()
                buildButton()
                lastBuildConsole()
            }
    }
    }
}