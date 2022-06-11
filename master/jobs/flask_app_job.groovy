job('flask-app-job-with-dsl') {
  steps {
    shell(''' 
	
	
APP_SERVER_IP="192.168.1.51"
APP_SERVER_USERNAME="vagrant"
APP_SERVER_KEY="/var/lib/jenkins/deployment"

ssh -i ${APP_SERVER_KEY} "${APP_SERVER_USERNAME}"@"${APP_SERVER_IP}" "sudo apt-get update && sudo apt-get install python3-pip -y"

tar -zcvf ./app.tar.gz . 

scp -i ${APP_SERVER_KEY} ./app.tar.gz "${APP_SERVER_USERNAME}"@"${APP_SERVER_IP}":/home/vagrant

ssh -i ${APP_SERVER_KEY} "${APP_SERVER_USERNAME}"@"${APP_SERVER_IP}" "mkdir -p app && tar -xvf /home/vagrant/app.tar.gz -C /home/vagrant/app/"

ssh -i ${APP_SERVER_KEY} "${APP_SERVER_USERNAME}"@"${APP_SERVER_IP}" "sed -i 's/MarkupSafe==1.0/MarkupSafe/g' /home/vagrant/app/requirements.txt"

ssh -i ${APP_SERVER_KEY} "${APP_SERVER_USERNAME}"@"${APP_SERVER_IP}" "pip3 install -r /home/vagrant/app/requirements.txt"
		

''')
  }
}