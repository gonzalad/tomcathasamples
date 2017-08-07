if [ -z "${REDIS_HOST}" ]; then
  REDIS_HOST=localhost
fi
if [ -z "${REDIS_PORT}" ]; then
  REDIS_PORT=6379
fi
CATALINA_OPTS="-Dredis.sessions.host=$REDIS_HOST -Dredis.sessions.port=$REDIS_PORT $CATALINA_OPTS"