//S02_04 - MongoDB queries
use("restaurants");

//Escriu una consulta per mostrar tots els documents en la col·lecció Restaurants.
db.restaurants.find().pretty();

//Escriu una consulta per mostrar el restaurant_id, name, borough i cuisine per tots els documents en la col·lecció Restaurants.
db.restaurants.find({}, {restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

//Escriu una consulta per mostrar el restaurant_id, name, borough i cuisine, però exclou el camp _id per tots els documents en la col·lecció Restaurants.
db.restaurants.find({}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

//Escriu una consulta per mostrar restaurant_id, name, borough i zip code, però exclou el camp _id per tots els documents en la col·lecció Restaurants.
db.restaurants.find({}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, "address.zipcode": 1}).pretty();

//Escriu una consulta per mostrar tots els restaurants que estan en el Bronx.
db.restaurants.find({borough: "Bronx"}).pretty();

//Escriu una consulta per mostrar els primers 5 restaurants que estan en el Bronx.
db.restaurants.find({borough: "Bronx"}).limit(5).pretty();

//Escriu una consulta per mostrar el pròxim 5 restaurants després de saltar els primers 5 del Bronx.
db.restaurants.find({borough: "Bronx"}).skip(5).limit(5).pretty();

//Escriu una consulta per trobar els restaurants que tenen un score de més de 90.
db.restaurants.find({"grades.score": {$gt: 90}}).pretty();

//Escriu una consulta per trobar els restaurants que tenen un score de més de 80 però menys que 100.
db.restaurants.find({"grades.score": {$gt: 80, $lt: 100}}).pretty();

//Escriu una consulta per trobar els restaurants que es localitzen en valor de latitud menys de -95.754168.
db.restaurants.find({"address.coord.0": {$lt: -95.754168}}).pretty();

//Escriu una consulta de MongoDB per a trobar els restaurants que no preparen cap cuisine de 'American' i la seva qualificació és superior a 70 i longitud inferior a -65.754168.
db.restaurants.find({$and: [{"cuisine": {$not: {$eq: "American "}}}, {"grades.score": {$gt: 70}}, {"address.coord.0": {$lt: -65.754168}}]}).pretty();

//Escriu una consulta per trobar els restaurants que no preparen cap cuisine de 'American' i van aconseguir un marcador més de 70 i localitzat en la longitud menys que -65.754168. Nota: Fes aquesta consulta sense utilitzar $and operador.
db.restaurants.find({cuisine: {$not: {$eq: "American "}}, "grades.score": {$gt: 70}, "address.coord.0": {$lt: -65.754168}}).pretty();

//Escriu una consulta per trobar els restaurants que no preparen cap cuisine de 'American' i van obtenir un punt de grau 'A' no pertany a Brooklyn. S'ha de mostrar el document segons la cuisine en ordre descendent.
db.restaurants.find({cuisine: {$ne: "American "}, "grades.grade": "A", borough: {$ne: "Brooklyn"}}).sort({cuisine: -1}).pretty();

//Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que contenen 'Wil' com les tres primeres lletres en el seu nom.
db.restaurants.find({ name: { $regex: /^Wil/ } }, { _id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

//Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que contenen 'ces' com les últimes tres lletres en el seu nom.
db.restaurants.find({name: {$regex: /ces$/}}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

//Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que contenen 'Reg' com tres lletres en algun lloc en el seu nom.
db.restaurants.find({name: {$regex: /Reg/}}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

//Escriu una consulta per trobar els restaurants que pertanyen al Bronx i van preparar qualsevol plat americà o xinès.
db.restaurants.find({borough: "Bronx", cuisine: {$in: ["American ", "Chinese"]}}).pretty();

//Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que pertanyen a Staten Island o Queens o Bronx o Brooklyn.
db.restaurants.find({borough: {$in: ["Staten Island", "Queens", "Bronx", "Brooklyn"]}}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

//Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que no pertanyen a Staten Island o Queens o Bronx o Brooklyn.
db.restaurants.find({borough: {$nin: ["Staten Island", "Queens", "Bronx", "Brooklyn"]}}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

//Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que aconsegueixin un marcador que no és més de 10.
db.restaurants.find({"grades.score": {$not: {$gt: 10}}}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

//Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que preparen peix excepte 'American' i 'Chinese' o el name del restaurant comença amb lletres 'Wil'.
db.restaurants.find({$or: [{cuisine: {$ne: "American "}}, {cuisine: {$ne: "Chinese"}}, {name: {$regex: /^Wil/}}]}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

//Escriu una consulta per trobar el restaurant_id, name, i grades per a aquells restaurants que aconsegueixin un grau "A" i un score 11 en dades d'estudi ISODate "2014-08-11T00:00:00Z".
db.restaurants.find({"grades": {$elemMatch: {grade: "A", score: 11, date: ISODate("2014-08-11T00:00:00Z")}}}, {_id: 0, restaurant_id: 1, name: 1, grades: 1}).pretty();

//Escriu una consulta per trobar el restaurant_id, name i grades per a aquells restaurants on el 2n element de varietat de graus conté un grau de "A" i marcador 9 sobre un ISODate "2014-08-11T00:00:00Z".
db.restaurants.find({"grades.1.grade": "A", "grades.1.score": 9, "grades.1.date": ISODate("2014-08-11T00:00:00Z")}, {_id: 0, restaurant_id: 1, name: 1, grades: 1}).pretty();

//Escriu una consulta per trobar el restaurant_id, name, adreça i ubicació geogràfica per a aquells restaurants on el segon element del array coord conté un valor que és més de 42 i fins a 52.
db.restaurants.find({"address.coord.1": {$gt: 42, $lt: 53}}, {_id: 0, restaurant_id: 1, name: 1, "address.building": 1, "address.street": 1, "address.zipcode": 1, "address.coord": 1}).pretty();

//Escriu una consulta per organitzar el nom dels restaurants en ordre ascendent juntament amb totes les columnes.
db.restaurants.find().sort({name: 1}).pretty();

//Escriu una consulta per organitzar el nom dels restaurants en ordre descendent juntament amb totes les columnes.
db.restaurants.find().sort({name: -1}).pretty();

//Escriu una consulta per organitzar el nom de la cuisine en ordre ascendent i pel mateix barri de cuisine. Ordre descendent.
db.restaurants.find().sort({cuisine: 1, borough: -1}).pretty();

//Escriu una consulta per saber totes les direccions que no contenen el carrer.
db.restaurants.find({"address.street": {$exists: false}}, {_id: 0, "address": 1}).pretty();

//Escriu una consulta que seleccionarà tots els documents en la col·lecció de restaurants on el valor del camp coord és Double.
db.restaurants.find({"address.coord": {$type: "double"}}).pretty();

//Escriu una consulta que seleccionarà el restaurant_id, name i grade per a aquells restaurants que retornin 0 com a resta després de dividir el marcador per 7.
db.restaurants.find({$expr: {$eq: [{$mod: [{ $arrayElemAt: ["$grades.score", 0]}, 7]}, 0]}}, {_id: 0, restaurant_id: 1, name: 1, grades: 1}).pretty();

//Escriu una consulta per trobar el name de restaurant, borough, longitud i altitud i cuisine per a aquells restaurants que contenen 'mon' com tres lletres en algun lloc del seu nom.
db.restaurants.find({name: {$regex: /mon/i}}, {_id: 0, name: 1, borough: 1, "address.coord": 1, cuisine: 1}).pretty();

//Escriu una consulta per trobar el name de restaurant, borough, longitud i latitud i cuisine per a aquells restaurants que contenen 'Mad' com primeres tres lletres del seu nom.
db.restaurants.find({name: {$regex: /^Mad/i}}, {_id: 0, name: 1, borough: 1, "address.coord": 1, cuisine: 1}).pretty();