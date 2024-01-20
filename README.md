# Redis 실습 프로젝트

## TECH-STACK
- Redis 6.2
- Docker 24.0.7
- Spring Boot 3.X.X
- Java 17(LTS)
- IntelliJ IDEA 2023.3.2 (Ultimate Edition) 
- Mac OS

## COMMAND
- Redis 6.2
  - `docker run --rm -it -d -p 6379:6379 redis:6.2`
  - `docker ps`
  - `docker logs [CONTAINER_ID]`
  - `docker exec -it [CONTAINER_ID] redis-cli`
  - `docker exec -it [CONTAINER_ID] redis-cli monitor`
  - `docker exec -it [CONTAINER_ID] /bin/bash`
  - `redis-benchmark`
- MySQL 8
  - `docker pull mysql:8`
  - `docker run -e MYSQL_ROOT_PASSWORD=[PASSWORD] -d -p 3307:3306 mysql:8`
  - `docker exec -it [CONTAINER_ID] mysql -p`
  - `create database [DATABASE_NAME]`
  - `describe [TABLE_NAME]`

## DOCUMENTATION
- Jedis Guide
  - Jedis is a Java client for Redis designed for performance and ease of use.
  - [공식문서 링크](https://redis.io/docs/connect/clients/java)
- Redis Pipelining
  - Redis pipelining is a technique for improving performance by issuing multiple commands at once without waiting for the response to each individual command.Pipelining is supported by most Redis clients. This document describes the problem that pipelining is designed to solve and how pipelining works in Redis.
  - [공식문서 링크](https://redis.io/docs/manual/pipelining/)

## Data Type
### Strings
- 가장 기본 타입으로 Text, Byte 저장
- 증가 감소에 대한 원자적 연산 (Increment / Decrement)
- Command
  - `SET`, `SETNX (Set if Not eXists)`, `GET`, `MGET`, `INC`, `DEC`

### Lists
- Linked List (Strings)
  - ex) Java ArrayList
- Queue, Stack
- Command
  - `LPUSH`, `RPUSH`, `LPOP`, `RPOP`, `LLEN`, `LTRM`, `LRANGE`
- Block Command
  - `BLPOP`, `BLPOP

### Sets
- Unordered Collection (Unique Strings)
- Unique item
  - SNS Follow
  - Blacklist
  - Tags
- Command
  - `SADD`, `SREM`, `SISMEMBER`, `SMEMBERS`, `SINTER`, `SCARD`

### Hashes
- Field-Value Pair Collection
  - ex) Java HashMap
- Command
  - `HSET`, `HGET`, `HMGET`, `HGETALL`, `HDEL`, `HINCRBY` 

### Sorted Sets
- Ordered Collection (Unique Strings)
- Leader Board
- Rate Limit
- Command
  - `ZADD`, `ZREM`, `ZRANGE`, `ZCARD`, `ZRANK / ZREVRANK`, `ZINCRBY`

### Geospatial
- Coordinate (Latitude and Longitude)
- Command
  - `GEOADD`, `GEOSEARCH`, `GEODIS`, `GEOPOS` 

### Bitmap
- O 또는 1 의 값으로 이루어진 비트열
  - 메모리를 적게 사용하여 대량의 데이터 저장에 유용
- Command
  - `SETBIT`, `GETBIT`, `BITCOUNT`, 


## Redis Transaction
- Command
  - `MULTI`, `EXEC`, `DISCARD`, `WATCH`