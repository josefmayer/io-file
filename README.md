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
file name: text1_10kB
file size in bytes: 10016
read  time in ns: 16885
write time in ns: 73167

file name: text2_100kB
file size in bytes: 100151
read  time in ns: 46019
write time in ns: 89058

file name: text3_1MB
file size in bytes: 1001523
read  time in ns: 617778
write time in ns: 848867

file name: text4_10MB
file size in bytes: 10015215
read  time in ns: 6752195
write time in ns: 7335874
