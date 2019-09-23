set projectLocation=C:\Users\sufsa\eclipse-workspace\TestFlightBooking
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG C:\Users\sufsa\eclipse-workspace\TestFlightBooking\src\main\java\com\goibibo\resources\testng.xml
pause