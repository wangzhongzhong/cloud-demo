set curdir=%~dp0
@echo ����Ŀ¼��%curdir%
cd %curdir%
cd ../../..
call mvn mybatis-generator:generate -e
pause