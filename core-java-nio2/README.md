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

## What is Channel?
* A channel represents an open connection to an entity such as a hardware device, a file, a  
network socket, or a program component that is capable of performing one or more distinct I/O  
operations, for example reading or writing.
* A channel is either open or closed. A channel is open upon creation, and once closed it  
remains closed. Once a channel is closed, any attempt to invoke an I/O operation upon it will  
cause a ClosedChannelException to be thrown. Whether or not a channel is open may be tested by  
invoking its isOpen method.


## SeekableByteChannel 
* java.nio.channels.SeekableByteChannel
  - enable you to set or query the position, and you can then read the data from, or write the    
  data to, that location  
  - Methods --> 
    + position – Returns the channel's current position
	+ position(long) – Sets the channel's position
	+ read(ByteBuffer) – Reads bytes into the buffer from the channel
	+ write(ByteBuffer) – Writes bytes from the buffer to the channel
	+ truncate(long) – Truncates the file (or other entity) connected to the channel
 
 
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
* Will not throw exception if the Path doesn't exist
	- Creating path
``
Path p1 = Paths.get("/tmp/foo");
Path p2 = Paths.get(args[0]);
Path p3 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));
Path p4 = FileSystems.getDefault().getPath("/users/sally");
Path p5 = Paths.get(System.getProperty("user.home"),"logs", "foo.log");
``
	- Retrieving Information about a Path
``
// None of these methods requires that the file corresponding
// to the Path exists.
// Microsoft Windows syntax
Path path = Paths.get("C:\\home\\joe\\foo");

// Solaris syntax
Path path = Paths.get("/home/joe/foo");

System.out.format("toString: %s%n", path.toString());
System.out.format("getFileName: %s%n", path.getFileName());
System.out.format("getName(0): %s%n", path.getName(0));
System.out.format("getNameCount: %d%n", path.getNameCount());
System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
System.out.format("getParent: %s%n", path.getParent());
System.out.format("getRoot: %s%n", path.getRoot());
``
	- Removing Redundancies From a Path
1. toUri()
``
Path p1 = Paths.get("/home/logfile");
// Result is file:///home/logfile
System.out.format("%s%n", p1.toUri());
``

2. toAbsolutePath()
``
Path inputPath = Paths.get("sri/project");

// Returns somethink like /home/sri/project
Path fullPath = inputPath.toAbsolutePath();
``
Note: The toAbsolutePath method converts the user input and returns a Path   
that returns useful values when queried. The file does not need to exist  
for this method to work  

3. toRealPath()
``
try {
    Path fp = path.toRealPath();
} catch (NoSuchFileException x) {
    System.err.format("%s: no such" + " file or directory%n", path);
    // Logic for case when file doesn't exist.
} catch (IOException x) {
    System.err.format("%s%n", x);
    // Logic for other sort of file error.
}
``


## Read, Write using Files
1. java.nio.file.Files has several ways to perform IO operation
2. for Byte stream
 * Files.newInputStream(path, option) :: java.io.InputStream
 * Files.newOutputStram(path, option) :: java.io.OutputStream
3. for Character stream
 * Files.newBufferedReader(path) :: java.io.BufferedReader
 * Files.newBufferedWriter(path, option) :: java.io.BufferedWriter
4. for Channel access
 * Files.newByteChannel(path, option) :: java.nio.channels.SeekableByteChannel




