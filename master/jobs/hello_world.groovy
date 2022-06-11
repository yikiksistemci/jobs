job('flask-app-job-with-dsl') {
  steps {
    shell(''' 
        echo "Hello World !!!"
''')
  }
}