# cs400-p1

This repository is contains the first group project of CS400-S21 created by the CF team.

# Table of Contents

1. [BackEnd Developer](#packageone)
	1. [Files Written](#f1)
	2. [Additional Contributions](#ac1)
	3. [Signature](#s1)
2. [FrontEnd Developer](#packagetwo)
	1. [Files Written](#f2)
	2. [Additional Contributions](#ac2)
	3. [Signature](#s2)
3. [Data Wrangler](#packagethree)
	1. [Files Written](#f3)
	2. [Additional Contributions](#ac3)
	3. [Signature](#s3)
4. [Integration Manager](#sql-games)
	1. [Complete List Of Files](#file-list)
	2. [Instructions To Run The Project](#run)
	3. [Team Member Contributions](#tmc)
	4. [Signature](#s4)
5. [Demo](#demo)

</br></br></br></br>
## BackEnd Developer<a name="packageone" />

========================================================

Name of BackEndDeveloper: Abhimanyu Dev Gupta</br>
@wisc.edu Email of BackEndDeveloper: adgupta2@wisc.edu</br>
Group: CF</br>
Team: Adilnur Istekov, David Khachatryan, Zhiyuan Han</br>

Files Written by Me: <a name="f1" />
--------------------
1) backEndHash - A class that creates two hash tables. One has the rating as key and the other has genre.

2) TestBackEnd - A test class for the backend.

3) backInterface - Implementation of backend interface. Provides functionality to add filters and retrieve resulti\
ng sets.

Additional Contributions: <a name="ac1" />
-------------------------
Discussing the front end and integration with the integration manager.

Signature: <a name="s1" />
----------
Abhimanyu Dev Gupta 
</br></br></br></br>
## FrontEnd Developer<a name="packagetwo" />

========================================================

Name of FrontEndDeveloper: Zhiyuan Han</br>
@wisc.edu Email of FrontEndDeveloper: zhan98@wisc.edu</br>
Group: CF</br>
Team: red</br>

Files Written by Me: <a name="f2" />
--------------------
1) MovieMapper.java: Provides user interface for the project</br>

Additional Contributions: <a name="ac2" />
-------------------------
None

Signature: <a name="s2" />
----------
Signature: Zhiyuan Han
</br></br></br></br>

## Data Wrangler<a name="packagethree" />

========================================================

Name of DataWrangler: Adilnur Istekov</br>
@wisc.edu Email of DataWrangler: Istekov@wisc.edu</br>
Group: CF</br>
Team: red</br>

Files Written by Me: <a name="f3" />
--------------------
1) Movie.java - Creates a Movie Object</br>
2) MovieDataReader.java - Reads The CSV file and loads it into a 2D array</br>
3) TestMovieAndMovieDataReader.java - Tests the given two files</br>

Additional Contributions: <a name="ac3" />
-------------------------
I attended Zoom meetings and conversations on Whatsapp

Signature: <a name="s3" />
----------
Adilnur Istekov
</br></br></br></br>
## Integration Manager<a name="sql-games" />

========================================================

Name of IntegrationManager: David Khachatryan</br>
@wisc.edu Email of IntegrationManager: dkhachatryan@wisc.edu</br>
Group: CF</br>
Team: Red Team</br>

Complete List of Files: <a name="file-list" />
-----------------------
[backEndHash.java](https://github.com/KhachDavid/cs400-p1/blob/main/backEndHash.java) - Created by Abhimany</br>
[backInterface.java](https://github.com/KhachDavid/cs400-p1/blob/main/backInterface.java) - Created by Abhimany</br>
[BackendDummy.java](https://github.com/KhachDavid/cs400-p1/blob/main/BackendDummy.java) - Provided by the course staff</br>
[BackendInterface.java](https://github.com/KhachDavid/cs400-p1/blob/main/BackendInterface.java) - Provided by the course staff</br>
[HashTableMap.java](https://github.com/KhachDavid/cs400-p1/blob/main/HashTableMap.java) - Created by David</br>
[KeyAndValue.java](https://github.com/KhachDavid/cs400-p1/blob/main/KeyAndValue.java) - Created by David</br>
[Main.java](https://github.com/KhachDavid/cs400-p1/blob/main/Main.java) - Created by Zhiyuan</br>
[Makefile](https://github.com/KhachDavid/cs400-p1/blob/main/Makefile) - Created by David</br>
[MapADT.java](https://github.com/KhachDavid/cs400-p1/blob/main/MapADT.java) - Provided by course staff</br>
[movies.csv](https://github.com/KhachDavid/cs400-p1/blob/main/movies.csv) - Provided by course staff</br>
[Movie.java](https://github.com/KhachDavid/cs400-p1/blob/main/Movie.java) - Created by Adilnur</br>
[MovieDataReader.java](https://github.com/KhachDavid/cs400-p1/blob/main/MovieDataReader.java) - Created by Adilnur and David</br>
[MovieDataReaderDummy.java](https://github.com/KhachDavid/cs400-p1/blob/main/MovieDataReaderDummy.java) - Provided by course staff</br>
[MovieDataReaderInterface.java](https://github.com/KhachDavid/cs400-p1/blob/main/MovieDataReaderInterface.java) - Provided by course staff</br>
[MovieInterface.java](https://github.com/KhachDavid/cs400-p1/blob/main/MovieInterface.java) - Provided by course staff</br>
[MovieMapper.java](https://github.com/KhachDavid/cs400-p1/blob/main/MovieMapper.java) - Created by Zhiyuan</br>
[TestBackend.java](https://github.com/KhachDavid/cs400-p1/blob/main/TestBackEnd.java) - Created by Abhimany</br>
[TestFrontEnd.java](https://github.com/KhachDavid/cs400-p1/blob/main/TestFrontEnd.java) - Created by Zhiyuan</br>
[TestMovieAndMovieDataReader.java](https://github.com/KhachDavid/cs400-p1/blob/main/TestMovieAndMovieDataReader.java) - Created by Adilnur</br>


Instructions to Build, Run and Test your Project:<a name="run" />
-------------------------------------------------
Since this project uses GUI Swing and JFrame libraries, it is not possible to open the GUI with a make run command. 
You would need to open the code outside the command line to use the frontend.

To clone the repository
```
$ git clone https://github.com/KhachDavid/cs400-p1.git
```

To run the tests, you can run 
```
make test.
```
To run a specific test run:
```
make testFrontend
```

```
make testBackend
```
	
```
make testData
```

To clear the .class files, run 
```
make clean. 
```

Team Member Contributions: <a name="tmc" />
--------------------------

Zhiyuan did an amazing job with the frontend. He really went over the line with the front-end design.</br>
Abhimanyu was always available to debug and pair program. He is a really good team player.</br>
Adilnur completed his responsibilites on time and very accurately. </br>

Overall, the team did fine. We were a little clumsy in terms of being systematic. Next time, we should have a strict deadline to avoid
last minute hassle. 

Signature: David Khachatryan <a name="s4" />
----------

## Demo<a name="demo"/>

[Link]⋮ </br>
[Part 1]: https://flipgrid.com/e22cbf99 </br>
[Part 2]: https://flipgrid.com/c8953f99 </br>
[Part 3]: https://flipgrid.com/40325b69 </br>

Courtesy of David Khachatryan
