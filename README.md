## Read and Write File 
File read and write in Java <br />
Measure time of reading and writing files of different sizes <br />



### Technologies
JSE, FileInputStream, FileOutputStream


### Steps
Compile program: <br />
*mvn clean compile* <br />

Run program: <br />
*mvn exec:java -Dexec.mainClass="josefmayer.FileCopier"* <br />


### Results
file name: text1_10kB  <br />
file size in bytes: 10016  <br />
read  time in ns: 16885  <br />
write time in ns: 73167  <br />

file name: text2_100kB  <br />
file size in bytes: 100151  <br />
read  time in ns: 46019  <br />
write time in ns: 89058  <br />

file name: text3_1MB  <br />
file size in bytes: 1001523 <br />
read  time in ns: 617778 <br />
write time in ns: 848867 <br />

file name: text4_10MB <br />
file size in bytes: 10015215 <br />
read  time in ns: 6752195 <br />
write time in ns: 7335874 <br />
