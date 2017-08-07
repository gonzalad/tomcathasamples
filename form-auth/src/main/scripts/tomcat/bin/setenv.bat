IF "%~REDIS_HOST" == "" set REDIS_HOST=localhost
IF "%~REDIS_PORT" == "" set REDIS_PORT=6379
set CATALINA_OPTS="-Dredis.sessions.host=%REDIS_HOST -Dredis.sessions.port=%REDIS_PORT %CATALINA_OPTS"