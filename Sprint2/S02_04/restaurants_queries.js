use("restaurants");

db.restaurants.find().pretty();

db.restaurants.find({}, {restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

db.restaurants.find({}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

db.restaurants.find({}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, "address.zipcode": 1}).pretty();

db.restaurants.find({borough: "Bronx"}).pretty();

db.restaurants.find({borough: "Bronx"}).limit(5).pretty();

db.restaurants.find({borough: "Bronx"}).skip(5).limit(5).pretty();

db.restaurants.find({"grades.score": {$gt: 90}}).pretty();

db.restaurants.find({"grades.score": {$gt: 80, $lt: 100}}).pretty();

db.restaurants.find({"address.coord.0": {$lt: -95.754168}}).pretty();

db.restaurants.find({$and: [{"cuisine": {$not: {$eq: "American "}}}, {"grades.score": {$gt: 70}}, {"address.coord.0": {$lt: -65.754168}}]}).pretty();

db.restaurants.find({cuisine: {$not: {$eq: "American "}}, "grades.score": {$gt: 70}, "address.coord.0": {$lt: -65.754168}}).pretty();

db.restaurants.find({cuisine: {$ne: "American "}, "grades.grade": "A", borough: {$ne: "Brooklyn"}}).sort({cuisine: -1}).pretty();

db.restaurants.find({name: {$regex: /^Wil/}}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

db.restaurants.find({name: {$regex: /ces$/}}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

db.restaurants.find({name: {$regex: /Reg/}}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

db.restaurants.find({borough: "Bronx", cuisine: {$in: ["American ", "Chinese"]}}).pretty();

db.restaurants.find({borough: {$in: ["Staten Island", "Queens", "Bronx", "Brooklyn"]}}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

db.restaurants.find({borough: {$nin: ["Staten Island", "Queens", "Bronx", "Brooklyn"]}}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

db.restaurants.find({"grades.score": {$not: {$gt: 10}}}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

db.restaurants.find({$or: [{cuisine: {$ne: "American "}}, {cuisine: {$ne: "Chinese"}}, {name: {$regex: /^Wil/}}]}, {_id: 0, restaurant_id: 1, name: 1, borough: 1, cuisine: 1}).pretty();

db.restaurants.find({"grades": {$elemMatch: {grade: "A", score: 11, date: ISODate("2014-08-11T00:00:00Z")}}}, {_id: 0, restaurant_id: 1, name: 1, grades: 1}).pretty();

db.restaurants.find({"grades.1.grade": "A", "grades.1.score": 9, "grades.1.date": ISODate("2014-08-11T00:00:00Z")}, {_id: 0, restaurant_id: 1, name: 1, grades: 1}).pretty();

db.restaurants.find({"address.coord.1": {$gt: 42, $lt: 53}}, {_id: 0, restaurant_id: 1, name: 1, "address.building": 1, "address.street": 1, "address.zipcode": 1, "address.coord": 1}).pretty();

db.restaurants.find().sort({name: 1}).pretty();

db.restaurants.find().sort({name: -1}).pretty();

db.restaurants.find().sort({cuisine: 1, borough: -1}).pretty();

db.restaurants.find({"address.street": {$exists: false}}, {_id: 0, "address": 1}).pretty();

db.restaurants.find({"address.coord": {$type: "double"}}).pretty();

db.restaurants.find({$expr: {$eq: [{$mod: [{$arrayElemAt: ["$grades.score", 0]}, 7]}, 0]}}, {_id: 0, restaurant_id: 1, name: 1, grades: 1}).pretty();

db.restaurants.find({name: {$regex: /mon/i}}, {_id: 0, name: 1, borough: 1, "address.coord": 1, cuisine: 1}).pretty();

db.restaurants.find({name: {$regex: /^Mad/i}}, {_id: 0, name: 1, borough: 1, "address.coord": 1, cuisine: 1}).pretty();
