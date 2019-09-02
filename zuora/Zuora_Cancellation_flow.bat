REM set projectLocation=P:\saravanan\TheStreet_Automation\TheStreet_Commerce_Zuora
REM cd %projectLocation%
REM set classpath=%projectLocation%\target\test-classes;%projectLocation%\libs\*
REM java org.testng.TestNG %projectLocation%\Zuora_Cancellation_flow_testng.xml
REM pause

set projectLocation=P:\saravanan\TheStreet_Automation\TheStreet_CD
cd %projectLocation%
set classpath=%projectLocation%\target\test-classes;%projectLocation%\libs\*
java org.testng.TestNG %projectLocation%\Article_Creation_testng.xml
pause