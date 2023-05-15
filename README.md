# haicao-assignment
****************    Setup Environment       ****************
1. Install Java
2. Setup Java Environment:
   2.1 Go to System Property > Environment Variables > At System Variables, Click [New] button
   2.2 Enter [JAVA_HONE] to [Variable name] field
   2.3 Enter path (Eg: C:\Program Files\Java\jdk-14.0.2 ) to [Variable value] field
   2.4 Select to [Path] in System Variables, then Click to [Edit] button
   2.5 At [Edit Environment Variable] popup, Click to [New] Button, then Past the path (E.g: %JAVA_HOME%\bin)
   2.6 Save all

3. Download Maven (E.g: 3.8.1) and copy to C://
   3.1 Go to System Property > Environment Variables > At System Variables, Click [New] button
   3.2 Enter [MAVEN_HONE] to [Variable name] field
   3.3 Enter path (Eg: C:\apache-maven-3.8.1 ) to [Variable value] field
   3.4 Save all

4. Download and Setup Allure report to C://allure-2.13.9
   4.1 Go to System Property > Environment Variables > At System Variables, Select to [Path] in System Variables, then Click to [Edit] button
   4.2 At [Edit Environment Variable] popup, Click to [New] Button, then Past the path (E.g: C:\allure-2.13.9\bin )

5. Redirect to IntelliJ and open terminal with current project path
   5.1 Execute "allure --version" in console to make sure that allure is now available
   5.2 Execute "mvn clear test"
   5.3 Execute "allure serve target/allure-results"

6. After Run TestCase, If you want to generate report:
   6.1 Execute "allure generate"
   6.1 Execute "allure open"
   ---> Report page will open
   