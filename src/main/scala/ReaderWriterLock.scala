package com.knoldus

import java.util.concurrent.locks.{Lock, ReentrantReadWriteLock}

class ReaderWriterLock[T] {
  // Create a new ReentrantReadWriteLock instance
  private val lock: ReentrantReadWriteLock = new ReentrantReadWriteLock()

  // Get the read lock and write lock from the lock instance
  private val readLocks: Lock = lock.readLock()
  private val writeLocks: Lock = lock.writeLock()
  private var readersWaiting: Int = 0
  var list: List[T] = List.empty

  def readLock(): Option[T] = {
    readLocks.lock() // Acquire the read lock
    try {
      readersWaiting += 1
      println(s"No. of readers waiting = $readersWaiting")
      list.headOption
    } catch {
      case exception: Exception => println(s"Exception occurred during read operation: ${exception.getMessage}")
        None
    } finally {
      readersWaiting -= 1
      println(s"No. of readers waiting = $readersWaiting")
      readLocks.unlock()
    }
  }

  def writeLock(elementToInsert: T): Unit = {
    writeLocks.lock() // Acquire the write lock
    try {
      println(s"List Before Writing $list")
      list = elementToInsert :: list
      println(s"List After Writing $list")
    } catch {
      case exception: Exception => println(s"Exception occurred during write operation: ${exception.getMessage}")
    } finally {
      writeLocks.unlock()
    }
  }
}
