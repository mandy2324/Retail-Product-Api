// mongo Sh

// show dbs 

// use product_db

db.users.insertMany(

    [
        {
            "userId": "1",
            "username": "user1",
            "pass": "12345",
            "email": "user1@email.com",
            "role": "ADMIN"

        },
        {
            "userId": "2",
            "username": "user2",
            "pass": "12345",
            "email": "user2@email.com",
            "role": "USER"

        }
    ]
);


db.products.insertMany(
    [
        {
            "id": "1",
            "name": "FrenchBread",
            "price": 2.99,
            "expriation": "11-3-2022",
            "organic": "true",
            "gluten-free": "true",
            "in-stock": 1
        },
        {
            "id": "2",
            "name": "Bread",
            "price": 6.99,
            "expriation": "11-6-2022",
            "organic": "false",
            "gluten-free": "true",
            "in-stock": 6
    
        },
        {
            "id": "3",
            "name": "muffin",
            "price": 1.99,
            "expriation": "11-3-2022",
            "organic": "true",
            "gluten-free": "true",
            "in-stock": 6
    
        },
        {
            "id": "4",
            "name": "cupcake",
            "price": 4.99,
            "expriation": "11-3-2022",
            "organic": "true",
            "gluten-free": "false",
            "in-stock": 2
    
        }
    ]
);

db.cart.insertMany(
    [
        {
            "user": {
                "userId": 1,
                "username": "user1"
            },
            "products": [
                {
                    "id": "1",
                    "qty": 1,
                    "price": 2.99,
                    "item-total" : 2.99
                },
                {
                    "id": "2",
                    "qty": 1,
                    "price": 6.99,
                    "item-total" : 6.99
                },
                {
                    "id": "3",
                    "qty": 2,
                    "price": 1.99,
                    "item-total" : 3.98
                }
            ],
            "total": 13.96
        }
    ]
);

