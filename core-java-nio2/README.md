# Java IO and NIO2


## Type of streams
* Byte Stream
  - java.io.InputStream
  - java.io.OutputStream
* Character Stream
  - java.io.Reader
  - java.io.Writer


## Bridge between byte and character stream
* java.io.InputStreamReader
  - it acts as bridge between byte and charater stream for reading
  - Ex: java.io.FileReader fr = new FileReader(new java.io.InputStreamReader("/tmp/data.dat"));
* java.io.OutputStramWriter
  - it acts as bridge between byte and charater stream for writing
  - Ex: java.io.FileWriter fw = new FileWriter(new java.io.OutputStreamWriter("/tmp/data.dat"));


## Buffering data
* Byte Stream
	- java.io.BufferedInputStream
	- java.io.BufferedOutputStream
* Character Stream
	- java.io.BufferedReader
	- java.io.BufferedWriter


## Why buffering?
* read(), write() calls are direct native call in OS which is very expensive
* How? access disk, hold other process if using based on priority, bring process to read/write


## What buffer?
* temporary small junk of memory block which holds data
* program -> buffer -> disk
* Buffered input streams read data from a memory area known as a buffer; the native input API 
is called only when the buffer is empty
* Buffered output streams write data to a buffer, and the native output API is called only 
when the buffer is full.


## What is Flush?
* It often makes sense to write out a buffer at critical points, without waiting for it to fill. 
* This is known as flushing the buffer. 


## DataStreams vs ObjectStreams
* DataStreams
	- Manipulates primitive data in IO
	- java.io.DataInputStream
	- java.io.DataOutputStream
	- java.io.EOFException used while reading from DataStreams
* ObjectStreams
	- Manipulates Java objects and primitive data in IO
	- java.io.ObjectInputStream
	- java.io.ObjectOutputStream
	- Serialization/Deserialization


## Efficient IO
* Buffered processing
* closing IO - try-with-resource

## Path - Jdk 7
* It represent File or Directory in OS
* Will not throw if the Path doesn't exist
	- Creating path
		`Path p1 = Paths.get("/tmp/foo");
		Path p2 = Paths.get(args[0]);
		Path p3 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));`











