# Digital Preservation - Task 3, TU Wien

[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.802363.svg)](https://doi.org/10.5281/zenodo.802363)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

### Contributors

**Cynthia Marcelino**  
* cynthia.marcelino@student.tuwien.ac.at  
* ORCID ID: 0000-0003-1707-3014

**Daniel Hofer**  
* e0901130@student.tuwien.ac.at  
* ORCID ID: 0000-0003-4032-6008

### Running the Application

#### Requirements 
* MongoDB
* Gradle 3.x
* Java 8  

#### Running the backend

Go to 

     dp-task3/digitalpreservation-datascience-backend

and execute

     gradle bootRun
    
Raw data is available in http://localhost:9000/getWeatherAllData

#### Running the frontend

Go to

    dp-task3/datascience-webui
and execute 

    npm install
    npm start

The chart will open in the browser : http://localhost:8000/
Since the chart is loading from real data the backend has to fetch all the necessary data. The chart takes up to 30s to load.
