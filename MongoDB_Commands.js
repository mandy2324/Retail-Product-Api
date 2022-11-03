// check the databases on the server
//show dbs

// clear your terminal
cls

// switch or create a database
//use my_db

// check for collections in a database
//show collections


// insert/create data in a database for that database to be set in mongo
// db.<collection>.insertOne(<json document>)
db.test.insertOne( { "value": "First Document" } )

// find() -> return the documents in a collection
db.test.find()


// documents in the same collection don't need to follow the same structure
db.test.insertOne({
    "color": "blue",
    "number": 4,
    "list": [
        "one",
        "two",
        "three"
    ],
    "active": true,
    "contact": {
        "email": "example@email.com",
        "phone": "123-456-7890"
    }
})

db.test.find()

// pretty() -> select documents and format them nicely
db.test.find().pretty()

// insertMany() -> insert multiple documents
db.test.insertMany([
    { "value": 1 },
    { "value": 2 }
])
db.test.find()



// create a products collection with multiple documents
db.products.insertMany([
    {
        "item": "chair",
        "qty": 6,
        "price": 20.49,
        "brand": "IKEA"
    },
    {
        "item": "table",
        "qty": 16,
        "price": 67.99
    },
    {
        "item": "book",
        "qty": 2,
        "price": 15.99
    },
    {
        "item": "lamp",
        "qty": 6,
        "price": 30.89,
        "warehouse": "Dallas"
    },
    {
        "item": "shirt",
        "qty": 12,
        "price": 5.99,
        "colors": [
            "red", "blue", "black"
        ]
    },
    {
        "item": 'bookcase',
        "qty": 100,
        "brand": "IKEA",
        "price": 89.99,
        "colors": [
            "red", "white", "black", "yellow"
        ]
    },
    {
        "item": 'dresser',
        "qty": 100,
        "brand": "IKEA", 
        "price": 110
    }
]);

// look at the values
db.products.find()



// update() -> old way of doing update (update one or more documents)
// updateOne(), updateMany() -> new way of doing updates

// updateOne( { --what to select-- }, { -- what to change -- } )
// $set -> indicate the value that you are trying to change
db.products.updateOne(
    { "item": "book" }, 
    { $set: { "qty": 10 } }
)

db.products.find()

// chair & lamp have a quantity of 6, it will only select one of them in order to do the update
db.products.updateOne(
    { "qty": 6 },
    { $set: { "price": 100.95 } }
)


// update both products
db.products.updateMany(
    { "qty": 6 },
    { $set: { "price": 99.95 } }
)

// update based on a unique value, you can use _id
db.products.updateOne(
    { "_id": ObjectId("636145453afa9da116c95d18") },
    { $set: { "price": 510.99 } }
)


// update all documents in the collection
// useful if you need to add another field to all your documents
db.products.updateMany(
    {  },
    { $set: { "instock": true } }
)


// update multiple fields 
db.products.updateMany(
    { "brand": "IKEA" },
    { $set: {
        "price": 51.49,
        "qty": 50
    } }
)


// find( -- filters -- ) 

// update the dress to have a different brand
db.products.updateOne(
    { "item": "dresser" },
    { $set: { "brand": "Universal" } }
)

// find all products that have a brand
db.products.find( {
    "brand": { $exists: true }
} )

// don't have a brand
db.products.find( {
    "brand": { $exists: false }
} )

// documents that have the brand = IKEA
db.products.find(
    { "brand": "IKEA" }
)

// documents that have brand = IKEA and will only show the item, qty, price
db.products.find(
    { "brand": "IKEA" }, // filter
    { "item": 1, "qty": 1, "price": 1 } // which fields to select
)

// by default, the _id always shown, have to explicitly state not to show the _id
db.products.find(
    { "brand": "IKEA" },
    { "_id": 0, "item": 1, "qty": 1, "price": 1 } 
)

// multiply the price of each items with a brand by 0.75
// we're having a sale and want to see the price if it was 25% off
db.products.find( {
    "brand": { $exists: true }
} )

// return each product with the item, qty, and price, along with calculations for a price at 75% and the total value of this product using the price & qty
db.products.aggregate(
    [
        { $project: { 
            "item": 1, 
            "qty": 1,
            "price": 1,
            "sale": { $multiply: [ "$price", 0.75 ] },
            "total": { $multiply: [ "$price", "$qty" ] }
        } }
    ]
)


db.products.find( {"item": "shirt"} )

// update the first color in the list from red to yellow
db.products.updateOne(
    { "item": "shirt" },
    { $set: {
        "colors.0": "yellow" 
    } }
)

// db.products.updateOne(
//     { "item": "shirt" },
//     { $set: {
//         $unset: { color: "" }
//     } }
// )

//db.products.update({}, {$unset: {color:1}}, false, true);


// add a new field to the shirt
db.products.updateOne(
    { "item": "shirt" },
    { $set: {
        "material": {
            "cotton": "80%",
            "wool": "20%"
        }
    } }
)

// remove a field called color in any of the documents w/i the collection named products
db.products.update(
    {}, 
    { $unset: {color:1} } , 
    { multi: true }
);


// update cotton field to be 75% instead of 80%
db.products.updateOne(
    { "item": "shirt" },
    { $set: {
        "material.cotton": "75%" 
    } }
)

// add nylon : 5%
db.products.updateOne(
    { "item": "shirt" },
    { $set: {
        "material.nylon": "5%" 
    } }
)


db.products.updateMany(
    {"brand": "IKEA"},
    { $set: { "qty": 30 } }
)

db.products.updateOne(
    {"item": "shirt"},
    { $set: { "qty": 20 } }
)


// products with brand = IKEA and price > 20
db.products.find(
    {
        $and: [
            { "brand": "IKEA" },
            { "price": { $gt: 20 } }
        ]
    }
)

// price > 20
db.products.find(
    { "price": { $gt: 20 } }
)

// price = 67.99
db.products.find(
    { "price": { $eq: 67.99 } }
)

// match if "white" is in one of the colors fields
db.products.find(
    { "colors": { $in: [ "white" ] } }
)


db.products.find(
    { "colors": { $in: [ "yellow" ] } }
)


// which products have qty of 50 or 20
db.products.find(
    { "qty": { $in: [ 50, 20 ] } }
)

// $in --> check if the field matches one of the list of values
// $nin --> doesn't match one of the list of values


db.products.find(
    { "qty": { $nin: [ 50, 20 ] } }
)


// count() -> count the # of results
db.products.find().count()

// count how many items have a brand of IKEA
db.products.find(
    { "brand": "IKEA" }
).count()


// skip() -> skip the first n documents
db.products.find().skip(3)


// sort() -> sort documents by asc/desc order for some field
//          desc -> -1
//          asc -> 1
db.products.find().sort( { "qty": -1 } ) // highest to lowest
db.products.find().sort( { "qty": 1 } )  // lowest to highest

db.products.find().sort( { "item": 1 } ) // A-Z



// remove() -> old function used for deleting (multiple or one document)
// deleteOne(), deleteMany() -> recommended functions

// deleteOne( -- filter for removal -- )
db.products.deleteOne( { "item": "book" } )

db.products.deleteMany( { "price": { $gt : 60 } } )




