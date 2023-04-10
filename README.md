# ReaderWriterAssignment

This file contains Assignment of Session 5 Assignment 1 

This is an implementation of the writer's-preference reader-writer lock in Scala. The purpose of this lock is to prevent more than one thread modifying a shared resource simultaneously and to allow multiple reader threads to access the shared resource simultaneously. In addition, this implementation prioritizes writer threads over reader threads.


##Implementation

The implementation consists of a ReadWriteLock class with two methods: readLock() and writeLock(). The readLock() method acquires a read lock, which allows multiple reader threads to access the shared resource simultaneously. The writeLock() method acquires a write lock, which allows only one writer thread to modify the shared resource at a time.

If a writer thread is waiting to acquire the lock, it is given priority over reader threads. That is, if there are any reader threads currently holding the lock, any new writer thread waiting to acquire the lock will block until all the reader threads have released their locks. Once all the reader threads have released their locks, the writer thread is allowed to acquire the lock and modify the shared resource.
