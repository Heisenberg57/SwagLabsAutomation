pipeline {
	agent any

    tools {
		jdk 'jdk21'           // Configure JDK name in Jenkins Manage Jenkins → Global Tool Config
        maven 'maven3'        // Configure Maven installation
    }

    environment {
		REPORT_DIR = 'test-output'
        SCREENSHOT_DIR = 'screenshots'
    }

    stages {

		stage('Checkout Code') {
			steps {
				echo "📦 Checking out source code from Git..."
                git branch: 'main', url: 'https://github.com/<your-username>/SwagLabs-Automation.git'
            }
        }

        stage('Build & Install Dependencies') {
			steps {
				echo "⚙️ Building project..."
                bat 'mvn clean install -DskipTests=true'
            }
        }

        stage('Run Tests') {
			steps {
				echo "🧪 Running Selenium + TestNG tests..."
                bat 'mvn test'
            }
        }

        stage('Archive Reports') {
			steps {
				echo "📊 Archiving TestNG HTML report and screenshots..."
                archiveArtifacts artifacts: '**/test-output/**, **/screenshots/**', fingerprint: true
            }
        }

        stage('Publish HTML Report') {
			steps {
				echo "🌐 Publishing TestNG HTML Report..."
                publishHTML(target: [
                    allowMissing: false,
                    keepAll: true,
                    reportDir: 'test-output',
                    reportFiles: 'index.html',
                    reportName: 'TestNG HTML Report'
                ])
            }
        }
    }

    post {
		always {
			echo "🧹 Cleaning workspace..."
            cleanWs()
        }
        success {
			echo " All tests passed successfully!"
        }
        failure {
			echo " Some tests failed. Check the TestNG report & screenshots."
        }
    }
}
