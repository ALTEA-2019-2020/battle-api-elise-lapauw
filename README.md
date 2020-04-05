Lapauw Elise

M2 MIAGE FA - ALTEA

API Battle
============


Launch
-------------------------
The application is available at 
https://battle-api-lapauw.herokuapp.com/

Or you can launch it and use
http://localhost:9100/

API
--------------
This application contains the following routes : 

 - GET /battles-> returns all the battles
 - GEt /battles/{id} -> returns the battle n° {id}
 - POST/battles?trainer={trainerName}&opponent={opponentName} -> creates a battle between the trainer named {trainerName} & the trainer named {opponentName}
 - POST /battles/{id}/{trainerName}/attack -> {trainerName} attacks his opponent on the battle n° {id}

A postman collection is available in the src/test/resources folder
