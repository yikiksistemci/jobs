listView('Bootcamp'){
    description('Bootcamp View')
    filterBuildQueue()
    filterExecutors()
    recurse()
    jobs {
        name("flask-app-job-with-dsl")
        name("example")
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