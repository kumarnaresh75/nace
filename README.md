Current Status
-----------------
Please note all columns except Rulings are currently being read from the xls, persisted and retrieved.
The Rulings column seems to be having formula error.

Swagger URL
-------------
http://localhost:8080/swagger-ui/index.html#/

Library used to read xls
------------------------
apache-poi

Java
-----
17

REST APIs
--------------
POST method to upload xls:
http://localhost:8080/nace/upload

Supply form-data:
key: file
value: xlsm file

GET method to retrieve Order details
http://localhost:8080/nace/order/398482

DB: MYSQL - Please install MYSQL workbench

TESTS
-------
TEST DB: h2 in memory

Integration test: NaceApplicationTests

Repository test: NaceRepositoryTest

Unit test: NaceUtilsTest





