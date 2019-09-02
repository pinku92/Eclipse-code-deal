set projectLocation=P:\saravanan\TheStreet_Automation\TheStreet_Commerce_Zuora
cd %projectLocation%
set classpath=%projectLocation%\target\test-classes;%projectLocation%\libs\*
java org.testng.TestNG %projectLocation%\Zuora_Subscription_flow_testng.xml
pause