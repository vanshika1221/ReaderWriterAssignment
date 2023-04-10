package com.knoldus

object Driver extends App {
  private val readWriteLock = new ReaderWriterLock[Int]

  // A simple writer thread that acquires a write lock and performs some write operation
  private val firstWriterThread = new Thread(() => {
    readWriteLock.writeLock(14)
    println(s"Writer ${Thread.currentThread().getName} is writing 14 to the list")
  })
  firstWriterThread.start()

  private val secondWriterThread = new Thread(() => {
    readWriteLock.writeLock(15)
    println(s"Writer ${Thread.currentThread().getName} is writing 15 to the list")
  })
  secondWriterThread.start()

  // A simple reader thread that acquires a read lock and performs some read operation
  private val secondReaderThread = new Thread(() => {
    readWriteLock.readLock()
    println(s"Reader Id ${Thread.currentThread().getName} is reading")
  })
  secondReaderThread.start()

  private val thirdReaderThread = new Thread(() => {
    readWriteLock.readLock()
    println(s"Reader Id ${Thread.currentThread().getName} is reading")
  })
  thirdReaderThread.start()

  private val firstReaderThread = new Thread(() => {
    readWriteLock.readLock()
    println(s"Reader Id ${Thread.currentThread().getName} is reading")
  })
  firstReaderThread.start()

}