pipeline {
    agent any

    stages('Build') {
        steps {
            bat 'mvn -B clean install'
        }
    }
    stages('Test') {
        steps {
            bat 'mvn compile test'
            cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
        }
    }
    stages('Archive') {
        steps {
            archiveArtifacts 'target/*.jar'
        }
    }
}