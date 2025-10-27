def call(def appName="ESP", def costCenter="0977", def cmInclude="**/*", def cmExclude="", def cxDir="") {
    echo "Scan_Checkmarx in ${workingDirectory}/${cxDir}"
    def includeFiles = '**/CMX.zip'
    if (cmExclude !="") cmExclude += ","
    cmExclude += "**/das/**,**/.sonarqube/**,**/tmp/**,**/.jazz5/**"
    def scanType = (env.cxSASTOnly == "true")?"--scan-types sast ":""
    def serviceAccount = (jenkinsEnvironment=="PROD")? "SI_JENKINS_P":"SI_JENKINS_T"
    if (env.cxNoZip != "true") {
        zip dir: "${env.workingDirectory}/${cxDir}" , glob:cmInclude, exclude:cmExclude, zipFile: "${env.loadDirectory}/CMX.zip", overwrite:true
        includeFiles = "${env.loadDirectory}/CMX.zip"
    } else {
        includeFiles = "${env.loadDirectory}/${cmInclude}"
    }
    // def debugging = (DebugLevel() >= Debug.high())
//checkmarxASTScanner additionalOptions: '', baseAuthUrl: '', branchName: '', checkmarxInstallation: 'Checkmarx', credentialsId: 'CheckmarxPOV', projectName: 'projectName', serverUrl: 'https://serverURL', tenantName: 'bcbst-prod', useOwnServerCredentials: true
    checkmarxASTScanner additionalOptions: "${scanType}--file-filter !das,!.jazz5,!tmp --report-format summaryJSON,summaryHTML,pdf --output-path \"C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\test_jenkins_plugin\" -s \"C:\\Project\\grocery_booking_app\\grocerry_booking_app.zip\" --project-groups ${costCenter} --tags BuildId:${BUILD_DISPLAY_NAME} --project-tags cc:${costCenter}", 
        useAuthenticationUrl: true,
        baseAuthUrl: 'https://eu.iam.checkmarx.net', 
        branchName: 'NA', 
        checkmarxInstallation: 'Checkmarx', 
        credentialsId: 'cxapikey', 
        projectName: "ANspringBootApp", 
        serverUrl: 'https://eu.ast.checkmarx.net', 
        tenantName: 'cx_seg', 
        useOwnServerCredentials: true,
        useOwnAdditionalOptions: true

    env.cxStatus = Get_Checkmarx_Data()   
    
}

return this




