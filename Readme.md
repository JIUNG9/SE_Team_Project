#### This is a Enrolment classes project in University, Use the JDBC for connection MYSQL and Socket Progrramming with Java.
* Login 
* MVC pattern
* Socket Programming(JAVA)



## Topic1 : Database Connection Singleton pattern vs Connection pool

Solution: Database should be thread-safe. but using Singleton pattern does not apply the thread-safe. just only on static instance would be shared.
so use the Connection Pool

About Connection Pool:

Let's quickly understand how a connection pool works in a multi-threading scenario.

A connection pool holds multiple connection objects. We can configure the size of a pool.

When multiple threads need to access a database concurrently, they request connection objects from the connection pool.

If there are still free connections in the pool, a thread will get a connection object and start its database operations. After the thread finishes its work, it'll return the connection to the pool.

In case there is no free connection in the pool, the thread will wait for a connection object to be returned to the pool by another thread.

Therefore, a connection pool allows multiple threads to access the database concurrently using different connection objects instead of sharing the same one.


## reference
 https://www.baeldung.com/java-sql-connection-thread-safety#using-a-connection-pool (reference)
